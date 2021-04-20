#pragma once
#include <iostream>
#include <string>
#include "cvoie.h"
#include "cvehicule.h"
#include "personne.h"

using namespace std;

class cinfraction
{
private:
	string dateHeure;
	cvoie* voie;
	cvehicule* vehicule;
public:
	cinfraction();
	cinfraction(string, cvoie*, cvehicule*);
	void afficher();
};

