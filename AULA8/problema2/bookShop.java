package ProgramacionDinamica;

import java.util.Scanner;

/**Ejercicio2
 * 
 * @author MASSIEL
 *
 */
public class bookShop {
	public static int getMaxPages(int num, int max,int[]a, int[]b) {
		int rpta = 0;
		int[] maxPages = new int[num];
		for(int i=0; i<num;i++) {
			int bookPrice = a[i];
			int bookPages = b[i];
			for(int price = max; price >= bookPrice;price--) {
				maxPages[price]= Math.max(maxPages[price], (bookPages + maxPages[price - bookPrice]));
				rpta= rpta + maxPages[price];
			}	
		}
		return rpta;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int maxPrice = 10;
		int[] prices = {4,8,5,3};
		int[] pages = {5,12,8,1};
		System.out.println("Se obtiene que el numero de paginas es : ");
		getMaxPages(n,maxPrice,prices,pages);
	}
}
