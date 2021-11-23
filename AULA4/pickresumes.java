/**
 * Ejercicio 5
 * Este codigo se encarga de ir resumiendo el texto que se haya ingresado en el string
 * De ahi el nombre resumes ya que tecnicamente hace resumen al ir dividiendo la cantidad de caracteres
 * El tiempo de complejidad de este codigo es de: O(n)
 * 
 * */
public class pickresumes {
	/**
	 * La funcion pick_resumes recibe un string como parametro
	 * Se crea una variable auxiliar delete, al que le asignamos de forma temporal la palabra top
	 * Esta funcion se repetira siempre que el tamaño del string parametro sea mayor a 1
	 * Ahora comparamos por completo si el string delete es exactamente igual a top
	 * Si es verdad entonces ahora se usa el subString para disminuir el tamaño de la palabra
	 * Esto debido a que se partira la cadena y se comenzara a la mitad,hasta terminar.
	 * y luego de eso se procede a modificar el valor de delete auxiliar por bottom
	 * Si el caso anterior no funciono entonces se verifica si la palabra es igual al temporal.
	 * Ahora se resumes desde el inicio, es decir es partido desde la posicion inical hasta la mitad de la palab
	 * y se modifica la palabra a lo que queda que es la cima de la palabra.
	 * Esto seguira hasta que finalmente solo quede un caracter de la palabra original  
	 * **/
	
    public static String pick_resumes(String resumes) {
    	String delete = "top";
    	while (resumes.length() > 1) {
    		if(delete.equalsIgnoreCase("top")){
    			resumes = resumes.substring(resumes.length()/2, resumes.length()-1);
    		    delete = "bottom";
    		}
    		else {
    			if(delete.equalsIgnoreCase("bottom")) {
    				resumes= resumes.substring(0, resumes.length()/2);
    				delete = "top";
    			}
    		}
    	}
    	return resumes.substring(0);
    }
   
    public static void main (String []args) {
    	/**
    	 * Aqui se crea la cadena y se le da una pequeña informacion 
    	 * Luego se imprime la cadena original para mostrarla y despues ya resumida
    	 * **/
    	String cadena;
    	cadena = "letra";
    	System.out.println("Cadena: "+cadena.toString());
    	System.out.println("Cadena resumida: "+pick_resumes(cadena));
    }
}
