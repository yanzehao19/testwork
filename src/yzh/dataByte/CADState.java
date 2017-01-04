package yzh.dataByte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

abstract class Shape implements Serializable {
	public static final int RED = 1, BLUE = 2, GREEN = 3;
	private int xPos, yPos, dimension;
	private static Random r = new Random();
	private static int counter = 0;

	abstract public void setColor(int newColor);

	abstract public int getColor();

	public Shape(int xVal, int yVal, int dim) {
		xPos = xVal;
		yPos = yVal;
		dimension = dim;
	}

	public String toString() {
		return getClass().toString() + "colr[" + getColor() + "]xPos[" + xPos + "]yPos[" + yPos + "]dim[" + dimension
				+ "]\n";

	}

	public static Shape randomFactory() {
		int xVal = r.nextInt() % 100;
		int yVal = r.nextInt() % 100;
		int dim = r.nextInt() % 100;
		switch (counter++ % 3) {
		default:
		case 0:
			return new Circle(xVal, yVal, dim);
		case 1:
			return new Square(xVal, yVal, dim);
		case 2:
			return new Line(xVal, yVal, dim);
		}
	}
}

class Circle extends Shape {
	private static int color = RED;

	public Circle(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

class Square extends Shape {
	private static int color;

	public Square(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		color = RED;
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

class Line extends Shape {
	private static int color = RED;

	public static void serializeStaticState(ObjectOutputStream os) throws IOException {
		os.writeInt(color);
	}

	public static void deserializeStaticState(ObjectInputStream os) throws IOException {
		color = os.readInt();
	}

	public Line(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	public void setColor(int newColor) {
		color = newColor;
	}

	public int getColor() {
		return color;
	}
}

public class CADState {

	public static void main(String[] args) throws Exception {
		Vector shapeTypes, shapes;
		if (args.length == 0) {
			shapeTypes = new Vector();
			shapes = new Vector();
			shapeTypes.addElement(Circle.class);
			shapeTypes.addElement(Square.class);
			shapeTypes.addElement(Line.class);
			for (int i = 0; i < 10; i++)
				shapes.addElement(Shape.randomFactory());
			for (int i = 0; i < 10; i++)
				((Shape) shapes.elementAt(i)).setColor(Shape.GREEN);
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("CADState.out"));
			outputStream.writeObject(shapeTypes);
			Line.serializeStaticState(outputStream);
			outputStream.writeObject(shapes);
		} else {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
			shapeTypes = (Vector) in.readObject();
			Line.deserializeStaticState(in);
			shapes = (Vector) in.readObject();
		}
		System.out.println(shapes);
	}

}
