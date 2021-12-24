package ProgramacionDinamica;
/**Ejercicio5
 * En una matriz mxn que solo contiene 0 y 1.
 * Se debe encontrar el cuadrado mas grande que solo tenga 1 en su interior y devolver el area
 */
public class maximalSquare {
	public static int maxSquare(char[][] matrix) {
	    if((matrix.length == 0) || (matrix[0].length==0)) {
	    	return 0;
	    }
	    int[][] grip = new int [matrix.length+1][matrix[0].length+1];
	    int rpta = 0;
		for(int i=1;i<= matrix.length;i++) {
			for(int j=1;j<=matrix[0].length;j++) {
				if(matrix[i-1][j-1]=='1') {
					int min = Integer.MAX_VALUE;
					min = Math.min(grip[i-1][j], min);
					min = Math.min(grip[i][j-1], min);
					min = Math.min(grip[i-1][j-1], min);
					
					grip[i][j] = min + 1;
					rpta = Math.max(grip[i][j],rpta);
				}
			}
		}
		return rpta*rpta;		
	}
	/**
	 * Para el caso de prueba se han utilizado los datos brindados por la pagina en los ejemplos
	 * Al final se muestra el area indicada teniendo en cuenta los valores de los caracteres en el arreglo.
	 * **/
	public static void main(String[]args) {
		char[][] grid1 = {{'0'}};
		char[][] grid2 = {{'0','1'},
	                      {'1','0'}};
		char[][] grid3 = {{'1','0','1','0','0'},
	                      {'1','0','1','1','1'},
	                      {'1','1','1','1','1'},
                          {'1','0','0','1','0'}};
		System.out.println("El areal del cuadrado mas grande de la matriz 1 es: "+maxSquare(grid1));
		System.out.println("El areal del cuadrado mas grande de la matriz 2 es: "+maxSquare(grid2));
		System.out.println("El areal del cuadrado mas grande de la matriz 3 es: "+maxSquare(grid3));
		
	}

}
