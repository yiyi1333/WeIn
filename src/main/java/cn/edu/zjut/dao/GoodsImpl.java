package cn.edu.zjut.dao;

import cn.edu.zjut.po.Goods;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public List searchGoodsByKeyWord(@Param("keyword") String keyword) {
        System.out.println("execute--getGoodslist--dao");
        return sqlSession.getMapper(GoodsMapper.class).searchGoodsByKeyWord(keyword);
    }

    @Override
    public Goods getGoodById(Integer goodid) {
        System.out.println("execute--getGood--dao");
        return sqlSession.getMapper(GoodsMapper.class).getGoodById(goodid);
    }

    @Override
    public void updateGoods(Goods goods) {
        System.out.println("execute--updateGoods--dao");
        sqlSession.getMapper(GoodsMapper.class).updateGoods(goods);
    }

    @Override
    public void addGoods(Goods goods) {
        System.out.println("execute--addGoods--dao");
        sqlSession.getMapper(GoodsMapper.class).addGoods(goods);
    }

    @Override
    public List<Goods> selectGoods(Goods goods) {
        System.out.println("execute --selectGoods()-- method.");
        return sqlSession.getMapper(GoodsMapper.class).selectGoods(goods);
    }

    @Override
    public void deleteGoods(Integer goodid) {
        System.out.println("execute --deleteGoods()-- method.");
        sqlSession.getMapper(GoodsMapper.class).deleteGoods(goodid);
    }

    @Override
    public List<Goods> selectGoodsByWarehouseId(Integer warehouseId) {
        System.out.println("execute--selectGoodsByWarehouseId--dao");
        return sqlSession.getMapper(GoodsMapper.class).selectGoodsByWarehouseId(warehouseId);
    }
}
