
public class ArrayBagDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//boh = Bag of Holding
		ArrayBag<Integer> boh = new ArrayBag<Integer>();
		
		System.out.println("Getting size: " + boh.getCurrentSize());
		System.out.println("Testing is Empty: " + boh.isEmpty());
		
		System.out.println("Add Successful: " + boh.add(1));
		
		System.out.println("Getting size: " + boh.getCurrentSize());
		System.out.println("Testing is Empty: " + boh.isEmpty());
		
		//Filling our bag
//		for(int i = 2; i < 12; i++) {
//			System.out.println("Add Successful: " + boh.add(i));
//		}
//		System.out.println("Getting size: " + boh.getCurrentSize());
		
		boh.add(5);
		boh.add(4);
		boh.add(5);
		boh.add(6);
		boh.add(8);
		boh.add(7);
		boh.add(7);
		boh.add(9);
		boh.add(5);
		boh.add(8);
		System.out.println("Getting size: " + boh.getCurrentSize());
		
		//Testing remove()
		System.out.println("Removing Element: " + boh.remove());
		System.out.println("Getting size: " + boh.getCurrentSize());
		System.out.println("Removing Element: " + boh.remove());
		System.out.println("Removing Element: " + boh.remove());
		
		System.out.println("Removing one occurance of 5: " + boh.remove(5));
		
		

		//Testing clear()
//		boh.clear();
//		System.out.println("Getting size post-clear: " + boh.getCurrentSize());
//		System.out.println("Testing is Empty: " + boh.isEmpty());
//		System.out.println("Add Successful: " + boh.add(1));
//		System.out.println("Getting size post-add: " + boh.getCurrentSize());
//		System.out.println("Testing is Empty: " + boh.isEmpty());
//		System.out.println("Frequency of 1: " + boh.getFrequencyOf(1));
//		System.out.println("Does 5 exist: " + boh.contains(5));
//		System.out.println("Does 1 exist: " + boh.contains(1));
//		System.out.println("Removing Element: " + boh.remove());
//		System.out.println("Getting size post-removal: " + boh.getCurrentSize());
//		System.out.println("Testing is Empty: " + boh.isEmpty());
		
		//Testing getFrequencyOf() and contains()
		System.out.println("Frequency of 5: " + boh.getFrequencyOf(5));
		System.out.println("Does 5 exist: " + boh.contains(5));
//		System.out.println("Does 10 exist: " + boh.contains(10));
		
		Integer[] myArr = boh.toArray();
		for(int i = 0; i < myArr.length; i++) {
			System.out.print(myArr + ", ");
		}
		
	}

}
