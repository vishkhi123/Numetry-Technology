package listCollection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
	
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		//Array List Methods
		//1.add method
		list.add("vishal");
		list.add("rupesh");
		list.add("shubham");
		list.add("akshay");
		list.add("mayur");
		list.add("ganesh");
		list.add("mayur");
		System.out.println(list);
		System.out.println();
		list.stream().forEach(x-> System.out.println(x));
		System.out.println();
		//2.Get Method
		System.out.println(list.get(0));
		System.out.println();
		//3.set Method
		list.set(1, "Rupesh Roy");
		System.out.println(list.get(1));
		System.out.println();
		//4.remove Method
	     Object removed=list.remove(5);
		System.out.println(list.contains(removed));
		//list.remove("ganesh");
		System.out.println();
		//5.indexOf
		System.out.println("Index of object mayur :"+list.indexOf("mayur"));
		System.out.println();
		//6.lastIndexOf
		System.out.println("Index of object mayur :"+list.lastIndexOf("mayur"));
		
	
	
	
	
	
	
	}

}
