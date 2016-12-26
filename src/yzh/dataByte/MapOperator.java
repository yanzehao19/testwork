package yzh.dataByte;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author yzh
 *
 */
public class MapOperator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("1", new Integer(1));
		map.put("2", new Integer(2));
		map1.put("1", "3");
		map1.put("2", "4");
		System.out.println(map);
		map.putAll(map1);
		System.out.println(map1);

		System.out.println(map);

	}

}
