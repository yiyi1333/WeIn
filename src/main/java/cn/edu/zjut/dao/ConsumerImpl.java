package cn.edu.zjut.dao;

import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.EnterpriseConsumer;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class ConsumerImpl implements ConsumerMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public List<Consumer> getAllConsumer() {
        System.out.println("execute--getConsumer--dao");
        return sqlSession.getMapper(ConsumerMapper.class).getAllConsumer();
    }

    @Override
    public void addConsumer(Consumer consumer) {
        System.out.println("execute--addConsumer--dao");
        sqlSession.getMapper(ConsumerMapper.class).addConsumer(consumer);
    }

    @Override
    public Consumer searchUser(String phoneNumber) {
        return sqlSession.getMapper(ConsumerMapper.class).searchUser(phoneNumber);
    }

    @Override
    public EnterpriseConsumer searchEnterpriseConsumer(String phoneNumber) {
        return sqlSession.getMapper(ConsumerMapper.class).searchEnterpriseConsumer(phoneNumber);
    }


}
