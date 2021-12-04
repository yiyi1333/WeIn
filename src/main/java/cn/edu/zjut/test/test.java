package cn.edu.zjut.test;


import cn.edu.zjut.dao.ShopManagerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.edu.zjut.service.RegisterShopmanagerAndEnterpriseagencyService;
import cn.edu.zjut.po.ShopManager;

import java.util.List;

public class test {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory factory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
//        RegisterShopmanagerAndEnterpriseagencyService rService = (RegisterShopmanagerAndEnterpriseagencyService) ctx.getBean("registerShopmanagerAndEnterpriseagencyService");
        SqlSession sqlSession = factory.openSession();
        ShopManagerMapper shopManagerMapper = sqlSession.getMapper(ShopManagerMapper.class);
        System.out.println(shopManagerMapper.getAllShopManager().size());
    }
}
