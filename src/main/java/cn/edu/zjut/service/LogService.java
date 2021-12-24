package cn.edu.zjut.service;

import cn.edu.zjut.dao.LogMapper;
import cn.edu.zjut.po.Log;
import org.springframework.stereotype.Service;


/**
 * @author hydrogen_zyx
 */
@Service
public class LogService {
    private LogMapper logMapper;

    public LogMapper getLogMapper() {
        return logMapper;
    }

    public void setLogMapper(LogMapper logMapper) {
        this.logMapper = logMapper;
    }

    public int insert(Log record) {
        return logMapper.insert(record);
    }
}

