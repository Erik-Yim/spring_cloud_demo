package cn.itcast.zt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerBRibbonService {
  @Autowired
  private RestTemplate restTemplate;

  public String consumerB(Integer a, Integer b) {
    // http://服务提供者的serviceId/url,ribbon 可以传递很多参数比如httpheader 所以方便集成jwt，oauth2类似我们使用httpClient 去调用
    //web service
    //TODO 了解下RestTemplate 还有Jersey，RESTEasy的rest框架,{1}占位符，还可以使用{key}, 然后参数传入map对应key就会拼上去

    return this.restTemplate.getForObject("http://api-gateway/api-b/add?accessToken={1}&a=" + a + "&b=" + b, String.class,"tokenValue");
  }
}
