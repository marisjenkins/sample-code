// In the language of your choice, write code that prints every third element of this list using recursion. [1, 2, 3, 4, 5, 6, 7, 8, 9].
// Here I assume every third element of this list produces the following output: 3 6 9
// Many things can be done differently in this code and I will explain variations in comments

import java.util.*;

public class example1 {

	public static void main(String[] args) {
		thirdElement();
	}
  
  	// this method set up our list and calls the recursive helper function.
  	// I could set up my list in the main method and therefore eliminate the use of the "helper" method
  	// I choose to keep my main method clean and to the point
  	// This function could also take in an array or list of numbers that it creates the list from, which would be more flexible for future use
	public static void thirdElement() {
    		// here I create the given example list
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		helper(list);
	}
	
	public static void helper(ArrayList<Integer> list) {
		if (list.size() >= 3) {
			System.out.println(list.get(2)); // zero based indexing
      			// i could use a loop to iterate over the first 3 elements and remove them instead if i wanted
			list.remove(0);
			list.remove(0);
			list.remove(0);
			helper(list); // recursive part
		}
	}
  
}
