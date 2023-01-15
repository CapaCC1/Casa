

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
public class InfoProductos {
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void ordenarArrays (String [] productosOrdenados, int [] ventasOrdenadas, double [] preciosOrdenados, int [] cantidadesOrdenadas) {
		
		for (int i = 0; i < productosOrdenados.length - 1; i++) {
            for (int j = 0; j < productosOrdenados.length - i - 1; j++) {
                if (productosOrdenados[j].compareTo(productosOrdenados[j + 1]) > 0) {
                    // Intercambiamos ventasOrdenadas[j] y ventasOrdenadas[j + 1]
                    int temp = ventasOrdenadas[j];
                    ventasOrdenadas[j] = ventasOrdenadas[j + 1];
                    ventasOrdenadas[j + 1] = temp;

                    // Intercambiamos preciosOrdenados[j] y preciosOrdenados[j + 1]
                    double temp2 = preciosOrdenados[j];
                    preciosOrdenados[j] = preciosOrdenados[j + 1];
                    preciosOrdenados[j + 1] = temp2;

                    // Intercambiamos cantidadesOrdenadas[j] y cantidadesOrdenadas[j + 1]
                    int temp3 = cantidadesOrdenadas[j];
                    cantidadesOrdenadas[j] = cantidadesOrdenadas[j + 1];
                    cantidadesOrdenadas[j + 1] = temp3;

                    // Intercambiamos productosOrdenados[j] y productosOrdenados[j + 1]
                    String temp4 = productosOrdenados[j];
                    productosOrdenados[j] = productosOrdenados[j + 1];
                    productosOrdenados[j + 1] = temp4;
                }
            }
        }
	}
	public static void arrayConversionDosDimensionesAUna(String [][] productos, String [] productosOrdenados, int [][] ventas, int [] ventasOrdenadas, int [][] cantidades, int [] cantidadesOrdenadas, double[][] precios, double[] preciosOrdenados){
		 // Recorrer los productos y ventas del array original y agregarlos al array de productos y ventas ordenados
        int indice = 0;
        for (int i = 0; i < productos.length; i++) {
			for (int j = 0; j < productos[i].length; j++) {
				productosOrdenados[indice] = productos[i][j];
				indice++;
				
			}
		}
        
        
        indice = 0;
        for (int i = 0; i < ventas.length; i++) {
			for (int j = 0; j < ventas[i].length; j++) {
				
				ventasOrdenadas[indice] = ventas[i][j];
				indice++;
				
			}
		}
        indice = 0;
        for (int i = 0; i < cantidades.length; i++) {
			for (int j = 0; j < cantidades[i].length; j++) {
				cantidadesOrdenadas[indice] = cantidades[i][j];
				indice++;		
			}
		}
        indice = 0;
        for (int i = 0; i < precios.length; i++) {
			for (int j = 0; j < precios[i].length; j++) {
				preciosOrdenados[indice] = precios[i][j];
				indice++;		
			}
		}
	}
	public static void main(String[] args) {
		
		
		String[][] productos = {
				{"Lacasitos       ", "Chicles de fresa", "KitKat          ", "Palotes         "},
				{"Oreo            ", "Bolsa Haribo    ", "Chetoos         ", "Twix            "},
				{"M&M'S           ", "Kinder Bueno    ", "Papa Delta      ", "Chicles de menta"},
				{"Lacasitos       ", "Crunch          ", "Milkybar        ", "KitKat          "}
	        };
		
		

	        int[][] ventas = {
	        		{1,0,0,0},
	        		{0,0,1,0},
	        		{0,4,0,0},
	        		{3,0,0,1}
	        };
	        
	        double[][] precios = {
					{1.5, 0.8, 1.1, 0.9},
					{1.8, 1, 1.2, 1},
					{1.8, 1.3, 1.2, 0.8},
					{1.5, 1.1, 1.1, 1.1}
					};
	        int [][] cantidades = {
					{3, 3, 3, 3},
					{3, 3, 3, 3},
					{3, 3, 3, 3},
					{3, 3, 3, 3}
			};
	        
	        String[] productosOrdenados = new String[productos.length * productos[0].length];
	        int[] ventasOrdenadas = new int[productos.length * productos[0].length];
	        double [] preciosOrdenados = new double[precios.length * precios[0].length];
	        int [] cantidadesOrdenadas = new int [cantidades.length * cantidades[0].length];
	        
	        arrayConversionDosDimensionesAUna(productos, productosOrdenados, ventas, ventasOrdenadas, cantidades, cantidadesOrdenadas, precios, preciosOrdenados);
	        ordenarArrays(productosOrdenados, ventasOrdenadas, preciosOrdenados, cantidadesOrdenadas);
	        
	        String[] productosUnicos = new String[productosOrdenados.length];
			int[] ventasProductosUnicos = new int[productosOrdenados.length];
			int[] cantidadesProductosUnicos = new int[productosOrdenados.length];
			double[] preciosProductosUnicos = new double[productosOrdenados.length];
			
			int indiceProductoUnico = 0;
			for (int i = 0; i < productosOrdenados.length; i++) {
				boolean productoEncontrado = false;
				for (int j = 0; j < indiceProductoUnico; j++) {
					if (productosOrdenados[i].equals(productosUnicos[j])) {
						ventasProductosUnicos[j] += ventasOrdenadas[i];
						cantidadesProductosUnicos[j] += cantidadesOrdenadas[i];
						preciosProductosUnicos[j] += preciosOrdenados[i];
						productoEncontrado = true;
						break;
					}
				}
				if (!productoEncontrado) {
					productosUnicos[indiceProductoUnico] = productosOrdenados[i];
					ventasProductosUnicos[indiceProductoUnico] = ventasOrdenadas[i];
					cantidadesProductosUnicos[indiceProductoUnico] = cantidadesOrdenadas[i];
					preciosProductosUnicos[indiceProductoUnico] = preciosOrdenados[i];
					indiceProductoUnico++;
				}
			}
			for (int i = 0; i < indiceProductoUnico; i++) {
				 System.out.println(ANSI_CYAN + " -------------------------------------------------------------------");
				    System.out.println(" | " + productosUnicos[i] + " |\t" + ventasProductosUnicos[i] + " UDS Vendidas | " + preciosProductosUnicos[i] + " € |" + cantidadesProductosUnicos[i] + " UDS Disponibles " + " | ");
				    System.out.println(" -------------------------------------------------------------------" + ANSI_RESET);
			}
		}
	}
			
	       
	        
	
 
	        
	        

	     
