package cn.edu.zjut.action;

import cn.edu.zjut.po.ElectronicContracts;
import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.service.ElectronicContractsService;
import cn.edu.zjut.service.EnterpriseDepartmentService;
import cn.edu.zjut.service.RegisterShopmanagerAndEnterpriseagencyService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ElectronicContractsAction extends ActionSupport implements SessionAware, ServletRequestAware {
    private ElectronicContractsService electronicContractsService;
    private ElectronicContracts electronicContracts;
    private EnterpriseDepartment enterpriseDepartment;
    private List enterpriseDepartmentList;//起草时展示用
    private List electronicContractsList;
    private Map<String, Object> session;
    private HttpServletRequest httpServletRequest;
    private String tag;//批量选择ID号集合

    //获得企业结构用
    private RegisterShopmanagerAndEnterpriseagencyService registerShopmanagerAndEnterpriseagencyService;
    private EnterpriseDepartmentService enterpriseDepartmentService;
    private String enterpriseId;
    private String discount;
    private String enterpriseDepartmentId;
    private String shopId;
    private String enterpriseAgencyId;
    private String electronicContractsId;
    private String goodsId;

    public void setEnterpriseDepartmentService(EnterpriseDepartmentService enterpriseDepartmentService) {
        this.enterpriseDepartmentService = enterpriseDepartmentService;
    }

    public EnterpriseDepartmentService getEnterpriseDepartmentService() {
        return enterpriseDepartmentService;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setEnterpriseDepartmentId(String enterpriseDepartmentId) {
        this.enterpriseDepartmentId = enterpriseDepartmentId;
    }


    public void setElectronicContractsId(String electronicContractsId) {
        this.electronicContractsId = electronicContractsId;
    }

    public void setEnterpriseAgencyId(String enterpriseAgencyId) {
        this.enterpriseAgencyId = enterpriseAgencyId;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public String getDiscount() {
        return discount;
    }

    public String getElectronicContractsId() {
        return electronicContractsId;
    }

    public String getEnterpriseAgencyId() {
        return enterpriseAgencyId;
    }

    public String getEnterpriseDepartmentId() {
        return enterpriseDepartmentId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopId() {
        return shopId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    //商家查看合同内容
    public String queryElectronicContracts() {
        electronicContractsList = electronicContractsService.queryElectronicContracts();
        return "success";
    }

    //编辑合同--选择企业结构
    public String getEnterpriseDepartmentById() {
        List enterpriseDepartmentList;//选择企业放入合同用
        enterpriseDepartmentList = registerShopmanagerAndEnterpriseagencyService.queryEnterpriseStructure((Integer) session.get("loginuserEnterpriseId"));
        session.put("enterpriseDepartmentList", enterpriseDepartmentList);
        return "success";
    }

    //获得编辑的企业结构
    public String chooseDepartmentToElectronicContracts() {
        String key = "haveEnterpriseId";
        key += String.valueOf(enterpriseDepartment.getEnterpriseDepartmentId());
        session.put(key, enterpriseDepartment.getEnterpriseDepartmentId());
        if (session.get("electronicContractsList") == null) {//第一次
            session.put("electronicContractsList", new ArrayList<EnterpriseDepartment>());
        }
        List<EnterpriseDepartment> electronicContractsList = (List<EnterpriseDepartment>) session.get("electronicContractsList");
        electronicContractsList.add(enterpriseDepartment);
//        //折扣信息放入session
//        session.put("dicountList", new ArrayList<Double>());
        return "success";
    }

    //批量获得编辑的企业结构
    public String chooseDepartmentToElectronicContractsById() {
        String[] selectdepartmentId = tag.split(",");
        if (session.get("electronicContractsList") == null) {//第一次
            session.put("electronicContractsList", new ArrayList<EnterpriseDepartment>());
        }
        List<EnterpriseDepartment> electronicContractsList = (List<EnterpriseDepartment>) session.get("electronicContractsList");
        for (int i = 0; i < selectdepartmentId.length; i++) {
            String keykey = "haveEnterpriseId";
            keykey = keykey + selectdepartmentId[i];
            session.put(keykey, selectdepartmentId[i]);
            enterpriseDepartment = enterpriseDepartmentService.getEnterpriseDepartmentById(Integer.parseInt(selectdepartmentId[i]));
            electronicContractsList.add(enterpriseDepartment);
        }
        return "success";
    }

    //企业管理员起草合同
    public String editElectronicContracts() {
        //对于展示的企业结构
        boolean ok = true;

        StringBuilder mess = new StringBuilder();
        List<EnterpriseDepartment> EnterpriseDepartmentList = (List<EnterpriseDepartment>) session.get("electronicContractsList");
        Iterator<EnterpriseDepartment> enterpriseDepartmentIterator = EnterpriseDepartmentList.iterator();
//        //对于展示的折扣
//        List<Double> dicountList = (List<Double>) session.get("dicountList");
//        Iterator<Double> doubleIterator = dicountList.iterator();

        List<ElectronicContracts> list = new ArrayList<>();
        while (enterpriseDepartmentIterator.hasNext()) {
            EnterpriseDepartment enterpriseDepartment = enterpriseDepartmentIterator.next();
//            Double discountnow = doubleIterator.next();
            ElectronicContracts electronicContracts1 = new ElectronicContracts();
            electronicContracts1.setEnterpriseDepartmentId(enterpriseDepartment.getEnterpriseDepartmentId());
            electronicContracts1.setState(0);
            electronicContracts1.setEnterpriseId((Integer) session.get("loginuserEnterpriseId"));
            electronicContracts1.setEnterpriseAgencyId(electronicContracts.getEnterpriseAgencyId());
            electronicContracts1.setStarttime(electronicContracts.getStarttime());
            electronicContracts1.setEndtime(electronicContracts.getEndtime());
            electronicContracts1.setGoodsId(electronicContracts.getGoodsId());
            electronicContracts1.setShopId(electronicContracts.getShopId());
            String discount = httpServletRequest.getParameter("discountthis" + enterpriseDepartment.getEnterpriseDepartmentId());
            double dc = Double.parseDouble(discount);
            electronicContracts1.setDiscount(dc);
            List<ElectronicContracts> ec = electronicContractsService.getElectronicContractsimpl().queryElectronicContractsListByGoodsIdDepartmentId(electronicContracts1.getGoodsId(), electronicContracts1.getEnterpriseDepartmentId());
            for (ElectronicContracts ecec : ec) {
                if (ecec.getState() != 2 && ecec.getState() != 4) {
                    ok = false;
                    mess.append(String.valueOf(electronicContracts1.getEnterpriseDepartmentId()));
                    break;
                }
            }
            list.add(electronicContracts1);
        }
        session.put("printlist", list);
        if (!ok) {
            mess.append("号部门已经与该商品存在有效或待审核合同");
            addActionError(mess.toString());
            return "failed";
        }
        for (ElectronicContracts ec : list) {
            electronicContractsService.addElectronicContracts(ec);
        }
        return "success";
    }


    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    //展示要审核的合同条目
    public String showVerifyElectronicContracts() {
        electronicContractsList = electronicContractsService.showVerifyElectronicContracts((Integer) session.get("loginuserEnterpriseAgencyId"));
        session.put("verifyContracts", electronicContractsList);
        return "success";
    }

//    //提交审核通过
//    public String verifyElectronicContracts() {
//        electronicContractsService.changeStateElectronicContracts((Integer) session.get("loginuserEnterpriseAgencyId"));
//        session.remove("verifyContracts");
//        return "success";
//    }
//
//    //商家提交审核通过
//    public String verifyElectronicContracts2() {
//        electronicContractsService.changeStateElectronicContracts2((Integer) session.get("loginusershopId"));
//        session.remove("verifyContracts");
//        return "success";
//    }

    //商家接收合同
    public String showShopElectronicContracts() {
        electronicContractsList = electronicContractsService.showShopElectronicContracts((Integer) session.get("loginusershopId"));
        session.put("shopContracts", electronicContractsList);
        return "success";
    }

    public ElectronicContracts getElectronicContracts() {
        return electronicContracts;
    }

    public void setElectronicContracts(ElectronicContracts electronicContracts) {
        this.electronicContracts = electronicContracts;
    }

    public void setElectronicContractsService(ElectronicContractsService electronicContractsService) {
        this.electronicContractsService = electronicContractsService;
    }

    public ElectronicContractsService getElectronicContractsService() {
        return electronicContractsService;
    }

    public List getElectronicContractsList() {
        return electronicContractsList;
    }

    public void setElectronicContractsList(List electronicContractsList) {
        this.electronicContractsList = electronicContractsList;
    }

    public void setRegisterShopmanagerAndEnterpriseagencyService(RegisterShopmanagerAndEnterpriseagencyService registerShopmanagerAndEnterpriseagencyService) {
        this.registerShopmanagerAndEnterpriseagencyService = registerShopmanagerAndEnterpriseagencyService;
    }

    public RegisterShopmanagerAndEnterpriseagencyService getRegisterShopmanagerAndEnterpriseagencyService() {
        return registerShopmanagerAndEnterpriseagencyService;
    }

    public EnterpriseDepartment getEnterpriseDepartment() {
        return enterpriseDepartment;
    }

    public void setEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment) {
        this.enterpriseDepartment = enterpriseDepartment;
    }

    public List getEnterpriseDepartmentList() {
        return enterpriseDepartmentList;
    }

    public void setEnterpriseDepartmentList(List enterpriseDepartmentList) {
        this.enterpriseDepartmentList = enterpriseDepartmentList;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    // 企业管理员查看企业的所有合同
    public String queryElectronicContractsByEnterpriseId() {
        Integer id = (Integer) session.get("loginuserEnterpriseId");
        List list = electronicContractsService.queryElectronicContractsByEnterpriseId(id);
        session.put("contractList", list);
        return "success";
    }

    // 商家管理员查看企业的所有合同
    public String queryElectronicContractsByshopId() {
        Integer id = (Integer) session.get("loginusershopId");
        List list = electronicContractsService.queryElectronicContractsByshopId(id);
        session.put("contractList", list);
        return "success";
    }

    //模糊查询
    public String queryElectronicContractsLike() {

        ElectronicContracts electronicContracts = new ElectronicContracts();
        session.remove("contractList");
        if (!electronicContractsId.equals("") && electronicContractsId != null) {
            electronicContracts.setElectronicContractsId(Integer.parseInt(electronicContractsId));
        }
        if (!discount.equals("") && discount != null) {
            electronicContracts.setDiscount(Double.parseDouble(discount));
        }
        if (!enterpriseDepartmentId.equals("")) {
            electronicContracts.setEnterpriseDepartmentId(Integer.parseInt(enterpriseDepartmentId));
        }
        if (!goodsId.equals("")) {
            electronicContracts.setGoodsId(Integer.parseInt(goodsId));
        }
        if (!shopId.equals("")) {
            electronicContracts.setShopId(Integer.parseInt(shopId));
        }
        if (!enterpriseAgencyId.equals("")) {
            electronicContracts.setEnterpriseAgencyId(Integer.parseInt(enterpriseAgencyId));
        }
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        electronicContracts.setEnterpriseId(enterpriseAgency.getEnterpriseId());
        List list = electronicContractsService.queryElectronicContractsLike(electronicContracts);
        session.put("contractList", list);
        return "success";
    }


    public String manyVerifyElectrobicContractsById() {
        String[] selectId = tag.split(",");
        //System.out.println(tag);
        for (int i = 0; i < selectId.length; i++) {
            electronicContractsService.changeStateElectronicContracts((Integer) session.get("loginuserEnterpriseAgencyId"), Integer.parseInt(selectId[i]), 1);
        }
        session.remove("verifyContracts");
        electronicContractsList = electronicContractsService.showVerifyElectronicContracts((Integer) session.get("loginuserEnterpriseAgencyId"));
        session.put("verifyContracts", electronicContractsList);
        return "success";
    }

    public String manyDenyElectroContractsById() {

        String[] selectId = tag.split(",");

        for (int i = 0; i < selectId.length; i++) {
            electronicContractsService.changeStateElectronicContracts((Integer) session.get("loginuserEnterpriseAgencyId"), Integer.parseInt(selectId[i]), 2);
        }
        session.remove("verifyContracts");
        electronicContractsList = electronicContractsService.showVerifyElectronicContracts((Integer) session.get("loginuserEnterpriseAgencyId"));
        session.put("verifyContracts", electronicContractsList);
        return "success";
    }


    public String shopmanyVerifyElectrobicContractsById() {
        String[] selectId = tag.split(",");
        //System.out.println(tag);
        for (int i = 0; i < selectId.length; i++) {
            electronicContractsService.changeStateElectronicContracts2((Integer) session.get("loginusershopId"), Integer.parseInt(selectId[i]), 10);
        }
        session.remove("shopContracts");
        electronicContractsList = electronicContractsService.showShopElectronicContracts((Integer) session.get("loginusershopId"));
        session.put("shopContracts", electronicContractsList);
        return "success";
    }

    public String shopmanyDenyElectroContractsById() {

        String[] selectId = tag.split(",");
        for (int i = 0; i < selectId.length; i++) {
            electronicContractsService.changeStateElectronicContracts2((Integer) session.get("loginusershopId"), Integer.parseInt(selectId[i]), 4);
        }
        session.remove("shopContracts");
        electronicContractsList = electronicContractsService.showShopElectronicContracts((Integer) session.get("loginusershopId"));
        session.put("shopContracts", electronicContractsList);
        return "success";
    }
}


