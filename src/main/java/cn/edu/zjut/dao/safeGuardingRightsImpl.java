package cn.edu.zjut.dao;

import cn.edu.zjut.po.safeGuardingRights;
import cn.edu.zjut.po.safeGuardingRightsProgress;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class safeGuardingRightsImpl implements safeGuardingRightsMapper{
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<safeGuardingRights> getAllsafeGuardingRights() {
        return sqlSession.getMapper(safeGuardingRightsMapper.class).getAllsafeGuardingRights();
    }

    @Override
    public safeGuardingRights selectsafeGuardingRightsById(Integer safeGuardingRightsId) {
        return sqlSession.getMapper(safeGuardingRightsMapper.class).selectsafeGuardingRightsById(safeGuardingRightsId);
    }

    @Override
    public List<safeGuardingRights> selectsafeGuardingRights(safeGuardingRights safeGuardingRights) {
        return sqlSession.getMapper(safeGuardingRightsMapper.class).selectsafeGuardingRights(safeGuardingRights);
    }

    @Override
    public void updatesafeGuardingRights(safeGuardingRights safeGuardingRights) {
        sqlSession.getMapper(safeGuardingRightsMapper.class).updatesafeGuardingRights(safeGuardingRights);
    }

    @Override
    public List<safeGuardingRightsProgress> getsafeGuardingRightsProgressById(Integer safeGuardingRightsId) {
        return sqlSession.getMapper(safeGuardingRightsMapper.class).getsafeGuardingRightsProgressById(safeGuardingRightsId);
    }
    @Override
    public Integer addSafeGuardingRightsRecord(Integer goodsId, Integer goodsNum, String descript, String imagePath,
                                               Integer orderId, String type, String status) {
        SqlSession session = sqlSession.getSqlSessionFactory().openSession();
        safeGuardingRightsMapper safeGuardingRightsMapper = sqlSession.getMapper(safeGuardingRightsMapper.class);
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

    @Override
    public List<safeGuardingRights> selectSafeGuardingRightsByGoodId(Integer goodId) {
        return sqlSession.getMapper(safeGuardingRightsMapper.class).selectSafeGuardingRightsByGoodId(goodId);
    }
}
