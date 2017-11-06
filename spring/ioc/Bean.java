package ioc;

import java.util.HashMap;
import java.util.Map;

public class Bean {
/*Bean id*/
	private String id;
	/*Bean class*/
	private String type;
	/*Bean property*/
	private Map<String, Object> properties=new HashMap<String,Object>();
}
