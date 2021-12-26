package greedyAlgorithms;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/**Ejercicio3
 */
/**
 * Se tiene aqui la implementacion de una clase simple Persona con atributos cash y time
 * Esto ayuda a implementar de manera mas facil algunas funciones en la funcin maxProfit
 * **/
public class Person implements Comparable<Person> {
    int cash;
    int time;
    
    public Person(int c, int t) {
        this.cash = c;
        this.time = t;
    }
    public int compareTo(Person p) {
        int pc = p.cash;
        int pt = p.time;
        
        if (cash < pc) return -1;
        if (cash > pc) return 1;
        if (time < pt) return -1;
        if (time > pt) return 1;
        return 0;
    }

	/**
	 * El metodo main llamara al metodos encargado de obtener la cantidad maxima de dinero antes q el banco cierre
	 * **/
    public static void main(String[] args) {
            maxProfit();
    }

    public static void maxProfit() {
    	/**
    	 * Se obtienen datos ingresados por el usuario y luego son asignados a N y T
    	 * Donde N es el numero que personas que hay en la cola
    	 * Y T el tiempo que queda antes que el banco cierre
    	 * Se tienen varibles de tipo long
    	 * totalCash es donde se ira guardando y actualizando el dinero que Oliver este obteniendo
    	 * soFar es el numero de personas atendidas 
    	 * **/
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        long totalCash = 0;
        long soFar = 0;
        
        /**
         * Se crea un ArrayList que ayudara a crear y almacenar la cola llamada pq porque se toma en cuenta la prioridad de las personas en la cola
         * Esta cola pq sera ordenada mediante la libreria collections de forma inversa pues se ordenara deacuerdo a la paciencia que los clientes tengan
         * Donde se ira  actualizando a la cola la informacion de cuantas personas quedan en la cola y el tiempo antes de cerrar
         * Tambien se tiene un array de tipo boolean select que sera usado junto a clase Person
         * Siempre que el espaci sea menor al de las personas que quedan y la cola no este vacia
         * El objeto nextPerson de la clase Person es agregado a la cola
         * Se tiene la variable entera inicio que sera el cronometro de marcha atras y que se inicia en el momento del turno de la siguiente persona en cola
         * Siempre que sea horario del banco este seguira contando tiempo hasta que se cierre el banco
         * Dentro de este ciclo while al estar el tiempo aun contando y siendo diferente a negativo
         * Se aumenta el contador soFar y el banco sigue atendiendo se seguira sumando el dinero que la gente haya ido a depositar
         * De este modo al final ira a imprimir el dinero total hasta que el banco haya sido cerrado
         * **/
        
        PriorityQueue<Person> pq = new PriorityQueue<Person>(N, Collections.reverseOrder());
        
        for (int i = 0; i < N; i++) {
            pq.add(new Person(in.nextInt(), in.nextInt()));
        }
        
        boolean[] select = new boolean[T];
        Person nextPerson;
        while (soFar < N && !pq.isEmpty()) {
            nextPerson = (Person)pq.poll();
            int inicio = nextPerson.time;
            
            while (inicio >= 0 && select[inicio]) {
                inicio--;
            }     
            if (inicio != -1) {
                soFar++;
                select[inicio] = true;
                totalCash += nextPerson.cash;
            }
        }
        System.out.println(totalCash);  
    }
}