package cn.itcast.zt;

import cn.itcast.zt.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 参考文章：介绍服务网关，地址绑定以及权限过滤路由
 *
 * 在filter中集成spring security或者jwt,oauth2等实现保护接口安全访问。
 *
 * http://blog.didispace.com/springcloud5/
 */
//@SpringBootApplication
@SpringCloudApplication
@EnableZuulProxy
public class SpringcloudApiGatewayApplication {


	//ribbon调用路由的时候传递token过来了，所以过滤器可以，不需要注解这个
	//但是用feign暂时不能通过url传递其他参数过来和httpHeader过来所以那个demo需要注释这个filter
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter() ;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudApiGatewayApplication.class, args);
	}
}
