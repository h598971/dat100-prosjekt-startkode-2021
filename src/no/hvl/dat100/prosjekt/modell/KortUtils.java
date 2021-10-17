package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		// TODO - START
		// Henter først samling med getSamling() metoden.
		Kort nySamling[] = samling.getSamling();
		
		// Looper gjennom alle kortene.
		for (int i=0; i < nySamling.length; i++) {
			// For hvert kort, loop gjennom på nytt fra neste Kort.
			for(int j=i+1; j < nySamling.length; j++) {
				// Første Kort.
				Kort etKort = nySamling[i];
				// Neste Kort.
				Kort nesteKort = nySamling[j];
				// Ikke kall compareTo() hvis Kort er null.
				if (etKort != null && nesteKort != null) { 
					int numb = etKort.compareTo(nesteKort);
					// Hvis nesteKort er mindre enn etKort, bytt plass i samlingen.
					if (numb > 0) {
						// Bevarer plassen midlertidig. 
						Kort temp = nySamling[i];
						nySamling[i] = nySamling[j];
						nySamling[j] = temp;
					}
				}
			}
		}
		// TODO - END
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		// TODO - START
		Kort nySamling[] = samling.getSamling();
		
		for (int i=0; i < nySamling.length-1; i++) {
			// Lager tilfeldig tall mellom 0 og 51.
			int randNumb = i + (int) (Math.random() * (nySamling.length - i));
			// Bevarer kortet midlertidig
			Kort temp = nySamling[i];
			// Flytter kortet til random index i lista.
			nySamling[i] = nySamling[randNumb];
			nySamling[randNumb] = temp;
		}
		// TODO - END
	}
	
}
