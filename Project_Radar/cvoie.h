#pragma once
#include <iostream>
#include <string>

using namespace std;

class cvoie
{
private :
	string nom;
	int limitationVitesse;
public:
	cvoie(string, int);
	string getNom() { return nom; }
	int getLimitationVitesse() { return limitationVitesse; }
	void afficher();

};

