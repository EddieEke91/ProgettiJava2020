//DA MOGLIORARE
//una classe che registra in una banca dati gli utenti e il relativo pin
//da implementare l'associazione con l'utente


class AccessoATM 
{
	private int pin=1234;

	public boolean checkPin(int pin){
		return this.pin==pin;
	}
}
