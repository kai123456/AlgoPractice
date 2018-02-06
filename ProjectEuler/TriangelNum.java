import java.lang.Math;
public class TriangelNum{

	public static void main(String[] args){

		System.out.println(trangelNum());

	} 

	public static long trangelNum(){
	    long number = 1;
	    long nextNum = 2;
	    while (numOfDivisor(number) < 500) {
	        number += nextNum++;
	    }
		return number;
	}


	public static long numOfDivisor(long num){
		long divisor = 0;
		for(long i=1; i*i<=num; i++){
			if(num % i == 0){
				divisor += 2;
			}
		}
		return divisor;
	}
}