import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Forma extends JFrame {

	JPanel p1;
	JButton b1,b2;
	
	
	public Forma(){
		p1=new JPanel();
		b1=new JButton("upisi podatke");
		b2=new JButton("prikazi izbor");
		
		this.setTitle("UVODNA FORMA");
		this.setLayout(new FlowLayout(FlowLayout.CENTER,250,100));
		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		
		Dimension d=new Dimension(150,80);//koje ce biti dimenzije dugmica
		b1.setPreferredSize(d);
		b1.setMaximumSize(d);b1.setMinimumSize(d);b1.setAlignmentX(CENTER_ALIGNMENT);
		b2.setPreferredSize(d);
		b2.setMaximumSize(d);b2.setMinimumSize(d);b2.setAlignmentX(CENTER_ALIGNMENT);
		p1.add(b1);p1.add(Box.createHorizontalStrut(20));
		p1.add(b2);
		this.add(p1);
		
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Forma2 f2=new Forma2();
				f2.setVisible(true);
				f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f2.setLocationRelativeTo(null);
				f2.setSize(700, 700);
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Forma3 f3=new Forma3();
				f3.setVisible(true);
				f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f3.setLocationRelativeTo(null);
				f3.setSize(700, 700);
			}
		});
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
