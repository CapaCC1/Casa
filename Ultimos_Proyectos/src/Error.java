
import java.util.Iterator;
import java.util.Scanner;
public class Error {

	public static void main(String[] args) {
		
		Scanner in1 = new Scanner(System.in);
		
		System.out.println("INTRODUCE POSICION");
		String posicion = in1.next();
		
		int [] filasColumnas = new int [2];//Se crea un array unidimensional para guardar las letras introducidas
		String [] filasColumnasCopia = new String[2];
		char primerNumero = posicion.charAt(0);//Se guarda el primer caracter en la variable primerNumero
		char segundoNumero = posicion.charAt(1);//Se guarda el segundo caracter en la variable segundoNumero
		
		int filas = primerNumero; //Se pasa de char a int 
		int columnas = segundoNumero;
		filas = filas - 65; //Se le resta 65 para convertirlo en numero
		columnas = columnas - 65;
		
		
		if (filas < 4 && columnas < 4) {
			filasColumnas[0] = filas;
			filasColumnas[1] = columnas;
			System.out.println(filas);
			System.out.println(columnas);
		}else {
			//filasColumnas = filasColumnasCopia;
			
			System.out.println("ERROR");
		}
		for (int i = 0; i < filasColumnasCopia.length; i++) {
			System.out.println(filasColumnasCopia[i]);
		}
	}

}
