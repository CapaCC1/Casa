

public class OrdenamientoSegunArray {
	
	
	
	public static void main(String[] args) {
		
		
		String[] productosOrdenados = {
				
				"Lacasitos       ", "Chicles de fresa", "KitKat          ", "Palotes         ",
				"Oreo            ", "Bolsa Haribo    ", "Chetoos         ", "Twix            ",
				"M&M'S           ", "Kinder Bueno    ", "Papa Delta      ", "Chicles de menta",
				"Lacasitos       ", "Crunch          ", "Milkybar        ", "KitKat          "
				
				
	        };
		
		

	        int[] ventasOrdenadas = {
	        		1,2,3,4,
	        		5,6,7,8,
	        		9,10,11,12,
	        		13,14,15,16
	        };
	        
	        double[] preciosOrdenados = {
					1.5, 0.8, 1.1, 0.9,
					1.8, 1, 1.2, 1,
					1.8, 1.3, 1.2, 0.8,
					1.5, 1.1, 1.1, 1.1
					};
					
	        int [] cantidadesOrdenadas = {
					5, 3, 3, 3,
					3, 3, 3, 3,
					3, 3, 3, 3,
					3, 3, 3, 3
			};
	        
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
	    

		    for (int i = 0; i < productosOrdenados.length; i++) {
				System.out.println(productosOrdenados[i] + ventasOrdenadas[i] + " " + preciosOrdenados[i] + " " + cantidadesOrdenadas[i]);
				
			}
		   
		}

	}


