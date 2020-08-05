/*Ce programme permet d'écrire du texte dans un fichier txt déjà existant et en indiquant l'adresse de celui-ci*/


#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	string const nomFichier("C://Users//Spaz//Documents//ConsoleApplication1//issou//issou.txt");

	ofstream monFlux(nomFichier.c_str());
	
	if(monFlux)
	{
		int age(0);
		string nom;
		cin >> age;
		cin.ignore();
		getline(cin, nom);
		monFlux <<" Je m'appel "<<nom<< " et j'ai " << age << " ans." << endl;
	}
	else
	{
		cout << "ERREUR: Impossible d'ouvrir le fichier." << endl;
	}

	return 0;



}

