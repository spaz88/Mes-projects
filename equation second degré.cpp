/*Ce programme permet de calculer une équation du second
degré de la forme ax²+bx+c*/

#include <iostream>
#include <string>
#include <math.h>
using namespace std;


int main()
{
	int a, b, c, reponse;
	int alpha;
	cin >> a;
	cin >> b;
	cin >> c;

	alpha = b * b - 4 * a * c;

	if (alpha == 0) {
		reponse = -b / (2 * a);
		cout << reponse << endl;
	}

	if (alpha > 0) {
		int reponse2 = 0;
		reponse = (-b + sqrt(alpha)) / (2 * a);
		reponse2 = (-b - sqrt(alpha)) / (2 * a);
		cout << reponse <<endl << reponse2 << endl;
	}
	if (alpha < 0) {
		cout << "Il n'y a pas de solution" << endl;
	}


	return 0;

}