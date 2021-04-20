#include "cinfraction.h"

cinfraction::cinfraction() {
		dateHeure = "";
		voie = NULL;
		vehicule = NULL;;
}

cinfraction::cinfraction(string dateHeure, cvoie* voie, cvehicule* vehicule) {
	this->dateHeure = dateHeure;
	this->voie = voie;
	this->vehicule = vehicule;

	//dateHeure = "le 1/2/1990 a 14:05";

	this->afficher();
	
}


void cinfraction::afficher() {

	cout << "\n---------------------------------------" << endl;
	cout << "Le " << dateHeure << ", le vehicule immatricule \""
		<< vehicule->getImmatriculation()  << "\" a ete mesure a "
		<< vehicule->getVitesse() << "Km/h sur la voie \""
		<< voie->getNom() << "\" au lieu des "
		<< voie->getLimitationVitesse() << "Km/h autorises." << endl;
	cout << "\n---------------------------------------" << endl;


}


