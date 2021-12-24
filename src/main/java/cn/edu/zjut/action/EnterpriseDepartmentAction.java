package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.po.EnterpriseDepartmentDisplay;
import cn.edu.zjut.po.EnterpriseUser;
import cn.edu.zjut.service.ElectronicContractsService;
import cn.edu.zjut.service.EnterpriseDepartmentService;
import cn.edu.zjut.service.EnterpriseService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author hydrogen_zyx
 */
public class EnterpriseDepartmentAction extends ActionSupport implements SessionAware {
    private EnterpriseDepartmentService enterpriseDepartmentService;
    private EnterpriseService enterpriseService;
    private EnterpriseDepartment enterpriseDepartment;
    private ElectronicContractsService electronicContractsService;
    private EnterpriseUser enterpriseUser;
    private Map<String, Object> session;
    private Integer EnterpriseDepartmentId;
    private String tag;//批量删除ID号集合
    List<EnterpriseDepartmentDisplay> enterpriseDepartments;


    public ElectronicContractsService getElectronicContractsService() {
        return electronicContractsService;
    }

    public void setElectronicContractsService(ElectronicContractsService electronicContractsService) {
        this.electronicContractsService = electronicContractsService;
    }


    public List<EnterpriseDepartmentDisplay> getEnterpriseDepartments() {
        return enterpriseDepartments;
    }

    public void setEnterpriseDepartments(List<EnterpriseDepartmentDisplay> enterpriseDepartments) {
        this.enterpriseDepartments = enterpriseDepartments;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setEnterpriseDepartmentId(Integer enterpriseDepartmentId) {
        EnterpriseDepartmentId = enterpriseDepartmentId;
    }

    public Integer getEnterpriseDepartmentId() {
        return EnterpriseDepartmentId;
    }

    public String getTag() {
        return tag;
    }

    public EnterpriseDepartmentService getEnterpriseDepartmentService() {
        return enterpriseDepartmentService;
    }

    public void setEnterpriseDepartmentService(EnterpriseDepartmentService enterpriseDepartmentService) {
        this.enterpriseDepartmentService = enterpriseDepartmentService;
    }

    public EnterpriseDepartment getEnterpriseDepartment() {
        return enterpriseDepartment;
    }

    public void setEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment) {
        this.enterpriseDepartment = enterpriseDepartment;
    }

    public void setEnterpriseUser(EnterpriseUser enterpriseUser) {
        this.enterpriseUser = enterpriseUser;
    }

    public EnterpriseUser getEnterpriseUser() {
        return enterpriseUser;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String getEnterpriseList() {
        List<EnterpriseUser> enterpriseUserlist = enterpriseDepartmentService.getAllEnterpriseUser();
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        List<EnterpriseDepartmentDisplay> enterpriseDepartments = enterpriseDepartmentService.getAllEnterpriseDepartmentDisplay(enterpriseAgency.getEnterpriseId());
        session.put("displayEnterpriseDepartments", enterpriseDepartments);
        session.put("enterpriseUserlist", enterpriseUserlist);
        return "success";
    }

    public String addEnterpriseDepartment() {
        if (enterpriseDepartment.getEnterpriseDepartmentName().length() == 0 || enterpriseDepartment.getEnterpriseDepartmentName().length() > 10) {
            session.put("message", "名称不符合规范!");
            return "failed";
        }
        List<EnterpriseDepartment> enterpriseDepartments = (List<EnterpriseDepartment>) session.get("displayEnterpriseDepartments");
        for (EnterpriseDepartment ed : enterpriseDepartments) {
            if (Objects.equals(enterpriseDepartment.getEnterpriseDepartmentName(), ed.getEnterpriseDepartmentName())) {
                session.put("message", "名称不可以重复!");
                return "failed";
            }
        }
        enterpriseDepartmentService.addEnterpriseDepartment(enterpriseDepartment);
        return "success";
    }

    public String getAllEnterpriseDepartment() {
        List<EnterpriseDepartment> enterpriseDepartmentlist = enterpriseDepartmentService.getAllEnterpriseDepartment();
        session.put("enterpriseDepartmentlist", enterpriseDepartmentlist);
        return "success";
    }

    public String displayAddEnterpriseDepartment() throws AccessDeniedException {
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        List<EnterpriseDepartment> enterpriseDepartments = enterpriseDepartmentService.displayAddEnterpriseDepartment(enterpriseAgency);
        String name = enterpriseDepartmentService.getEnterpriseById(enterpriseAgency.getEnterpriseId()).getEnterpriseName();
        session.put("displayEnterpriseDepartments", enterpriseDepartments);
        session.put("displayEnterpriseName", name);
        session.put("enterpriseId", enterpriseAgency.getEnterpriseId());
        return "success";
    }

    public String displayAllDepartment() {
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        enterpriseDepartments = enterpriseDepartmentService.getAllEnterpriseDepartmentDisplay(enterpriseAgency.getEnterpriseId());
        String name = enterpriseDepartmentService.getEnterpriseById(enterpriseAgency.getEnterpriseId()).getEnterpriseName();
        List<EnterpriseDepartment> enterpriseDepartmentList = enterpriseDepartmentService.getEnterpriseDepartmentByEnterpriseId(enterpriseAgency.getEnterpriseId());
        //用于查询
        session.put("enterpriseDepartmentList", enterpriseDepartmentList);

        session.put("enterpriseDepartments", enterpriseDepartments);
        session.put("displayEnterpriseName", name);
        session.put("enterpriseId", enterpriseAgency.getEnterpriseId());
        return "success";
    }

    public void setEnterpriseService(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    public EnterpriseService getEnterpriseService() {
        return enterpriseService;
    }

    public String deleteDepartment() throws Exception {
        enterpriseDepartment = enterpriseDepartmentService.getEnterpriseDepartmentById(EnterpriseDepartmentId);
        if (enterpriseDepartmentService.deleteDepartment(enterpriseDepartment.getEnterpriseDepartmentId())) {
            electronicContractsService.legitimacyCheck();
//            throw new Exception();
            return "success";
        } else {
            this.addActionError("部门存在子部门，请先删除子部门！");
            return "failed";
        }
    }

    public String updateUserDepartment() {
        enterpriseDepartmentService.updateUserDepartment(enterpriseUser.getConsumerId(), enterpriseDepartment.getEnterpriseDepartmentId());
        return "success";
    }

    public String deleteConsumer() {
        enterpriseDepartmentService.deleteConsumer(enterpriseUser.getConsumerId());
        return "success";
    }

    //删除企业结构
    public String deleteEnterpriseDepartment() {
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        enterpriseDepartmentService.deleteDepartment(EnterpriseDepartmentId);
        enterpriseDepartments = enterpriseDepartmentService.getAllEnterpriseDepartmentDisplay(enterpriseAgency.getEnterpriseId());
        session.put("enterpriseDepartments", enterpriseDepartments);
        return "success";
    }

    //批量删除企业结构
    public String deleteEnterpriseDepartmentByIds() {
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        String[] deletedepartment = tag.split(",");
        for (int i = 0; i < deletedepartment.length; i++) {
            enterpriseDepartmentService.deleteDepartment(Integer.parseInt(deletedepartment[i]));
        }
        enterpriseDepartments = enterpriseDepartmentService.getAllEnterpriseDepartmentDisplay(enterpriseAgency.getEnterpriseId());
        session.put("enterpriseDepartments", enterpriseDepartments);
        return "success";
    }

    //选择更新企业结构
    public String selectEnterpriseDepartmentById() {
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        if (enterpriseAgency == null) {
            return "displayEnterpriseAgencyFailed";
        }
        EnterpriseDepartment enterpriseDepartment = enterpriseDepartmentService.getEnterpriseDepartmentById(EnterpriseDepartmentId);
        List<EnterpriseDepartment> enterpriseDepartmentList = enterpriseDepartmentService.getEnterpriseDepartmentByEnterpriseId(enterpriseAgency.getEnterpriseId());
        session.put("enterpriseDepartment", enterpriseDepartment);
        session.put("enterpriseDepartmentList", enterpriseDepartmentList);
        return "success";
    }

    //更新企业返回
    public String updateEnterpriseDepartment() {
        EnterpriseDepartment enterpriseDepartment1 = (EnterpriseDepartment) session.get("enterpriseDepartment");
        enterpriseDepartment.setEnterpriseDepartmentId(enterpriseDepartment1.getEnterpriseDepartmentId());
        enterpriseDepartmentService.updateEnterpriseDapartment(enterpriseDepartment);
        //并且清除原有的enterpriseDepartments,重置
        session.remove("enterpriseDepartments");
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        enterpriseDepartments = enterpriseDepartmentService.getAllEnterpriseDepartmentDisplay(enterpriseAgency.getEnterpriseId());
        session.put("enterpriseDepartments", enterpriseDepartments);
        return "success";
    }

    //模糊查询
    public String queryEnterpriseDepartment() {
//        enterpriseDepartment.setEnterpriseId(-1);
        session.remove("enterpriseDepartments");
        List<EnterpriseDepartmentDisplay> enterpriseDepartmentList = enterpriseDepartmentService.getEnterpriseDepartmentLike(enterpriseDepartment);
        for(EnterpriseDepartmentDisplay enterpriseDepartmentDisplay: enterpriseDepartmentList) {
            enterpriseDepartmentDisplay.setFaDepartment(enterpriseDepartmentService.queryDepartNameByEnterpriseDepartmentId(enterpriseDepartmentDisplay.getEnterpriseDepartmentpre()));
        }
        session.put("enterpriseDepartments", enterpriseDepartmentList);
        return "success";
    }
}
