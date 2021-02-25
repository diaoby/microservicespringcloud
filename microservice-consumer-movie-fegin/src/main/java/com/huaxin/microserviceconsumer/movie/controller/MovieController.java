package com.huaxin.microserviceconsumer.movie.controller;

import com.huaxin.microserviceconsumer.movie.feignclient.UserFeignClient;
import com.huaxin.microserviceconsumer.movie.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：diaoby
 * @date ：Created in 2021/2/24 13:39
 * @description：电影服务
 * @modified By：
 */
@RestController
@Slf4j
public class MovieController {

    @Autowired
    private UserFeignClient userClient;
    /**
     *
     * @param user
     * @return
     * 	调用会出错
     */
    @GetMapping("/movie/getA")
    public User findUser(User user) {
        log.info("get进入服务消费者 MovieController.findUser");
        return userClient.finUser(user);
    }

    @GetMapping("/movie/getB")
    public User findUser2(User user) {
        log.info("get2进入服务消费者 MovieController.findUser2");
        return userClient.finUser(user.getUsername(),user.getAge());
    }

    @GetMapping("/movie/getC")
    public User findUser3(User user) {
        log.info("get2进入服务消费者 MovieController.findUser3");
        Map<String, Object> map = new HashMap<String, Object>() {
            {
                put("username",user.getUsername());
                put("age",user.getAge());
            }
        };
        return userClient.finUser(map);
    }
}
