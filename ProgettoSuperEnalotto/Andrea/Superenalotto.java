import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

class Superenalotto 
{
	
	private HashSet<Integer> ultimaEstrazione = new HashSet<Integer>();



	public void estrai(){
		ultimaEstrazione = new HashSet<Integer>();
		while (ultimaEstrazione.size() < 6){
			ultimaEstrazione.add(new Random().nextInt(90) + 1);
		}
		/*for(int i = 1; i < 7; i++){
			ultimaEstrazione.add(i*10);
		}*/
	}

	public String getUltimaEstrazione(){
		Object[] arrayEstratti = new Object[6];
		arrayEstratti = ultimaEstrazione.toArray();
		String result = "";
		for(int i = 0; i < arrayEstratti.length; i++){
			result += arrayEstratti[i] + " ";
		}
		return result;
	}

	public int verifica(ArrayList<Integer> giocata){
		HashSet<Integer> numeriVincenti = new HashSet<Integer>();
		numeriVincenti.addAll(ultimaEstrazione);
		numeriVincenti.retainAll(giocata);
		/*HashSet<Integer> setGiocata = new HashSet<Integer>;
		for(int i = 0; i < giocata.size(); i++){
			setGiocata.add(giocata[i]);
		}*/
		return numeriVincenti.size();
	}

	public double calcolaVincita(int puntata, int numeriVincenti){
		return Math.pow(puntata, numeriVincenti);
	}

	public void isValid(ArrayList<Integer> giocata) throws DuplicatiException, OutOfRangeException{
		HashSet<Integer> verifica = new HashSet<Integer>();
		for(int i = 0; i < giocata.size(); i++){
			int number = giocata.get(i);
			if(number > 90 || number < 1) throw new OutOfRangeException();
			verifica.add(number);
		}
		if(verifica.size() < 6) throw new DuplicatiException();
	}
}
