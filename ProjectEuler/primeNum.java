import java.util.*;
public class primeNum{

	public static void main(String[] args){
		
		int count = 2;
		int sum = 1;
		boolean isPrime;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(count);
		while(sum != 10001){
			count++;
			isPrime = true;
			for(int i : list){
				if(count % i == 0){
					isPrime = false;
				}
			}
			if(isPrime == true){
				list.add(count);
				sum++;
			}
		}

		System.out.println(count);
	}
}
