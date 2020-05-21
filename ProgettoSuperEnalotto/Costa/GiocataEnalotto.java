/* TASK
REALIZZARE INTERFACCIA GRAFICA CHE PERMETTA DI FARE
UNA GIOCATA AL SUPERENALOTTO

IL PROGRAMMA DEVE VERIFICARE CHE:
-LA GIOCATA NON CONTENGA NUMERI DUPLICATI
-I NUMERI SIANO COMPRESI TRA 1 E 90
-LA GIOCATA DEVE ESSERE COMPOSTA DA 6 NUMERI

AVVENUTO L'INSERIMENTO DELLA GIOCATA, IL SISTEMA
DEVE GENERARE UNA SESTINA VINCENTE DI 6 NUMERI
COMPRESI TRA 1 E 90 NON DUPLICATI

VERIFICARE CHE CI SIA STATA UNA VINCITA
CONFRONTANDO LE 2 SESTINE (GIOCATA - VINCENTE)

INFORMARE IL GIOCATORE DELL'ESITO: 
-"NON HAI VINTO"/"HAI REALIZZATO 'X' PUNTI"
-"HAI VINTO 'Y' EURO"

a scelta l'algoritmo di guadagno
Tip#1
un metodo per generare randomicamente dei numeri:
math.random() <- genera un numero reale tra 0 e 1

Tip#2
utilizzo di siteTextfield per recuperare i numeri da giocare
*/
import java.util.*;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

class GiocataEnalotto extends Frame implements ActionListener 
{
	TextField numero=null; //tf per inserimento dei numeri
	TextField puntata=null; //inserimento puntata
	
	Label istruzioni=null; //istruzioni per giocare
	Label n1=null; //label che conterrà i numeri giocati
	Label vincente=null; //label sestina vincente
	Label risultato=null; //risultato della giocata (vincita/perdita)

	Button exit=null;
	Button gioca=null; //inserisce i numeri nella giocata
	Button punta=null; //conferma la puntata e inizia a giocare

	Set sestinaV=new HashSet(); //sestina vincente  !! da verificare funzionamento
	int[] inputArr = new int[6];
	int[] numeriV =new int[6];
	int inArr = 0;

	int uguali=0; //quanti numeri sono stati indovinati
	boolean elemPresente=false; //true se elemento da inserire è già presente

	boolean ritenta=true; //permette di ricominciare la partita

	public GiocataEnalotto(String t){
		super(t);
		Arrays.fill(inputArr, 0);

		//Creazione frame
		setLayout(null);
		this.setVisible(true);
		setSize(500,500);
		setLocation(200,250);
		setBackground(Color.red);
		//end Creazione Frame

		//Creazione TextField	
		//numero giocato
		numero=new TextField("");
		numero.setSize(30,30);
		numero.setLocation(150,200);
		
		//puntata
		puntata=new TextField(""); 
		puntata.setSize(60,30);
		puntata.setLocation(150,260);
		puntata.setVisible(false);
	
		//PULSANTI
		//exit
		exit=new Button("ESCI");
		exit.setSize(80,30);
		exit.setLocation(20,100);
		exit.addActionListener(this);

		//gioca
		gioca=new Button("GIOCA");
		gioca.setSize(80,30);
		gioca.setLocation(20,200);
		gioca.addActionListener(this);

		//punta								
		punta=new Button("PUNTA");
		punta.setSize(80,30);
		punta.setLocation(20,260);
		punta.addActionListener(this);
		punta.setVisible(false);
			
		//LABEL
		//istruzioni
		istruzioni = new Label("BENVENUTO! Per iniziare inserisci il primo numero e premi GIOCA");
		istruzioni.setSize(400,30);
		istruzioni.setLocation(40,40);
		
		//numeri giocati
		n1= new Label("  -    -    -    -    -   ");
		n1.setSize(200,30);
		n1.setLocation(200,100);

		//sestina vincente
		vincente=new Label("");
		vincente.setSize(250,30);
		vincente.setLocation(200,200);

		//risultato giocata
		risultato=new Label("");
		risultato.setSize(450,30);
		risultato.setLocation(10,250);

		//ADD componenti
		add(numero);
		add(puntata);

		add(exit);
		add(gioca);
		add(punta);

		add(istruzioni);
		add(n1);
		add(vincente);
		add(risultato);

	}//end costruttore
	
	//Gestione pulsanti
	public void actionPerformed(ActionEvent e) {

	//exit
	if (e.getSource()==exit)
	{
		System.exit(0);
	}
	
	//gioca
	if(e.getSource()==gioca && ritenta){
		istruzioni.setText("BENVENUTO! Per iniziare inserisci il primo numero e premi GIOCA");
		vincente.setText("");
		risultato.setText("");
		puntata.setText("");
		
		//aggiungi numeri fin quando se ne giocano esattamente 6
		if(inArr<6){ 
			int value=Integer.parseInt(numero.getText());
	
			//se numero che si tenta di giocare non è compreso 1-90
			if(value<1 || value>90){ 
				istruzioni.setText("Devi inserire un numero compreso tra 1 e 90");
				numero.setText("");

			//se numero rientra nel range 1-90
			}else{						
				Arrays.sort(inputArr, 0 , inArr); //ordina solo la parte inserita da utente di inputArr

				//se numero già inserito nella giocata  - 
				//elemPresente=true se elemento già giocato

				for (int i=0;i<inArr ;i++ )
				{
					if(inputArr[i]==value){
						elemPresente=true;
					}
				}

				if(elemPresente){				
					istruzioni.setText("Hai già inserito questo numero");
					numero.setText("");
					elemPresente=false;
				}else{
											
					inputArr[inArr]=value;
					n1.setText(  inputArr[0] + " - " + inputArr[1] + " - " + inputArr [2] + " - " + inputArr[3] + " - " + inputArr[4] + " - " + inputArr[5]);
					inArr++;
					numero.setText("");
					istruzioni.setText("BENE! ora inserisci i tuoi altri numeri");
					
				}
			}
		}//end if(inarr<6)
		
		if(inArr==6){
			ritenta=false; //disabilito pulsante gioca
			istruzioni.setText("Adesso inserisci la tua puntata");

			//cambio visibilità pulsanti e TF			
			numero.setVisible(false);
						
			puntata.setVisible(true);
			punta.setVisible(true);
		}
	}//end pulsante GIOCA

//pulsante PUNTA
	if(e.getSource()==punta){
		int valorePuntata = Integer.parseInt(puntata.getText());
		double numeroRandom = 0;
		int numeroInt=0;
		boolean found=false;
		uguali=0;

		for (int j=0; j<6 ;j++ )
		{
			Arrays.sort(numeriV,0,j);
			//generazione numero int random 1-90
			do{			
				found=false;
				numeroRandom = Math.random()*100;
				numeroInt=(int)numeroRandom;

				//ricerca se numero già generato
				for (int i=0;i<j ;i++ )
				{
					if(numeriV[i]==numeroInt){
						found=true;
					}
				}

				}while(numeroInt<1 || numeroInt>90 || found); //continua il do finchè è escluso dal range o è già presente
			numeriV[j]=numeroInt;//inserisci il numero random nell'array
		};//end for

		istruzioni.setText("Premi GIOCA per riprovare!");
		vincente.setText("La sestina vincente: " + numeriV[0] + " - " + numeriV[1] + " - " + numeriV [2] + " - " + numeriV[3] + " - " + numeriV[4] + " - " + numeriV[5]);
		
		//confronto tra numeri giocati e numeri vicenti
		for (int i=0; i<6 ; i++ )
		{
			for(int j=0; j<6 ; j++)
			{
				if(inputArr[i] == numeriV[j]){
					uguali++;
				}
			}
		}

//messaggi che indicano il risultato
		switch (uguali)		
		{
			case 0:
				risultato.setText("Che sfortuna. Ma questa è solo un'app java: puoi ritentare quanto vuoi");
				break;
			
			case 1:
				risultato.setText("Hai un Solitario. Ma purtroppo non basta per vincere...");
				break;

			case 2:
				risultato.setText("Complimenti! hai vinto " + valorePuntata*1.5 + " soldi grazie a questo ambo");
				break;

			case 3:
				risultato.setText("Tre numeri uguali! Non male! Ecco, hai vinto " + valorePuntata*3 + " soldi!");
				break;

			case 4:
				risultato.setText("La fortuna ti è amica, ma scommetto che puoi fare di più. Hai vinto " + valorePuntata*4.5 + " soldi");
				break;

			case 5:
				risultato.setText("Strabiliante! Meno male che questo è solo un giochino eh? Ecco i tuoi " + valorePuntata*6 + " soldi");
				break;

			case 6:
				risultato.setText("Nessuno ha mai avuto tanta fortuna. Prendi i tuoi " + valorePuntata*8 + " soldi e non farti più vedere");
				break;
		}
				
//ricomincia una partita
		ritenta=true; 
		inArr = 0;
		numero.setVisible(true);
		punta.setVisible(false);
		puntata.setVisible(false);
		Arrays.fill(inputArr, 0);		
		}//end pulsnte PUNTA

	}//end pulsanti

}//END CLASS








