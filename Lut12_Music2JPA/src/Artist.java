
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.sql.*;
import javax.persistence.*;
import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name="artist")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "artist_id")
	private String artistID;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "band_name")
	private String bandName;
	
	@Column(name = "bio")
	private String bio;
	
	
/*	public Artist(String firstName,String lastName,String bandName) {
	
		this.conn = conn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName = bandName;
		UUID uuidArtist = UUID.randomUUID();
		artistID = uuidArtist.toString();//creates UUID
		String sql = "INSERT INTO artist (artist_id, first_name,last_name,band_name) VALUES  (?, ?, ? ,?);";//creates a new object record
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
	public Artist(String artistID) {
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
	//all setters for database updating
	public String getFirstName() {
		return firstName;
	}*/
	public void setArtistID(String artistID)
	{
		this.artistID = artistID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	/*public void deleteArtist(String artistID)
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
	
	}*/
	public String getArtistID() {
		return artistID;
	}
	public String getFirstName() {
		return firstName;
	}
	public JSONObject toJSON(){
		JSONObject artistJson = new JSONObject();
		try {
			artistJson.put("artist_id", this.artistID);
			artistJson.put("first_name", this.firstName);
			artistJson.put("last_name", this.lastName);
			artistJson.put("band_name", this.bandName);
			artistJson.put("bio", this.bio);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artistJson;
		
	}
	
}

