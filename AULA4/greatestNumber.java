/**
 * Ejercicio 1
 * Convertir de O(n^2) a O(n)
 * Esta funcion greatestNum consiste en lograr imprimir el numero mayor de un arreglo de numeros
 * */
public class greatestNumber{

    public static int greatestNum(int[]list){
    /**
     * Se recibe como parametro un arreglo de tipo int
     * Se crea e inicializa la variable maxNum con el valor 0
     * Mediante el for se recorre el arreglo list
     * Por el condicional if se comprueba si el elemento i del array es mayor al maxNum
     * Si se cumple entonces el valor del elemento i se convierte en el valor de la variable maxNum
     * Finalmente se retorna el valor de maxNum
     * **/
	    int maxNum = 0;
	        for (int i=0;i<list.length;i++) {
	    	    if(list[i]> maxNum)
	    		    maxNum = list[i];
	    }
	    return maxNum;
    }
    public static void main(String []args) {
    /**
     * Se crea valores para el caso de prueba de la funcion
     * Se muestra en consola: El numero maximo es:
     * Se llama al metodo greatestNum
     * **/
    	int [] list = {2,5,3,7,10};
    	System.out.println("El numero maximo es: ");
    	System.out.println(greatestNum(list));
    }
}