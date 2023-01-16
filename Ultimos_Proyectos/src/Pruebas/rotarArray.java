package Pruebas;
import java.util.Scanner;
public class rotarArray {
	public static void imprimirArray(int numeros[]) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		
		}
	}
	public static void volteaArrayInt (int numeros []) {
		int [] invertido = new int[numeros.length];
		
		for (int i = 0; i < numeros.length; i++) {
			invertido[i] = numeros[numeros.length-1-i];
		}
		numeros = invertido;
		imprimirArray(numeros);
}
	public static void rotaIzquierdaArrayInt(int mover) {
		/*Aquí, se ha utilizado un ciclo anidado, donde el ciclo externo se ejecuta mover veces 
		 *y el ciclo interno se encarga de desplazar cada elemento hacia la izquierda una vez. 
		 *En cada iteración del ciclo interno, el primer elemento del array se almacena en una variable temporal, 
		 *y luego se desplaza cada elemento del array una posición hacia la izquierda. 
		 *Finalmente, el elemento temporal se coloca en la última posición del array, completando así una rotación hacia la izquierda.*/
		
		int [] numeros = {1,2,3,4,5,6,7,8};
	    mover = mover % numeros.length;
	    for (int i = 0; i < mover; i++) {
	        int primero = numeros[0];
	        for (int j = 0; j < numeros.length - 1; j++) {
	            numeros[j] = numeros[j + 1];
	        }
	        numeros[numeros.length - 1] = primero;
	    }
	    
	    imprimirArray(numeros);
	}
	public static void rotaDerechaArrayInt (int mover) {
		int [] numeros = {1,2,3,4,5,6,7,8};
		int i,ultimo;
		mover = mover % numeros.length;
		for (int j = 0; j < mover; j++) {
			ultimo = numeros[numeros.length-1];
			
			for(i = numeros.length-1; i>0; i--){
            numeros[i]=numeros[i-1]; 
        }
        numeros[0] = ultimo;
		}
        imprimirArray(numeros);
    }
	public static void main(String[] args) {
		Scanner in1 = new Scanner (System.in);
		System.out.println("Cuantas posiciones quieres mover? ");
		int mover = in1.nextInt();
		
		int [] numeros = {1,2,3,4,5,6,7,8};
		imprimirArray(numeros);
		System.out.println("\n");
		rotaDerechaArrayInt(mover);
		System.out.println("\n");
		rotaIzquierdaArrayInt(mover);
		System.out.println("\n");


	}

}
