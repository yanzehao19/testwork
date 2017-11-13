package concurrentMap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<String, String>();
		concurrentMap.put("key", "value");
		Object value = concurrentMap.get("key");
	}
}
