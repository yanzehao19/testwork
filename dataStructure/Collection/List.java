package Collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import iterator.pattern.Iterator;

public class List {
	public static void main(String[] args) throws ParseException {
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
		Class clazz = strlists.getClass();
		int amount = 0;
		java.util.List<Map> list = new ArrayList<Map>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 2);
		map.put("A", 2);
		map.put("B", 4);
		list.add(map);
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("A", 2);
		map1.put("A", null);
		map1.put(null, null);
		Integer integer = map1.get("B");
		Set<Entry<String, Integer>> set = map1.entrySet();
		java.util.Iterator<Entry<String, Integer>> iterator = map1.entrySet().iterator();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		String dateStr = simpleDateFormat.format(date);
		dateStr = dateStr.split(" ")[0];
		Date datetemp = (Date) simpleDateFormat.parseObject(dateStr + " 23:59:59");

		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
		}

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
