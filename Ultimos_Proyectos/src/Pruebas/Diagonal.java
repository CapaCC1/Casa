package Pruebas;

import java.util.Scanner;

public class Diagonal {
	public static void llenarMatriz(int [][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = 5;
			}
		}
	}
	public static String mostrarMatriz(int [][] matriz) {
		String resultado = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				resultado += matriz[i][j] + "\t";
			}
			resultado += "\n";
		}
		return resultado;
	}
	public static void diagonal1(int [][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if(i == j) {
					matriz[i][j] = 0;
				}if(i == matriz.length -j -1) {
					matriz[i][j] = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner in1 = new Scanner (System.in);
		System.out.println("Introduce el tamaño del array ");
		int tamanio = in1.nextInt();
		int [][] matriz = new int[tamanio][tamanio];
		
		llenarMatriz(matriz);
		diagonal1(matriz);
		System.out.println(mostrarMatriz(matriz));
	}

}
