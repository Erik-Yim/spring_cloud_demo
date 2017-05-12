package cn.itcast.zt.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Erik_Yim on 2017/5/12.
 */
@FeignClient(name = "api-gateway")
public interface ServiceBFeignClient {


    @RequestMapping("/api-b/add")
    //使用feign一定要使用RequestParam并且要写名字，或者PathVariable一定要加名称不然会报错
    public String consumerB(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
