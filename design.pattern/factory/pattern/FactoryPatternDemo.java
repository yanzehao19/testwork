package factory.pattern;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory=new ShapeFactory();
		//获取circle对象，并调用它的draw方法
		Shape shape1=shapeFactory.getShape("CIRCLE");
		shape1.draw();
		Shape shape2=shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		Shape shape3=shapeFactory.getShape("SQUARE");
		shape3.draw();
	}

}
