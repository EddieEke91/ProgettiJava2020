class Conto_corrente 
{
	//Tre attributi per mostrare le informazioni di base del conto
	private String nomeCorrentista = null;
	private double saldoDisponibile = 0.0;
	private double saldoUsatoMensile = 0.0;



	//costruttore
	public Conto_corrente(String nomeCorrentista, double saldoDisponibile,double saldoUsatoMensile, String pin)
	{
		this.nomeCorrentista= nomeCorrentista;
		this.saldoDisponibile= saldoDisponibile;
		this.saldoUsatoMensile = saldoUsatoMensile;
	}

	//Metodi set
	public final void setnomeCorrentista (String nome){
		this.nomeCorrentista = nome;
	}

	public final void setsaldoDisponibile (double saldoDisponibile){
	 System.out.println("Aggiornamento del saldo disponibile ");
	 this.saldoDisponibile += saldoDisponibile;
	 System.out.println("Il nuovo saldo disponibile è: "+this.saldoDisponibile+ " Euro");
	}

	public final void setsaldoUsatoMensile (double saldoUsatoMensile){
		this.saldoUsatoMensile = saldoUsatoMensile;
	}

	//Metodi get
	public String getnomeCorrentista()
	{
		return this.nomeCorrentista;
	}
	
	public double getsaldoDisponibile()
	{
		return this.saldoDisponibile;
	}

		public double getsaldoUsatoMensile()
	{
		return this.saldoUsatoMensile;
	}

	public void deposito(double soldiDepositati)
	{
		if(soldiDepositati<0 ||soldiDepositati==0)
		{
			System.out.println("Errore, non è consentita questa operazione");
		}
		else
		{
			this.saldoDisponibile = saldoDisponibile+soldiDepositati;
			System.out.println("Saldo aggiornato, il quantitativo è: "+this.getsaldoDisponibile());
		}
	}

	public void prelievo (double soldiPrelevati)
	{
		if((soldiPrelevati>this.saldoDisponibile) || (soldiPrelevati<0) || (soldiPrelevati==0))
			{
				this.saldoDisponibile -= soldiPrelevati;
			}
	}
}
