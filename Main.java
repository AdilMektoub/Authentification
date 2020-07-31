package Authentification;


	import java.awt.EventQueue;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;

	import com.mysql.jdbc.Connection;

	public class Main {
		
	    
	    // Vos information de connexion à une base de données
		static String url = "jdbc:mysql://localhost:3306/bib";
		static  String user = "root";
		static String passwd = "";
	    // La méthode qui appelera votre fonction Run
	    public static void main(String[] args) {
	    	System.out.println(nomsDesUtilisateurs());
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                // Votre fonction Run
	                // L'essaie de connexion à votre base de donées
	                try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection conn =
	                    		(Connection) DriverManager.getConnection(url, user, passwd);
	                    System.out.println("Connecter");
	                } catch (Exception e){
	                    e.printStackTrace();
	                    System.out.println("Erreur");
	                    System.exit(0);
	                }
	            }
	        });
	        
	        
	    }
	    
		public static ArrayList<String> nomsDesUtilisateurs(  ) {
			ArrayList<String> list = new ArrayList<String>();
			try { Connection connection = 
					(Connection) DriverManager.getConnection( url, user, passwd ) ;
				//String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND password='" + password + "'";
				String strSql = "SELECT nom FROM utilisateurs"; //  WHERE login=? AND password=?
				try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
//					statement.setString( 1, login );
//					statement.setString( 2, password );
					try ( ResultSet resultSet = statement.executeQuery() ) {
						while ( resultSet.next() ) { //(int id, int id_livre, String nom, String login, String password)	
									list.add(resultSet.getString( "nom" )); }
					}
				}
			} catch ( Exception exception ) {
				throw new RuntimeException( exception );
			}
			return list;
		}

	}

