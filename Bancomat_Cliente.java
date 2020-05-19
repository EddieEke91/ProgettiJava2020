import java.awt.Frame;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
class Bancomat_Cliente extends Frame implements ActionListener
{
	Button prelievo=null;
	Button deposito=null;
	Button esci =null;
	Button pulizia =null;
	Button saldo=null;

	TextField tfprelievo=null;
	TextField tfdeposito=null;
	
	Label labelnome=null;
	Label labelpin=null;
	Label labeldeposito=null;
	Label labelprelievo=null;
	Label nome_banca=null;

	//istanzio una classe Conto_corrente
		Conto_corrente primo = new Conto_corrente("Ale",10000,100,"1234");
	
	public Bancomat_Cliente(String t){

		super(t);
		//***************************************
		// sezione costruzione della finestra
		setLayout(null);
		this.setVisible(true);
		setSize(500,500);
		setLocation(400,300);
		setBackground(Color.green);
		// fine sezione costruzione della finestra
		//***************************************

		

		//costruisco un oggetto pulsante "Esci"
		esci=new Button("Esci");

		esci.setSize(80,30);// dimensiono il button
		esci.setLocation(250,170);// posiziono il pulsante nel frame
		esci.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		//costruisco un oggetto pulsante "Prelievo"
		prelievo=new Button("Prelievo");

		prelievo.setSize(80,30);// dimensiono il button
		prelievo.setLocation(150,170);// posiziono il pulsante nel frame
		prelievo.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		//costruisco un oggetto pulsante "Deposito"
		deposito=new Button("Deposito");

		deposito.setSize(80,30);// dimensiono il button
		deposito.setLocation(70,170);// posiziono il pulsante nel frame
		deposito.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		//costruisco un oggetto pulsante "pulizia"
		pulizia=new Button("Pulisci");

		pulizia.setSize(80,30);// dimensiono il button
		pulizia.setLocation(250,140);// posiziono il pulsante nel frame
		pulizia.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		saldo=new Button("Saldo");

		saldo.setSize(80,30);// dimensiono il button
		saldo.setLocation(150,70);// posiziono il pulsante nel frame
		saldo.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		//creazione di una textprelievo
		tfprelievo=new TextField();

		tfprelievo.setSize(150,30);
		tfprelievo.setLocation(250,350);
		
		//Creazione di una textdeposito
		tfdeposito=new TextField();

		tfdeposito.setSize(150,30);
		tfdeposito.setLocation(250,390);

		//Costruzione LabelNome
		labelnome=new Label("Nome correntista:"+primo.getnomeCorrentista());
		labelnome.setSize(150,30);
		labelnome.setLocation(120,260);
		
		//Costruzione LabelPin
		labelpin=new Label("Pin correntista:"+primo.getPin());
		labelpin.setSize(150,30);
		labelpin.setLocation(120,300);

		//Costruzione Labelnome_banca
		nome_banca=new Label("Banca INTESA");
		nome_banca.setSize(150,60);
		nome_banca.setLocation(200,25);

		//Costruzione Labelprelievo
		labelprelievo=new Label("Quanto si desidera prelevare? ");
		labelprelievo.setSize(150,30);
		labelprelievo.setLocation(120,350);
		
		//Costruzione Labeldeposito
		labeldeposito=new Label("Quanto si desidera depositare? "+primo.getPin());
		labeldeposito.setSize(150,30);
		labeldeposito.setLocation(120,390);

		add(esci);//metodo per aggiungere i componenti al frame
		add(labelnome);
		add(labelpin);
		add(nome_banca);
		add(deposito);
		add(prelievo);
		add(saldo);
		
	}

	public void actionPerformed(ActionEvent e)
	{
				
				//se è stato cliccato il pulsante prelievo
					if(e.getSource()==prelievo)
					{
						add(labelprelievo);
						add(tfprelievo);

					}
				//se è stato cliccato il pulsante prelievo
					if(e.getSource()==deposito)
					{
						add(labeldeposito);
						add(tfdeposito);

					}
					
				//se è stato cliccato il pulsante esci
					if(e.getSource()==esci)
					{
							System.exit(0);	
					}

				//se è stato cliccato il pulsante saldo
					if(e.getSource()==saldo)
					{
						add(labeldeposito);
						labeldeposito.setText(Double.toString(primo.getsaldoDisponibile()));
					}
	}
}