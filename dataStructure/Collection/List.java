package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class List {
	public static void main(String[] args) {
		java.util.List<String> strlists = new ArrayList<String>();
		strlists.add("1");
		strlists.add("2");
		strlists.add("3");
		System.out.println(strlists);
		for (String strlist : strlists) {
			strlist = "4";
		}
		for (String strlist : strlists) {
			System.out.println(strlist);
		}

		int amount = 0;
		java.util.List<Map> list = new ArrayList<Map>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 2);
		map.put("A", 2);
		map.put("B", 4);
		list.add(map);
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("A", 2);
		map1.put("A", 2);
		map1.put("B", 4);
		list.add(map1);
		System.out.println(list);
		for (Map<String, Integer> m : list)
			for (String key : m.keySet())
				if (key.contains("B"))
					if (m.get(key) > 3) {
						amount = 10;
						System.out.println("true");
						break;

					}

	}

}
