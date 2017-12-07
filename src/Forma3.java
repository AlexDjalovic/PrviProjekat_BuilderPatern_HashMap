import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Forma3 extends JFrame {
File f;
public static final String imeFajla="pokusaj.txt";
JPanel a,b;
JTextArea ta;
JScrollPane scroll;
JComboBox combo;
JButton ispisi;

public static final String IT="italijanska kuhinja";
public static final String SRB="srpska kuhinja";

Map<String,Double>italijanskaPredjela=new HashMap<String,Double>();
Map<String,Double>italijanskiDezerti=new HashMap<String,Double>();
Map<String,Double>srpskaPredjela=new HashMap<String,Double>();
Map<String,Double>srpskiDezerti=new HashMap<String,Double>();
KeteringTim ktim;



public Forma3(){
	this.setTitle("PRIKAZ ZA KLIJENTE");
	this.setLayout(new GridLayout(3,1));
	
	//CITANJE FAJLA
	f=new File(imeFajla);
	
	try {
		Scanner sc=new Scanner(f);
		while(sc.hasNextLine()){
			String red=sc.nextLine();
			Scanner sd=new Scanner(red);
			sd.useDelimiter(";");
			String tipKuh=sd.next();
			String predjelo=sd.next();
			double cenaPred=sd.nextDouble();
			String dezet=sd.next();
			double cenaDez=sd.nextDouble();
		//	System.out.println(dezet+" "+cenaDez);
		//	System.out.println(tipKuh);
			System.out.println("***");
			Hrana hrana=new Hrana(tipKuh,predjelo,cenaPred,dezet,cenaDez);
			if(tipKuh.equalsIgnoreCase("italijanska")) {
				italijanskaPredjela.put(predjelo, cenaPred);
			     italijanskiDezerti.put(dezet, cenaDez);}
			else if(tipKuh.equalsIgnoreCase("srpska")){
				srpskaPredjela.put(predjelo, cenaPred);
				srpskiDezerti.put(dezet, cenaDez);
			}
			System.out.println(italijanskaPredjela);
			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//inicijalizacija komponenti i postavljanje na formu
	
	a=new JPanel();b=new JPanel();
	a.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	ta=new JTextArea(); scroll=new JScrollPane(ta);
	combo=new JComboBox();
	ispisi=new JButton("ISPISI NA AREA");
	combo.addItem(IT);combo.addItem(SRB);
	a.add(combo);a.add(ispisi);
	this.add(a);
	this.add(b);this.add(scroll);
//STAVLJANJE OSLUSKIVACA NA DUGMICE
	combo.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String izbor=(String) combo.getSelectedItem();//u promenljivu izbor stavi ono sto si izabrao iz comba
			IzborKlasa ik=new IzborKlasa();//instanciraj klasu za izbor koja podklasa ce biti instancirana
			ktim=ik.izaberi(izbor);//u promenljivu interfejsnog(tipa apstraktne klase) tipa smesti ono sto si instancirao
			Klijent k=new Klijent(ktim);//klijentu prosledi
			k.Konstruisi();
			JPanel noviPanel=ktim.getMeni();
			PrikaziNaFormi(noviPanel);
		}
	});
	ispisi.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ta.setText(ktim.prikaziNaArea());//metoda prikaziNaArea mora biti tipa String jer SetText zahteva 
		}
	});
		
}//KRAJ KONSTRUKTORA



public void PrikaziNaFormi(JPanel p){
	b.removeAll();
	b.add(p);
	b.validate();
}
//GET METODE ZA HASHMAPE 
public Map<String, Double> getItalijanskaPredjela() {
	return italijanskaPredjela;
}
public Map<String, Double> getItalijanskiDezerti() {
	return italijanskiDezerti;
}
public Map<String, Double> getSrpskaPredjela() {
	return srpskaPredjela;
}
public Map<String, Double> getSrpskiDezerti() {
	return srpskiDezerti;
}


}
