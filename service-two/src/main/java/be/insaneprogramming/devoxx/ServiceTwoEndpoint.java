package be.insaneprogramming.devoxx;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients
public class ServiceTwoEndpoint {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	ServiceOneClientFallback serviceOneClientFallback() {
		return new ServiceOneClientFallback();
	}

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ServiceOneClient serviceOneClient;

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceTwoEndpoint.class).run(args);
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String helloServiceTwo() {
		return "Hello from service two (" + getIp() + ") with a message from service one:" + getMessageFromServiceOne();
	}

	@RequestMapping("/feign")
	@ResponseBody
	public String helloServiceTwoWithFeign() {
		return "Hello from service two (" + getIp() + ") with a message from service one with Feign:" + getMessageFromFeign();
	}

	private String getMessageFromFeign() {
		return serviceOneClient.getHello();
	}

	private String getMessageFromServiceOne() {
		return restTemplate.getForObject("http://service-one/hello", String.class);
	}

	private String getIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
}
