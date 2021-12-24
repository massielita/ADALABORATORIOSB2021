/***Ejercicio2
 * El disleccionario es cuando se tiene un conjunto de palabras pero que estas llega estar ordenadas a partir de sus ultima letra
 * En lugar de la primera por lo tanto en esta ocasion procederemos a crear una algoritmo que permita simular un disleccionario a un conjunto de palabras
 */
import java.io.IOException;
import java.util.*;
public class Dyslectionary {
public static void main(String[] args) throws IOException {
Scanner scan = new Scanner(System.in);
boolean end = false;
while (scan.hasNext()){
    ArrayList<String> words = new ArrayList<>();
    int max = 0;
    while (true){
        String word = scan.nextLine();
        if (!scan.hasNext())
            end = true;
        if (word.isEmpty())
            break;
        
        max = word.length() > max ? word.length() : max;
        words.add(word);
        if (end)
            break;
        }
     for (int i = 0; i < words.size(); i++){
        String word = words.get(i);
        int spaces = max - word.length();
        /**
         * Ayuda a calcular la existencia de espacios y si los encuentra los añade al array words comenzando edesde la ultima letra 
         * **/
        for (int z = 0; z < spaces; z++)
            word = " " + word;
        words.set(i , word);
        }
    /**
     * Se hace uso de la herramienta collections para trabajar con funciones complejas de los strings
     * Asi como para comparar de manera mas eficiente entre las cadenas
     * **/
        Collections.sort(words , new Comparator<String>() {
        public int compare(String str1 , String str2) {
            for (int i = str1.length() - 1; i >= 0; i--)
                if (str1.charAt(i) != str2.charAt(i))
                    return str1.charAt(i) - str2.charAt(i);
            
            return 0;
    }
    });
    for (String word : words)
        System.out.println(word);
    
    if (!end)
        System.out.println();
    }
    System.out.println("");
scan.close();
    }

}