interface  ContoATM
{
	String cognome="Costa";
	String nome="Andrea";
	double saldo=100.0;


	public String getCognome();
	public String getNome();
	public double getSaldo();

	public boolean prelievo (double p);
	public void deposito (double d);

	public boolean checkPrelievo (double cp);
}
