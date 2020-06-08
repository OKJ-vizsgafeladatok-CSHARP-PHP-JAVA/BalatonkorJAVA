package balatonkor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main {
	
	
	
	public static String versenyzokSzama;
	public static List<Helyszinek> beolvasFajlbol()
	{
		List<Helyszinek> helyszinLista = new ArrayList<>();
		try 
		{
			List<String> sorok = Files.readAllLines(Paths.get("kerekpar.csv"));
			versenyzokSzama=sorok.get(0);
			for (String sor : sorok.subList(1, sorok.size())) 
			{
				String[] split = sor.split(";");
				Helyszinek h = new Helyszinek(split[0], Integer.parseInt(split[1]), 
						Integer.parseInt(split[2]), Integer.parseInt(split[3]));
				helyszinLista.add(h);
			}
		} 
		catch (IOException e) 
		{
			System.err.println("Hiba a beolvasáskor..." + e);
		}
		return helyszinLista;
	}
	
	
	
	public static void main(String[] args) 
	{
		Scanner beker =  new Scanner(System.in);
		
		List<Helyszinek> helyszLista = beolvasFajlbol();
		System.out.println("2/1 részfeladat: Teljesítve, a fájl beolvasva.");
		System.out.println("\tA fájl tartalma: ");
		if (helyszLista.size() > 20) 
		{
			System.out.println("Csak 20 elemu lehet a lista!");
		}
		else
		{
			for (Helyszinek h : helyszLista) 
			{
				System.out.println(h);
				/*System.out.println("\tVáros neve: "+h.getNev()+", 1. szakasz hossza: "+h.getElsoSzakaszHossza()+" km"+
						", 2. szakasz hossza: "+h.getMasodikSzakaszHossza()+" km"+", 3. szakasz hossza: "+h.getHarmadikSzakaszHossza()+" km");*/
			}
		}
		
		
		System.out.println("2/2 részfeladat:");		
		int osszesHelyszinSzama=helyszLista.size();
		System.out.println("\tA helyszínek száma: "+osszesHelyszinSzama+" db.");
		
		
		System.out.println("2/3 részfeladat: ");
		int teljesHossza=0;
		for (Helyszinek h : helyszLista) 
		{
			teljesHossza+=h.getElsoSzakaszHossza()+h.getMasodikSzakaszHossza()+h.getHarmadikSzakaszHossza();			
		}
		System.out.println("\tA versenysorozat teljes hossza: "+teljesHossza+" km.");	
		
				
		System.out.println("2/4 részfeladat:");
		System.out.println("\tAdjon meg egy (balatoni) városnevet: ");
		String varos = beker.nextLine();
		String talalat="Ez a város nem szerepel a verseny állomásai között!";
		for (Helyszinek h : helyszLista) 
		{
			if (varos.equals(h.getNev()))
			{
				talalat= ("\t"+h.getNev()+" versenyszakaszai: "+h.getElsoSzakaszHossza()+" km, "+h.getMasodikSzakaszHossza()+" km, "+h.getHarmadikSzakaszHossza()+" km.");
			}
		}
		System.out.println(talalat);
		
		
		System.out.println("2/5 részfeladat:");
		int max=Integer.MIN_VALUE;
		Helyszinek leghosszabb=null;
		for (Helyszinek h : helyszLista) 
		{
			if ((h.getElsoSzakaszHossza()+h.getMasodikSzakaszHossza()+h.getHarmadikSzakaszHossza()) > max) 
			{
				leghosszabb=h;
				max=h.getElsoSzakaszHossza()+h.getMasodikSzakaszHossza()+h.getHarmadikSzakaszHossza();
			}
		}
		System.out.println("\tA leghosszabb versenytávot adó település: "+leghosszabb.getNev());
		
		
		System.out.println("2/6 részfeladat:");
		int elsoSzakOssz=0;
		for (Helyszinek h : helyszLista) 
		{
			elsoSzakOssz+=h.getElsoSzakaszHossza();
		}
		double elsoSzakAtlag=(double)elsoSzakOssz/osszesHelyszinSzama;
		System.out.println("\tAz első szakaszok átlagos hossza: "+elsoSzakAtlag+" km.");
		
		
		System.out.println("2/7 részfeladat:");		
		
		Set<String> statisztika = new HashSet<>();
		int adottAllHossza=0;
		double szazalek=0;
		for (Helyszinek h : helyszLista) 
		{
			adottAllHossza=h.getElsoSzakaszHossza()+h.getMasodikSzakaszHossza()+h.getHarmadikSzakaszHossza();
			szazalek=((double)adottAllHossza/teljesHossza)*100;
			System.out.println(adottAllHossza);
			System.out.println(szazalek);
			statisztika.add(h.getNev()+": "+szazalek+"%");
		}			
		
		String fajlba="";	
		for (String s : statisztika) 
		{
			
			fajlba+=s+"\n";
		}		
		try
		{
			Files.write(Paths.get("statisztika.txt"), fajlba.getBytes());
	
		}
		catch (IOException e)
		{
			System.err.println("Hiba a fájlba áraskor!");
		}
		System.out.println("\tA fájl létrehozva.");
		
		System.out.println("2/8 részfeladat");
		int atlagosVersSzam=Integer.parseInt(versenyzokSzama)/osszesHelyszinSzama;		
		System.out.println("\tAz átlagos versenyzőszám: "+atlagosVersSzam);		
		
	}

}
