package cn.edu.zjut.dao;

import cn.edu.zjut.po.DrawBack;
import cn.edu.zjut.po.OrderStatus;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class DrawBackImpl implements DrawBackMapper {
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<DrawBack> getDrawBackMoneyById(Integer orderId) {
        System.out.println("execute --getDrawBackMoneyById()-- dao.");
        return sqlSession.getMapper(DrawBackMapper.class).getDrawBackMoneyById(orderId);
    }

    @Override
    public DrawBack getDrawBackById(DrawBack drawBack) {
        System.out.println("execute --getDrawBackById()-- dao.");
        return sqlSession.getMapper(DrawBackMapper.class).getDrawBackById(drawBack);
    }

    @Override
    public void updateDrawBack(DrawBack drawBack) {
        System.out.println("execute --updateDrawBack()-- dao.");
        sqlSession.getMapper(DrawBackMapper.class).updateDrawBack(drawBack);
    }

    @Override
    public void addDrawBack(DrawBack drawBack) {
        System.out.println("execute --addDrawBack()-- dao.");
        sqlSession.getMapper(DrawBackMapper.class).addDrawBack(drawBack);
    }
}