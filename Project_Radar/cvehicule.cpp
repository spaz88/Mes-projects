#include "cvehicule.h"

cvehicule::cvehicule() {
	this->immatriculation = "xxx-xx-xxx";
	this->vitesse = 0;
}

cvehicule::cvehicule(string immatriculation) {
	this->immatriculation = immatriculation;
	this->vitesse = 0;
}

void cvehicule::setVitesse(int vitesse) {
	this->vitesse = vitesse;
}

void cvehicule::afficher() {
	cout << "La voiture immatriculee \"" << immatriculation << "\" roule a " << vitesse << "Km/h." << endl; 
}
