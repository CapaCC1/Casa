
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_1 {
	
	//convierto el entero a un array de enteros, en el que cada entero es uno de los digitos
	public static int[] convertirInt (int numero) {
		String num = Integer.toString(numero);
		int length = num.length();
		int[] cifras = new int[length];
		for (int x = 0;x < length;x++) {
			cifras[x] = cifras[x] + (num.charAt(x) - 48);
		}
		return cifras;
	}
	//ordeno el array de menor a mayor para poder compararlos mejor
	public static int[] ordenarArray (int[] cadena) {
		for (int x = 0;x < cadena.length-1;x++) {
			for (int y = 0;y < cadena.length-x-1;y++) {                                                              
				if (cadena[y+1] < cadena[y]) {
					int aux = cadena[y+1];
	                cadena[y+1] = cadena[y];
	                cadena[y] = aux;
	            }
	        }
	    }
		return cadena;
	}
	//calculo el MMC del numero
	public static int calculaMMC(int num, int[] ordenado) {
		int mmc = 1;
		int aux;
		boolean romper = false;
		while (!romper) {
			mmc++;
			aux = num * mmc;
			int[] auxiliar = convertirInt(aux);
			int[] ord = ordenarArray(auxiliar);
			if (ord.length != ordenado.length) {
				romper = true;
				break;
			}
			for (int x = 0;x < ord.length;x++) {
				if (ord [x] == ordenado [x]) {
					romper = false;
				} else {
					romper = true;
					break;
				}
			}
		}
		return mmc - 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean on = true;
		int opcion;
		int num = 1;
		int mmc = 1;
		while (on) {
			try {
			System.out.println("---------------------------------------\n---------- CALCULADOR DE MMC ----------\n---------------------------------------\n1. Dado un número n y determina su MMC\n2. Pide un número x y determina los números n con MMC >= x\nIntroduce una opciún:");
				opcion = sc.nextInt();
				if (opcion == 1) {
					System.out.print("De qué número quieres calcular su MMC: ");
					num = sc.nextInt();
					int[] numero = convertirInt(num);
					int[] ordenado = ordenarArray(numero);
					mmc = calculaMMC(num, ordenado);
					System.out.println("MMC (" + num + ") = " + mmc);
				} else if (opcion == 2) {
					System.out.print("¿Con qué MMC vamos a trabajar? ");
					int input = sc.nextInt();
					System.out.println("Lista de números n donde MMC(n) >= " + input + "\n---------------------------------------");
					while (num < 100000000) {
						int[] numero = convertirInt(num);
						int[] ordenado = ordenarArray(numero);
						mmc = calculaMMC(num, ordenado);
						if (mmc >= input) {
							System.out.println("El número " + num + " cumple: MMC(" + num + ") = " + mmc);
						}
						num++;
					}
				} else {
					System.err.println("ERROR: Introduce una opción válida");
				}
			} catch (InputMismatchException ex) {
				System.err.println("ERROR: Introduce un número entero");
				sc.next();
			}
		}
			sc.close();

	}

}
