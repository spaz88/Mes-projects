#include "cradar.h"

void cradar::setVoie(cvoie* voie){
	this->voie = voie;
}
void cradar::controler(cvehicule* vehicule) {
	int vitesseLimite = voie->getLimitationVitesse();
	int vitesseVehicule = vehicule->getVitesse();

	if (vitesseVehicule > vitesseLimite) {
		/*
		int depassementVitesse = vitesseVehicule - vitesseLimite;
		
		cout << "Le vehicule immatricule \"" << vehicule->getImmatriculation()
		<< "\" roule a " << depassementVitesse
		<< "Km/h au dessus de la limite autorisee." << endl;
		*/
		cinfraction infraction("le 1/2/1990 a 14:05",voie, vehicule);
		conducteur->afficher();
	}
	else
	{
		cout << "Aucune infraction constatee.." << endl;
	}
}