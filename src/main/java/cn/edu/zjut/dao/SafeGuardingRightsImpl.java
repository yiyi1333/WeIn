package cn.edu.zjut.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

public class SafeGuardingRightsImpl implements SafeGuardingRightsMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public Integer addSafeGuardingRightsRecord(Integer goodsId, Integer goodsNum, String descript, String imagePath,
                                               Integer orderId, String type, String status) {
        SqlSession session = sqlSession.getSqlSessionFactory().openSession();
        SafeGuardingRightsMapper safeGuardingRightsMapper = sqlSession.getMapper(SafeGuardingRightsMapper.class);
        Integer line = null;
        try {
            line = safeGuardingRightsMapper.addSafeGuardingRightsRecord(goodsId, goodsNum, descript, imagePath, orderId, type, status);
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
