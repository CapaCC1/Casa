package Pruebas;
import java.util.Scanner;
public class cuadradoMagico {
	
	public static void rellenarMatriz (int [][] matriz) {
		Scanner in1 = new Scanner(System.in);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				
				System.out.println("Introduce elemento: " + "[" + i + "," + j + "]");
				matriz[i][j] = in1.nextInt();
			}	
		}
		
	}
	
	public static String mostrarMatriz(int [][] matriz) {
		String resultado = "";
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado += matriz[i][j] + "\t";
			}
			resultado += "\n";
		}
		return resultado;
	}
	
	public static void cuadradoMagico1 () {
		
	}
	public static void main(String[] args) {
		
		Scanner in1 = new Scanner(System.in);
		System.out.println("-----------------------");
		System.out.println("|---CUADRADO MAGICO---|");
		System.out.println("-----------------------");
		System.out.println();
		
		System.out.println("Introduzca Dimension: ");
		int dimension = in1.nextInt();
				
		int [][] matriz = new int [dimension][dimension];
		rellenarMatriz(matriz);
		

		int sumaFilas = 0;
		for (int i = 0; i < matriz.length; i++) {
			sumaFilas = 0;
			for (int j = 0; j < matriz.length; j++) {
				sumaFilas = sumaFilas + matriz[i][j];
			}
			
		}
		int sumaColumnas = 0;
		for (int i = 0; i < matriz.length; i++) {
			sumaColumnas = 0;
			for (int j = 0; j < matriz.length; j++) {
				sumaColumnas = sumaColumnas + matriz[j][i];
			}		
		}
		int sumaDiagonalP = 0;
		int sumaDiagonalS = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (i == j) {
					sumaDiagonalP = sumaDiagonalP + matriz[i][j];
					
				}if(i == 3 - j -1 ) {
					sumaDiagonalS = sumaDiagonalS + matriz[i][j];
					
				}
			}	
		}
		
		if(sumaColumnas == sumaFilas && sumaDiagonalP == sumaDiagonalS) {
			System.out.println("Cte Magica Detectada!! La Cte Magica es: " + sumaColumnas);
		}else {
			System.err.println("Cte Magica NO Detectada!!");
		}
	}

}
