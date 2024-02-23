package listCollection;

import java.util.LinkedList;

public class LinkedListEx {
	public static void main(String[] args) {
		
		LinkedList<Integer> list=new LinkedList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(5);
		
		//1.addFirst
		list.addFirst(100);
		System.out.println(list);
		System.out.println();
		
		//2.add last
		list.addLast(500);
		System.out.println(list);
		System.out.println();
		
		//3.GetFirst
		System.out.println(list.getFirst());
		System.out.println();
		
		//4.GetLast
		System.out.println(list.getLast());
		System.out.println();
		
		//5.removeFirst
		System.out.println(list.removeFirst());
		System.out.println();
		
		//6.removeLast
		System.out.println(list.removeLast());
		System.out.println();
		
		//7.removeFirstOccurrence
		System.out.println(list.removeFirstOccurrence(1));
		System.out.println(list);
		System.out.println();
		
		
		//8.removeLastOccurrence
		System.out.println(list.removeLastOccurrence(5));
		System.out.println(list);
		System.out.println();
		
		
		
		
		
		
		
		
	}

}
