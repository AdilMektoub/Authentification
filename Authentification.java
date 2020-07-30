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
		ArrayList<String> list = new ArrayList<String>(); //je crée une arrayList de String
		File file1 = new File("C://Users/Admin/Desktop/testJ2/DB.txt"); //il va chercher le fichier .txt de data           
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(new FileInputStream(file1), "UTF-8"));//récupère les données du fichier .txt
		String s = reader.readLine();
		while(s != null) { // tant que le string "s" est vide tu me rajoute l'éléments
			list.add(s);
			s = reader.readLine();
		} reader.close();
		
		System.out.println(list);
		HashMap<String, String> DB = new HashMap<String, String>(); // j'insére dans une HMap ces éléments
		for (String str : list) {
			String[] decomposes = str.split(" "); // à chaque espace tu me le Décompose (met à la ligne)
			DB.put(decomposes[2], decomposes[5]);// je me rend compte que le login se retrouve au 2éme élément decomposé et le password au 5éme éléments décomposé
		}
		System.out.println(DB);
		System.out.println("Connexion ?");
		authentification2(DB, "anis@pop.fr", "0000");
	}
	public static void authentification2(HashMap<String, String> pDB, String id, String mp) {
		boolean connexion = false; // par défault la connexion est invalide
		for (String e : pDB.keySet()) { //par contre POUR CHAQUE 
			if (id.equals(e) && pDB.get(id).equals(mp)) // Si id est égale au string "e" et que la VALEUR de l'ID de la Base de donné "pDB"(qui est le mot de passe) est égale au password "mp"
				connexion = true;// alors la connexion est valide
		}
		if (connexion) System.out.println("connexion établie");
		else System.out.println("connexion échouée");
	}
}
