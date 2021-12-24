package cn.edu.zjut.service;

import cn.edu.zjut.dao.CollectionMapper;
import cn.edu.zjut.po.Collection;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

public class CollectionService {
    private CollectionMapper collectionDao;

    public CollectionMapper getCollectionDao() {
        return collectionDao;
    }

    public void setCollectionDao(CollectionMapper collectionDao) {
        this.collectionDao = collectionDao;
    }

    public boolean addCollection(Integer customerId, Integer goodsId){
        boolean flag = false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy--MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        Time time = new Time(date.getTime());
        if(collectionDao.addCollection(customerId, goodsId, date, time) != null){
            flag = true;
        }
        return flag;
    }
    //查询出用户的全部收藏
    public List<Collection> selectAllCollection(Integer customerId){
        List<Collection> list = collectionDao.selectAllCollection(customerId);
        return list;
    }
}
