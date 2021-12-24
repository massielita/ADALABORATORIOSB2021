/**Ejercicio1
 * 20/12/2021
 * Se 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * Ejercicio1
 * Se le dice Anagrama a aquellas palabras donde el orden de las letras puede ser cambiado y luego crear palabras totalmente diferentes
 * En esta ocasion se plantea crear un algoritmo que me permita crear un anagrama con un array de cadenas que yo ingrese
 * **/
public class Anagrama{
   public static List<List<String>> groupAnagrams(String[] strs) {
	   /**
	    * Primer se crea un ArrayList de Lista de String groupedAnagrams
	    * Luego un HashMap  map que reciba String y un ArrayList de String
	    * Despues se crea un for each donde la variable String current va almacenar la cadena que recibio como parametro
	    * Dentro de este for each se crea un array characters de tipo char el cual se va almacenar los valores de cada uno de los caracteres de current
	    * Como ahora son tecnicamente un array se usa una funcion de arrays para ordenar a los caracteres.
	    * Con ayuda de otra cadena string el antiguo array caracteres vuelve a ser una cadena
	    * Ahora se hara un confirmacion, siempre que en el hasmap no contenga una cadena que haya sido ordenada,
	    * Esta sera ordenada y enviada a un nuevo ArrayList
	    * El mapa ordenara sus elementos y los ira añadiedno a current
	    * Una vez que el ArrayList haya añadido todos lo valores del hashmap 
	    * Este regresara una lista con las cadenas donde hayan sido movidos sus caracteres y tengan otro significado.
	    * **/
        List<List<String>> groupedAnagrams = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String current:strs){
            char[] characters = current.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());   
            }   
            map.get(sorted).add(current);
        }   
        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
   }
  public static void main(String[]args) {
	  String[] words = {"eat","tea","tan","ate","nat","bat"};
	  System.out.println("Al ingresar esta cadena de palabras: ");
	  System.out.println("[ eat, tea, tan, ate, nat, bat ]");
	  System.out.println("Obtenemos las siguientes palabras: "+ groupAnagrams(words) +" ");
  }
   
   
}