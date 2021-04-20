#pragma once
#include <iostream>
#include <string>

using namespace std;

class cvehicule
{
private:
	string immatriculation;
	int vitesse;
public:
	cvehicule();
	cvehicule(string);
	void setVitesse(int);
	string getImmatriculation() { return immatriculation;  }
	int getVitesse() { return vitesse; }
	void afficher();
};

