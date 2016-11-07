package be.insaneprogramming.devoxx;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@EnableEurekaClient
public class ConfigServer {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServer.class).run(args);
	}
}
