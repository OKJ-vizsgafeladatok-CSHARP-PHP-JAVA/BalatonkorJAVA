package balatonkor;

public class Helyszinek 
{
	private String nev;
	private int elsoSzakaszHossza;
	private int masodikSzakaszHossza;
	private int harmadikSzakaszHossza;
	
	public Helyszinek(String nev, int elsoSzakaszHossza, int masodikSzakaszHossza, int harmadikSzakaszHossza)
	{
		this.nev = nev;
		this.elsoSzakaszHossza = elsoSzakaszHossza;
		this.masodikSzakaszHossza = masodikSzakaszHossza;
		this.harmadikSzakaszHossza = harmadikSzakaszHossza;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getElsoSzakaszHossza() {
		return elsoSzakaszHossza;
	}

	public void setElsoSzakaszHossza(int elsoSzakaszHossza) {
		this.elsoSzakaszHossza = elsoSzakaszHossza;
	}

	public int getMasodikSzakaszHossza() {
		return masodikSzakaszHossza;
	}

	public void setMasodikSzakaszHossza(int masodikSzakaszHossza) {
		this.masodikSzakaszHossza = masodikSzakaszHossza;
	}

	public int getHarmadikSzakaszHossza() {
		return harmadikSzakaszHossza;
	}

	public void setHarmadikSzakaszHossza(int harmadikSzakaszHossza) {
		this.harmadikSzakaszHossza = harmadikSzakaszHossza;
	}

	@Override
	public String toString() {
		return "Helyszinek [nev=" + nev + ", elsoSzakaszHossza=" + elsoSzakaszHossza + ", masodikSzakaszHossza="
				+ masodikSzakaszHossza + ", harmadikSzakaszHossza=" + harmadikSzakaszHossza + "]";
	}
	
	
	
}
