package com.gym.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gym.dao.GymInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClasssName GymInfoDao
 * @Description TODO
 * @Author root
 * @Date 2019/10/12 下午4:05
 **/

@Component
public class GymInfoService {

    @Autowired
    private GymInfoDao gymInfoDao;

    public List<Map<String,Object>> findAllGymInfo(){
        return gymInfoDao.findAllGymInfo();
    }

    /**
     * @Author zhanglonglong
     * @Description //TODO 分页
     * @Date 2019/10/12 下午4:45
     * @Param []
     * @return List<Map<String,Object>>
     **/
    public Page findAllGymInfo2Page(int start, int limit){
        PageHelper.startPage(start,limit);
        return (Page)gymInfoDao.findAllGymInfo();
    }
}
