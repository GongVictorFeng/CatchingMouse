//Student 1: Gong(Victor) Feng,300176400


//We didn't use this class in our program.
import java.util.Random;

public class UseRandom{

	private static Random aRandom = new Random();


	public static void main(String[] args){

		int n;
		//generate a random number between 1 and 9
		n = generateRandom(0,9);
		display(n);	
	}

	//generate a random number between nim and max
	private static int generateRandom(int min, int max){
		//aRandom.nextInt(n) will generate a random number between 0 and n-1
		//so we adjust to get a random between min and max
		int randomNumber = aRandom.nextInt((max-min)+1)+min;
		return randomNumber;
	}

	private static void display(int rand){

		System.out.println("Generated random number: "+rand); 
	}  
}