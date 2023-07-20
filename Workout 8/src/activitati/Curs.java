package activitati;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import basic.Persoana;
import basic.Trainer;

public class Curs implements Activitate{

	private String nume;
	private String dificultate;
	private String trainer;
	private ArrayList<Persoana> exploreri = new ArrayList<Persoana>();
	private int cost;
	private LinkedHashMap<String, Activitate> materialActivitate = new LinkedHashMap<>();
	
	
	

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getDificultate() {
		return dificultate;
	}

	public void setDificultate(String dificultate) {
		this.dificultate = dificultate;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public ArrayList<Persoana> getExploreri() {
		return exploreri;
	}

	public void setExploreri(ArrayList<Persoana> exploreri) {
		this.exploreri = exploreri;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	public LinkedHashMap<String, Activitate> getMaterialActivitate() {
		return materialActivitate;
	}

	public void setMaterialActivitate(LinkedHashMap<String, Activitate> materialActivitate) {
		this.materialActivitate = materialActivitate;
	}
	
	

	public Curs(String nume, String dificultate, String trainer, ArrayList<Persoana> exploreri, int cost) {
		super();
		this.nume = nume;
		this.dificultate = dificultate;
		this.trainer = trainer;
		this.exploreri = exploreri;
		this.cost = cost;
	}
	
	public int getCost(Persoana p) {
		if(p instanceof Trainer )
		       this.cost = 0;
		return this.cost;
	}

	@Override
	public String getDescriere() {
		// TODO Auto-generated method stub
		return this.nume+" "+ this.dificultate;
	}

	@Override
	public String getDurata() {
		// TODO Auto-generated method stub
		if(dificultate.equals("usor")) 
			return "1 luna";
		else if(dificultate.equals("mediu"))
				return "3 luni";
		else if(dificultate.equals("dificil"))
				return "5 luni";
		else
			return "necunoscut";	
	}
	//TODO 17: Modificati metoda suprascrisa din clasa Curs astfel incat sa returneze o durata in functie de dificultate
	//"usor"->"1 luna"; "mediu"->"3 luni"; "dificil"->"5 luni"; altfel -> "necunoscut"; 
}
