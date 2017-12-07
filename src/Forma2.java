import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Forma2 extends JFrame {

	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5;
	JTextField tf1,tf2,tf3,tf4;
	JComboBox kuh;
	JButton b;
	ArrayList<Hrana>ukupna=new ArrayList<Hrana>();
	public File f;
	public static final String imeFajla="pokusaj.txt";
	
	public Forma2(){
		this.setTitle("Forma za unos podataka");
		//this.setLayout(new GridLayout(2,1));
		this.setLayout(new BorderLayout());//lepse izgleda ako je u borderu,komponente su nekako lepse pozicionirane!!!!!
		p1=new JPanel();
		p1.setBorder(BorderFactory.createTitledBorder("IZABERI"));
		p2=new JPanel();
		l1=new JLabel("izaberi kuhinju");
		l2=new JLabel("upisi predjelo");
		l3=new JLabel("cena predjela");
		l4=new JLabel("upisi dezert");
		l5=new JLabel("cena dezerta");
		tf1=new JTextField(10);
		tf2=new JTextField(10);
		tf3=new JTextField(10);
		tf4=new JTextField(10);
		String[]imena={"italijanska","srpska"};
		kuh=new JComboBox(imena);
		b=new JButton("UPISI U FAJL");
		//p1.setLayout(new GridBagLayout());
		p1.setLayout(new GridBagLayout());
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(5,5,5,5);
		gbc.fill=GridBagConstraints.NONE;
		
		
		//prva kolona
		gbc.anchor=GridBagConstraints.WEST;//FIRSTLINE START
		gbc.gridx=0;
		gbc.gridy=0;
		p1.add(l1, gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		p1.add(l2,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		p1.add(l4, gbc);
		
		//druga kolona
		gbc.anchor=GridBagConstraints.WEST;
		gbc.gridx=1;
		gbc.gridy=0;
		//gbc.gridwidth=3; OVO JE TREBALO DA ZNACI DA KOMBO SE PROSTIRE NA 3 POLJA
		p1.add(kuh,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		p1.add(tf1, gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		p1.add(tf2, gbc);
		
		//TrecaKOLONA
		gbc.anchor=GridBagConstraints.EAST;//firstlineend
		gbc.gridx=2;
		gbc.gridy=1;
		p1.add(l3, gbc);
		
		gbc.gridx=2;
		gbc.gridy=2;
		p1.add(l5, gbc);
		
		//CETVRTA KOLONA
		gbc.anchor=GridBagConstraints.EAST;
		gbc.gridx=3;
		gbc.gridy=1;
		p1.add(tf3, gbc);
		gbc.gridx=3;
		gbc.gridy=2;
		p1.add(tf4, gbc);
		
		
		
		p2.add(b);
		//this.add(p1);OVO JE AKO HOCU DA BUDE GridLayout
	    //this.add(p2);
		this.add(p1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.SOUTH);
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String tip=(String) kuh.getSelectedItem();
				String predjelo=tf1.getText();
				double cenaPred=Double.parseDouble(tf3.getText());
				String dezert=tf2.getText();
				double cenaDez=Double.parseDouble(tf4.getText());
				System.out.println(dezert);
				Hrana h=new Hrana(tip,predjelo,cenaPred,dezert,cenaDez);
				ukupna.add(h);
				f=new File(imeFajla);
				if(!f.exists())
					try {
						f.createNewFile();
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				PrintWriter pw;
				try {
					pw = new PrintWriter(new FileWriter(f));
					for(Hrana hw:ukupna){
						pw.println(hw.toString());
						System.out.println("upisano u fajl");
					}
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
			}
		});
		
		
		
		
		
		
		
		
	}
}
