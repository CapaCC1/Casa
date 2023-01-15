

public class RankingMenor {

	public static void main(String[] args) {
		
		String[][] productos = {
				{"Lacasitos       ", "Chicles de fresa", "KitKat          ", "Palotes         "},
				{"Oreo            ", "Bolsa Haribo    ", "Chetoos         ", "Twix            "},
				{"M&M'S           ", "Kinder Bueno    ", "Papa Delta      ", "Chicles de menta"},
				{"Lacasitos       ", "Crunch          ", "Milkybar        ", "KitKat          "}
				};

	        int[][] ventas = {
	        		{0,2,1,2},
	        		{2,2,2,2},
	        		{2,2,2,2},
	        		{1,2,1,1}
	        };
	        		
        int tablaVentas = 0;
        int contador = 1;
        int minimo = 10;
        
        for (int i = 0; i < ventas.length; i++) {
			for (int j = 0; j < ventas[0].length; j++) {
				if(ventas[i][j] < minimo) {
					minimo = ventas[i][j];
				}
			}
		}
        
        System.out.println(minimo);
       
        
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String producto = productos[i][j];
                tablaVentas = ventas[i][j];
                int ventasAcumuladas = tablaVentas;
                
                
                // Recorre la matriz buscando productos iguales a "producto"
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        if (productos[k][l].equals(producto) && (k != i || l != j)) {
                            tablaVentas += ventas[k][l];
                            // Se establece el producto como repetido
                            productos[k][l] = "";
                        }
                    }
                }
                
                // Si el producto no es repetido, se imprime
               
                if (!producto.equals("")) {
                		if(ventas[i][j] == minimo) {
                			String resultado = "Producto " + contador + ": " + producto + " \tcon cantidad vendida: " + tablaVentas;
                            contador++;
                            System.out.println(resultado);
                		}
                		
                	}
                	}
                    
                }
            }
        }
        
	



