package cn.edu.zjut.dao;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public class CartImpl implements CartMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public ArrayList getConsumerCart(int consumerId) {
        return sqlSession.getMapper(CartMapper.class).getConsumerCart(consumerId);
    }
}
