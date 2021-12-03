package cn.edu.zjut.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class GoodsImpl implements GoodsMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public List searchGoodsByKeyWord(@Param("keyword") String keyword) {
        System.out.println("execute--getGoodslist--dao");
        return sqlSession.getMapper(GoodsMapper.class).searchGoodsByKeyWord(keyword);
    }
}
