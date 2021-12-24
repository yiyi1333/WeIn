package cn.edu.zjut.dao;

import cn.edu.zjut.po.Log;
import org.mybatis.spring.SqlSessionTemplate;

public class LogImpl implements LogMapper {

    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insert(Log record) {
        return sqlSession.getMapper(LogMapper.class).insert(record);
    }
}
