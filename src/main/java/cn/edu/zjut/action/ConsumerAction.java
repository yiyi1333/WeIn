package cn.edu.zjut.action;

import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.EnterpriseConsumer;
import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.service.ConsumerService;
import cn.edu.zjut.service.EnterpriseDepartmentService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class ConsumerAction implements SessionAware {
    private ConsumerService consumerService;
    private Map<String, Object> session;
    private Consumer consumer;
    private EnterpriseConsumer enterpriseConsumer;
    private String phoneNumber;
    private String nickName;
    private String avatarUrl;
    private String realName;
    private String idNumber;
    private String statusMes;
    private String consumerId;
    private EnterpriseDepartmentService enterpriseDepartmentService;

    public EnterpriseDepartmentService getEnterpriseDepartmentService() {
        return enterpriseDepartmentService;
    }

    public void setEnterpriseDepartmentService(EnterpriseDepartmentService enterpriseDepartmentService) {
        this.enterpriseDepartmentService = enterpriseDepartmentService;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getStatusMes() {
        return statusMes;
    }

    public void setStatusMes(String statusMes) {
        this.statusMes = statusMes;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public EnterpriseConsumer getEnterpriseConsumer() {
        return enterpriseConsumer;
    }

    public void setEnterpriseConsumer(EnterpriseConsumer enterpriseConsumer) {
        this.enterpriseConsumer = enterpriseConsumer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ConsumerService getConsumerService() {
        return consumerService;
    }

    public void setConsumerService(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String getConsumerList() {
        List<Consumer> consumerlist = consumerService.getAllConsumer();
        session.put("consumerlist", consumerlist);
        return "success";
    }

    public String displayAddConsumer() {
        EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.get("enterpriseAgency");
        List<EnterpriseDepartment> enterpriseDepartmentlist = enterpriseDepartmentService.getEnterpriseDepartmentByEnterpriseId(enterpriseAgency.getEnterpriseId());
        session.put("enterpriseDepartmentList", enterpriseDepartmentlist);
        return "success";
    }

    public String addConsumer() {
        if (Objects.equals(consumer.getName(), "")) {
            session.put("message", "姓名不能为空");
            return "failed";
        }
        if (Objects.equals(consumer.getIdCardNumber(), "")) {
            session.put("message", "证件号不能为空");
            return "failed";
        }
        if (Objects.equals(consumer.getEmail(), "")) {
            session.put("message", "邮箱不能为空");
            return "failed";
        }
        if (Objects.equals(consumer.getPhoneNumber(), "")) {
            session.put("message", "手机号不能为空");
            return "failed";
        }
        if (!Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", consumer.getEmail())) {
            session.put("message", "邮箱格式不正确");
            return "failed";
        }
        if (!Pattern.matches("[0-9]{11}", consumer.getPhoneNumber())) {
            session.put("message", "手机号格式不正确");
            return "failed";
        }
        if (!Pattern.matches("[0-9]{18}", consumer.getIdCardNumber())) {
            session.put("message", "证件号格式不正确");
            return "failed";
        }
        if (consumerService.findPhoneNumber(consumer.getPhoneNumber()) == false) {
            session.put("message", "找不到手机号对应的用户");
            return "failed";
        }
        consumerService.addConsumer(consumer);
        return "success";
    }

    public String login() {
        System.out.println("PhoneNumber：" + phoneNumber);
        enterpriseConsumer = consumerService.loginAndRegister(phoneNumber);
        return "success";
    }

    //    响应获取授权数据之后写入数据库
    public String authorize() {
        enterpriseConsumer = consumerService.updateAuthorizeInfo(nickName, avatarUrl, phoneNumber);
        return "success";
    }

    //实名认证处理
    public String Certification() {
        statusMes = consumerService.Certification(realName, idNumber, Integer.parseInt(consumerId));
        return "success";
    }
}
