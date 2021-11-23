import java.util.ArrayList;
/**
 * Ejercicio 2
 * ¿Cual es el tiempo de complejidad?
 * Este problema en ruby yo lo entiendo asi:
 * Recibes un array y mediante un each evaluas los numeros del array con el indice
 * Luego compara si el numero es igual a la posicion de dicho numero en el array
 * si fuera cierto entonces esta posicion se almacena en una variable othernumber
 * Luego se imprimen los numeros que cumplen la condicion junto a su posicion en el arreglo
 * Tiempo de complejidad: es O(n) ya que se han un for y condicionales
 * */

public class everyother{
	
    /**
     * La funcion everysame recibe un array list de tipo entera     
     * Ahora mediante un for se procede a evaluar los elementos del arrayList
     * Con el condicional if se comprueba si el numero del array es exactamente igual a su indice del array
     * Si es verdad entonces se imprimira el numero junto a su indice en el arrayList
     * **/
	public static void everysame(ArrayList <Integer>list){
		for(int i =0;i<list.size();i++) {
			if(list.get(i)==i)
				System.out.println("Numero: "+list.get(i)+" ------> "+"Indice "+i);			
		}
	}
	
	/**
	 * El main es hecho principalmente para declarar el ArrayList y hacer uso del caso de prueba
	 * Se decidio trabajar con ArrayList ya que es mas facil trabajar con los indices de sus elementos
	 * **/
	public static void main (String []args) {
		ArrayList <Integer> numbers;
		numbers = new ArrayList<Integer>();
		numbers.add(6);
		numbers.add(1);
		numbers.add(8);
		numbers.add(3);
		numbers.add(4);
		System.out.println(" Numeros del arrayList:");
		System.out.println(numbers);
		System.out.println("Numero  ---------  Indice");
		everysame(numbers);
	}
}
