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

    //zuul 可以继承Feign 和Ribbon用，因为我再zuul中写了filter需要再http中获取accessToken但是feign不好传这个参数所以就有问题，去掉filter就可以了
    //但是用ribbon就可以，直接在url中后面拼接accessToken参数
    @RequestMapping("/consumerb")
    public String consumerb(Integer a, Integer b) {
//        return "ff";
        return serviceBFeignClient.consumerB(a, b);
    }

}
