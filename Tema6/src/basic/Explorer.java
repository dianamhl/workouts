package basic;

public class Explorer extends Persoana {

	public Explorer(String nume, String prenume, String oras, Integer varsta, boolean casatorita) {
		super(nume, prenume, oras, varsta, casatorita);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getResponsabilitati() {
		
		return "Parcurgerea materialelor, rezolvarea temelor, participarea la activitati";
	}
	
	@Override
	public String obtineIdentificator() {
		return "explorer_"+getPrenume().toLowerCase().replaceAll(" ", "").replaceAll("-", "") + "_" + getNume().toUpperCase().replaceAll(" ", "").replaceAll("-", "") ;
	}

}
