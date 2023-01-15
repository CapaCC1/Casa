
import java.util.Iterator;
import java.util.Scanner;
public class Diagonal1_2 {
	public static int[][] generarArray(int tamanio){
		
		int tabla [][] = new int [tamanio][tamanio];
		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {
				tabla [i] [j] = (int) (Math.random()* (10 + 1) + 1);
			}
		}
		return(tabla);
	}
	public static void mostrarArray (int [][] tabla) {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.print(tabla[i][j] + "\t");
			}
			System.out.println("");
		}
	}
	public static void diagonal1 (int tabla[][], int tamanio) {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if(i==j) {
					tabla[i][j] = 1;
				}if (i == tamanio - j -1) {
				tabla [i] [j] = 1;
			
			}
		}
		}
		mostrarArray(tabla);
	}
	public static void main(String[] args) {
		
		Scanner in1 = new Scanner (System.in);
		
		System.out.println("Introduce tamaño: ");
		int tamanio = in1.nextInt();
		
		int tabla [][] = generarArray(tamanio);
		diagonal1(tabla, tamanio);
		
	}

}
