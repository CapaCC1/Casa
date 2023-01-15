
import java.util.Arrays;

import java.util.Scanner;

	public class NumeroCabalistico {
		public static void main(String[] args) {
	        int number = 142857;
	        for (int i = 2; i <= 6; i++) {
	            int product = number * i;
	            if (!isCabibonacci(product)) {
	                System.out.println("El número deja de ser cábibonacci al multiplicarlo por " + i);
	                break;
	            }
	        }
	    }
	 
	    public static boolean isCabibonacci(int n) {
	        String str = String.valueOf(n);
	        int len = str.length();
	        for (int i = 0; i < len; i++) {
	            if (str.charAt(i) != '0' && str.charAt(i) != '1' && str.charAt(i) != '2' && str.charAt(i) != '5' && str.charAt(i) != '8') {
	                return false;
	            }
	        }
	        return true;
	    }
	}
		

