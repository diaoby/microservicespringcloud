package com.huaxin.micorserviceconsumer.movie.controller;

import com.huaxin.micorserviceconsumer.movie.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：diaoby
 * @date ：Created in 2021/2/24 13:39
 * @description：电影服务
 * @modified By：
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServicePath + id, User.class);
    }
}
