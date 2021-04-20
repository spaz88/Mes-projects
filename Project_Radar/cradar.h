#pragma once
#include <iostream>
#include <string>
#include "cinfraction.h"
#include "cvoie.h"
#include "cvehicule.h"

using namespace std;

class cradar
{
private:
	cvoie* voie;
	cinfraction* infraction;
	personne* conducteur;
public:
	void setVoie(cvoie*);
	void controler(cvehicule*);
};



