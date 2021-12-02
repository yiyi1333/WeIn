package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.po.User;
import cn.edu.zjut.service.EnterpriseAgencyService;
import cn.edu.zjut.service.ShopManagerService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UserAction implements SessionAware {
    private User user;
    private EnterpriseAgencyService enterpriseAgencyService;
    private ShopManagerService shopManagerService;
    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public ShopManagerService getShopManagerService() {
        return shopManagerService;
    }

    public void setShopManagerService(ShopManagerService shopManagerService) {
        this.shopManagerService = shopManagerService;
    }

    public EnterpriseAgencyService getEnterpriseAgencyService() {
        return enterpriseAgencyService;
    }


    public void setEnterpriseAgencyService(EnterpriseAgencyService enterpriseAgencyService) {
        this.enterpriseAgencyService = enterpriseAgencyService;
    }

    public String login() {
        if (user.getAuthority() == 0) {
            ShopManager shopManager = new ShopManager();
            shopManager.setShopManagerAccount(user.getAccount());
            shopManager.setShopManagerPassword(user.getPassword());
            shopManager = shopManagerService.login(shopManager);
            if (shopManager != null) {
                session.put("type", "店铺管理员");
                session.put("name", shopManager.getShopManagerName());
                session.put("shopManager", shopManager);
                return "success";
            }
        } else if (user.getAuthority() == 1) {
            EnterpriseAgency enterpriseAgency = new EnterpriseAgency();
            enterpriseAgency.setEnterpriseAgencyAccount(user.getAccount());
            enterpriseAgency.setEnterpriseAgencyPassword(user.getPassword());
            enterpriseAgency = enterpriseAgencyService.login(enterpriseAgency);
            if (enterpriseAgency != null) {
                session.put("type", "企业用户");
                session.put("name", enterpriseAgency.getEnterpriseAgencyName());
                session.put("enterpriseAgency", enterpriseAgency);
                return "success";
            }
        } else if (user.getAuthority() == 2) {

        }
        return "failed";
    }
}
