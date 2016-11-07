package be.insaneprogramming.devoxx;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableEurekaClient
public class ServiceOneEndpoint {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceOneEndpoint.class).run(args);
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String helloServiceOne() {
		return "Hello from service one (" + getIp() + ")";
	}

	private String getIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
}
