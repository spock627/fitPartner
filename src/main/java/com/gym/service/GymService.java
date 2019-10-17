package com.gym.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gym.dao.GymDao;
import com.gym.model.gym.GymBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClasssName GymInfoDao
 * @Description TODO
 * @Author root
 * @Date 2019/10/12 下午4:05
 **/

@Service
public class GymService {

    @Autowired
    private GymDao gymDao;

    public List<Map<String,Object>> findAllGymInfo(){
        return gymDao.findAllGymInfo();
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
        return (Page)gymDao.findAllGymInfo();
    }

    /**
     * 获取附近的健身房
     * @return
     */
    public List<GymBean> getNearbyGymList() {
        List<GymBean> gymList = gymDao.getNearbyGymList();
        return gymList;
    }
}
