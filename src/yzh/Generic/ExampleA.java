package yzh.Generic;

public class ExampleA {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}

	public static void main(String[] args) {
		ExampleA ea = new ExampleA();
		ea.f("");
		ea.f(10);
		ea.f('a');
		ea.f(ea);
	}
}
