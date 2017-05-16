package cn.itcast.zt.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Erik_Yim on 2017/5/12.
 */
@FeignClient(name = "api-gateway") //name 不区分大小写
public interface ServiceBFeignClient {


    @RequestMapping("/api-b/add")
    //使用feign一定要使用RequestParam并且要写名字，或者PathVariable一定要加名称不然会报错
    //feign参数的内容就是相当于http请求中参数和header，和我要调用的方法的参数可以不一样
    //之前的那个filter需要传accessToken 可以直接在方法里加上@RequestParam("AccessToken") String accessToken,api-gateway 就能取到token了
    //这里面的方法签名不需要和调用的方法签名一样，可以多一些就行了，但是参数名称是一样的，原理就是把这些值和名称放到http request中
    public String consumerB(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    //feign 使用教程@RequestHeader("accessToken")和@RequestParam("a")参数不能少，通过这个把http的请求参数名称拼接到URI中
    //下面这个方法的解释为调用/api-b/add使用get方法发送，在http中加入请求参数a和b，并且加上请求头accessToken
    @RequestMapping(value="/api-b/add", method = RequestMethod.GET)
    public String consumerB2(@RequestHeader("accessToken") String accessToken, @RequestParam("a") Integer a, @RequestParam("b") Integer b);


    //feign 传递复杂对象，其实就是包装一层，然后外面代理，把参数解析按照你的mapping和参数的类型在使用RestTemplate 传到后台去
    //这个方法签名和你调用的api的方法签名不一样的，这是两个方法，并不是同一个方法
    @RequestMapping(value="/api-b/add", method = RequestMethod.GET)
    public String consumerB2(@RequestBody ConsumerBVO consumerBVO);
}
