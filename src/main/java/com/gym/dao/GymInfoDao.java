package com.gym.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ClasssName GymInfoDao
 * @Description TODO
 * @Author root
 * @Date 2019/10/12 下午4:05
 **/

@Mapper
public interface  GymInfoDao {

    @Select("select * from recommend_gym ")
    List<Map<String,Object>> findAllGymInfo();

    @Select("select * from recommend_gym ")
    Page<Map<String,Object>> findAllGymInfo2Page();
}
