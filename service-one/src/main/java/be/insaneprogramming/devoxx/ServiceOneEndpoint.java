package be.insaneprogramming.devoxx;

import java.util.Random;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ServiceOneEndpoint {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceOneEndpoint.class).run(args);
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String helloServiceOne() {
		return "Hello from service one (" + randomNumber() + ")";
	}

	@Bean
	public Integer randomNumber() {
		return new Random().nextInt();
	}
}
