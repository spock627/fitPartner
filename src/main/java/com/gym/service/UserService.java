package com.gym.service;

import com.gym.dao.UserDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * business:
 * Author:easy
 * Date:19/10/17 下午5:53
 */

@Service
@Log4j2
public class UserService {
    @Autowired
    private UserDao userDao;

    public void setUserGym(String userId, String gymId) {
        userDao.updateUserGym(userId, gymId);
    }
} 