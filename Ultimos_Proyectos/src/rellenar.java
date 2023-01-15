
import java.util.Scanner;
public class rellenar {

	public static void main(String[] args) {
		Scanner in1 = new Scanner(System.in);
		String[][] productos = {
				{"Lacasitos       ", "Chicles de fresa", "KitKat          ", "Palotes         "},
				{"Oreo            ", "Bolsa Haribo    ", "Chetoos         ", "Twix            "},
				{"M&M'S           ", "Kinder Bueno    ", "Papa Delta      ", "Chicles de menta"},
				{"Lacasitos       ", "Crunch          ", "Milkybar        ", "KitKat          "}
	        };
		
		int [][] cantidades = {
				{3, 3, 3, 3},
				{3, 3, 3, 3},
				{3, 3, 3, 3},
				{3, 3, 3, 3}
		};
		int tablaCantidad = 0;
		System.out.println("Introduce posicion: ");
		int filas = in1.nextInt();
		int columnas = in1.nextInt();
		
		System.out.println("Introduce cantidad ");
		int cantidad = in1.nextInt();
		
		System.out.println();
		
		for (int i = 0; i < cantidades.length; i++) {
			for (int j = 0; j < cantidades[0].length; j++) {
				tablaCantidad = cantidades[i][j];
				
			}
		}
	
		if(tablaCantidad <= 5) {
			
			cantidades[filas][columnas] = cantidad;
			cantidades[filas][columnas] = tablaCantidad;
		}if(tablaCantidad > 5) {
			
			cantidades[filas][columnas] = 3;
			cantidades[filas][columnas] = 3;
		}
		
		//System.out.println(cantidades[filas][columnas]);
			
		for (int i = 0; i < cantidades.length; i++) {
			for (int j = 0; j < cantidades[i].length; j++) {
				System.out.println(cantidades[i][j]);
				
			}
		}

	}

}
