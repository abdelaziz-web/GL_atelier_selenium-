package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import DAO.*;

public class agent_impl implements agent_interface {
	
	

	private DAOFactory          daoFactory;

    public agent_impl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
    
    public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
   	    for ( int i = 0; i < objets.length; i++ ) {
   	        preparedStatement.setObject( i + 1, objets[i] );
   	    }
   	    return preparedStatement;
   	}
	
	public void create(agent Agent) throws SQLException {
		// TODO Auto-generated method stub

		
final String SQL_SELECT_PAR_NOM = "INSERT INTO users (fullName,username,email,phonenumber,password,gender ) VALUES (?,?,?,?,?,?) ;"  ;

		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	   // ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	       connexion = daoFactory.getConnection();
	       preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, Agent.getFullname() ,Agent.getUsername() ,
	    		   Agent.getEmail()   ,
	    		   Agent.getNumber() ,
	    		   Agent.getPassword(),
	    		   Agent.getGender()
	       );
	       preparedStatement.execute();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	 //ClosingAll( resultSet, preparedStatement, connexion );	
	    }
	          
		
		
	}

}
