package cn.edu.zjut.dao;

import cn.edu.zjut.po.PlatformAdministrator;

import java.util.List;

public interface PlatformAdministratorMapper {
    public List<PlatformAdministrator> getAllPlatformAdministrator();

    public PlatformAdministrator getPlatformAdministratorByAccount(String account);
}
