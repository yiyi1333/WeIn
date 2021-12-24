package cn.edu.zjut.service;

import cn.edu.zjut.dao.HistoryMapper;
import cn.edu.zjut.po.History;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

public class HistoryService {
    private HistoryMapper histortDao;

    public HistoryMapper getHistortDao() {
        return histortDao;
    }

    public void setHistortDao(HistoryMapper histortDao) {
        this.histortDao = histortDao;
    }

    public boolean addHistory(Integer customerId, Integer goodsId){
        boolean flag = false;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        Time time = new Time(date.getTime());
        System.out.println(time);
        if(histortDao.addHistory(customerId, goodsId, date, time) != null){
            flag = true;
        }
        return flag;
    }

    public List<History> selectAllHistory(Integer customerId){
        List<History> list = histortDao.selectAllHistory(customerId);
        return list;
    }
}
