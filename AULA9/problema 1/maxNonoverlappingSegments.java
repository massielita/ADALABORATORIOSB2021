package greedyAlgorithms;
/**Ejercicio1
 * 
 * @author MASSIEL
 *
 */
/**
*/
public class maxNonoverlappingSegments {
	public int solution(int []A,int []B) {
		int tempPosition = -1;
		int segmentCount = 0;		
		for(int i = 0; i<A.length; i++) {
			if(A[i]>tempPosition) {
				tempPosition = B[i];
				segmentCount++;
			}
		}
		return segmentCount;
	}
	
	public static void main(String[] args) {
		System.out.println("Dados los valores de ciertos elementos del arreglo");
		System.out.println("El numero maximo de  segmentos solapados es: ");
		System.out.println(new maxNonoverlappingSegments().solution(
		        new int [] {1,3,7,9,9},
				new int [] {5,6,8,9,10}));
		
	}
}
