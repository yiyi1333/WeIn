package cn.edu.zjut.action;

import cn.edu.zjut.po.EnterpriseAgency;
import cn.edu.zjut.po.PlatformAdministrator;
import cn.edu.zjut.po.ShopManager;
import cn.edu.zjut.po.User;
import cn.edu.zjut.service.EnterpriseAgencyService;
import cn.edu.zjut.service.PlatformAdministratorService;
import cn.edu.zjut.service.ShopManagerService;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UserAction implements SessionAware {
    private User user;
    private EnterpriseAgencyService enterpriseAgencyService;
    private ShopManagerService shopManagerService;
    private PlatformAdministratorService platformAdministratorService;
    private Map<String, Object> session;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public PlatformAdministratorService getPlatformAdministratorService() {
        return platformAdministratorService;
    }

    public void setPlatformAdministratorService(PlatformAdministratorService platformAdministratorService) {
        this.platformAdministratorService = platformAdministratorService;
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
                session.put("type", "shopManager");
                session.put("name", shopManager.getShopManagerName());
                session.put("shopManager", shopManager);
                //存一下商家的编号
                session.put("loginusershopId", shopManager.getShopId());
                return "shopSuccess";
            }
        } else if (user.getAuthority() == 1) {
            EnterpriseAgency enterpriseAgency = new EnterpriseAgency();
            enterpriseAgency.setEnterpriseAgencyAccount(user.getAccount());
            enterpriseAgency.setEnterpriseAgencyPassword(user.getPassword());
            enterpriseAgency = enterpriseAgencyService.login(enterpriseAgency);
            int right = enterpriseAgency.getEnterpriseAgencyRight();
            if (enterpriseAgency != null) {
                session.put("type", "enterpriseAgency");
                session.put("name", enterpriseAgency.getEnterpriseAgencyName());
                session.put("enterpriseAgency", enterpriseAgency);
                //存一下企业管理员的企业号
                session.put("loginuserEnterpriseId", enterpriseAgency.getEnterpriseId());
                //存一下企业管理员的编号
                session.put("loginuserEnterpriseAgencyId", enterpriseAgency.getEnterpriseAgencyId());
                //有权限审核则主页显示审核
                if(right == 1) {
                    return "rightsuccess";
                }
                else {
                    return  "success";
                }
            }
        } else if (user.getAuthority() == 2) {
            PlatformAdministrator platformAdministrator = new PlatformAdministrator();
            platformAdministrator.setAdminAccount(user.getAccount());
            platformAdministrator.setAdminPassword(user.getPassword());
            platformAdministrator = platformAdministratorService.login(platformAdministrator);
            if (platformAdministrator != null) {
                session.put("type", "platformAdministrator");
                session.put("name", platformAdministrator.getAdminName());
                session.put("platformAdministrator", platformAdministrator);
                return "platformAdministratorsuccess";
            }
        }
        return "failed";
    }

}
