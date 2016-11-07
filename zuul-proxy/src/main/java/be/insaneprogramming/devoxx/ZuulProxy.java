package be.insaneprogramming.devoxx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulProxy {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulProxy.class).run(args);
	}
}
