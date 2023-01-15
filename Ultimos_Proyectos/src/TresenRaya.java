
import java.util.Scanner;
public class TresenRaya {
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	
	public static char[][] rellenarVacio(char [][] matriz) {
		char vacio = '-';
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = vacio;
			}	
		}
		
		return matriz;
	}
	public static int[] convertirInt (String numero) {
		
		int [] resultado = new int[2];
		
		int filas = numero.charAt(0);
		int columnas = numero.charAt(1);
		filas = filas - 48;
		columnas = columnas - 48;
		
		resultado[0] = filas;
		resultado[1] = columnas;
		
		return resultado;
	}
	
	public static String mostrarMatriz (char [][] matriz){
		String resultado = "";
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				resultado += matriz[i][j] + "\t";

				if (i < matriz.length - 1) {
					resultado += ANSI_YELLOW + "" + ANSI_RESET;
				}
			}
			resultado += ANSI_YELLOW + "\n" + ANSI_RESET;
		}
		return resultado;	
	}
	public static boolean comprobarJuego (char [][] matriz, boolean winner1, boolean winner2) {
		for(int i = 0; i < 3; i++){
		    if(matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] == 'X' && matriz[i][1] == 'X'){ //fila
		        winner1 = true;
		        return winner1;
		        
		    }
		    if(matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[0][i] == 'X' && matriz[1][i] == 'X'){ //columna
		        winner1 = true;
		        return winner1;
		        
		    }
			if(matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] == 'X' && matriz[1][1] == 'X'){ // diagonal principal
				winner1 = true;
				return winner1;
				
			}
			if(matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] == 'X' && matriz[1][1] == 'X'){ // diagonal secundaria
				winner1 = true;
				return winner1;
				
			}if(matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][0] == 'O' && matriz[i][1] == 'O'){ //fila
		        winner2 = true;
		        return winner2;
		       
		    }
		    if(matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[0][i] == 'O' && matriz[1][i] == 'O'){ //columna
		        winner2 = true;
		        return winner2;
		        
		    }
			if(matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[0][0] == 'O' && matriz[1][1] == 'O'){ // diagonal principal
				winner2 = true;
				return winner2;
				
			}
			if(matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] == 'O' && matriz[1][1] == 'O'){ // diagonal secundaria
				winner2 = true;
				return winner2;		
			}
			}
		return false;
			
	}
	public static boolean[][] rellenarOcupado(boolean [][] ocupado) {
	
		for (int i = 0; i < ocupado.length; i++) {
			for (int j = 0; j < ocupado.length; j++) {
				ocupado[i][j] = false;			
			}
		}
		return ocupado;
	}
	public static boolean comprobarOcupado1 (String numero, boolean [][] ocupado, char jugador1, char jugador2,  char [][] matriz, boolean posicionOcupada) {
		
		int [] filasColumnas = convertirInt(numero);
		int filas = filasColumnas[0];
		int columnas = filasColumnas[1];
		
		if(ocupado[filas][columnas] == false) {
			matriz[filas][columnas] = jugador1;
			ocupado[filas][columnas] = true;
		}else{
			System.err.println(ANSI_RED + "POSICION OCUPADA" + ANSI_RESET);
			posicionOcupada = true;
		}
		return posicionOcupada;
	}
	public static boolean comprobarOcupado2 (String numero, boolean [][] ocupado, char jugador1, char jugador2,  char [][] matriz, boolean posicionOcupada) {
		
		int [] filasColumnas = convertirInt(numero);
		int filas = filasColumnas[0];
		int columnas = filasColumnas[1];
		
		if(ocupado[filas][columnas] == false) {
			matriz[filas][columnas] = jugador2;
			ocupado[filas][columnas] = true;
		}else{
			System.err.println(ANSI_RED + "POSICION OCUPADA" + ANSI_RESET);
			posicionOcupada = true;
		}
		return posicionOcupada;
	}
	public static void main(String[] args) {
		Scanner in1 = new Scanner (System.in);
		
		char [][] matriz = new char [3][3];
		boolean[][] ocupado = new boolean[3][3];
		rellenarVacio(matriz);
		
		boolean posicionOcupada = false;
		char jugador1 = 'X';
		char jugador2 = 'O';
		boolean winner1 = false;
		boolean winner2 = false;

		System.out.println(ANSI_YELLOW + "------------------" + ANSI_RESET);
		System.out.println(ANSI_YELLOW + "|--TRES EN RAYA--|" + ANSI_RESET);
		System.out.println(ANSI_YELLOW + "------------------" + ANSI_RESET);
		while(!winner1 || !winner2) {

			System.out.println(ANSI_GREEN + "Turno Jugador 1\n" + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "Introduce posicion" + ANSI_RESET);
			String numero = in1.next();
			
			int [] filasColumnas = convertirInt(numero);
			int filas = filasColumnas[0];
			int columnas = filasColumnas[1];
			
			posicionOcupada = comprobarOcupado1(numero, ocupado, jugador1, jugador2, matriz, posicionOcupada);

			System.out.println(mostrarMatriz(matriz));

			winner1 = comprobarJuego(matriz, winner1, winner2);
			winner2 = comprobarJuego(matriz, winner1, winner2);

				if(winner1){
					System.out.println(ANSI_GREEN + "GANADOR Jugador 1" + ANSI_RESET);
					break;
				}
				if(winner2) {
					System.out.println(ANSI_CYAN + "GANADOR Jugador 2!" + ANSI_RESET);
					break;
				}	
				
			System.out.println(ANSI_CYAN + "Turno Jugador 2" + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "Introduce posicion" + ANSI_RESET);
			numero = in1.next();
			
			filasColumnas = convertirInt(numero);
			filas = filasColumnas[0];
			columnas = filasColumnas[1];

			posicionOcupada = comprobarOcupado2(numero, ocupado, jugador1, jugador2, matriz, posicionOcupada);
			
			System.out.println(mostrarMatriz(matriz));

		}
		in1.close();
		}
}
	
	



