package concurrentNavigableMap;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentNavigableMap {

	public static void main(String[] args) {
		ConcurrentSkipListMap map=new ConcurrentSkipListMap();
		map.put("1","one");
		map.put("2","two");
		map.put("3","three");
		java.util.concurrent.ConcurrentNavigableMap headMap=map.headMap("2");
		java.util.concurrent.ConcurrentNavigableMap tailMap=map.tailMap("2");
		java.util.concurrent.ConcurrentNavigableMap subMap = map.subMap("2", "3");
		
		
	}

}
