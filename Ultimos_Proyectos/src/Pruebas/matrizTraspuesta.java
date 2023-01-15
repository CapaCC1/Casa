package Pruebas;

import java.util.Scanner;

public class matrizTraspuesta {
	
	public static void matrizTraspuesta1 (int [][] matriz, int [][] matrizT) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matrizT[j][i] = matriz[i][j];
			}
		}
	}
	public static void rellenarMatriz(int [][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
					matriz[i][j] = (int) (Math.random()* (10 + 1) + 1);
			}
		}
	}
	public static String mostrarMatriz(int [][] matriz) {
		String resultado = "";
		rellenarMatriz(matriz);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado += matriz[i][j] + "\t";
			}
			resultado += "\n";
		}
		return resultado;
	}
	public static String mostrarMatrizT(int [][] matrizT) {
		String resultado = "";
		for (int i = 0; i < matrizT.length; i++) {
			for (int j = 0; j < matrizT[i].length; j++) {
				resultado += matrizT[i][j] + "\t";
			}
			resultado += "\n";
		}
		return resultado;
	}
	public static void main(String[] args) {
		
		Scanner in1 = new Scanner(System.in);
		System.out.println("-----------------------");
		System.out.println("|--MATRIZ TRASPUESTA--|");
		System.out.println("-----------------------");
		System.out.println();
		System.out.println("Introduzca filas");
		int filas = in1.nextInt();
		System.out.println("Introduzca columnas");
		int columnas = in1.nextInt();
		
		int [][] matriz = new int [filas][columnas];
		int [][] matrizT = new int [matriz[0].length][matriz.length];
		
		System.out.println(mostrarMatriz(matriz));
		
		matrizTraspuesta1(matriz, matrizT);
		System.out.println(mostrarMatrizT(matrizT));
		
		in1.close();
	}
	
}
