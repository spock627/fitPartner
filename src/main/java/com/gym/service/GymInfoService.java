package com.gym.service;

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

    @Autowired(required = false)
    private GymInfoDao gymInfoDao;

    public List<Map<String,Object>> findAllGymInfo(){
        return gymInfoDao.findAllGymInfo();
    }

}
