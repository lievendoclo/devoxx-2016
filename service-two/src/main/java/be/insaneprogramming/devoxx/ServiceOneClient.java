package be.insaneprogramming.devoxx;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-one", fallback = ServiceOneClientFallback.class)
public interface ServiceOneClient {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String getHello();
}
