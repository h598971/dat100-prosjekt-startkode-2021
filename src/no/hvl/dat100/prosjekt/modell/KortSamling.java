package no.hvl.dat100.prosjekt.modell;
import java.util.HashMap; // import the HashMap class
import java.util.Arrays;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 13 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	
	public KortSamling() {
		
		// TODO - START
		samling = new Kort[MAKS_KORT];
		antall = 0;
		// TODO - END
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {

		return this.samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		// TODO - START
		return this.antall;		
		// TODO - END
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		// TODO - START			
		if (this.antall > 0) {
			return false;
		} else {
			return true;
		}
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 * er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		// TODO - START
		this.samling[antall] = kort;
		this.antall += 1;
		
		//throw new UnsupportedOperationException(TODO.method());
		// TODO - END
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		
		// TODO - START
		// Husk: bruk Regler.MAKS_KORT_FARGE for å få antall kort per farge
		for (int i=0; i < Regler.MAKS_KORT_FARGE; i++) {
			for (int a=1; a <= 13; a++) {
				Kort kort = new Kort(Kortfarge.values()[i], a);
				this.leggTil(kort);
			}
		}
		// TODO - END
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() {
		
		// TODO - START
		this.samling = new Kort[MAKS_KORT];
		this.antall = 0;
		// TODO - END
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		// TODO - START
		int counter = 0;
		if (this.antall > 0) {
			counter = this.antall-1;
		}
		return this.samling[counter];
		// TODO - END
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		// TODO - START
		Kort t = seSiste();
		fjern(t);
		return t;

		// TODO - END
	}
	
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		// TODO - START		
		// Return false om kort er null.
		if (kort == null) {
			return false;
		}
		// Looper gjennom og sjekke om objekter i samling med objekt i param. Ma bruke .equals fordi vi vil sammenligne objektets properties. 
		for (int i=0; i < this.samling.length; i++) {
			if (this.samling[i] != null) {
				if (this.samling[i].equals(kort)) {
					return true;
				}
			}
		}
		
		return false;
		
		// TODO - END
		
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
		
		// TODO - START
		
		if (kort == null) {
			return false;
		}
		
		// Looper gjennom samling og sjekker om kort finnes is samling.
		for (int i=0; i < this.samling.length; i++) {
			// .equals failer hvis prøver å sjekke med null. Sjekker derfor kun elementer i samling som ikke er null.
			if (this.samling[i] != null) {
				if (this.samling[i].equals(kort)) {
					// Fjerner elementet.
					this.samling[i] = null;
					this.antall--;
					return true;
				} 	
			}	
		}
		return false;
		
		// TODO - END
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		
		// TODO - START
		Kort nySamling[] = new Kort[this.antall];
		
		for (int i=0; i < this.samling.length; i++)
			if (this.samling[i] != null) {
				nySamling[i] = this.samling[i];
			}
		
		return nySamling;
		// TODO - END
	
	}
	
}