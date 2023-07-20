package main;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import activitati.Activitate;
import activitati.Curs;
import activitati.Material;
import activitati.Rush;
import activitati.Tema;
import basic.Explorer;
import basic.Persoana;
import basic.Trainer;

public class Main {
	
	public static void main(String[] args) {
		
		Persoana e1 = new Explorer("Ionescu","Elena","Arad",32,true);
		Persoana t1 = new Trainer("Iliescu","Mihai","Timisoara",37,true);
		
	System.out.println(e1.getResponsabilitati());	
	System.out.println(t1.getResponsabilitati());
	
	System.out.println(e1.obtineIdentificator());	
	System.out.println(t1.obtineIdentificator());
	
	Explorer e2 = new Explorer("Popescu","Ion","Bucuresti",37,false);
	Explorer e3 = new Explorer("Florescu","Sorin","Bucuresti",27,false);
	Trainer t2 = new Trainer("Enescu","Mihai","Iasi",30,true);
	ArrayList<Persoana> listEx = new ArrayList<>(List.of(e1,e2,e3,t2));
	
	Curs curs = new Curs("JAVA","mediu",t1.getNume(),listEx,1000);
			//TODO 20: In metoda main din clasa Main vom realiza tot ce avem nevoie pentru a crea o instanta de curs:
			//Pentru trainer vom folosi instanta t1;
			//Pentru lista de exploreri vom crea 2 noi instante de exploreri e2, e3, dar si un nou trainer t2 si un nou ArrayList in care vom adauga aceste instante (e1, e2, e3 si t2)
			//Pentru nume vom folosi "JAVA"
			//Pentru dificultate vom folosi "mediu"
			//Pentru cost vom estima "1000"
			//Se va crea o instainta de Curs folosind variabilele de mai sus
	
	for(Persoana person : listEx) {
		System.out.println(person.obtineIdentificator() + " "+curs.getCost(person));
	}
	
	//TODO 22: In metoda main din clasa Main parcurgeti lista de exploreri ai cursului definit si afisati pentru fiecare costul
		//folositi obtineIdentificator() pentru a vedea mai clar tipul persoanei
		//ex: explorer_matei_SANDU pays 1000 vs:	trainer_sorina_ION pays 0
	
	
	
	Activitate rush1 = new Rush();
	Activitate rush2 = new Rush();
	Activitate material1 = new Material();
	Activitate material2 = new Material();
	Activitate tema1 = new Tema();
	Activitate tema2 = new Tema();
	
	LinkedHashMap<String, Activitate> activ = new LinkedHashMap<String, Activitate>();
	activ.put("rush1", rush1);
	activ.put("rush2", rush2);
	activ.put("material1", material1);
	activ.put("material2", material2);
	activ.put("tema1", tema1);
	activ.put("tema2", tema2);
	curs.setMaterialActivitate(activ);
	
	for(String key : curs.getMaterialActivitate().keySet()) {
		System.out.println("Activitatea " + key + " este de tip " + curs.getMaterialActivitate().get(key).getClass() + " cu descrierea \"" + 
					curs.getMaterialActivitate().get(key).getDescriere() + "\" si durata estimata de " + curs.getMaterialActivitate().get(key).getDurata() );
	}
	
	
	
	
	
	    String fileName = "fisier.txt"; // Numele fișierului cu informațiile despre persoane
	    List<Persoana> persoane = new ArrayList<>();
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            Persoana persoana = parseLine(line);
	            if (persoana != null) {
	                persoane.add(persoana);
	                System.out.println("aaa");
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    // Afișăm persoanele parsate
	    for (Persoana persoana : persoane) {
	        System.out.println(persoana);
	    }
	    
	    
	    
	    
	    
	}//se inchide main
	
	private static Persoana parseLine(String line) {
	    String[] tokens = line.split(", ");
	    if (tokens.length == 6) {
	        String tipPersoana = tokens[0].substring(10); // "Persoana: " are 10 caractere
	        String nume = tokens[1];
	        String prenume = tokens[2];
	        String locatie = tokens[3];
	        int varsta = Integer.parseInt(tokens[4]);
	        boolean esteTrainer = Boolean.parseBoolean(tokens[5]);
	        
	        if (tipPersoana.equalsIgnoreCase("Explorer")) {
	            return new Explorer(nume, prenume, locatie, varsta, esteTrainer);
	        } else if (tipPersoana.equalsIgnoreCase("Trainer")) {
	            return new Trainer(nume, prenume, locatie, varsta, esteTrainer);
	        }
	    }
	    return null; // Linie invalidă sau nerecunoscută
	}
	

}
	
	
	
	
	//TODO 1: Creati o noua clasa Explorer in pachetul basic
	
	//TODO 2: Creati o noua clasa Trainer in pachetul basic
	
	//TODO 3: Ambele clase trebuie sa extinda clasa Persoana
	
	//TODO 4: Rezolvati erorile din cele doua noi subclase generand constructorii ce apeleaza constructorul din Persoana si implementand metodele necesare
	//Pentru responsabilitatile Trainerului se va returna un mesaj de tipul: "Pregatirea materialelor, evaluarea temelor, crearea contextului de lucru, raspunderea la intrebari"
	//Pentru responsabilitatile Explorerului se va returna un mesaj de tipul: "Parcurgerea materialelor, rezolvarea temelor, participarea la activitati";
	
	//TODO 5: In metoda main din clasa Main, definiti si initializati doua variabile de tip Persoana - e1 folosind constructorul clasei Explorer si t1 folosind constructorul clasei Trainer. 
	//Afisati cele doua variabile si responsabilitatile fiecaruia
	
	//TODO 6: Suprascrieti in cele doua clase noi metoda obtineIdentificator astfel incat aceasta sa afiseze inainte de identificatorul utilizatorului calitatea acestuia:
	//ex: explorer_alexandru_ANDREI vs trainer_ana_POPESCU
		
	//TODO 7: Afisati cele rezultatul obtinut prin rularea metodei obtineIdentificator pe fiecare dintre variabile
	
	//TODO 8: Creati un pachet nou numit "activitati"
	
	//TODO 9: Creati o noua interfata numita "Activitate"
	
	//TODO 10: Pentru aceasta interfata definiti metodele publice:
	//getDescriere ce returneaza String
	//getDurata ce returneaza String
	
	//TODO 11: Creati in pachetul activitati clasele numite Rush, Tema, Material, Curs care implementeaza interfata Activitate

	//TODO 12: Implementati metodele necesare in fiecare clasa astfel incat sa returneze o descriere si un timp estimat de parcurgere (in afara de clasa Curs ce va fi tratata separat)
	//ex: pentru rush Rush se vor returna - descriere: "Activitate de lucru colaborativ & Q&A"; durata - "2h"
		
	//TODO 13: Pentru clasa Curs definiti proprietatile privat: "nume" (tip String), "dificultate" (tip String), "trainer" (tip Persoana), "exploreri" (tip ArrayList<Persoana>), int cost
		
	//TODO 14: Definiti getters/setters pentru proprietatile clasei Curs
	
	//TODO 15: Generati un constructor pentru clasa Curs cu toti parametrii clasei
	
	//TODO 16: Modificati metoda suprascrisa din clasa Curs astfel incat sa returneze o descriere ce contine numele si dificultatea cursului
	
	//TODO 17: Modificati metoda suprascrisa din clasa Curs astfel incat sa returneze o durata in functie de dificultate
	//"usor"->"1 luna"; "mediu"->"3 luni"; "dificil"->"5 luni"; altfel -> "necunoscut"; 
	
	//TODO 18: In clasa curs vom adauga o proprietate privata de tip LinkedHashMap<String, Activitate> ce reprezinta materialele acelui curs (numele si o Activitate)
	//Folosim LinkedHashMap pentru capacitatea acestuia de a pastra ordinea elementelor adaugate
	
	//TODO 19: Instantiati HashMap-ul atunci cand este definit si creati getter/setter pentru acesta
	
	//TODO 20: In metoda main din clasa Main vom realiza tot ce avem nevoie pentru a crea o instanta de curs:
	//Pentru trainer vom folosi instanta t1;
	//Pentru lista de exploreri vom crea 2 noi instante de exploreri e2, e3, dar si un nou trainer t2 si un nou ArrayList in care vom adauga aceste instante (e1, e2, e3 si t2)
	//Pentru nume vom folosi "JAVA"
	//Pentru dificultate vom folosi "mediu"
	//Pentru cost vom estima "1000"
	//Se va crea o instainta de Curs folosind variabilele de mai sus
	
	//TODO 21: Consideram ca trainerii pot participa la alte cursuri gratuit si pentru aceasta definim metoda getCost(Persoana p) ce overload-uieste getterul getCost() fara niciun parametru
	//In metoda getCost cu parametru persoana se verifica daca persoana are instanta de trainer si atunci se returneaza 0, altfel se returneaza costul cursului
	
	//TODO 22: In metoda main din clasa Main parcurgeti lista de exploreri ai cursului definit si afisati pentru fiecare costul
	//folositi obtineIdentificator() pentru a vedea mai clar tipul persoanei
	//ex: explorer_matei_SANDU pays 1000 vs:	trainer_sorina_ION pays 0
	
	//TODO 23: Definiti cate doua activitati de fiecare tip Rush, Tema, Material si adaugati-le in linkedhashmap-ul cursului apoi afisati calendarul cursului
	//pentru afisare puteti folosi codul de mai jos:
	/*
	for(String key:c.getActivitati().keySet()) {
		System.out.println("Activitatea " + key + " este de tip " + c.getActivitati().get(key).getClass() + " cu descrierea \"" + 
					c.getActivitati().get(key).getDescriere() + "\" si durata estimata de " + c.getActivitati().get(key).getDurata() );
	}
	*/

		
	

