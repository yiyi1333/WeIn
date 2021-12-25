package cn.edu.zjut.dao;

import cn.edu.zjut.po.CartRecord;
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

    @Override
    public Integer getCartNum(int consumerId, int goodsId) {
        return sqlSession.getMapper(CartMapper.class).getCartNum(consumerId, goodsId);
    }

    @Override
    public Integer addOneToCart(int consumerId, int goodsId) {
        return sqlSession.getMapper(CartMapper.class).addOneToCart(consumerId, goodsId);
    }

    @Override
    public Integer insertCart(int consumerId, int goodsId) {
        return sqlSession.getMapper(CartMapper.class).insertCart(consumerId, goodsId);
    }

    @Override
    public CartRecord getRecord(Integer consumerId, Integer goodsId) {
        return sqlSession.getMapper(CartMapper.class).getRecord(consumerId, goodsId);
    }

    @Override
    public Integer removeRecord(Integer consumerId, Integer goodsId) {
        return sqlSession.getMapper(CartMapper.class).removeRecord(consumerId, goodsId);
    }

    @Override
    public Integer updateRecord(Integer consumerId, Integer goodsId, Integer num) {
        return sqlSession.getMapper(CartMapper.class).updateRecord(consumerId, goodsId, num);
    }

    @Override
    public List<CartRecord> getRecordAll(Integer consumerId) {
        return sqlSession.getMapper(CartMapper.class).getRecordAll(consumerId);
    }
}
