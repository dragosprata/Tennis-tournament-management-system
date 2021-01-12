package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jucator {
	
	private IntegerProperty id;
	private StringProperty nume;
	private StringProperty prenume;
	private StringProperty domiciliu;
	private StringProperty echipament;
	private IntegerProperty clasament;
	private IntegerProperty meciuri;
	private IntegerProperty puncte;
	private StringProperty palmares;
	
	public Jucator(){
		this.id = new SimpleIntegerProperty();
		this.nume = new SimpleStringProperty();
		this.prenume = new SimpleStringProperty();
		this.domiciliu = new SimpleStringProperty();
		this.echipament = new SimpleStringProperty();
		this.clasament = new SimpleIntegerProperty();
		this.meciuri = new SimpleIntegerProperty();
		this.puncte = new SimpleIntegerProperty();
		this.palmares = new SimpleStringProperty();
	}

	//ID
	public int getPlayerID() {
		return id.get();
	}

	public void setPlayerID(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty(){
		return id;
	}
	
	//surname
	public String getName() {
		return nume.get();
	}

	public void setName(String nume) {
		this.nume.set(nume);
	}

	public StringProperty nameProperty(){
		return nume;
	}
	
	//first name
	public String getPrenume() {
		return prenume.get();
	}

	public void setPrenume(String prenume) {
		this.prenume.set(prenume);
	}

	public StringProperty prenumeProperty(){
		return prenume;
	}
	
	//residence
	public String getResidence() {
		return domiciliu.get();
	}

	public void setResidence(String domiciliu) {
		this.domiciliu.set(domiciliu);
	}

	public StringProperty residenceProperty(){
		return domiciliu;
	}
	
	//equipment
	public String getEquipment() {
		return echipament.get();
	}

	public void setEquipment(String echipament) {
		this.echipament.set(echipament);
	}

	public StringProperty equipmentProperty(){
		return echipament;
	}
	
	//ranking
	public int getRank() {
		return clasament.get();
	}

	public void setRank(int clasament) {
		this.clasament.set(clasament);
	}

	public IntegerProperty rankProperty(){
		return clasament;
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
	
	//points
	public int getPoints() {
		return puncte.get();
	}

	public void setPoints(int puncte) {
		this.puncte.set(puncte);
	}

	public IntegerProperty pointsProperty(){
		return puncte;
	}
	
	//record
	public String getRecord() {
		return palmares.get();
	}

	public void setRecord(String palmares) {
		this.palmares.set(palmares);
	}

	public StringProperty recordProperty(){
		return palmares;
	}

	@Override
	public String toString() {
		return "Jucator [id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", domiciliu=" + domiciliu
				+ ", echipament=" + echipament + ", clasament=" + clasament + ", meciuri=" + meciuri + ", puncte="
				+ puncte + ", palmares=" + palmares + "]";
	}
}
