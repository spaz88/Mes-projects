/*J'ai réaliser ce programme pour me faire comprendre
comment assigner une valeur a un pointeur a la place d'une adresse*/

#include <iostream>
#include <string>

using namespace std;

int main()
{

	int i = 7;
	int* ptr = &i;
	*ptr = *ptr + 1;
	cout << *ptr << endl;


	return 0;
}