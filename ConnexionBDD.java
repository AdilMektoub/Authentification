package Authentification;


	import java.awt.EventQueue;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.util.ArrayList;

	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;
	
public class ConnexionBDD {
	
// je déclare les variables static dans la class aussi car j'ai la methode nomDesLivres qui est pas dans le main mais dans la class (en-dehors de main)
	static String url = "jdbc:mysql://localhost:3306/bib";
	static  String user = "root";
	static String passwd = "";
	
	    // La méthode qui appelera votre fonction Run
	    public static void main(String[] args) {
	    	System.out.println(nomsDesLivres());
	    	EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                // Votre fonction Run
	                // Vos information de connexion à une base de données
	                String BDD = "bib";
	                String url = "jdbc:mysql://localhost:3306/" + BDD;
	                String user = "root";
	                String passwd = "";
	                
	                // L'essaie de connexion à votre base de donées
	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection conn =
	                            (Connection) DriverManager.getConnection(url, user, passwd);
	                    System.out.println("Connecter");
	                    //si ça se connecte pas exception
	                } catch (Exception e){
	                    e.printStackTrace();
	                    System.out.println("Erreur");
	                    System.exit(0);
	                }
	            }
	        });
	    	
	    }
	    
//		Je crée une méthode qui affiche les noms des utilisateur
		public static ArrayList<String> nomsDesLivres(  ) {
			ArrayList<String> list = new ArrayList<String>();
			try { Connection connection = 
					(Connection) DriverManager.getConnection( url, user, passwd ) ;
				//String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND password='" + password + "'";
				String strSql = "SELECT * FROM livres"; //  WHERE login=? AND password=?
				try ( PreparedStatement statement  = (PreparedStatement) connection.prepareStatement( strSql ) ) {
//					statement.setString( 1, login );
//					statement.setString( 2, password );
					try ( ResultSet resultSet = statement.executeQuery() ) {
						while ( resultSet.next() ) { //(int id, int id_livre, String nom, String login, String password)	
									list.add(resultSet.getString( "titre" )); }
					}
				}
			} catch ( Exception exception ) {
				throw new RuntimeException( exception );
			}
			return list;
		}
	}

