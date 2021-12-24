package cn.edu.zjut.dao;

import cn.edu.zjut.po.SafeGuardingRights;
import cn.edu.zjut.po.SafeGuardingRightsProgress;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class SafeGuardingRightsImpl implements SafeGuardingRightsMapper {
    SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<SafeGuardingRights> getAllsafeGuardingRights() {
        return sqlSession.getMapper(SafeGuardingRightsMapper.class).getAllsafeGuardingRights();
    }

    @Override
    public SafeGuardingRights selectsafeGuardingRightsById(Integer safeGuardingRightsId) {
        return sqlSession.getMapper(SafeGuardingRightsMapper.class).selectsafeGuardingRightsById(safeGuardingRightsId);
    }

    @Override
    public List<SafeGuardingRights> selectsafeGuardingRights(SafeGuardingRights safeGuardingRights) {
        return sqlSession.getMapper(SafeGuardingRightsMapper.class).selectsafeGuardingRights(safeGuardingRights);
    }

    @Override
    public void updatesafeGuardingRights(SafeGuardingRights safeGuardingRights) {
        sqlSession.getMapper(SafeGuardingRightsMapper.class).updatesafeGuardingRights(safeGuardingRights);
    }

    @Override
    public List<SafeGuardingRightsProgress> getsafeGuardingRightsProgressById(Integer safeGuardingRightsId) {
        return sqlSession.getMapper(SafeGuardingRightsMapper.class).getsafeGuardingRightsProgressById(safeGuardingRightsId);
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

    @Override
    public SafeGuardingRights selectSafeGuardingRightsByGoodIdAndOrderId(Integer goodId, Integer orderId) {
        return sqlSession.getMapper(SafeGuardingRightsMapper.class).selectSafeGuardingRightsByGoodIdAndOrderId(goodId, orderId);
    }
}
