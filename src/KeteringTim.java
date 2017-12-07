import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class KeteringTim {
 public JPanel meni;
 public JComboBox predCombo,dezCombo;
 public JLabel l1,l2;
 //abstract metode
 public abstract void postaviKomponente();
 public abstract String prikaziNaArea();
 
 
public JPanel getMeni() {
	return meni;
}
 
}
