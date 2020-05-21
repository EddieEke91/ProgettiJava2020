/** TASK
Creare interfaccia grafica che permetta di gestre una postazione
bancomat
-Il cliente deve poter inserire un pin da 4 cifre
-il sistema deve permettere max 3 errori
-deve essere possibile cancellare il pin inserito
-deve essere possibile chiudere l'applicazione
-se il pin è valido, si passa alla finestra di gestione
bancomat:
	-prelievo
	-deposito
	-visualiza saldo attuale
	
	-cancellare le cifre inserite
	-possibilità di chiudere l'applicazione

Tutti i messaggi (errori, saldo, avvenuta operazione)devono 
essere visualizzati sulle finestre, tramite oggetti label.
Non sono ammesse finestre pop-up.
l'applicazione deve usare la classe Conto_Corrente
già implementata precedentemente.
Classi da usare:
Frame
Textfield
Button
Lable
*/

import java.awt.Frame;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label; //etichette

public class Bancomat extends Frame implements ActionListener
{
	Button confirmpin=null;
	Button exit=null;
	Button cancellapin=null;
	TextField tf=null;
	Label nome_banca=null;
	Label messaggio=null; //messaggi di avviso durante inserimento pin
	int tentativi;
	int pin=5555;
	
	

	public Bancomat (String t){
		super(t);
		

		//******************
		//creazione finestra per inserimento pin
		setLayout(null);
		this.setVisible(true);
		setSize(500,500);
		setLocation(200,250);
		setBackground(Color.white);
		// fine sezione costruzione della finestra
		//***************************************
	


		//LABEL
		//label nome banca
		nome_banca=new Label(t);
		nome_banca.setSize(500,30);
		nome_banca.setLocation(200,50);

		//label messaggi inserimento pin
		messaggio = new Label("");
		messaggio.setSize(200,30);
		messaggio.setLocation(150,450);
		add(messaggio);


		//BUTTONS
		//costruisco il pulsante per confermare
		confirmpin=new Button("OK");
		tentativi=0;

		confirmpin.setSize(80,30);
		confirmpin.setLocation(250,200);
		confirmpin.addActionListener(this);//permette al pulsante di ascoltare
										//l'evento che avviene su di se


		//pulsante per cancellarepin
		cancellapin=new Button("Cancella");
		cancellapin.setSize(80,30);
		cancellapin.setLocation(150,200);
		cancellapin.addActionListener(this);
		
		//pulsante uscita app
		exit=new Button("Chiudi");

		exit.setSize(80,30);
		exit.setLocation(200,100);
		exit.addActionListener(this);//permette al pulsante di ascoltare
										//l'evento che avviene su di se


		//TEXTFIELD
		//creazione della text di immissione pin
		tf=new TextField();

		tf.setSize(150,30);
		tf.setLocation(200,250);

		//aggiungo i componenti al frame
		add(nome_banca);
		add(confirmpin);
		add(cancellapin);
		add(exit);
		add(tf);
	}//fine costruttore Bancomat (frame)

	//gestione pressione pulsanti
	public void actionPerformed(ActionEvent e){		
			
		//se exit -> chiudi app
		if(  e.getSource()==exit  ){
			System.exit(0);				
		}

		//se cancellapin-> pulisci il textfield
		if(e.getSource()==cancellapin){
			tf.setText("");
		}

		//CONFERMA PIN		
		if(e.getSource()==confirmpin){
			int x= Integer.parseInt(tf.getText());
			//Pin corretto
			if (x==pin)
			{	
				this.dispose(); //chiude l'oggetto corrente -> frame di accesso con pin
				SchermoConto menu=new SchermoConto(nome_banca.getText());				
			}

			//Pin errato
			if (x!=pin)
			{	
				//tentativi massimi raggiunti
				if (tentativi==3){					
					System.exit(0);			
				}else 
					tentativi++;
					messaggio.setText("Pin errato: tentativo numero " + tentativi + " su 3");										
			} 


		}

	} //Fine gestione pulsanti

}//end class
