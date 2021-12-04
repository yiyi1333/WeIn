package cn.edu.zjut.dao;

import cn.edu.zjut.po.ShopManager;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class ShopManagerImpl implements ShopManagerMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    public List<ShopManager> getAllShopManager() {
        System.out.println("execute --getAllShopManager()-- method.");
        return sqlSession.getMapper(ShopManagerMapper.class).getAllShopManager();
    }

    public void addShopManager(ShopManager shopManager) {
        System.out.println("execute --registerShopmanager()-- method.");
        sqlSession.getMapper(ShopManagerMapper.class).addShopManager(shopManager);
    }
}
