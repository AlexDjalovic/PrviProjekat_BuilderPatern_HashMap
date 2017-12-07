
public class Klijent {
KeteringTim ktim;

public Klijent(KeteringTim ktim) {
	super();
	this.ktim = ktim;
}

public void Konstruisi(){
	ktim.postaviKomponente();
	ktim.prikaziNaArea();
}

}
