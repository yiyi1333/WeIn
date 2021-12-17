package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.po.EnterpriseDepartmentDisplay;
import cn.edu.zjut.po.EnterpriseUser;
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
    private EnterpriseUser enterpriseUser;
    private Map<String, Object> session;
    private String deleteDepartmentId;


    public String getDeleteDepartmentId() {
        return deleteDepartmentId;
    }

    public void setDeleteDepartmentId(String deleteDepartmentId) {
        this.deleteDepartmentId = deleteDepartmentId;
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
            this.addActionError("名称不符合规范!");
            return "failed";
        }
        List<EnterpriseDepartment> enterpriseDepartments = (List<EnterpriseDepartment>) session.get("displayEnterpriseDepartments");
        for (EnterpriseDepartment ed : enterpriseDepartments) {
            if (Objects.equals(enterpriseDepartment.getEnterpriseDepartmentName(), ed.getEnterpriseDepartmentName())) {
                this.addActionError("名称不可以重复!");
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
        List<EnterpriseDepartmentDisplay> enterpriseDepartments = enterpriseDepartmentService.getAllEnterpriseDepartmentDisplay(enterpriseAgency.getEnterpriseId());
        String name = enterpriseDepartmentService.getEnterpriseById(enterpriseAgency.getEnterpriseId()).getEnterpriseName();
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

    public String deleteDepartment() {
        enterpriseDepartment = enterpriseDepartmentService.getEnterpriseDepartmentById(Integer.parseInt(deleteDepartmentId));
        if (enterpriseDepartmentService.deleteDepartment(enterpriseDepartment.getEnterpriseDepartmentId())) {
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
}
