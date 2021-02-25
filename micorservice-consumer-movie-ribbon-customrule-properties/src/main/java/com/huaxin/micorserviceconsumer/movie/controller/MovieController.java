package com.huaxin.micorserviceconsumer.movie.controller;

import com.huaxin.micorserviceconsumer.movie.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @Value("${user.userServicePath2}")
    private String userServicePath2;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        this.restTemplate.getForObject(this.userServicePath2 +"/user/" + id, User.class);
        return this.restTemplate.getForObject(this.userServicePath +"/user/" + id, User.class);
    }

    @GetMapping("/callProvider")
    public String callProvider() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的哪个节点
        log.info("serviceId: {} , host: {} ,port: {} ,uri: {}" ,serviceInstance.getServiceId() , serviceInstance.getHost(), serviceInstance.getPort(),serviceInstance.getUri());
        return serviceInstance.getUri().toString();
    }

    @GetMapping("/searchUser")
    public User searchUser(String name ,String age ,String username) {
        Map<String, Object> paraMap = new HashMap<String ,Object>() {
            {
                put("name",name);
                put("age",age);
                put("username",username);
            }
        };

        return  this.restTemplate.getForObject(this.userServicePath+"/get?name={name}&age={age}&username={username}", User.class, paraMap);

    }

}
