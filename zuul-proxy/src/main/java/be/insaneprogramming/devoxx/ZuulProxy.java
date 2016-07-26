package be.insaneprogramming.devoxx;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulProxy {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulProxy.class).run(args);
	}
}
