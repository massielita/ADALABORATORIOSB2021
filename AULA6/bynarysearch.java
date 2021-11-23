/**
 * Pregunta1: ¿Es x=16 un cuadrado? por busqueda binaria
 * Yes
 * **/
public class bynarysearch {
	/**
     * Se crea la funcion mainroot que recibe un parametro entero
     * Creamos una variabla auxiliar rpt inicializada en 0
     * Mediante un for se recorre desde el 0 hasta el numero ingresado del parametro de la funcion
     * Si al multiplicar numero iguales cuyos valores son entre 0 y n y la respuesta es menor o igual a n
     * Entonces se tiene una raiz cuadrada
     * Caso contrario si no la tiene simplemente retornara cero
     * 
     * **/
    public static int mainroot(int n) {
 	   int rpt=0;
 	   for(int i=0;i<=n;i++) {
 		   if(i*i<=n)
 			   rpt=i;
 	   }
       return rpt;
    } 		
	
	   /**
	    * Aqui se declara una variable number con el valor que queremos trabajar en la prueba que en este caso es 16
	    * Tambien se puede elegir trabajar con el otro dato 20 para comprobar su funcionalidad
	    * Ahora se crea una variable root que almacenara el resultado de la funcion mainroot
	    * Finalmente se imprime la respuesta siempre y cuando esta tenga raiz cuadrada sin usar metodos matematicos
	    * **/
       public static void main (String[]args){
    	  int number = 16; 
    	  int root =mainroot(number);
    	  System.out.println(root);
       }
       /* public static void main (String[]args){
    	  int number = 20; 
    	  int root =mainroot(number);
    	  System.out.println(root);
       }
       */    
}
