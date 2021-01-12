package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Arbitri {

	private IntegerProperty id;
	private StringProperty nume;
	private IntegerProperty nr_teren;
	
	public Arbitri(){
		this.id = new SimpleIntegerProperty();
		this.nume = new SimpleStringProperty();
		this.nr_teren = new SimpleIntegerProperty();
	}
	
	//ID
	public int getID() {
		return id.get();
	}

	public void setID(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty(){
		return id;
	}

	//name
	public String getName() {
		return nume.get();
	}

	public void setName(String nume) {
		this.nume.set(nume);
	}

	public StringProperty nameProperty(){
		return nume;
	}
	
	//court_no
	public int getCourtNo() {
		return nr_teren.get();
	}

	public void setCourtNo(int nr_teren) {
		this.nr_teren.set(nr_teren);
	}

	public IntegerProperty courtNoProperty(){
		return nr_teren;
	}

	@Override
	public String toString() {
		return "Arbitri [nume=" + nume + ", nr_teren=" + nr_teren + "]";
	}
}
