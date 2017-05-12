package cn.itcast.zt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Erik_Yim on 2017/5/12.
 */
@RestController
public class ConsumerController {

    @Autowired
    private ServiceBFeignClient serviceBFeignClient;

    @RequestMapping("/consumerb")
    public String consumerb(Integer a, Integer b) {
//        return "ff";
        return serviceBFeignClient.consumerB(a, b);
    }

}
