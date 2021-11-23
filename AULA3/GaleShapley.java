/**
 * Implementacion del algoritmo GaleShapley
 * En esta ocasion se ha creado una clase,y los metodos para su implementacion
 * 
 * 
 * */
public class GaleShapley
{
	/**
	 * El atributo entero N contendra el tamaño del arreglo del cual se inicie el algoritmo
	 * En este caso se iniciara con la preferencia de los hombres, los hombres proponen
	 * El atributo entero engagedCount tiene a la cantidad de parejas
	 * El arreglo menPref es el que almacenara las preferencias de los hombres
	 * El arreglo womenPre las preferencias de las mujeres
	 * El array men tendra los nombres de los hombres
	 * El array women a los nombres de las mujeres
	 * El array womenParter a los compañeros de las mujeres
	 * El booleano menEngaged me dira si un hombre esta con pareja o no.
	 * 
	 * */
    private int N, engagedCount;
    private String[][] menPref;
    private String[][] womenPref;
    private String[] men;
    private String[] women;
    private String[] womenPartner;
    private boolean[] menEngaged;
 
    /** Constructor **/
    public GaleShapley(String[] m, String[] w, String[][] mp, String[][] wp)
    {
        N = mp.length;
        engagedCount = 0;
        men = m;
        women = w;
        menPref = mp;
        womenPref = wp;
        menEngaged = new boolean[N];
        womenPartner = new String[N];
        calcMatches();
    }
    /** Funcion que calcula las parejas **/
    private void calcMatches()
    {   
    	/**
    	 * Mientras que el numero de parejas sea menor que el numero de hombres
    	 * 
    	 * */
    	
        while (engagedCount < N)
        {
        	/**
        	 * Se crea variables auxiliares: free, index,currentPartner
        	 * entero free: me indica el numero de personas solteras
        	 * entero index: contendra el indice de la preferencia de las mujeres solteras por parte de los hombres
        	 * String currentPartner: el indice de la pareja de la mujer
        	 * */
            int free;
            for (free = 0; free < N; free++)
                if (!menEngaged[free])
                    break;
 
            for (int i = 0; i < N && !menEngaged[free]; i++)
            {
                int index = womenIndexOf(menPref[free][i]);
                if (womenPartner[index] == null)
                {
                    womenPartner[index] = men[free];
                    menEngaged[free] = true;
                    engagedCount++;
                }
                else
                {
                	/**
                	 * Si el indice de la nueva pareja tiene mayor preferencia para la mujer u hombre 
                	 * Se cambia y actualiza la pareja
                	 * Un hombre queda soltero 
                	 * Se obtiene el indice de este hombre soltero para volver a repetir el algoritmo 
                	 * */
                    String currentPartner = womenPartner[index];
                    if (morePreference(currentPartner, men[free], index))
                    {
                        womenPartner[index] = men[free];
                        menEngaged[free] = true;
                        menEngaged[menIndexOf(currentPartner)] = false;
                    }
                }
            }            
        }
        printCouples();
    }
    /** Funcion que verifica si las mujeres prefieren una nueva pareja a la que tienen por preferencia **/
    private boolean morePreference(String curPartner, String newPartner, int index)
    {
    	/**
    	 * Si el indice de la nueva pareja tiene mayor preferencia para la mujer u hombre devuelve true
    	 * Esto significa que quiere cambiar de pareja sino se queda con la que tiene
    	 * */
        for (int i = 0; i < N; i++)
        {
            if (womenPref[index][i].equals(newPartner))
                return true;
            if (womenPref[index][i].equals(curPartner))
                return false;
        }
        return false;
    }
    /** Obtiene el indice de uno de los hombres **/
    private int menIndexOf(String str)
    {
        for (int i = 0; i < N; i++)
            if (men[i].equals(str))
                return i;
        return -1;
    }
    /** Obtiene el indice de una de las mujeres **/
    private int womenIndexOf(String str)
    {
        for (int i = 0; i < N; i++)
            if (women[i].equals(str))
                return i;
        return -1;
    }
    /** Imprime las parejas **/
    public void printCouples()
    {
        System.out.println("Las parejas obtenidas son : ");
        for (int i = 0; i < N; i++)
        {
            System.out.println(womenPartner[i] +"  y  "+ women[i]);
        }
    }
    /** Funcion principal **/
    public static void main(String[] args) 
    {
        System.out.println("Gale Shapley Algorithm\n");
        System.out.println("Los hombres proponen a las mujeres\n");
        /** Lista de hombres añadidos de antemano **/
        String[] m = {"Wiliam", "Victor", "Zeus", "Xavier", "Yancey"};
        /** Lista de mujeres añadidas **/
        String[] w = {"Bertha", "Amy", "Erika", "Claire", "Diane"};
 
        /** Preferencia de los Hombres**/
        String[][] mp = {{"Bertha", "Amy", "Diane", "Erika", "Claire"}, 
                         {"Diane", "Bertha", "Amy", "Claire", "Erika"}, 
                         {"Bertha", "Erika", "Claire", "Diane", "Amy"}, 
                         {"Amy", "Diane", "Claire", "Bertha", "Erika"},
                         {"Bertha", "Diane", "Amy", "Erika", "Claire"}};
        /** Preferencia de las Mujeres **/                      
        String[][] wp = {{"Zeus", "Victor", "Wiliam", "Yancey", "Xavier"},
        		{"Xavier", "Wiliam", "Yancey", "Victor", "Zeus"}, 
                {"Wiliam", "Xavier", "Yancey", "Zeus", "Victor"},
                {"Victor", "Zeus", "Yancey", "Xavier", "Wiliam"}, 
                {"Yancey", "Wiliam", "Zeus", "Javier", "Victor"}};

        GaleShapley gs = new GaleShapley(m, w, mp, wp);                        
     }
}
   