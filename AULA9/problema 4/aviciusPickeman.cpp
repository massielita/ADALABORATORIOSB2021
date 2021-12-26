#include <iostream>
/**
* Ejercicio4
* Problema del wateringGrass
**/
using namespace std;
/**
* Se tiene la funcion comp que recibe unpuntero *p y un puntero *q
* Luego son asignados a otros punteros a y b
* Para que la funcion llege a retornan la resta de ambos punteros a y b
**/
int comp(const void *p, const void *q) {
	int *a = (int *) p;
	int *b = (int *) q;
	return *a - *b;
}

int main() {
	/**
	* Se tienen 10 variables de tipo long sin inicializar
	* Una variable array tipo log ti que puede almacenar hasta 10000 elementos
	* Luego se asignan los valores ingresado por teclado 
	**/
	long n, t, a, b, c, p, s, i, t_p;
	long ti[10000];
	
	cin >> n >> t >> a >> b >> c >> ti[0];
	/**
	* Para el ciclo for se tiene que el contador i empiece en 1 y sea menor al valor n ingresado
	* Para cada uno de los elementos el valor de a asume la direccion del puntero de la posicion i-1 del arreglo, luego se le suma el valor de b y se le saca el moduloc para sumar finalmente 1
	* El resultado sera almacenado en la posicion i del array ti
	**/
	for (i = 1; i < n; i++)
		ti[i] = (a * ti[i-1] + b) % c + 1;
	/**
	* Se hace un ordenamiento con 4 elementos
	**/
	qsort(ti, n, sizeof(long), comp);
	/**
	* Finalmente se usan las otras variables para hallar el tiempo limite y la penalidad total
	* Para evitar que el valor de las penalidades sea demasiado grande se saca modulo a esta variable p
	**/
	p = 0;
	s = 0;
	t_p = 0;
	for (i = 0; i < n; i++) {
		if (t_p + ti[i] <= t) {
			p = (p + ti[i] + t_p) % 1000000007;
			t_p += ti[i];
			s++;
		} else {
			break;
		}
	}
	
	cout << s << " " << p << endl;
	return 0;
}
