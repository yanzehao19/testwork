package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class TestListMap {
	static int i=0;
	public static void main(String[] args) {
		Map<String ,String> map=new HashMap<String ,String>();
		List<Map<String, String>> list=new ArrayList<>();
		map.put("1", "111");
		map.put("2", "2222");
		
		list.add(map);
		for(Map<String, String> m:list) {
			for(String kString:m.keySet()) {
				System.out.println("11"+m.get(kString));
			}
		}
	//	list.forEach(item->{item.entrySet().});
	}

}
