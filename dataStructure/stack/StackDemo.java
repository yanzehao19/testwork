package stack;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

import examples.Chapter2.Item6.Stack;

public class StackDemo {

	static void showpush(Stack st, int a) {
		st.push(new Integer(a));
		System.out.println("push(" + a + ")");
		System.out.println("stack: " + st);
	}

	static void showpop(Stack stack) {
		System.out.print("pop -> ");
		Integer aInteger = (Integer) stack.pop();
		System.out.println(aInteger);
		System.out.println("stack: " + stack);
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		System.out.println("stack: " + st);
		showpush(st, 42);
		showpush(st, 66);
		showpush(st, 99);
		showpop(st);
		showpop(st);
		showpop(st);
		
		
		Map<String , String> m1= new HashMap<>();
		m1.put("1", "2");
		System.out.println(m1);
		
		
		try {
			showpop(st);
		} catch (EmptyStackException e) {
			System.out.println("empty stack");
		}
		
		
		
	}

}
