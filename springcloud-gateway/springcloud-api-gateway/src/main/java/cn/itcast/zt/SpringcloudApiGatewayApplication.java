package cn.itcast.zt;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 参考文章：介绍服务网关，地址绑定以及权限过滤路由
 * http://blog.didispace.com/springcloud5/
 */
//@SpringBootApplication
@SpringCloudApplication
@EnableZuulProxy
public class SpringcloudApiGatewayApplication {

	/*@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter() ;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudApiGatewayApplication.class, args);
	}
}
