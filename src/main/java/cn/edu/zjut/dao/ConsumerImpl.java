package cn.edu.zjut.dao;

import cn.edu.zjut.po.Consumer;
import cn.edu.zjut.po.EnterpriseConsumer;
import org.apache.ibatis.session.SqlSession;
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

    @Override
    public EnterpriseConsumer searchEnterpriseConsumerById(Integer consumerId) {
        return sqlSession.getMapper(ConsumerMapper.class).searchEnterpriseConsumerById(consumerId);
    }

    @Override
    public void updateWxInfo(String phoneNumber, String nickName, String avatarUrl) {
        sqlSession.getMapper(ConsumerMapper.class).updateWxInfo(phoneNumber, nickName, avatarUrl);
    }

    @Override
    public Integer modfiyCertificationInfo(Integer consumerId, String realName, String idNumber) {
        SqlSession session = sqlSession.getSqlSessionFactory().openSession();
        ConsumerMapper consumerMapper = sqlSession.getMapper(ConsumerMapper.class);
        Integer line = null;
        try {
            line = consumerMapper.modfiyCertificationInfo(consumerId, realName, idNumber);
            System.out.println(line);
            session.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return line;
    }
}
