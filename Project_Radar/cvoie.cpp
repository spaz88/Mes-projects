#include "cvoie.h"

cvoie::cvoie(string nom, int limitationVitesse) {
	this->nom = nom;
	this->limitationVitesse = limitationVitesse;
}

void cvoie::afficher() {
	cout << "La voie \"" << nom << "\" est limitee a " << limitationVitesse << "Km/h." << endl;
}