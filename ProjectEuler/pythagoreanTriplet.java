import java.util.*;
public class pythagoreanTriplet{

	public static void main(String[] args){
		
		System.out.println("First solution: ");
		for(int a=1; a<=1000; a++){
			for(int b=1; b<=1000; b++){
				for(int c=1; c<=1000; c++){
					if((a+b+c==1000) && (a*a+b*b==c*c)){
						System.out.println("a: "+a+", b: "+b+", c: "+c+".");
						System.out.println(a*b*c);
					}
				}
			}
		}

		System.out.println("\nSecond solution: ");
		for(int a=1; a<=1000/3; a++){
			for(int b=1; b<=1000/2; b++){
				int c = 1000 - a - b;
				if((a+b+c==1000) && (a*a+b*b==c*c)){
					System.out.println("a: "+a+", b: "+b+", c: "+c+".");
					System.out.println(a*b*c);
				}
			}
		}

	}
}
