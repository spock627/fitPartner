package com.gym.dao;

import com.gym.model.order.AddOrderBean;
import com.gym.model.order.ReceiveOrderBean;
import org.apache.ibatis.annotations.*;

/**
 * business:
 * Author:easy
 * Date:19/10/14 下午6:33
 */

@Mapper
public interface  OrderDao {


    @Insert("insert into `gym`.fit_order (user_id,gym_id,price,start_time,end_time,content,type,status) values " +
            "(#{userId}, #{gymId}, #{price}, #{start_time}, #{end_time}, #{content},#{type}, #{status})")
    @Options(useGeneratedKeys = true)
    void saveOrder(AddOrderBean addOrderBean);


    @Update("update `gym`.fit_order set receive_id = #{receive_id},status= #{status} where id = #{id}")
    void updateOrder(ReceiveOrderBean receiveOrderBean);
} 