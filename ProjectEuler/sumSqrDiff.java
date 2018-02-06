public class sumSqrDiff{

	public static void main(String[] args){
		int sqr = 0; int sum = 0;
		for(int i=1; i<=100; i++){
			sqr += (i*i);
			sum += i;
		}	
		int result = sum*sum - sqr;
		System.out.println(result);
	}
}