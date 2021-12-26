package greedyAlgorithms;
/**Ejercicio2
 * Este algoritmo recibira un arreglo intero y un valor entero K como parametros
 */
public class tieRopes {
	/**
	 * Se crean e inicializan las variables enteras maxRopes y cont en 0
	 * maxRopes guardara el valor de la cantidad maxima de nodos a crear con los datos recibidos
	 * cont sera nuestra variable auxiliar temporal para contar los nodos a considerar
	 * Se comienza un ciclo for iniciado en i, cuyo tamaño es menor al del arreglo A
	 * La variable cont ira sumando los valores dentro del arreglo en las diferentes posiciones
	 * Si se tiene que la suma de los elementos es mayor o igual al parametro K
	 * Este asigna el valor de la suma a maxRopes y se para a suma
	 * Para devolver el numero maximo de enteros llamado desde el main
	 * **/
	
	public static int maxRopes(int K, int[] A) {
		int maxRopes = 0;
		int cont=0;
		for(int i=0;i<A.length;i++) {
			cont = cont + i;
			if(cont>=K) {
				maxRopes = maxRopes + 1;
				cont = 0;
			}
			else
				continue;
		}
		return maxRopes;
	}
	public static void main(String []args) {
		int arr[]= {1,2,3,4,1,1,3};
		int num = 4;
		System.out.println("Usando los datos del prueba: ");
		System.out.println(" {1,2,3,4,1,1,3} ");
		System.out.println("El numero maximos de nudos es: "+ maxRopes(num,arr));
	}
}
