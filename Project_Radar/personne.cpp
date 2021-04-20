#include "personne.h"

personne::personne() {
	nom = "*-NonDefinie-*";
	prenom = "*-NonDefinie-*";
	permis = "*-NonDefinie-*";
	points = 0;
	age = 0;

	V1 = NULL;
	ferrari = NULL;
}

personne::personne(string nom, string prenom, string permis, int points, int age) {
	this->nom = nom;
	this->prenom = prenom;
	this->permis = permis;
	this->points = points;
	this->age = age;
}

void personne::afficher() {
	cout << "/*************************\"" <<endl;
	cout << "Information importantes" << endl;
	cout <<"Nom :"<< nom << endl;
	cout <<"Prenom :"<< prenom << endl;
	cout << permis << endl;
	cout << "Votre solde etais de " << points << " points" << endl;
	cout << "Votre nouveau solde est de " << setSoldesPoints(points) << points<< endl;
	cout << "***************************" << endl;
}

int personne::setSoldesPoints(int points) {

	int vitesseLimite = V1->getLimitationVitesse();
	int vitesseVehicule = ferrari->getVitesse();
	int depassementVitesse = vitesseVehicule - vitesseLimite;

	if (depassementVitesse <= 20) {
		points = points - 1;
		return points;
	}
	if (depassementVitesse <= 30 && depassementVitesse > 20) {
		points = points - 2;
		return points;
	}
	if (depassementVitesse <= 40 && depassementVitesse > 30) {
		points = points - 3;
		return points;
	}
	if (depassementVitesse <= 50 && depassementVitesse > 40) {
		points = points - 4;
		return points;
	}
	if (depassementVitesse > 50) {
		points = points - 6;
		return points;
	}
}

