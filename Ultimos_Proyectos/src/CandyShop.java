

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CandyShop {
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void mostrarGolosina(String[][] productos, double [][] precios){
		/*Funcion utilizada para la visualizacion de la lista entera de productos y precio con sus posiciones*/

		String tablaProductos = "";
		double tablaPrecios = 0;
		
		int aux,aux2;
		for (int i = 0; i < productos.length; i++) {
			for (int j = 0; j < productos[0].length; j++) {
				tablaProductos = productos[i][j]; //Se guarda el nombre del producto
				tablaPrecios = precios[i][j]; //Se guarda el precio del producto
				
				aux = i; 
				aux2 = j; 
				aux = aux + 65; //Se le suma + 65 para convertirlo a ascii y poder imprimir la primera letra
				aux2 = aux2 + 65;//Se le suma + 65 para convertirlo a ascii y poder imprimir la segunda letra
				
				char letra1 = (char) aux;//Conversion a primera letra
				char letra2 = (char)aux2;//Conversion a segunda letra
				System.out.println(ANSI_CYAN + "------------------------------------------");
				System.out.println("| " + tablaProductos + " | " + "Posicion: " +  letra1 + letra2 + " | " + tablaPrecios + "€" + " | ");
				System.out.println("------------------------------------------" + ANSI_RESET);
		} 
	}
}
	public static String pedirGolosina (String [][] productos,int [][] cantidades,int [][] ventas, String posicion) {
		/*Funcion para pedir golosinas mediante posiciones alfabeticas, restar en la tabla cantidad y sumar en la tabla ventas.*/

		String tablaProductos;
		int tablaCantidad;
		int tablaVentas;
		try { /*Control de excepciones para evitar errores de out of bounds*/
		int [] numeros = cambioLetrasANumeros(posicion); /*Convertimos de posicion alfabetica(A,A) a posicion numerica (0,0)*/
		int filas = numeros[0]; /*Se asigna el primer numero a la variable filas*/
		int columnas = numeros[1];/*Se asigna el segundo numero a la variable columnas*/
			
		tablaProductos = productos[filas][columnas];
		tablaCantidad = cantidades[filas][columnas];
		tablaVentas = ventas[filas][columnas];
		
			if (tablaCantidad != 0) { /*Condicion que nos permite restar cantidades y sumar ventas*/
				tablaCantidad --;
				cantidades[filas][columnas] = tablaCantidad;
				tablaVentas ++;
				ventas[filas][columnas] = tablaVentas;
				
				String productoComprado = ANSI_CYAN + "Producto Elegido: " + tablaProductos + ANSI_RESET + ANSI_GREEN + "\nRetire su Producto" + ANSI_RESET;
				return productoComprado;
			
			}else if(tablaCantidad == 0) { /*Si la cantidad del producto es 0 saldra el mensaje de error*/
				String prodAgotado = ANSI_RED + "Producto Agotado" + ANSI_RESET;
				return prodAgotado;
			}
		
		}
		catch(StringIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			return error;
		}catch(ArrayIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			return error;
		}
		return null;	
}
	public static int[] cambioLetrasANumeros(String posicion) {	
		/*Funcion utilizada para la conversion de caracteres (AA) a posiciones del array(0,0)*/
			
		int [] filasColumnas = new int [2];/*Se crea un array unidimensional para guardar las letras introducidas*/
		char primerNumero = posicion.charAt(0);/*Se guarda el primer caracter en la variable primerNumero*/
		char segundoNumero = posicion.charAt(1);/*Se guarda el segundo caracter en la variable segundoNumero*/
		
		int filas = primerNumero; /*Se pasa de char a int*/
		int columnas = segundoNumero;
		columnas = columnas - 65;
		filas = filas - 65; /*Se le resta 65 para convertirlo en numero*/
		
			filasColumnas[0] = filas; /*En la posicion 0 del array se asigna el primer numero para las filas*/
			filasColumnas[1] = columnas; /*En la posicion 1 del array se asigna el primer numero para las columnas*/
	
			return filasColumnas;
		}
	
	public static String subMenuContrasenia (String contraseniaUsuario, String contrasenia) {
		/*Funcion de acceso con contraseña*/
		
		if (contraseniaUsuario.equals(contrasenia)) {
			String contraseniaC = ANSI_CYAN + "Contraseña Correcta! " + ANSI_RESET;
			return contraseniaC;
		}else {
			String contraseniaI = ANSI_RED + "Contraseña No Valida! " + ANSI_RESET;
			return contraseniaI;
		}
	}
	public static String subMenuCambioContrasenia (String nuevaContrasenia, String verificarContrasenia, String contrasenia) {
	/*Funcion para el cambio de contraseña y verificacion de doble introduccion de la nueva contraseña correctamente*/
		
	if (nuevaContrasenia.equals(verificarContrasenia)) { /*Si la nueva contraseña es igual a la de verificacion entra en la condicion 
														y se cambia la contraseña*/
		System.out.println(ANSI_CYAN + "Contraseña Cambiada! " + ANSI_RESET);
		contrasenia = nuevaContrasenia;
		return contrasenia;
	}
	else{	
		System.out.println(ANSI_RED + "Las Contraseñas NO Coinciden! " + ANSI_RESET); /*Si las contraseñas no coinciden se retorna la contraseña de fabrica*/
		contrasenia = "DAM";
		return contrasenia;
	}
}
	public static void rellenarMatrizCantidad (int [][] cantidades ) {
		/*Funcion que nos rellena la matriz de cantidad con un mismo valor, solo teniendo que cambiar la cantidadInicial si queremos 
		 * rellenar toda la matriz de la misma cantidad*/
		int cantidadInicial = 3;
		for (int i = 0; i < cantidades.length; i++) {
			for (int j = 0; j < cantidades[i].length; j++) {
				cantidades[i][j] = cantidadInicial;
			}
		}
	}
	public static void rellenarMatrizVentas (int [][] ventas) {
		/*Funcion que nos rellena la matriz de ventas con un mismo valor en todas las posiciones*/
		int valorInicial = 0;
		
		for (int i = 0; i < ventas.length; i++) {
			for (int j = 0; j < ventas[i].length; j++) {
				ventas[i][j] = valorInicial;
			}
		}
	}
	public static void rellenarGolosinas (String posicion, int cantidadRelleno, int [][] cantidades, String [][] productos, int cantidadInicial ){
	    /*Funcion que nos permite rellenar cada posicion de las golosinas, no permitiendo tener mas de 5 golosinas en cada posicion*/
	    int tablaCantidad;
	    String tablaProductos;
	    int aux = 0;
	    try { /*Control de excepciones para evitar errores de out of bounds*/
	    int [] numeros = cambioLetrasANumeros(posicion);
	    int filas = numeros[0];
	    int columnas = numeros[1];
	    
	    tablaCantidad = cantidades[filas][columnas];
	    tablaProductos = productos[filas][columnas];

	    aux = cantidadRelleno; /*Para mostar la cantidad que se rellena*/
	    tablaCantidad = tablaCantidad + cantidadRelleno; /*Cantidad que se va a rellenar + la cantidad inicial, que se va rellenando segun recorramos el bucle*/
	    	    
	    if (tablaCantidad <= 5) { /*Si en el array de cantidad en la posicion que se quiera acceder hay menos o igual de 5 producto permiter rellenar la posicion */
	    	cantidades[filas][columnas] = tablaCantidad;
	    	
	        String mensajeCantidad = ANSI_CYAN + "Usted a rellenado " + tablaProductos.replace("  ", " ") + "[" + posicion + "]" + " con " + aux + " unidades " + ANSI_RESET;
	        System.out.println(mensajeCantidad);

	    } else { /*Sino nos dara un error*/
	        String cajetinLleno = ANSI_RED + "Los Productos NO Caben! " + ANSI_RESET;
	        System.out.println(cajetinLleno);
	    }
	    }
	    catch(StringIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			System.out.println(error);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			System.out.println(error);
		}
	    
	    }

	public static String cambiarPrecio (String posicion, String [][] productos, double [][] precios, double nuevoPrecio) {
		/*Funcion que nos permite el cambio de precio de los productos con el mismo nombre en la maquina. Se elige la posicion que queremos
		 * cambiar y si se encuentra dos golosinas con el mismo nombre se cambia el precio de los dos*/
		try { /*Control de excepciones para evitar errores de out of bounds*/
		String tablaProductos;
		int [] numeros = cambioLetrasANumeros(posicion);
		int filas = numeros[0];
		int columnas = numeros[1];
	
		tablaProductos = productos[filas][columnas];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (productos[i][j].replace(" ", "").equals(tablaProductos.replace(" ", ""))) {
					precios[i][j] = nuevoPrecio; /*Se recorre el array de productos hasta el producto que hayamos elegido, y se le asigna un nuevo precio
					 							 si hay otro producto con el mismo nombre se le cambia tambien el precio*/		
				}
			}	
		}	
		String precioCambiado = ANSI_CYAN + "Precio Cambiado! " + ANSI_RESET;
		return precioCambiado;
		}catch(StringIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			return error;
		}catch(ArrayIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			return error;
		}	
	}
	public static String cambiarProducto(String posicion, String nuevoNombre, String [][] productos,int [][] cantidades, double [][] precios, double nuevoPrecio, int cantidadRelleno, int cantidadInicial) {
		/*Funcion de cambiar producto, mediante la posicion se reemplaza el producto*/
		try { /*Control de excepciones para evitar errores de out of bounds*/
		int [] numeros = cambioLetrasANumeros(posicion);
		int filas = numeros[0];
		int columnas = numeros[1];
		
		productos[filas][columnas] = nuevoNombre; //Remplaza el producto actual por el nuevo
 		cambiarPrecio(posicion, productos, precios, nuevoPrecio); //Se cambia el precio
		rellenarGolosinas(posicion, cantidadRelleno, cantidades, productos, cantidadInicial); //Se rellena
		String productoCambiado = ANSI_CYAN + "Producto Cambiado!" + ANSI_RESET;
		return productoCambiado;
	
		}catch(StringIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			return error;
		}catch(ArrayIndexOutOfBoundsException e) {
			String error = ANSI_RED + "Posicion Incorrecta! " + ANSI_RESET;
			return error;
		}		
	}
	
	public static void rankingMasVendidos(String [][] productos, int [][] ventas) { 
		
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
                String resultado = ANSI_CYAN + "Producto " + (contador) + ": " + tablaProductos + "\tcon cantidad vendida: " + tablaVentas + ANSI_RESET;
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
          String sinVentas = ANSI_RED + "No se han producido ventas " + ANSI_RESET;
          System.out.println(sinVentas);
        }
}

	public static void rankingMenosVendidos(int [][] ventas) {
		/*Esta funcion mostrara siempre los valores mas bajos del ranking y los demas no los mostrara*/
		
		String[][] productosCopia = {
				
				{"Lacasitos       ", "Chicles de fresa", "KitKat          ", "Palotes         "},
				{"Oreo            ", "Bolsa Haribo    ", "Chetoos         ", "Twix            "},
				{"M&M'S           ", "Kinder Bueno    ", "Papa Delta      ", "Chicles de menta"},
				{"Lacasitos       ", "Crunch          ", "Milkybar        ", "KitKat          "}
				};
		
		 int tablaVentas = 0;
	        int contador = 1;
	        int minimo = 10;
	        
	        for (int i = 0; i < ventas.length; i++) { /*Bucle para buscar el valor minimo del array*/
				for (int j = 0; j < ventas[0].length; j++) {
					if(ventas[i][j] < minimo) {
						minimo = ventas[i][j];
					}
				}
			}     
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                String producto = productosCopia[i][j];
	                tablaVentas = ventas[i][j];
   
	                // Recorre la matriz buscando productos iguales a "producto"
	                for (int k = 0; k < 4; k++) {
	                    for (int l = 0; l < 4; l++) {
	                        if (productosCopia[k][l].equals(producto)) {
	                            tablaVentas += ventas[k][l];
	                            // Se establece el producto como repetido y se quita de la lista
	                            productosCopia[k][l] = "";
	                        }
	                    }
	                }
	                // Si el producto no esta repetido, se imprime
	                if (!producto.equals("")) {
	                		if(ventas[i][j] == minimo) { /*Si la venta del producto corresponde al valor minimo se imprime*/
	                			String resultado = ANSI_CYAN + "Producto " + contador + ": " + producto + " \tcon cantidad vendida: " + tablaVentas + ANSI_RESET;
	                            contador++;
	                            System.out.println(resultado);
	                		}
	                	}
	                }   
	            }
	        }        
	public static double ventasTotales (int [][] ventas, double [][] precios) {
		
		/*Funcion que permite calcular las ventas totales de la maquina*/
		double suma = 0;
		for (int i = 0; i < ventas.length; i++) {
			for (int j = 0; j < ventas.length; j++) {
				if(ventas[i][j] >= 1) {
					suma = precios[i][j] * ventas[i][j];
				}
			}
		}
		return suma;	
	}
public static void ordenarArrays (String [] productosOrdenados, int [] ventasOrdenadas, double [] preciosOrdenados, int [] cantidadesOrdenadas) {
		
		/*Funcion que permite ordenar los todos los arrays segun el array productosOrdenados para evitar perder el sentido de los arrays*/
		/*Se realiza mediante el ordenamiento de la burbuja*/

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
		 /* Recorre los productos y ventas del array original y los agrega al array de productos y ventas ordenados*/
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
	public static void infoProductos (String [][] productos, int [][] ventas, double [][] precios, int [][] cantidades) {
		
		/*Arrays en los que se hace la conversion de bidimensional a unidimensional*/
		String[] productosOrdenados = new String[productos.length * productos[0].length];
        int[] ventasOrdenadas = new int[productos.length * productos[0].length];
        double [] preciosOrdenados = new double[precios.length * precios[0].length];
        int [] cantidadesOrdenadas = new int [cantidades.length * cantidades[0].length];
        
        arrayConversionDosDimensionesAUna(productos, productosOrdenados, ventas, ventasOrdenadas, cantidades, cantidadesOrdenadas, precios, preciosOrdenados);
        ordenarArrays(productosOrdenados, ventasOrdenadas, preciosOrdenados, cantidadesOrdenadas);
        
        /*Arrays que se imprimen sin los productos repetidos y ordenados alfabeticamente*/
        String[] productosUnicos = new String[productosOrdenados.length];
		int[] ventasProductosUnicos = new int[productosOrdenados.length];
		int[] cantidadesProductosUnicos = new int[productosOrdenados.length];
		double[] preciosProductosUnicos = new double[productosOrdenados.length];
		
		int indiceProductoUnico = 0;
		for (int i = 0; i < productosOrdenados.length; i++) {
			boolean productoEncontrado = false;
			for (int j = 0; j < indiceProductoUnico; j++) {
				if (productosOrdenados[i].equals(productosUnicos[j])) {/*Si se encuentra dos productos con el mismo nombre, se mostrara solo uno de ellos*/
					ventasProductosUnicos[j] += ventasOrdenadas[i]; /*Se añade su venta al array que se imprimira*/
					cantidadesProductosUnicos[j] += cantidadesOrdenadas[i]; /*Se añade su cantidad al array que se imprimira*/
					preciosProductosUnicos[j] = preciosOrdenados[i]; /*Se añade su precio al array que se imprimira*/
					productoEncontrado = true; /*se establece el booleano "productoEncontrado" como verdadero para que no se añada ese producto repetido al array de productos únicos.*/
					
				}
			}
			if (!productoEncontrado) { 
				productosUnicos[indiceProductoUnico] = productosOrdenados[i];				/*Si se encuentra un producto que no esta repetido,*/				
				ventasProductosUnicos[indiceProductoUnico] = ventasOrdenadas[i];			/*se añade el producto, sus ventas, cantidades y precios a los arrays de productos únicos, */
				cantidadesProductosUnicos[indiceProductoUnico] = cantidadesOrdenadas[i];	/*ventas de productos únicos, cantidades de productos únicos y precios de productos únicos, respectivamente*/
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
	public static void main(String[] args) {
		Scanner in1 = new Scanner (System.in);		
		int cantidadInicial = 3;	
		String contrasenia = "DAM";	
		String[][] productos = {
				
				{"Lacasitos       ", "Chicles de fresa", "KitKat          ", "Palotes         "},
				{"Oreo            ", "Bolsa Haribo    ", "Chetoos         ", "Twix            "},
				{"M&M'S           ", "Kinder Bueno    ", "Papa Delta      ", "Chicles de menta"},
				{"Lacasitos       ", "Crunch          ", "Milkybar        ", "KitKat          "}
				};
				
		double[][] precios = {
				{1.5, 0.8, 1.1, 0.9},
				{1.8, 1, 1.2, 1},
				{1.8, 1.3, 1.2, 0.8},
				{1.5, 1.1, 1.1, 1.1}
				};
		
		int [][] cantidades = new int [4][4];	
		int [][] ventas = new int [4][4];
		rellenarMatrizCantidad(cantidades); 
		rellenarMatrizVentas(ventas);
		boolean apagar = false;

		while(!apagar) {
			System.out.println(ANSI_GREEN + "\n--MAQUINA EXPENDEDORA--\n");
			System.out.println("**OPCIONES**");
			System.out.println("1. Pedir Golosina ");
			System.out.println("2. Mostrar Golosinas");
			System.out.println("3. Submenu Administrador" + ANSI_RESET);
			System.out.println("");
				System.out.println(ANSI_YELLOW + "Introduce la opcion deseada: " + ANSI_RESET);
				try {
				int seleccion = in1.nextInt();
				
				switch (seleccion) {
				case 1: 
					System.out.println(ANSI_YELLOW + "Introduce la posicion de la golosina. " + ANSI_RESET);
					String posicion = in1.next();
					posicion = posicion.toUpperCase();
					System.out.println(pedirGolosina(productos, cantidades, ventas, posicion));
					break;
				case 2: 
					System.out.println(ANSI_GREEN + "|--PRODUCTOS DISPONIBLES--|" + ANSI_RESET);
					mostrarGolosina(productos, precios);
					break;
				case 3:
					System.out.println(ANSI_YELLOW + "Introduzca la contraseña para acceder: " + ANSI_RESET);
					String contraseniaUsuario = in1.next();
					System.out.println(subMenuContrasenia(contraseniaUsuario, contrasenia));
					boolean salir = false;
					
					while(contrasenia.equals(contraseniaUsuario)&&!salir) {
					System.out.println("");
					System.out.println(ANSI_GREEN + "**OPCIONES**");
					System.out.println("1. Cambiar Contraseña ");
					System.out.println("2. Rellenar Golosina ");
					System.out.println("3. Cambiar Precio ");
					System.out.println("4. Cambiar Producto ");
					System.out.println("5. Ranking Mas Vendido ");
					System.out.println("6. Ranking Menos Vendido ");
					System.out.println("7. Info Productos ");
					System.out.println("8. Ventas Totales ");
					System.out.println("9. Cerrar Sesion Administrador ");
					System.out.println("10. Apagar Maquina" + ANSI_RESET);
					System.out.println("");
					System.out.println(ANSI_YELLOW + "Introduce la opcion deseada: " + ANSI_RESET);
					int seleccion1 = in1.nextInt();
					switch(seleccion1) {
					case 1:
						System.out.println(ANSI_GREEN + "--CAMBIAR CONTRASEÑA--" + ANSI_RESET);
						System.out.println(ANSI_YELLOW + "Introduce la NUEVA contraseña: ");
						String nuevaContrasenia = in1.next();
						System.out.println("REPITA la NUEVA contraseña " + ANSI_RESET);
						String verificarContrasenia = in1.next();
						contrasenia = subMenuCambioContrasenia(nuevaContrasenia, verificarContrasenia, contrasenia);
						
						break;
					case 2:
						System.out.println(ANSI_GREEN + "--RELLENAR GOLOSINA--" + ANSI_RESET);
						System.out.println(ANSI_YELLOW + "Introduce la posicion a rellenar");
						posicion = in1.next();
						System.out.println("Introduce la cantidad a rellenar" + ANSI_RESET);
						int cantidadRelleno = in1.nextInt();
						rellenarGolosinas(posicion, cantidadRelleno, cantidades, productos, cantidadInicial);
						break;
						
					case 3:
						System.out.println(ANSI_GREEN + "--CAMBIAR PRECIO--" + ANSI_RESET);
						System.out.println(ANSI_YELLOW + "Introduzca posicion del articulo a cambiar el PRECIO: ");
						posicion = in1.next();
						System.out.println("Introduzca nuevo precio: " + ANSI_RESET);
						double nuevoPrecio = in1.nextDouble();
						System.out.println(cambiarPrecio(posicion, productos, precios, nuevoPrecio));
						break;
					case 4:
						System.out.println(ANSI_GREEN + "--CAMBIAR PRODUCTO--" + ANSI_RESET);
						System.out.println(ANSI_YELLOW + "Introduzca busqueda: ");
						posicion = in1.next();
						System.out.println("Introduzca nuevo nombre: ");
						String nuevoNombre = in1.next();
						System.out.println("Introduzca nuevo precio: ");
						nuevoPrecio = in1.nextDouble();
						System.out.println("Introduce la cantidad a rellenar" + ANSI_RESET);
						cantidadRelleno = in1.nextInt();
						System.out.println(cambiarProducto(posicion, nuevoNombre, productos, cantidades, precios, nuevoPrecio, cantidadRelleno, cantidadInicial));
						break;
						
					case 5:
						rankingMasVendidos(productos, ventas);
						break;
					case 6:
						rankingMenosVendidos(ventas);
						break;
					case 7:
						
						infoProductos(productos, ventas, precios, cantidades);
						break;
					case 8:
						System.out.println(ANSI_CYAN + "Las VENTAS totales desde el inicio de la maquina son: " + ventasTotales(ventas, precios) + ANSI_RESET);
						break;
					case 9:
						System.out.println(ANSI_CYAN + "Cerrando Sesion..." + ANSI_RESET);
						salir = true;
						break;
					case 10:
						System.out.println(ANSI_CYAN + "Apagando Maquina..." + ANSI_RESET);
						apagar = true;
						salir = true;
						break;
						}
					}
				}
			}catch (NoSuchElementException e) {
				System.out.println(ANSI_RED + "Ha indicado una posicion incorrecta. " + ANSI_RESET);
				in1.next();
			}
		}
		in1.close();
	}	
}
  