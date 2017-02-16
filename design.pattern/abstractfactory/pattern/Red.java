package abstractfactory.pattern;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method");
	}

}
