
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.sql.*;
public class Artist {
	private String artistID;
	private String firstName;
	private String lastName;
	private String bandName;
	private String bio;
	private Connection conn;
	private PreparedStatement stmt;
	
	public Artist(String firstName,String lastName,String bandName, Connection conn) {
	
		this.conn = conn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName = bandName;
		UUID uuidArtist = UUID.randomUUID();
		artistID = uuidArtist.toString();//creates UUID 
		String sql = "INSERT INTO artist (artist_id, first_name,last_name,band_name) VALUES  (?, ?, ? ,?);"; //creates the new artist
		try {
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, artistID);
		stmt.setString(2, firstName);
		stmt.setString(3, lastName);
		stmt.setString(4, bandName);
		int i = stmt.executeUpdate();
		System.out.println(i+" records inserted"); 
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public Artist(String artistID, Connection conn) {
		this.artistID = artistID;
		String sql = "SELECT first_name, last_name, band_name, bio from artist WHERE artist_id =?;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,this.artistID);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
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
	public void setFirstName(String firstName, Connection conn) {
		String sql = "UPDATE artist SET first_name = ? WHERE artist_id = ?"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, artistID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName, Connection conn) {
		String sql = "UPDATE artist SET last_name = ? WHERE artist_id = ?"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, lastName);
			stmt.setString(2, artistID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName, Connection conn) {
		String sql = "UPDATE artist SET band_name = ? WHERE artist_id = ?"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bandName);
			stmt.setString(2, artistID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio, Connection conn) {
		String sql = "UPDATE artist SET bio = ? WHERE artist_id = ?;"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bio);
			stmt.setString(2, this.artistID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public void deleteArtist(Connection conn)
	{
		this.artistID = artistID;
		String sql = "DELETE FROM artist WHERE artist_ID = ?;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, artistID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
	
	}
	public String getArtistID() {
		return artistID;
	}
	
}

