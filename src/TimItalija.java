import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimItalija extends KeteringTim {
Forma3 f3;//deklarisao sam ovu promenljivu da bi mogao da pristupam mapama koje se nalaze u klasi Forma3
double p,d;
	@Override
	public void postaviKomponente() {
		// TODO Auto-generated method stub
		//instanciranje komponenata koje su deklarisane u abstractclasi KeteringTim
		meni=new JPanel();
		predCombo=new JComboBox();
		dezCombo=new JComboBox();
		f3=new Forma3();
		l1=new JLabel("Predjela: ");
		l2=new JLabel("Dezerti: ");
		meni.setLayout(new GridBagLayout());
		//moj omiljeni layout!!!!!
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(15,15,15,15);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.EAST;
		//prva kolona
		gbc.gridx=0;
		gbc.gridy=0;
		meni.add(l1, gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		meni.add(l2, gbc);
		//DRUGA kOLONA
		gbc.gridx=1;
		gbc.gridy=0;
		meni.add(predCombo, gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		meni.add(dezCombo, gbc);
		
		//POSTAVLJANJE VREDNOSTI U COMBU ZA ITALIJU IZ HASHMAPA
		//pozivom f3.getItalijanskaPredjela pozivamo mapu, a sa .keySet prolazimo Kroz kljuceve koji
		//su String , da bi ih stavili u kombove
		for(String x:f3.getItalijanskaPredjela().keySet()){
			predCombo.addItem(x);
		}
		//ista prica vazi za dezerte
		for(String y:f3.getItalijanskiDezerti().keySet()){
			dezCombo.addItem(y);
		}
}
	@Override
	public String prikaziNaArea() {
		// TODO Auto-generated method stub
		//konkretne nazive izabranih jela uzimamo sa combova
		String predjelo1=(String) predCombo.getSelectedItem();
		String dezert1=(String) dezCombo.getSelectedItem();
		//ali cene...
		//moraju se prvo deklarisati
		//ako mapa saddrzi izabranno jelo kao kljuc, u promenjivu d ili p smesti vrednost koja odgovara datom kljucu
		if(f3.italijanskiDezerti.containsKey(dezert1))  {d=f3.italijanskiDezerti.get(dezert1);}
		if(f3.italijanskaPredjela.containsKey(predjelo1)){p=f3.italijanskaPredjela.get(predjelo1);}
		//ovo je zbir 2 cene
		double total=p+d;
		//da bi moglo da se prikaze na textArea mora biti tipa String
	    //zato sve 3 vrednosti pretvaramo u String
		String cenaPredjela=String.valueOf(p);
		String cenaDezerta=String.valueOf(d);
		String ukupnaCena=String.valueOf(total);
		
		//KONACAN ISPIS  NA TEXT AREA IZGLEDA OVAKO
				return "Italijanski meni se sastoji od:\nPredjelo: "+predjelo1+"\tCena: "+cenaPredjela+"din"+"\nDezert:"+dezert1+"\tCena: "+cenaDezerta+"din"
						+"\n*************************************"+"\nUKUPAN IZNOS ZA PLACANJE: "+ukupnaCena;
	}
	}


