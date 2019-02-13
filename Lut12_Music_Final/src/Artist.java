
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;



import java.util.*;
public class Artist {
	private static String artistID;
	private String firstName;
	private String lastName;
	private String bandName;
	private String bio;
	private DbUtilities db;
	
	public Artist(String firstName,String lastName,String bandName,String bio) {
		
		db = new DbUtilities();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName = bandName;
		this.bio = bio;
		UUID.fromString(artistID);//Generates a songID using  java.util.UUID.randomUUID() method
		String sql = "INSERT INTO song (first_name,last_name,band_name, bio) VALUES  ('" + firstName+"', '"+ lastName+ "','"+bandName+"','"+bio+"');";//creates a new object record
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public Artist(String artistID) {
		this.artistID = artistID;
		db = new DbUtilities();
		String sql = "SELECT first_name, last_name, band_name, bio from artist WHERE artist_id = "+this.artistID+";";
		try {
			ResultSet rs = db.getResultSet(sql);
			
			if(rs.next()) {
			
				this.firstName = rs.getString("first_name");
				this.lastName = rs.getString("last_name");
				this.bandName = rs.getString("band_name");
				this.bio = rs.getString("bio");
			}
			 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		String sql = "UPDATE artist SET first_name = '"+firstName+"'WHERE artist_id = "+ this.artistID + ";"; 
		this.firstName = firstName;
		System.out.println(sql);
		db.executeQuery(sql);
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		String sql = "UPDATE artist SET last_name = '"+lastName+"'WHERE artist_id = "+ this.artistID + ";"; 
		this.firstName = firstName;
		System.out.println(sql);
		db.executeQuery(sql);
		
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		String sql = "UPDATE artist SET band_name = '"+bandName+"'WHERE artist_id = "+ this.artistID + ";"; 
		this.firstName = firstName;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		String sql = "UPDATE artist SET bio = '"+ bio+"'WHERE artist_id = "+ this.artistID + ";"; 
		this.firstName = firstName;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public static String getArtistID() {
		return artistID;
	}
	public void deleteArtist(String artistID)
	{
		this.artistID = artistID;
		db = new DbUtilities();
		String sql = "DELETE FROM artist WHERE artist_ID = "+ this.artistID+";";//Deletes a song from the database using songID as the key
		System.out.println(sql);
		db.executeQuery(sql);
	
	}
	/*public String insertArtist(String firstName, String lastName, String bandName, String bio)
	{
		db = new DbUtilities();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName = bandName;
		this.bio = bio;
		
		String sql = "INSERT INTO artist (first_name, last_name, band_name, bio) VALUES ('" + artistID + "', '" + firstName + "', '" + lastName + "', '" + bandName + "','" + bio +"');";
		System.out.println(sql);
		
		return(sql);
	}*/
}

