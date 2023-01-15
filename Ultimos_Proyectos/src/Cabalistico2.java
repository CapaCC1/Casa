
import java.util.Arrays;
import java.util.Scanner;
public class Cabalistico2 {

	public static int[] separarNumeros(int numero1) {
		
		String num2 = Integer.toString(numero1);
		int length = num2.length();
		int[] cifras2 = new int[length];
		for (int x = 0;x < length;x++) {
			cifras2[x] = cifras2[x] + (num2.charAt(x) - 48);
		}
		Arrays.sort(cifras2);
		
		return cifras2;

		}
	
	public static int mmc (int numero1) {
		
		boolean esta = false;
		int mmc = 1;
		int numero = 0;
		int cifras2 [] = separarNumeros(numero1);
		while(!esta) {
			mmc++;
			numero = numero1 * mmc;
			int [] auxiliar = separarNumeros(numero);
			if (auxiliar.length != cifras2.length) {
				esta = true;
				break;
			}
			for (int x = 0;x < auxiliar.length;x++) {
				if (auxiliar [x] == cifras2 [x]) {
					esta = false;
				} else {
					esta = true;
					break;
				}
			}
		}
		return mmc -1;
	}
	public static void main(String[] args) {
	
	Scanner in1 = new Scanner (System.in);
	
	System.out.println("Introduzca el numero a comprobar: ");
	int numero1 = in1.nextInt();
	
	int mmc = mmc(numero1);
	System.out.println("El MMC del numero " + numero1 + " es -> " + mmc);
	
	System.out.println("Introduce el MMC:");
	int input = in1.nextInt();
	
	while(numero1 < 100000000 ) {
		mmc = mmc(numero1);
		if (mmc >= input) {
			System.out.println("El número " + numero1 + " cumple: MMC(" + numero1 + ") = " + mmc);
		}
		numero1++;
	}
}
}


