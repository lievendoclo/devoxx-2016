package be.insaneprogramming.devoxx;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServer {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServer.class).run(args);
	}
}
