package com.gym.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @ClasssName GymInfoDao
 * @Description TODO
 * @Author root
 * @Date 2019/10/12 下午4:05
 **/

@Mapper
@Component
public interface UserDao {

    @Update("update `gym`.user set gym_id = #{gymId} where uuid = #{userId}")
    void updateUserGym(String userId, String gymId);
}
