import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculatrise extends JFrame {
	private JPanel container = new JPanel();
	String[] TAB = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
	JButton[] tab = new JButton[TAB.length]; 
	private JLabel ecran = new JLabel();
	private Dimension dim = new Dimension(50, 40);
	private Dimension dim2 = new Dimension(50, 31);
	private double chiffre1 ;
	private Boolean clickOperateur = false , Update = false ;
	private String operateur = "";
	public Calculatrise() {
	this.setSize(240,260);
	this.setTitle(" Calculatrice ");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	initComposant();
	this.setContentPane(container);
	this.setVisible(true);
	}
	private void initComposant(){
		Font police = new Font("Arial", Font.BOLD, 20);
		ecran = new JLabel("0");
		ecran.setFont(police);
		ecran.setHorizontalAlignment(JLabel.RIGHT);
		ecran.setPreferredSize(new Dimension(220, 20));
		JPanel operateur = new JPanel();
		operateur.setPreferredSize(new Dimension(55, 250));
		JPanel chiffre = new JPanel();
		chiffre.setPreferredSize(new Dimension(165, 225));
		JPanel panEcran = new JPanel();
		panEcran.setPreferredSize(new Dimension(220, 30));
		for (int i = 0 ; i < TAB.length ; i++){
			tab[i] = new JButton(TAB[i]);
			tab[i].setPreferredSize(dim);
			switch (i) {
			case 11:
				tab[i].addActionListener(new EgalListener());
				chiffre.add(tab[i]);
				break;
			case 12:
				tab[i].setForeground(Color.red);
				tab[i].addActionListener(new ResetListener());
				operateur.add(tab[i]);
				break;
			case 13:
				tab[i].addActionListener(new PlusListener());
				tab[i].setPreferredSize(dim2);
				operateur.add(tab[i]);
				break;
			case 14:
				tab[i].addActionListener(new MoinsListener());
				tab[i].setPreferredSize(dim2);
				operateur.add(tab[i]);
				break;
			case 15:
				tab[i].addActionListener(new MultiListener());
				tab[i].setPreferredSize(dim2);
				operateur.add(tab[i]);
				break;
			case 16:
				tab[i].addActionListener(new DivListener());
				tab[i].setPreferredSize(dim2);
				operateur.add(tab[i]);
				break;
			default:
				chiffre.add(tab[i]);
				tab[i].addActionListener(new ChiffreListener());
				break;
			}
		}
		panEcran.add(ecran);
		panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
		container.add(panEcran, BorderLayout.NORTH);
		container.add(chiffre, BorderLayout.CENTER);
		container.add(operateur, BorderLayout.EAST);
	}
	private void calcul(){
		if (operateur.equals("+")){
			chiffre1 = chiffre1 + Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(chiffre1));
		}
		if (operateur.equals("-")){
			chiffre1 = chiffre1 - Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(chiffre1));
		}
		if (operateur.equals("*")){
			chiffre1 = chiffre1 * Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(chiffre1));
		}
		if (operateur.equals("/")){
			try{
			chiffre1 = chiffre1 / Double.valueOf(ecran.getText()).doubleValue();
			ecran.setText(String.valueOf(chiffre1));
		}catch (ArithmeticException e){
			ecran.setText("0");
		}
		}
	}
	class ChiffreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String str = ((JButton)arg0.getSource()).getText();
			if(Update){
				Update = false ;
			}
			else{
				if(!ecran.getText().equals(" 0 "))
					str = ecran.getText() + str;
			}
			ecran.setText(str);
		}
		
	}
	class EgalListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			calcul();
			Update = true ;
			clickOperateur = false ;
		}
	}
	class PlusListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(clickOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clickOperateur = true ;
			}
			operateur = "+";
			Update = true ;
		}
	}
	class MoinsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(clickOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clickOperateur = true ;
			}
			operateur = "-";
			Update = true ;
			
		}
		
	}
	class MultiListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(clickOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clickOperateur = true ;
			}
			operateur = "*";
			Update = true ;
			
		}
		
	}
	class DivListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(clickOperateur){
				calcul();
				ecran.setText(String.valueOf(chiffre1));
			}
			else{
				chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
				clickOperateur = true ;
			}
			operateur = "/";
			Update = true ;
			
		}
		
	}
	class ResetListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			clickOperateur = false ;
			Update = true ;
			chiffre1 = 0 ;
			operateur = "" ;
			ecran.setText("");
		}
	}

	public static void main(String[] args) {
		Calculatrise calcul = new Calculatrise();

	}

}

