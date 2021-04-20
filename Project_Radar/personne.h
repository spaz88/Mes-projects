#pragma once
#include <iostream>
#include <string>
#include "cinfraction.h"
#include "cvoie.h"
#include "cvehicule.h"

using namespace std;

class personne
{
private:

	string nom;
	string prenom;
	string permis;
	int points;
	int age;

	cvoie* V1;
	cvehicule* ferrari;
public:
	personne();
	personne(string, string, string, int, int);
	int setSoldesPoints(int);
	void afficher();

};

