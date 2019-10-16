package com.gym.dao;

import com.gym.model.order.AddOrderBean;
import com.gym.model.order.OrderBean;
import com.gym.model.order.ReceiveOrderBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * business:
 * Author:easy
 * Date:19/10/14 下午6:33
 */

@Mapper
@Component
public interface  OrderDao {


    @Insert("insert into `gym`.fit_order (user_id,gym_id,price,start_time,end_time,content,type,status) values " +
            "(#{userId}, #{gymId}, #{price}, #{startTime}, #{endTime}, #{content}, #{type}, #{status})")
    @Options(useGeneratedKeys = true)
    void saveOrder(AddOrderBean addOrderBean);


    @Update("update `gym`.fit_order set receive_id = #{receiveId},receive_time = now(),status= #{status} where id = #{id}")
    void updateOrder(ReceiveOrderBean receiveOrderBean);

    @Results(id = "getGymOrderList", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "gymId", column = "gym_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "startTime", column = "start_time"),
            @Result(property = "endTime", column = "end_time"),
            @Result(property = "receiveId", column = "receive_id"),
            @Result(property = "receiveTime", column = "receive_time"),
    })
    @Select("select * from `gym`.fit_order where gym_id = #{gymId}")
    List<OrderBean> getGymOrderList(String gymId);


} 