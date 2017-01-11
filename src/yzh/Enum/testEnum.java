package yzh.Enum;

public class testEnum {

	public static void main(String[] args) {
		System.out.println(isRed(Color.BLANK));
		System.out.println(isRed(Color.RED));
		System.out.println(Color.RED.getName());
		System.out.println(Color.RED.getIndex());
		for (Color color : Color.values()) {
			System.out.println(color + "name:" + color.getName() + "index:" + color.getIndex());
		}
	}

	static boolean isRed(Color color) {
		if (Color.RED.equals(color)) {
			return true;
		}
		return false;
	}

}
