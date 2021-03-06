package com.erik.cloud.demo.user.feign;

import com.erik.cloud.demo.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erik.cloud.demo.user.feign.UserFeignHystrixClient.HystrixClientFallback;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 * @author erik
 */
@FeignClient(name = "microservice-provider-user", fallback = HystrixClientFallback.class)
@Primary //这个注解是有多个实现类时候优先使用这个实现类，和@FeiginClient
public interface UserFeignHystrixClient {
  @RequestMapping("/{id}")
  public User findByIdFeign(@RequestParam("id") Long id);

  /**
   * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
   * @author erik
   */
  @Component
  static class HystrixClientFallback implements UserFeignHystrixClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    @Override
    public User findByIdFeign(Long id) {
      HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
      User user = new User();
      user.setId(-1L);
      user.setUsername("default username");
      user.setAge(0);
      return user;
    }
  }
}
