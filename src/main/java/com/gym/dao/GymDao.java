package com.gym.dao;

import com.github.pagehelper.Page;
import com.gym.model.gym.GymBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClasssName GymInfoDao
 * @Description TODO
 * @Author root
 * @Date 2019/10/12 下午4:05
 **/

@Mapper
@Component
public interface GymDao {

    @Select("select * from recommend_gym ")
    List<Map<String,Object>> findAllGymInfo();

    @Select("select * from recommend_gym ")
    Page<Map<String,Object>> findAllGymInfo2Page();

    @Select("select * from `gym`.recommend_gym where id = #{gymId}")
    GymBean  getGymInfo(String gymId);

    @Select("select * from recommend_gym where name like \"SUPER%\"")
    List<GymBean> getNearbyGymList();
}
