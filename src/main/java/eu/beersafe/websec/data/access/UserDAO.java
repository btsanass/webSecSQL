package eu.beersafe.websec.data.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.beersafe.websec.data.objects.Beer;
import eu.beersafe.websec.data.objects.Note;
import eu.beersafe.websec.data.objects.User;
import eu.beersafe.websec.logger.Logger;

public class UserDAO {

	private static final String TABLE = "Users";
	
	public List<User> findAllByEmail(String email) throws SQLException {
		List<User> results = new ArrayList<User>();
		ResultSet rs = null;
	
		try {
			Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Users","root","");
			
			java.sql.PreparedStatement pr= cn.prepareStatement( "SELECT * FROM Notes where email like  '%?%'");
			pr.getInt(1,id);
			pr.getString(2,email);
			pr.getString(3,password);
			pr.getString(4,name);

			while(rs.next()){
                 result = true;
             }
		}
		catch(Exception e) {
			throw new SQLException(e);
		}
		return results;
	}
	
	public User findOneById(int id) throws SQLException {
		User result = null;
		
		String query = "SELECT * FROM " + TABLE + " WHERE id = " + id;
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Users","root","");
			
			java.sql.PreparedStatement pr= cn.prepareStatement( "SELECT * FROM Notes where id like  '%?%'");
			pr.getInt(1,id);
			pr.getString(2,email);
			pr.getString(3,password);
			pr.getString(4,name);

			while(rs.next()){
                 result = true;
             }
		}
		catch(Exception e) {
			throw new SQLException(e);
		}
		return results;
	}
	
	public void updatePassword(User user, String password) throws SQLException {
			try {
			
			
			Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Users","root","");
			
			java.sql.PreparedStatement pr= cn.prepareStatement( "UPDATE UPDATE 'Users' SET (password) WHERE id=?");
			
			pr.getInt(1,id);
			pr.getString(2,email);
			pr.getString(3,password);
			pr.getString(4,name);
             
             while(rs.next()){
                 
                 User us=new Users();
                 us.setPassword(rs.getString("password"));
                 result = true;
             }
		}
	}
	
	protected User processItem(ResultSet rs) throws SQLException {
		return new User(rs.getLong("id"), rs.getString("email"), rs.getString("password"), rs.getString("name"));
	}
}
