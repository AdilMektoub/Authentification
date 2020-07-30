package Authentification;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TrierLesLogins {
	
	

	//METHODE Minimum de l'arrayList
	static String minArraylist(ArrayList<String> arr) {
		char c = arr.get(0).charAt(0);
		int codeAsciMin = (int)(c);
		String first = arr.get(0);
		for (String s : arr) {
			if (codeAsciMin > (int)(s.charAt(0))) {
				codeAsciMin = (int)(s.charAt(0));
				first = s;
			}
		}
		return first;
	}
	//METHODE POUR TRIER
	static ArrayList<String> tri (ArrayList<String> arr) {
		ArrayList<String> finall = new ArrayList<String>();

		while (! arr.isEmpty()) {
			String min = minArraylist(arr);
			finall.add(min);
			arr.remove(min);
		}
		return finall;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		String[] stagiaires = { "Anis","Inga", "Imén", "Sébastien", "Nicolas", "Dalia"};
		
//		Parite 1 je crée un dossier dans le bureau de l'ordinateur « testJAVA2 » à l’intérieur je crée un fichier txt appelé testJ2.txt :
//			j'insérer dans testJ2.txt les noms, un nom pour chaque ligne mais les noms sont en majuscule.
//			les noms sont insérés dans le bon ordre alphabétique
//			(ASCII)
		File testJ2 = new File("C://Users/Admin/Desktop/testJ2/");// je crée dossier
		
		if (!testJ2.exists())// si il exist PAS je le recrée
			testJ2.mkdir();

		File testJ2Txt = new File("C://Users/Admin/Desktop/testJ2/testJ2.txt");// je crée le fichier .txt dans le dossier
		if (!testJ2Txt.exists())// si il existe pas 
		try {
			testJ2Txt.createNewFile();// essie de le créer
		} catch (IOException e) {// sinon tu crée une exeption
			e.printStackTrace();// et tu me l'écrit (exeption)
		}
			
			FileWriter writer = new FileWriter(testJ2Txt);//je crée un nouveau fichier d'écriture 
			BufferedWriter bw = new BufferedWriter(writer);//
			ArrayList<String> arraystagiaires = new ArrayList<String>();
			for (String s : stagiaires) {//pour chaque element de mon tableau de string 
				arraystagiaires.add(s.toUpperCase());// tu me l'écrit dans le fichier chaque string en majuscule
			}
			ArrayList<String> testArr = new ArrayList<String>(); 
			System.out.println(arraystagiaires);
			System.out.println("--------------------");
			testArr = tri(arraystagiaires);
			System.out.println(testArr);
//			Collections.sort(arraystagiaires); 1er Façon de TRIER
			System.out.println(arraystagiaires);
			
			for (String i : arraystagiaires) {
				bw.write(i);
				bw.newLine();
			}
			bw.close();//tu arrete la boucle foreach
			
			
			System.out.println(minArraylist(arraystagiaires));// 2éme façon de TRIER avec la METHODE 
			
			
			for (String s : stagiaires) {//pour chaque string de mon tableau 
				char p = s.charAt(0); //p = au premier caractére
//				System.out.println((int) p); // tu me les affiches
				ArrayList<Integer> ordreCroissant = new ArrayList<Integer>(); // je crée une nouvelle arrayList "ordreCroissant"
				ordreCroissant.add((int) p);// je l'ajoute dans l'arrayList ordreCroissant
				Collections.sort(ordreCroissant); // je le trie
				System.out.print(ordreCroissant); // j'affiche trier
			}
		}
}
