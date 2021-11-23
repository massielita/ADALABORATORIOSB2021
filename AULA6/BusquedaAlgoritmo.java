/**
 * Pregunta2:
 * Encuentra el primer valor mayor mas cercano que x
 * No pude concretarlo al 100%
 * **/
public class BusquedaAlgoritmo{
	/**
	 * El metodo buscar de tipo entero recibe un parametro array entero y un dato entero
	 * Se crean variables para que ayuden en la busqueda binaria, inf es inicializada en 0
	 * Sup viene a ser la cantidad total de mis elementos mientras que half solo es creada por el momento
	 * Para que funcione nuestro algoritmo se debe tener una modo de parar el ciclo para eso usamos un while
	 * Mientras que el inf sea menor al sup se repetira el ciclo, en donde half viene a ser el promedio de inf y sup
	 * Luego con un condicional se comprueba si el elemento del medio es el dato que se busca
	 * Si es asi entonces se retorna el valor del medio
	 * Caso contrario siel elemento del medio es menor que el dato entonces nos movemos hacia la derecha del arreglo
	 * Los valores cambian y ahora el inf es igual al valor del medio + 1 ya que el dato que buscamos es mayor que el valor del medio
	 * caso contrario seria lo opuesto que el dato que buscamos es menor al valor del medio
	 * Por lo que vamos a la izquierda y la variable a modificar viene  a ser sup cuyo valor es ahora igual al valor del medio -1
	 * Si ninguna de las anteriores se llega a cumplir entonces se regresa el valor -1
	 * **/
	public static int buscar( int [] lista, int dato) {
		 int inf = 0;
		 int sup = lista.length - 1;
		 int half;
		 while (inf <= sup) {
		     half = (inf+sup) / 2;
		     if (lista[half] == dato )
		         return half;
		     else if (lista[half] < dato ) {
		         inf = half+1;
		     }    else {
		         sup = half-1;
		     }
		 }
		 return -1;
	}

	/**
	 * En el main se declaran los numero del arreglo para el caso de prueba se usan los datos de la diapositiva
	 * Algo para agregar es que se puede imprimir si se ha llegado a encontrar o no el dato
	 * Esto gracias a la funcion buscar que ha registrado mediante valores numericos si se ha logrado la busqueda
	 * Si es verdad se mostrara el mensaje que ha sido encontrado con el indice de dicho dato
	 * De haber fallado la busqueda se indicara que se fallo
	 * No se ha llegado a implementar que se muestre el elemento mayor
	 * **/
    public static void  main (String args[]) {
    int [] numeros = {2,3,5,6,8,10,12};
    //Se llenan los elementos del arreglo 
    for (int i = 0; i < numeros.length ; i++)
          numeros[i] = i*i ;
    //Se imprime el arreglo
    for (int i = 0; i < numeros.length ; i++)
    System.out.println ( "Posicion ["+i+"]: "+  numeros[i]);

    int resultado = BusquedaAlgoritmo.buscar(numeros,4);
       if (resultado != -1) {
       System.out.println ( "El numero ha sido encontrado en: "+  resultado);
       }  else {
       System.out.println ( "El numero no se ha encontrado en el arreglo");
       }
 }
}
