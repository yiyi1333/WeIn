package cn.edu.zjut.po;

import java.sql.Date;
import java.sql.Time;

public class Collection {
    private Goods goods;
    private Date date;
    private Time time;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
