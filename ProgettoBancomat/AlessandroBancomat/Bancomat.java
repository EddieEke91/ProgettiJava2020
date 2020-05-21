import java.awt.Frame;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
class Bancomat extends Frame implements ActionListener
{
	int contatore=0;
	Button b=null;
	Button pulizia=null;
	Button b2=null;

	TextField tfnome=null;
	TextField tfpin=null;
	
	Label labelnome=null;
	Label labelpin=null;
	Label labeltentativi=null;
	Label nome_banca=null;
	
	public Bancomat(String t){

		super(t);
		//***************************************
		// sezione costruzione della finestra
		setLayout(null);
		this.setVisible(true);
		setSize(500,500);
		setLocation(400,300);
		setBackground(Color.white);
		// fine sezione costruzione della finestra
		//***************************************

		//costruisco un oggetto pulsante "Esci"
		b2=new Button("Esci");

		b2.setSize(80,30);// dimensiono il button
		b2.setLocation(250,170);// posiziono il pulsante nel frame
		b2.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		//costruisco un oggetto pulsante "Accedi"
		b=new Button("Accedi");

		b.setSize(80,30);// dimensiono il button
		b.setLocation(250,200);// posiziono il pulsante nel frame
		b.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		//costruisco un oggetto pulsante "pulizia"
		pulizia=new Button("Pulisci");

		pulizia.setSize(80,30);// dimensiono il button
		pulizia.setLocation(250,140);// posiziono il pulsante nel frame
		pulizia.addActionListener(this);//permette al pulsante di ascoltare
							  //l'evento che avviene su di se

		//creazione di una textNome
		tfnome=new TextField();

		tfnome.setSize(150,30);
		tfnome.setLocation(250,260);
		
		//Creazione di una textPin
		tfpin=new TextField();

		tfpin.setSize(150,30);
		tfpin.setLocation(250,300);
		tfpin.minimumSize(4);

		//Costruzione LabelNome
		labelnome=new Label("Nome correntista");
		labelnome.setSize(150,30);
		labelnome.setLocation(120,260);
		
		//Costruzione LabelPin
		labelpin=new Label("Pin correntista");
		labelpin.setSize(150,30);
		labelpin.setLocation(120,300);

		//Costruzione Labelnome_banca
		nome_banca=new Label("Banca INTESA");
		nome_banca.setSize(150,60);
		nome_banca.setLocation(200,25);

		//Costruzione LabelTentativi
		labeltentativi=new Label(" ");
		labeltentativi.setSize(150,30);
		labeltentativi.setLocation(120,360);

		add(b);//metodo per aggiungere i componenti al frame
		add(tfnome);
		add(tfpin);
		add(labelnome);
		add(labelpin);
		add(nome_banca);
		add(b2);
		add(pulizia);
		add(labeltentativi);
	}

	public void actionPerformed(ActionEvent e)
		{
				
				//se è stato cliccato il pulsante pulizia
					if(e.getSource()==pulizia)
					{
							tfnome.setText(" ");
							tfpin.setText(" ");
					}

				//se è stato cliccato il pulsante uscita
					if(e.getSource()==b2)
					{
							System.out.println("uscita in corso");
							System.exit(0);	
					}

				//se è stato cliccato il pulsante b
				if(e.getSource()==b)
					{
					if(tfpin.getText().equals("1234"))
						{
							System.out.println("Pin corretto");
							Bancomat_Cliente x = new Bancomat_Cliente("t2");	
						}
					else
						{
						contatore = contatore+1;
						labeltentativi.setText("Errato, tentativo utilizzati: "+contatore);
						if(contatore ==3)
							{
							System.out.println("Si è sbagliato per tre volte il pin, uscita in corso");
							System.exit(0);
							}
						}							
		}
	}
}
