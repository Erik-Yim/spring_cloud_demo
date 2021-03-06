package com.erik.cloud.demo.user.controller;

import com.erik.cloud.demo.user.entity.User;
import com.erik.cloud.demo.user.feign.UserFeignHystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignHystrixController {
 // @Qualifier("microservice-provider-user")
 // @Qualifier("hystrixClientFallback")
  @Autowired
  private UserFeignHystrixClient userFeignHystrixClient;

  @GetMapping("feign/{id}")
  public User findByIdFeign(@PathVariable Long id) {
    User user = this.userFeignHystrixClient.findByIdFeign(id);
    return user;
  }
}
