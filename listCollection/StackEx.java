package listCollection;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> stack=new Stack<String>();
		//1.push
		stack.push("Vishal");
		stack.push("mayur");
		stack.push("rupesh");
		stack.push("ganesh");
		stack.push("akshay");
		
		System.out.println(stack);
		System.out.println();
		
		//2.pop
		stack.pop();
		System.out.println(stack);
		System.out.println();
		
		//3.peek
		System.out.println(stack.peek());
		System.out.println();
		
		//4.search
		System.out.println(stack.search("mayur")); //gives index value from top
		

	}

}
