package cn.edu.zjut.service;

import cn.edu.zjut.dao.DrawBackMapper;
import cn.edu.zjut.po.DrawBack;

import java.util.List;

public class DrawBackService {
    private DrawBackMapper drawBackDao;

    public DrawBackMapper getDrawBackDao() {
        return drawBackDao;
    }

    public void setDrawBackDao(DrawBackMapper drawBackDao) {
        this.drawBackDao = drawBackDao;
    }

    public List<DrawBack> getDrawBackMoneyById(Integer orderId){
        System.out.println("execute --getDrawBackMoneyById()-- method.");
        return drawBackDao.getDrawBackMoneyById(orderId);
    }

    public DrawBack getDrawBackById(DrawBack drawBack) {
        System.out.println("execute --getDrawBackById()-- method.");
        return drawBackDao.getDrawBackById(drawBack);
    }

    public void updateDrawBack(DrawBack drawBack) {
        System.out.println("execute --updateDrawBack()-- method.");
        drawBackDao.updateDrawBack(drawBack);
    }

    public void addDrawBack(DrawBack drawBack) {
        System.out.println("execute --addDrawBack()-- method.");
        drawBackDao.addDrawBack(drawBack);
    }
}
