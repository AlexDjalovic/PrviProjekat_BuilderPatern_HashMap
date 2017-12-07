import java.awt.EventQueue;

import javax.swing.JFrame;

public class Glavna {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				gui();
			}
			
		});
	}
	static void gui(){
		Forma f=new Forma();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);f.setSize(500, 500);
	}
}
