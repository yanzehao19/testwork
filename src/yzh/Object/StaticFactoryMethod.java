package yzh.Object;

import java.security.Provider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.ws.Service;



public class StaticFactoryMethod {
	private StaticFactoryMethod() {
	}

	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
	public static final String DEFAULT_PROVIDER_NAME = "<def>";

	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}

	public static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}

	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public static Service newInstance(String name) {
		Provider provider = providers.get(name);
		if (provider == null)
			throw new IllegalArgumentException("No provider registered with name:" + name);
		return provider.newService();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
