package jvm;

/**
 * @Described：蝌蚪网曾经的杯具
 * @author lenovo
 *
 */

public class CothurnusInPassport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<CothurnusInPassport> inPassports = new ArrayList<CothurnusInPassport>();
		inPassports.add(new CothurnusInPassport());
		String xml = XML_Util.createXML(inPassports);
		System.out.println(xml);
	}
	
	class XML_Util{
		public static String createXML(Object obj){
			 return  。。。// ... 通过反射遍历属性 生成对应的XML节点
		}
		public static String createXML(List<Object> objs){
			 StringBuilder sb = new StringBuilder();
			 for(Object obj : objs)
				 sb.append(createXML(obj));
			 return new String(sb);
		}
	}

}
