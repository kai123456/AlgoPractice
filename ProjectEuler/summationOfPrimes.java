import java.util.*;
import java.lang.*;
public class summationOfPrimes{

	public static void main(String[] args){
	
		long answer = 2;
		long sum = 3;
		boolean isPrime = true;
		while(sum < 2000000){
			for(int i=2; i<=Math.sqrt(sum); i++){
				if(sum%i == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime == true){
				answer += sum;
			}
			isPrime = true;
			sum += 2;
		}

		System.out.println(answer);

	}
}

//142913828922