package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Meciuri {

	private IntegerProperty nr_meci;
	private StringProperty nume_jucator1;
	private StringProperty nume_jucator2;
	private StringProperty faza;
	private StringProperty ziua;
	private IntegerProperty numar_teren;
	private StringProperty arbitru;
	private StringProperty scor;
	
		public Meciuri(){
			this.nr_meci = new SimpleIntegerProperty();
			this.nume_jucator1 = new SimpleStringProperty();
			this.nume_jucator2 = new SimpleStringProperty();
			this.faza = new SimpleStringProperty();
			this.ziua = new SimpleStringProperty();
			this.numar_teren = new SimpleIntegerProperty();
			this.arbitru = new SimpleStringProperty();
			this.scor = new SimpleStringProperty();
		}
	
		//match_no
		public int getMatchNo() {
			return nr_meci.get();
		}

		public void setMatchNo(int nr_meci) {
			this.nr_meci.set(nr_meci);
		}

		public IntegerProperty matchNoProperty(){
			return nr_meci;
		}
		
		//player1_name
		public String getP1Name() {
			return nume_jucator1.get();
		}

		public void setP1Name(String nume_jucator1) {
			this.nume_jucator1.set(nume_jucator1);
		}

		public StringProperty p1NameProperty(){
			return nume_jucator1;
		}
		
		//player2_name
		public String getP2Name() {
			return nume_jucator2.get();
		}

		public void setP2Name(String nume_jucator2) {
			this.nume_jucator2.set(nume_jucator2);
		}

		public StringProperty p2NameProperty(){
			return nume_jucator2;
		}
		
		//phase
		public String getPhase() {
			return faza.get();
		}

		public void setPhase(String faza) {
			this.faza.set(faza);
		}

		public StringProperty phaseProperty(){
			return faza;
		}
		
		//day
		public String getDay() {
			return ziua.get();
		}

		public void setDay(String ziua) {
			this.ziua.set(ziua);
		}

		public StringProperty dayProperty(){
			return ziua;
		}
		
		//court_no
		public int getCourtNo() {
			return numar_teren.get();
		}

		public void setCourtNo(int numar_teren) {
			this.numar_teren.set(numar_teren);
		}

		public IntegerProperty courtNoProperty(){
			return numar_teren;
		}
		
		//referee
		public String getReferee() {
			return arbitru.get();
		}

		public void setReferee(String arbitru) {
			this.arbitru.set(arbitru);
		}

		public StringProperty refereeProperty(){
			return arbitru;
		}
		
		//score
		public String getScore() {
			return scor.get();
		}

		public void setScore(String scor) {
			this.scor.set(scor);
		}

		public StringProperty scoreProperty(){
			return scor;
		}

		@Override
		public String toString() {
			return "Meciuri [nr_meci=" + nr_meci + ", nume_jucator1=" + nume_jucator1 + ", nume_jucator2="
					+ nume_jucator2 + ", faza=" + faza + ", ziua=" + ziua + ", numar_teren=" + numar_teren
					+ ", arbitru=" + arbitru + ", scor=" + scor + "]";
		}
}
