import java.util.ArrayList;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.WindowEvent;  
import java.awt.event.WindowListener; 
import java.awt.event.WindowAdapter;


class Interfaccia extends Frame implements ActionListener
{
	
	private Superenalotto s1 = new Superenalotto();
	private String numeriEstratti = "";
	private String iTuoiNumeri = "";
	private int numeriVincenti;
	private ArrayList<TextField> textList = new ArrayList<TextField>();
	private ArrayList<Label> labelList = new ArrayList<Label>();
	private ArrayList<Label> msgList = new ArrayList<Label>();
	private TextField campoPuntata;
	private Label labelPuntata;
	private Button pulsanteGioca = null;
	private Label title;
	private Label subtitle1;
	private Label subtitle2;
	private Label avviso1;
	private Label avviso2;
	private Label vittoria;

	public Interfaccia(){

		super("Superenalotto");

		setLayout(null);
		this.setVisible(true);
		setSize(600,700);
		setLocation(300,20);
		setBackground(new Color(109,155,156));

		campoPuntata = new TextField();
		campoPuntata.setSize(100,30);
		campoPuntata.setLocation(310, 340);
		this.add(campoPuntata);

		labelPuntata = new Label("€");
		labelPuntata.setSize(30, 30);
		labelPuntata.setLocation(420, 340);
		labelPuntata.setFont(new Font("Verdana", Font.BOLD, 18));
		labelPuntata.setForeground(Color.WHITE);
		labelPuntata.setVisible(true);
		this.add(labelPuntata);

		pulsanteGioca = new Button("GIOCA");
		pulsanteGioca.setSize(100,30);
		pulsanteGioca.setLocation(310, 380);
		pulsanteGioca.setVisible(true);
		pulsanteGioca.addActionListener(this);
		this.add(pulsanteGioca);

		for(int i = 0; i < 6; i++){
			textList.add(new TextField());
			textList.get(i).setSize(100,30);
		    textList.get(i).setLocation(135, 180+40*i);
			this.add(textList.get(i));
		}

		for(int i = 0; i < 6; i++){
			labelList.add(new Label("" + (i+1)));
			labelList.get(i).setSize(30, 30);
			labelList.get(i).setLocation(105, 180+40*i);
			labelList.get(i).setFont(new Font("Verdana", Font.BOLD, 14));
			labelList.get(i).setForeground(Color.WHITE);
			labelList.get(i).setVisible(true);
			this.add(labelList.get(i));
		}

		for(int i = 0; i < 3; i++){
			msgList.add(new Label("Lorem Ipsum"));
			msgList.get(i).setSize(400, 20);
			msgList.get(i).setLocation(105, 550+20*i);
			msgList.get(i).setFont(new Font("Verdana", Font.BOLD, 14));
			msgList.get(i).setForeground(Color.WHITE);
			msgList.get(i).setVisible(false);
			this.add(msgList.get(i));
		}

		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }
		});					  

		title = new Label("Superenalotto");
		title.setSize(400, 60);
		title.setLocation(100, 40);
		title.setFont(new Font("Verdana", Font.BOLD, 50));
		title.setForeground(Color.WHITE);
		title.setVisible(true);
		this.add(title);

		subtitle1 = new Label("Inserire i numeri da giocare nei campi a sinistra");
		subtitle1.setSize(400, 20);
		subtitle1.setLocation(105,100);
		subtitle1.setFont(new Font("Verdana", Font.BOLD, 14));
		subtitle1.setForeground(Color.WHITE);
		subtitle1.setVisible(true);
		this.add(subtitle1);

		subtitle2 = new Label("Inserire la puntata nel campo a destra");
		subtitle2.setSize(400, 20);
		subtitle2.setLocation(105,120);
		subtitle2.setFont(new Font("Verdana", Font.BOLD, 14));
		subtitle2.setForeground(Color.WHITE);
		subtitle2.setVisible(true);
		this.add(subtitle2);

		avviso1 = new Label("ATTENZIONE!!!");
		avviso1.setSize(400,20);
		avviso1.setLocation(105,430);
		avviso1.setFont(new Font("Verdana", Font.BOLD, 14));
		avviso1.setForeground(Color.RED);
		avviso1.setVisible(false);
		this.add(avviso1);

		avviso2 = new Label();
		avviso2.setSize(400,20);
		avviso2.setLocation(105,450);
		avviso2.setFont(new Font("Verdana", Font.BOLD, 14));
		avviso2.setForeground(Color.RED);
		avviso2.setVisible(false);
		this.add(avviso2);

		vittoria = new Label();
		vittoria.setSize(400,60);
		vittoria.setLocation(100,480);
		vittoria.setFont(new Font("Verdana", Font.BOLD, 20));
		vittoria.setForeground(Color.WHITE);
		vittoria.setVisible(false);
		this.add(vittoria);
	}

	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==pulsanteGioca){
			
			s1.estrai();
			numeriEstratti = s1.getUltimaEstrazione();
			iTuoiNumeri = "";
			avviso1.setVisible(false);
			avviso2.setVisible(false);
			vittoria.setVisible(false);
			for(int i = 0; i < msgList.size(); i++){
				msgList.get(i).setVisible(false);
			}
			
			try{
				ArrayList<Integer> giocata = new ArrayList<Integer>();
				for(int i = 0; i < textList.size(); i++){
					giocata.add(Integer.parseInt(textList.get(i).getText()));
					iTuoiNumeri += textList.get(i).getText() + " ";
				}
				
				int puntata = Integer.parseInt(campoPuntata.getText());
				s1.isValid(giocata);

				numeriVincenti = s1.verifica(giocata);
				if(numeriVincenti > 1){
					double vincita = s1.calcolaVincita(puntata, numeriVincenti);
					vittoria.setText("Complimenti! Hai vinto " + vincita + " Euro!");
					vittoria.setVisible(true);
				}
				else{
					vittoria.setText("Che peccato! Hai perso.");
					vittoria.setVisible(true);
				}

				msgList.get(0).setText("I TUOI NUMERI: " + iTuoiNumeri);
				msgList.get(0).setVisible(true);

				msgList.get(1).setText("NUMERI ESTRATTI: " + numeriEstratti);
				msgList.get(1).setVisible(true);

				if(numeriVincenti != 1){
					msgList.get(2).setText("HAI AZZECCATO " + numeriVincenti + " NUMERI");
					msgList.get(2).setVisible(true);
				}
				else{
					msgList.get(2).setText("HAI AZZECCATO " + numeriVincenti + " NUMERO");
					msgList.get(2).setVisible(true);
				}

				msgList.get(1).setText("NUMERI ESTRATTI: " + numeriEstratti);
				msgList.get(1).setVisible(true);
			}
			catch(NumberFormatException exc){
				String excString = exc.toString();
				char control = excString.charAt(excString.length()-2);
				if(control != '"') avviso2.setText("Sono ammessi solo valori numerici di tipo intero");
				else avviso2.setText("Alcuni campi potrebbero essere vuoti");
				avviso2.setVisible(true);
				avviso1.setVisible(true);
			}
			catch(DuplicatiException exc){
				avviso2.setText("Non si può inserire due volte lo stesso numero!");
				avviso2.setVisible(true);
				avviso1.setVisible(true);
			}
			catch(OutOfRangeException exc){
				avviso2.setText("I numeri devono essere compresi tra 1 e 90");
				avviso2.setVisible(true);
				avviso1.setVisible(true);
			}
		}	
	}
}