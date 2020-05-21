import java.awt.Frame;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label; //etichette

public class SchermoConto extends Frame implements ActionListener, ContoATM
{
		TextField tf2=null; //field per le cifre da depositare e prelevare

	    Label nome_banca2=null; //logo banca
		Label gen_mex=null; //messaggio generico

		Button exit1=null; //exit
		Button depo=null; //deposito
		Button prel=null; //prelievo
		Button saldoc=null; //saldo corrente

		private double saldoATM=0;


		public SchermoConto(String t2){
			super(t2);
			nome_banca2=new Label(t2);
			this.saldoATM=saldo;
			
			//******************
			//creazione finestra per interfaccia menu
			setLayout(null);
			this.setVisible(true);
			setSize(500,500);
			setLocation(200,250);
			setBackground(Color.cyan);
			// fine sezione costruzione della finestra
			//***************************************

			//label nome banca nella finestra del menu
			nome_banca2.setSize(500,30);
			nome_banca2.setLocation(100,50);

			//label messaggio generico
			gen_mex = new Label("");
			gen_mex.setSize(200,30);
			gen_mex.setLocation(150,450);

			//TEXTFIELD
			tf2=new TextField();
			tf2.setSize(150,30);
			tf2.setLocation(150,400);
			
			//PULSANTI
			//exit
			exit1=new Button("CHIUDI");
			exit1.setSize(80,30);
			exit1.setLocation(150,200);
			exit1.addActionListener(this);
			
			//deposito
			depo=new Button("DEPOSITA");
			depo.setSize(80,30);
			depo.setLocation(150,250);
			depo.addActionListener(this);
			
			//prelievo
			prel=new Button("PRELEVA");
			prel.setSize(80,30);
			prel.setLocation(150,300);
			prel.addActionListener(this);

			//saldo
			saldoc=new Button("SALDO");
			saldoc.setSize(80,30);
			saldoc.setLocation(150,350);
			saldoc.addActionListener(this);

			//aggiunta componenti
			add(nome_banca2);
			add(gen_mex);

			add(exit1);
			add(depo);
			add(prel);
			add(saldoc);

			add(tf2);

		}//end costruttore

		//gestione pulsanti
		public void actionPerformed(ActionEvent e){

			//exit
			if (e.getSource()==exit1)
			{
				System.exit(0);
			}
		
			//saldo corrente
			if (e.getSource()==saldoc)
			{
				gen_mex.setText("Il saldo corrente -> " + this.getSaldo() + " talleri");
			}

			//prelievo
			if (e.getSource()==prel)
			{
				double input=Double.parseDouble(tf2.getText()); //crea un double con le cifre in tf2
				if (!checkPrelievo(input))
				{
					gen_mex.setText("Non è possibile prelevare");
				} else {
					prelievo(input);
					gen_mex.setText( "Il saldo corrente -> " + this.getSaldo() + " talleri");
				}


			}

			//deposito
			if(e.getSource()==depo){
				double input=Double.parseDouble(tf2.getText());
				deposito(input);
				gen_mex.setText( "Il saldo corrente -> " + this.getSaldo() + " talleri");
			}

	
		}//fine gestione pulsanti

		//OVERRIDE CONTO ATM
	@Override
		public String getCognome(){
			return cognome;
		}

	@Override
		public String getNome(){
			return nome;
		}
	@Override
	public double getSaldo(){
		return saldoATM;
	}

	@Override
	public boolean prelievo (double p){ //torna true a prelievo effettuato
		if(checkPrelievo (p)){
			saldoATM-=p;
		}
		return checkPrelievo(p);

	}

	@Override
	public void deposito (double d){
		saldoATM+=d;
	}
	
	@Override
	public boolean checkPrelievo (double cp){ //true se prelievo possibile
		if (saldoATM>0 && cp<saldoATM)
		{
			return true;
		}else 
			return false;

	}//END OVERRIDE CONTO ATM

}//end class