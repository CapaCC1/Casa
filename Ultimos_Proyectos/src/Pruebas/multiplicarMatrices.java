package Pruebas;
import java.util.Scanner;
public class multiplicarMatrices {
	public static void rellenarMatrices(int [][] matrizA, int [][] matrizB) {
		
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				matrizA[i][j] = (int) (Math.random()* (10 + 1) + 1);
				matrizB[i][j] = (int) (Math.random()* (10 + 1) + 1);
			}
		}
	}
	public static String mostrarMatrizA (int [][] matrizA) {
		String resultado = "";
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				resultado += matrizA[i][j] + "\t";
			}
			resultado += "\n";
		}
		return resultado;
	}
	public static String mostrarMatrizB (int [][] matrizB) {
		String resultado = "";
		for (int i = 0; i < matrizB.length; i++) {
			for (int j = 0; j < matrizB[i].length; j++) {
				resultado += matrizB[i][j] + "\t";
			}
			resultado += "\n";
		}
		return resultado;
	}
	public static String mostrarMatrizC (int [][] matrizC) {
		String resultado = "";
		for (int i = 0; i < matrizC.length; i++) {
			for (int j = 0; j < matrizC[i].length; j++) {
				resultado += matrizC[i][j] + "\t";
			}
			resultado += "\n";
		}
		return resultado;
	}
	public static void multiplicarMatrices1(int filasA, int columnasB, int [][] matrizB, int [][] matrizA, int [][] matrizC) {
		
		if(filasA == columnasB) {
			for (int i = 0; i < matrizB[0].length; i++) {
				for (int j = 0; j < matrizA.length; j++) {
					int suma = 0;
					for (int k = 0; k < matrizA[0].length; k++) {
						suma += matrizA[j][k] * matrizB[k][i];
					}
					matrizC[j][i] = suma;
					System.out.println(mostrarMatrizC(matrizC));
				}
			}
		}else {
			System.err.println("LAS MATRICES NO SON MULTIPLICABLES!!");
			
		}
		
	}
	public static void main(String[] args) {
		
		Scanner in1 = new Scanner (System.in);
		System.out.println("Introduzca Filas de la Matriz A: ");
		int filasA = in1.nextInt();
		System.out.println("Introduzca Columnas de la Matria B:");
		int columnasA = in1.nextInt();
		
		System.out.println("Introduzca Filas de la Matriz A: ");
		int filasB = in1.nextInt();
		System.out.println("Introduzca Columnas de la Matria B:");
		int columnasB = in1.nextInt();

		int [][] matrizA = new int [filasA][columnasA];
		
		int [][] matrizB = new int [filasB][columnasB];
		
		int [][] matrizC = new int[matrizB.length][matrizB[0].length];
		
		rellenarMatrices(matrizA, matrizB);
		System.out.println(mostrarMatrizA(matrizA));
		System.out.println(mostrarMatrizB(matrizB));
		
		multiplicarMatrices1(filasA, columnasB, matrizB, matrizA, matrizC);
		
		in1.close();
	}

}
