package cn.edu.zjut.dao;

import cn.edu.zjut.po.NewOrder;
import org.mybatis.spring.SqlSessionTemplate;

public class NewOrderImpl implements NewOrderMapper {
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Integer addOrder(NewOrder newOrder) {
        return sqlSession.getMapper(NewOrderMapper.class).addOrder(newOrder);
    }


}
