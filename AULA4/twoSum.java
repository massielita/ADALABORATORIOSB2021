/**
 * Ejercicio3
 * ¿Cual es el tiempo de complejidad en terminos de O()?
 * O() quiere decir: En el peor de los casos
 * Este ejercicios tine un tiempo de O(n^2) ya que existen 2 for anidados
 * Este ejercicio parece ser parte de un juego de sumas
 * Ya que estos trabajan en su mayoria con posiciones
 * **/
public class twoSum{
	/**
	 * En la funcion booleana llamada OperationSum
	 * Se recibe como parametro un array de tipo entero
	 * Se crean 2 ciclos for anidados 
	 * Luego se comprueba las dos condiciones:
	 * Si el valor de las posiciones es diferente y si la suma de los elementos de dicha posicion son exactamente iguales a 10
	 * De cumplirse ambas la funcion regresara el valor de true
	 * Caso contrario regresa el valor de false
	 * **/
	public static boolean OperationSum(int[]numers){
    for(int i=0;i<numers.length;i++) {
    	for(int j=0;j<numers.length;j++) {
    		if((i!=j)&&(numers[i] + numers[j])==10) {
    			return true;
    		}
    	}
    }
    return false;    	
	}
	
	/**
	 * Este main crea el arreglo y los valores a usar para el caso de prueba
	 * Luego se llama a la funcion OperationSum
	 * **/
	public static void main(String []args) {
		int []numbers = {2,4,3,1};
		System.out.println(numbers);
	}
}
