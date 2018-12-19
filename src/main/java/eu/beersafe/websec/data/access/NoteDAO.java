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
import eu.beersafe.websec.logger.Logger;

public class NoteDAO {

	private static final String TABLE = "Notes";
	
	public List<Note> findAllByBeerId(int id) throws SQLException {
		
		List<Note> results = new ArrayList<Note>();
		
		public List<Note> findAllByUserId(int id) throws SQLException {
			
			List<Note> results = new ArrayList<Note>();

			try {
				try {
					
					Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Notes","root","");
					
					java.sql.PreparedStatement pr= cn.prepareStatement( "SELECT * FROM Notes where beerid like  '%?%'");
		             
					 pr.setInt(1,id);
		             pr.setString(2,created);
		             pr.setString(3,title);
		             pr.setString(4,content);
		             pr.setInt(5,IsPublicNote());
		             pr.setInt(6,userid);
		             pr.setInt(7,beerid);
		            rs =pr.executeQuery();

					while(rs.next()) {
						result = processItem(rs);
						
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				return result;
			}
	
	public List<Note> findAllByUserId(int id) throws SQLException {
		List<Note> results = new ArrayList<Note>();
		

		try {
			try {
				
				
				Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Notes","root","");
				
				java.sql.PreparedStatement pr= cn.prepareStatement( "SELECT * FROM Notes where userid like  '%?%'");
	             
				 pr.setString(1,id);
	             pr.setString(2,created);
	             pr.setString(3,title);
	             pr.setString(4,content);
	             pr.setString(5,isPublicNote());
	             pr.setInt(6,userid);
	             pr.setInt(7,beerid);
	            rs =pr.executeQuery();

				while(rs.next()) {
					result = processItem(rs);
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
	
	public Note findOneById(int id) throws SQLException {
		Note result = null;
		ResultSet rs = null;
		try {
			
			
			Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Notes","root","");
			
			java.sql.PreparedStatement pr= cn.prepareStatement( "SELECT * FROM Notes where id like  '%?%' ");
             
			 pr.setString(1,id);
             pr.setString(2,created);
             pr.setString(3,title);
             pr.setString(4,content);
             pr.setString(5,isPublicNotes());
             pr.setInt(6,userid);
             pr.setInt(7,beerid);
             rs =pr.executeQuery();

			while(rs.next()) {
				result = processItem(rs);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean updateNote(Note note) throws SQLException {
		boolean result = false;
		
		try {
			
			
			Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Notes","root","");
			
			java.sql.PreparedStatement pr= cn.prepareStatement( "UPDATE UPDATE 'Notes' SET (title, content, public) WHERE id=?");
			
			 pr.setString(1,id);
             pr.setString(2,created);
             pr.setString(3,title);
             pr.setString(4,content);
             pr.setString(5,isPublicNotes());
             pr.setInt(6,userid);
             pr.setInt(7,beerid);
             
			
             while(rs.next()){
                 result = true;
                 Note us=new Notes();
                 us.setId(rs.getInt("id"));
                 us.setTitle(rs.getString("title")) ;
                 us.setContent(rs.getString("content"));
                 //us.setisPublicNote(rs.getInt("public"));
             }
		}
		catch(Exception e) {
			throw new SQLException(e);
		}

		return result;
	}

	public boolean createNote(Note note) throws SQLException {
		boolean result = false;
	try {
			
			
			Connection cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:8443/Notes","root","");
			
			java.sql.PreparedStatement pr= cn.prepareStatement( "INSERT INTO Notes (title, content, created, public, beerid, userid) VALUES (1,2,3,4,5)");
			
			
			pr.getString(1,title);
			pr.getString(2,content);
			pr.getString(3,created);
			pr.getString(4,publicNote);
	        pr.getInt(5,userid);
	        pr.getInt(6,beerid); 
			while(rs.next()){
                 result = true;
                 Note us=new Notes();
                 
                 us.getTitle(rs.getString("title")) ;
                 us.getContent(rs.getString("content"));
                 us.getCreated(rs.getString("created"));
                 us.isPublicNote();
                 us.getUserid(rs.getInt("userid"));
                 us.getUserid(rs.getInt("beerid"));
             }
		}
		catch(Exception e) {
			throw new SQLException(e);
		}

		return result;
	}

	protected Note processItem(ResultSet rs) throws SQLException {
		return new Note(rs.getLong("id"), rs.getTimestamp("created"), rs.getString("title"), rs.getString("content"), rs.getBoolean("public"), rs.getLong("userid"), rs.getLong("beerid"));
	}
}
