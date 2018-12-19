package eu.beersafe.websec.data.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eu.beersafe.websec.data.objects.Beer;
import eu.beersafe.websec.logger.Logger;

public class BeerDAO {
	
	private static final String TABLE = "Beers";
	
	public List<Beer> findAll() throws SQLException {
		return findAllByName("");
	}
	
	public List<Beer> findAllByName(String filter) throws SQLException {
		List<Beer> results = new ArrayList<Beer>();
		
			try {
				
				Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Beers","root","");
				
				java.sql.PreparedStatement pr= cn.prepareStatement( "SELECT * FROM Beers where name like  '%?%'");
				 pr.setInt(1,id);
	             pr.setString(2,name);
	             pr.setInt(3,alcohol);
	             pr.setString(4,color);
	             pr.setString(5,category);
	             pr.setString(6,description);
				while(rs.next()) {
					result = processItem(rs);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
	
	public Beer findOneById(int id) throws SQLException {
		Beer result = null;
		
		List<Beer> results = new ArrayList<Beer>();
		
		try {
			
			Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Beers","root","");
			
			java.sql.PreparedStatement pr= cn.prepareStatement( "SELECT * FROM Beers where id like  '%?%'");
			 pr.setInt(1,id);
             pr.setString(2,name);
             pr.setInt(3,alcohol);
             pr.setString(4,color);
             pr.setString(5,category);
             pr.setString(6,description);
			while(rs.next()) {
				result = processItem(rs);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	protected Beer processItem(ResultSet rs) throws SQLException {
		return new Beer(rs.getLong("id"), rs.getString("name"), rs.getString("image"), rs.getDouble("alcohol"), rs.getString("color"), rs.getString("category"), rs.getString("description"));
	}
}
