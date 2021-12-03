package cn.edu.zjut.dao;

import cn.edu.zjut.po.Goods;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class GoodsImpl implements GoodsMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Goods> getAllGoods() {
        System.out.println("execute --getAllGoods()-- method.");
        return sqlSession.getMapper(GoodsMapper.class).getAllGoods();
    }
}
