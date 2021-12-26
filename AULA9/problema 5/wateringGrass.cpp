#include <algorithm>
#include <vector>
#include <cstdio>
#include <iostream>
#include <cmath>
/**
* Ejercicio5
* Problema del wateringGrass
**/
using namespace std;
/**
* Se crea un struct interval con sus atributos a, b e index.
* Asi como un metodo boolean operator 
**/
struct interval{
	double a;
	double b;
	int index;
	
	bool operator < (interval x) const {
		return a < x.a;
	}
};
/**
* Los elementos del cpp wateringGrass son las variables de tipo double A,B y maxx 
* Las variables enteras son n,it,best y el vector entero cover
* Y una variable booleana possible 
**/
double A,B,maxx;    
int n, it, best;
vector<int> cover;
bool possible;
/**
* Se tiene un ciclo while que se activa al ingresar los parametros correspondientes
* Luego mediante el ciclo for se viene a indicar la posicion del radio asi como la construccion del intervalo
**/
int main(){
	int n,l;
	double r,w,x;
	while (cin >> n >> l >> w){
		interval intervals[n];
		for (int i=0;i<n;i++){
			cin >> x >> r; // Esta viene a indicar la posicion del radio  position radius => build intervals
			if (r >= w/2){
				double p = sqrt(r*r -w*w/4);
				intervals[i].a = x - p;
				intervals[i].b = x + p;
				intervals[i].index = i;
			}
			else {
				intervals[i].a = -1;
				intervals[i].b = -1;
				intervals[i].index = i;
			}
		}
		A = 0;
		B = l;
		
		sort(intervals,intervals+n); //Este viene a incrementarse 
		it = 0;
		cover.clear();
		possible = true;
		/**
		* Hasta que intervals pueda ser razonable se ira incrementando el contador it 
		**/
		while (intervals[it].b < A){
			it++;
			if (it == n){
				possible = false;
				break;
			}
		}
        /**
		* Si A es exactamente igual a B y este llega a ser posible se ingresa a otra condicion 
		* Si se tiene que el intervaalo en la posicion de a y b del respectivo contador it llegara  a ser menor que A
		* Entonces el vector cover envia de vuelta la posicion del elemento 
		* Caso contrario no devuelve falso para indicar que es imposible
		**/
		if (A == B && possible){
			if (intervals[it].a <= A && intervals[it].b >= A)
				cover.push_back(intervals[it].index);
			else possible = false; 
		}
		/**
		* Si ocurre que A es menor a B y que es verdaderamente posible se vuelve a entrar en otro condicional
		* Si se tiene que it es exactamente igual a n
		* Entonces el valor de posible es falso y se rompe el ciclo
		**/
		while (A < B && possible){
			if (it == n){
				possible = false;
				break;
			}
			/**
			* Se llegan a asignar valores negativos a max y best para luego actualizarlos teniendo en cuenta las condiciones
			*/
			maxx = -1;
			best = -1;
			while (intervals[it].a <= A){
				if (intervals[it].b - A > maxx){
					maxx = intervals[it].b - A;   // maxx asume el valor de este intervalo
					best = it;    // Se actualiza el valor de best con la posicion it
				}
				it++;
				if (it == n) break;
			}
			/**
			* Si best tiene valores negativos entonces el valor de la variable possible tambien se vuelve falso y se termina el ciclo
			* Se continua devolviendo el indice del mejor intervalo y luego se le asigna a a variable A
			**/
			if (best == -1){
				possible = false;
				break;
			}
			cover.push_back(intervals[best].index);
			A = intervals[best].b;
		}
		/**
		* Para terminar si el valor de posible es falso entonces se imprimira -1 
		* Caso contrario se imprimiran los valores del vector 
		**/
		if (!possible)
			printf("-1\n");
		else{
			printf("%lu\n",cover.size());
		}
	}
	return 0;
}
