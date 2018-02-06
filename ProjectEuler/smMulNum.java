public class smMulNum{

	public static void main(String[] args){
		int dividor = 20;
		int count = 1;
		boolean check = false;
		while(dividor > 0){
			if(count%dividor == 0){
				check = true;
				dividor--;
			}else{
				check = false;
				dividor = 20;
			}
			count++;
		}
		if(check == true){
			System.out.println(count);
		}
	}
}