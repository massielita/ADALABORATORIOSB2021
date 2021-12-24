package ProgramacionDinamica;
import java.util.Arrays;
/**Ejercicio3
 * Hallar el numero maximo de subsecuencias a partir de un arreglo
 */
public class numLongestIncreasingSubsequence {
	public static int findNumberofList(int []nums ) {
		/**
		 * Teniendo como dato el arreglo se utiliza su tamaño
		 * De esta forma si se ve que es un numero menor o igual a uno ya no es necesario calcular y simplemente se envia su tamaño comoresultado
		 * **/
		if(nums.length <=1)
			return nums.length;
		/**
		 * Se crea un array unidimensional dp de tipo entero que recibira el tamaño del parametro nums
		 * Se crea una variable maxTam y se le inicializa con 1, que sera actualizado hasta encontrarse el subyacente de mayor tamaño
		 * Mediante un forma se empiezan a recorrer los elementos del array nums.
		 * Al haber creado ciclos anidados comparamos si los elementos de la posicion con mayores a los elementos de la posicion j
		 * Entonces se actualiza el valor del array dp con el elemento maximo(dp[i] y dp[j]+1)
		 * Saliendo de un for se vuelve a utilizar la funcion matematica max, pero esta vez para actualizar al valor de max
		 * De manera que al final la funcion findNumberofList retorna un valor de tipo entero que viene a ser la maxima cantidad de subsequentes que tiene un arreglo
		 * **/
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<i;j++) {
				  if(nums[j]<nums[i]) {
					  dp[i] = Math.max(dp[i],dp[j]+1);
				  }
			}
			max = Math.max(max,dp[i]);
	    }
		return max;

	}	
	public static void main(String[]args) {
		/**
		 * Se utilizan los ejemplos de las diapositivas trabajadas en clase para los casos de prueba
		 * **/
		int[]arr1 = {0,3,1,6,2,2,7};
		int[]arr2 = {10,9,2,5,3,7,101,18};
		System.out.println("Para el arreglo : [0,3,1,6,2,2,7]");
		System.out.println("El numero de subsecuencias mas largas del arr1 es: [ " + findNumberofList(arr1)+ " ]");
		System.out.println("Para el arreglo : [10,9,2,5,3,7,101,18]");
		System.out.println("El numero de subsecuencias mas largas del arr2 es: [ " + findNumberofList(arr2)+ " ]");	
	}	
}
