package ProgramacionDinamica;
import java.util.Scanner;
/**Ejercicio1
 * Lo que quiere es encontrar un algoritmo de manera que este pueda hallar los caminos posibles
 * De un robot dentro de una matriz cuadratica.
 * Teniendo en cuenta que solo puede avanzar hacia abajo y hacia la derecha.
 * @author MASSIEL
 */
public class uniquePath {
	/**
	 * El metodo uniquePathsWithObstacles recibe un arreglo bidimensional de parametros
	 * A las variables row y col se les asignan los valores de filas y columnas respectivamente
	 * Creamos un nuevo array con los datos anteriores
	 * La variable boolean nos sirve para indicarnos si hay un obstaculo 
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][]road = new int[row][col];
        boolean obstacle = false;
        /**
         * Al ser bidimensional primero se comprueba desde la primera fila 
         * **/
		for(int i=0;i<col;i++) {
			if(obstacle||obstacleGrid[0][i]==1){
                obstacle = true;
                road[0][i] = 0;
            }
            else
                road[0][i] = 1;
		}
		/**
         * Ahora  comprobamos el estado desde la primera columna 
         * **/
        obstacle = false;
		for(int i=0;i<row;i++) {
			if(obstacle||obstacleGrid[i][0]==1){
                obstacle = true;
                road[i][0] = 0;
            }
            else
                road[i][0] = 1;
		} 
		/**
		 * Ahora se analizaran si se encuentra caminos
		 * Se verifica si se ha encontrado algun obstaculo en la pocision [i][j] dentro de la matriz
		 * De encontrarse un camino con algun obstaculo nos enviara como respuesta 0 ya que no puede avanzar
		 * Caso contrario enviara como respuesta la cantidad de caminos que este pueda tener al avanzar solo hacia abajo y a la derecha
		 * **/
		
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==1)
                    road[i][j] = 0;
                else
                    road[i][j] = road [i - 1][j] + road[i][j - 1];
            }
        }
        return road[row - 1][col - 1];
    }
	
	public static void main(String[] args) {
		//Se usan los datos de entrada del ejemplo de la descripcion
		int road[][]= {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("El robot tiene: "+ uniquePathsWithObstacles(road)+" caminos");
		
		
	
		
		
		
		
	}
}
