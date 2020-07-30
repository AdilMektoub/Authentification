package Authentification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Authentification {

	public static void main(String[] args) throws IOException {
		ArrayList<String> list = new ArrayList<String>(); //je cr�e une arrayList de String
		File file1 = new File("C://Users/Admin/Desktop/testJ2/DB.txt"); //il va chercher le fichier .txt de data           
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(new FileInputStream(file1), "UTF-8"));//r�cup�re les donn�es du fichier .txt
		String s = reader.readLine();
		while(s != null) { // tant que le string "s" est vide tu me rajoute l'�l�ments
			list.add(s);
			s = reader.readLine();
		} reader.close();
		
		System.out.println(list);
		HashMap<String, String> DB = new HashMap<String, String>(); // j'ins�re dans une HMap ces �l�ments
		for (String str : list) {
			String[] decomposes = str.split(" "); // � chaque espace tu me le D�compose (met � la ligne)
			DB.put(decomposes[2], decomposes[5]);// je me rend compte que le login se retrouve au 2�me �l�ment decompos� et le password au 5�me �l�ments d�compos�
		}
		System.out.println(DB);
		System.out.println("Connexion ?");
		authentification2(DB, "anis@pop.fr", "0000");
	}
	public static void authentification2(HashMap<String, String> pDB, String id, String mp) {
		boolean connexion = false; // par d�fault la connexion est invalide
		for (String e : pDB.keySet()) { //par contre POUR CHAQUE 
			if (id.equals(e) && pDB.get(id).equals(mp)) // Si id est �gale au string "e" et que la VALEUR de l'ID de la Base de donn� "pDB"(qui est le mot de passe) est �gale au password "mp"
				connexion = true;// alors la connexion est valide
		}
		if (connexion) System.out.println("connexion �tablie");
		else System.out.println("connexion �chou�e");
	}
}
