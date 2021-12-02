package cn.edu.zjut.dao;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class AdvertisementImpl implements AdvertisementMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List getAdvertisement() {
        System.out.println("execute--getAdvertisement--dao");
        return sqlSession.getMapper(AdvertisementMapper.class).getAdvertisement();
    }
}
