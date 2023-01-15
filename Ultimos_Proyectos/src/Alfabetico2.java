

import java.util.Arrays;

public class Alfabetico2 {
	
public static void infoProductos(String [] productos, int [] ventas, double [] precios, int [] cantidades ) {
	
	// Creamos un array con los índices originales del array productos
    Integer[] indices = new Integer[productos.length];
    for (int i = 0; i < indices.length; i++) {
      indices[i] = i;
    }
    
    // Ordenamos el array indices según el orden de los elementos en el array productos
    Arrays.sort(indices, (a, b) -> productos[a].compareTo(productos[b]));
    
    // Creamos los arrays ordenados según el orden de los elementos en el array indices
    String[] productosOrdenados = new String[productos.length];
    int[] ventasOrdenadas = new int[ventas.length];
    double[] preciosOrdenados = new double[precios.length];
    int[] cantidadesOrdenadas = new int[cantidades.length];
    
    for (int i = 0; i < indices.length; i++) {
    			ventasOrdenadas[i] = ventas[indices[i]];
            	preciosOrdenados[i] = precios[indices[i]];
            	cantidadesOrdenadas[i] = cantidades[indices[i]]; 	
    	} 
    
    Arrays.sort(productos);
    
    
    
    // Imprimimos los arrays ordenados
    System.out.println();
    for (int i = 0; i < ventasOrdenadas.length; i++) {
    	System.out.println(" | " + productos[i] + "\t\t" + " |\t" + ventasOrdenadas[i] + " UDS Vendidas | " + preciosOrdenados[i] + " € |" + cantidadesOrdenadas[i] + " UDS Disponibles " + " | ");
	}
    
  }
public static void arrayMultiAUni (String [][] productos, int [][] ventas, double [][] precios, int [][] cantidades ) {
	String[] productos1 = new String[productos.length * productos[0].length];

    int indice = 0;
    for (String[] fila : productos) {
        for (String elemento : fila) {
            productos1[indice] = elemento;
            indice++;
        }
    }

    int[] ventas1 = new int[ventas.length * ventas[0].length];
    
    indice = 0;
    
    for (int[] fila : ventas) {
        for (int elemento : fila) {
            ventas1[indice] = elemento;
            indice++;
        }
    }

    double[] precios1 = new double[precios.length * precios[0].length];

    indice = 0;
    for (double[] fila : precios) {
        for (double elemento : fila) {
            precios1[indice] = elemento;
            indice++;
        }
    }

    int[] cantidades1 = new int[cantidades.length * cantidades[0].length];

    indice = 0;
    for (int[] fila : cantidades) {
        for (int elemento : fila) {
            cantidades1[indice] = elemento;
            indice++;
        }
    }
    infoProductos(productos1, ventas1, precios1, cantidades1);
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
	    
	        arrayMultiAUni(productos, ventas, precios, cantidades);
	        
	}
}
	