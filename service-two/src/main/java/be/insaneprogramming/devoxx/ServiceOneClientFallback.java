package be.insaneprogramming.devoxx;

public class ServiceOneClientFallback implements ServiceOneClient {
	@Override
	public String getHello() {
		return "Whoops, service one is not available yet";
	}
}
