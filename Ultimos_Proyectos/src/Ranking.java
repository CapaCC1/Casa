
import java.util.Random;
import java.util.Arrays;
public class Ranking {

	public static void main(String[] args) {
		String[][] productos = {
				{"Lacasitos       ", "Chicles de fresa", "KitKat          ", "Palotes         "},
				{"Oreo            ", "Bolsa Haribo    ", "Chetoos         ", "Twix            "},
				{"M&M'S           ", "Kinder Bueno    ", "Papa Delta      ", "Chicles de menta"},
				{"Lacasitos       ", "Crunch          ", "Milkybar        ", "KitKat          "}
				};

	        int[][] ventas = {
	        		{3,0,0,0},
	        		{0,0,2,0},
	        		{0,0,1,0},
	        		{0,0,0,0}
	        };
	        
	       
	        Arrays.sort(ventas, (a, b) -> Integer.compare(b[0], a[0]));
	        
	        boolean hayVentas = false;
	        int contador = 1;
	        String tablaProductos = "";
	        int tablaVentas = 0;
	        
	        for (int i = 0; i < 4; i++) {
	          for (int j = 0; j < 4; j++) {

	            tablaProductos = productos[i][j];
	            tablaVentas = ventas[i][j];

	            if (tablaVentas != 0) { /*Si hay algun valor del array que sea diferente a 0 significara que hay ventas*/
	              hayVentas = true;
	              if (tablaVentas > 0) {
	            	  
	  
	            	  
	            	  
	                String resultado = "Producto " + (contador) + ": " + tablaProductos + "\tcon cantidad vendida: " + tablaVentas;
	                System.out.println(resultado);
	                contador++; /*Contador para enumerar las ventas del ranking*/
	                
	                if (contador >= 4) { /*Contador para mostrar las 3 primeras ventas unicamente, sino sale del bucle*/
	                  break;
	                }
	              }
	            }
	          }
	        }
	        if (hayVentas == false) { /*Si en el array todos los valores son 0 significara que no hay ventas*/
	          String sinVentas = "No se han producido ventas ";
	          System.out.println(sinVentas);
	        }
	}
}

