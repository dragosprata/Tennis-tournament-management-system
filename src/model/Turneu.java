package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Turneu {

	private StringProperty nume;
	private StringProperty complex;
	private IntegerProperty puncte;
	private StringProperty perioada;
	private IntegerProperty nr_terenuri;
	private IntegerProperty meciuri;
	private IntegerProperty arbitri;
	private IntegerProperty jucatori;
	
	public Turneu(){
		this.nume = new SimpleStringProperty();
		this.complex = new SimpleStringProperty();
		this.puncte = new SimpleIntegerProperty();
		this.perioada = new SimpleStringProperty();
		this.nr_terenuri = new SimpleIntegerProperty();
		this.meciuri = new SimpleIntegerProperty();
		this.arbitri = new SimpleIntegerProperty();
		this.jucatori = new SimpleIntegerProperty();
	}
	
	//name
	public String getName(){
		return nume.get();
	}

	public void setName(String nume) {
		this.nume.set(nume);
	}

	public StringProperty nameProperty(){
		return nume;
	}
				
	//complex
	public String getComplex() {
		return complex.get();
	}

	public void setComplex(String complex) {
		this.complex.set(complex);
	}

	public StringProperty complexProperty(){
		return complex;
	}
				
	//points
	public int getPoints(){
		return puncte.get();
	}

	public void setPoints(int puncte){
		this.puncte.set(puncte);
	}

	public IntegerProperty pointsProperty(){
		return puncte;
	}
		
	//period
	public String getPeriod(){
		return perioada.get();
	}

	public void setPeriod(String perioada) {
		this.perioada.set(perioada);
	}

	public StringProperty periodProperty(){
		return perioada;
	}
	
	//courts
	public int getCourts() {
		return nr_terenuri.get();
	}

	public void setCourts(int terenuri) {
		this.nr_terenuri.set(terenuri);
	}

	public IntegerProperty courtsProperty(){
		return nr_terenuri;
	}
	
	//matches
	public int getMatches() {
		return meciuri.get();
	}

	public void setMatches(int meciuri) {
		this.meciuri.set(meciuri);
	}

	public IntegerProperty matchesProperty(){
		return meciuri;
	}
	
	//referees
	public int getReferees() {
		return arbitri.get();
	}

	public void setReferees(int arbitri) {
		this.arbitri.set(arbitri);
	}

	public IntegerProperty refereesProperty(){
		return arbitri;
	}
	
	//players
	public int getPlayers() {
		return jucatori.get();
	}

	public void setPlayers(int jucatori) {
		this.jucatori.set(jucatori);
	}

	public IntegerProperty playersProperty(){
		return jucatori;
	}

	@Override
	public String toString() {
		return "Turneu [nume=" + nume + ", complex=" + complex + ", puncte=" + puncte + ", perioada=" + perioada
				+ ", nr_terenuri=" + nr_terenuri + ", meciuri=" + meciuri + ", arbitri=" + arbitri + ", jucatori="
				+ jucatori + "]";
	}
}
