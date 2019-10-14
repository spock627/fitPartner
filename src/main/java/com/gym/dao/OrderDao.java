package com.gym.dao;

import com.gym.model.order.OrderBean;
import org.apache.ibatis.annotations.*;

/**
 * business:
 * Author:easy
 * Date:19/10/14 下午6:33
 */

@Mapper
public interface  OrderDao {


    @Insert("insert into `gym`.fit_order (user_id,gym_id,price,create_time,start_time,end_time,content,receive_id,receive_time,type) values " +
            "(#{userId}, #{gymId}, #{price}, #{create_time}, #{start_time}, #{end_time}, #{content}, #{receive_id}, #{receive_time},#{type})")
    @Options(useGeneratedKeys = true)
    void saveOrder(OrderBean orderBean);

} 