#include<iostream>
#include<string>
#include"cvoie.h"
#include"cradar.h"
#include"cvehicule.h"

using namespace std;

int main(){
	cradar Mesta;
	cvoie RouteDeNantes("routedeNantes",80);
	RouteDeNantes.afficher();
	Mesta.setVoie(&RouteDeNantes);// On définit la voie RouteDeNantes pour le radar Mesta
	personne p5;
	
	personne P1("Dupon", "Jean","Permis B", 12, 24);
	cvehicule V1("FG-598-AS");
	V1.setVitesse(78);

	personne P2("Bodin", "Doryan", "Permis B", 12, 19);
	cvehicule * V2= new cvehicule("AA-432-FD");// Allocation de mémoire pour V2
	V2->setVitesse(72);

	personne P3("Hourdin", "Thomas", "Permis B", 12, 30);
	cvehicule V3("DE-012-BV");
	V3.setVitesse(96);

	Mesta.controler(&V1);// Contrôle du véhicule 
	Mesta.controler(V2);// Contrôle du véhicule 
	Mesta.controler(&V3);// Contrôle du véhicule V3
}
