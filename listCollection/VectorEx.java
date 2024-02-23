package listCollection;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector<Integer> vect=new Vector<Integer>();
		
		//1.addElement
			vect.addElement(1);
			vect.addElement(2);
			vect.addElement(3);
			vect.addElement(4);
			vect.addElement(5);
			vect.addElement(6);
			vect.addElement(7);
			System.out.println(vect);
			System.out.println();
			
			//2.firstElement
			System.out.println(vect.firstElement());
			System.out.println();

			//3.lastElement
			System.out.println(vect.lastElement());
			System.out.println();
			
			//4.elementAt
			System.out.println(vect.elementAt(3));
			System.out.println();
			
			//5.remenveElement
			vect.removeElementAt(3);
			System.out.println(vect);
			System.out.println();
			
			
			//6.removeElement
			vect.removeElement(2);
			System.out.println(vect);
			System.out.println();
			
			//7.removeAllElements
			vect.removeAllElements();
			System.out.println(vect);
			System.out.println();
			

	}

}
