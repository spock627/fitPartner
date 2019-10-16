package com.gym.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author jarek
 */
@Log4j2
@Component
public class LoginService {
    @Autowired
    private ApiWrapper apiWrapper;



}
