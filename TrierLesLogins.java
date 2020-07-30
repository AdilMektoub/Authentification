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
		String[] stagiaires = { "Anis","Inga", "Im�n", "S�bastien", "Nicolas", "Dalia"};
		
//		Parite 1 je cr�e un dossier dans le bureau de l'ordinateur � testJAVA2 � � l�int�rieur je cr�e un fichier txt appel� testJ2.txt :
//			j'ins�rer dans testJ2.txt les noms, un nom pour chaque ligne mais les noms sont en majuscule.
//			les noms sont ins�r�s dans le bon ordre alphab�tique
//			(ASCII)
		File testJ2 = new File("C://Users/Admin/Desktop/testJ2/");// je cr�e dossier
		
		if (!testJ2.exists())// si il exist PAS je le recr�e
			testJ2.mkdir();

		File testJ2Txt = new File("C://Users/Admin/Desktop/testJ2/testJ2.txt");// je cr�e le fichier .txt dans le dossier
		if (!testJ2Txt.exists())// si il existe pas 
		try {
			testJ2Txt.createNewFile();// essie de le cr�er
		} catch (IOException e) {// sinon tu cr�e une exeption
			e.printStackTrace();// et tu me l'�crit (exeption)
		}
			
			FileWriter writer = new FileWriter(testJ2Txt);//je cr�e un nouveau fichier d'�criture 
			BufferedWriter bw = new BufferedWriter(writer);//
			ArrayList<String> arraystagiaires = new ArrayList<String>();
			for (String s : stagiaires) {//pour chaque element de mon tableau de string 
				arraystagiaires.add(s.toUpperCase());// tu me l'�crit dans le fichier chaque string en majuscule
			}
			ArrayList<String> testArr = new ArrayList<String>(); 
			System.out.println(arraystagiaires);
			System.out.println("--------------------");
			testArr = tri(arraystagiaires);
			System.out.println(testArr);
//			Collections.sort(arraystagiaires); 1er Fa�on de TRIER
			System.out.println(arraystagiaires);
			
			for (String i : arraystagiaires) {
				bw.write(i);
				bw.newLine();
			}
			bw.close();//tu arrete la boucle foreach
			
			
			System.out.println(minArraylist(arraystagiaires));// 2�me fa�on de TRIER avec la METHODE 
			
			
			for (String s : stagiaires) {//pour chaque string de mon tableau 
				char p = s.charAt(0); //p = au premier caract�re
//				System.out.println((int) p); // tu me les affiches
				ArrayList<Integer> ordreCroissant = new ArrayList<Integer>(); // je cr�e une nouvelle arrayList "ordreCroissant"
				ordreCroissant.add((int) p);// je l'ajoute dans l'arrayList ordreCroissant
				Collections.sort(ordreCroissant); // je le trie
				System.out.print(ordreCroissant); // j'affiche trier
			}
		}
}
