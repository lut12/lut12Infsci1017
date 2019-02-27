import java.util.Map;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID; 

public class Song {
	
	private String songID;
	private String title;
	private int length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private Map<String, Artist> songArtists= new HashMap<String,Artist>();
	
	private DbUtilities db;
	private Connection conn;
	private PreparedStatement stmt;
	
	public Song(String title,int length,String releaseDate,String recordDate, Connection conn) {
		
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		UUID uuidSong = UUID.randomUUID();
		songID = uuidSong.toString();//creates UUID
		String sql = "INSERT INTO song (song_id, title,length,release_date,record_date) VALUES  (?,?,?,?,?);";//creates a new object record
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, songID);
			stmt.setString(2, title);
			stmt.setInt(3, length);
			stmt.setString(4, releaseDate);
			stmt.setString(5,recordDate);
			int i = stmt.executeUpdate();
			System.out.println(i+" records inserted"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
}
	public Song(String songID, Connection conn) {
		this.songID = songID;
		
		String sql1 = "SELECT title,length,release_date,record_date from song WHERE song_id = ?;";//Retrieves an existing record from the database using songID as the key
	try {
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1,songID);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				this.title = rs.getString("title");
				this.length = rs.getInt("length");
				this.releaseDate = rs.getString("release_date");
				this.recordDate = rs.getString("record_date");
				System.out.println(this.title);
				System.out.println(this.length);
				System.out.println(this.releaseDate);
				System.out.println(this.recordDate);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void deleteArtist(String artistID, Connection conn) {
		String sql = "DELETE FROM song_artist WHERE fk_artist_id = ?;";
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
	public void deleteArtist2 (Artist artist, Connection conn) {
		db = new DbUtilities();
		String sql = "DELETE FROM song_artist WHERE fk_artist_id = ? AND fk_song_id = ?;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, artist.getArtistID());
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
}
	public void deleteSong(String songID, Connection conn) { 

		this.songID = songID;
		String sql = "DELETE FROM song WHERE song_id = ?;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, songID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
	
	}
	public void addArtist(Artist artist, Connection conn) {
		db = new DbUtilities();
		String artistID = artist.getArtistID();
		String sql = "INSERT INTO song_artist (fk_song_id,fk_artist_id) VALUES  (?, ?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, songID);
			stmt.setString(2, artistID);
			songArtists.put(artist.getArtistID(), artist); //adds this artist to the songArtists map
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String songID, String title, Connection conn) {
		String sql = "UPDATE song SET title = ? 'WHERE song_id =?"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, songID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public int getLength() {
		return length;
	}
	public void setLength(Song song, int length, Connection conn) {
		String sql = "UPDATE song SET length = ? 'WHERE song_id =?"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, length);
			stmt.setString(2, song.getSongID());
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath, Connection conn) {
		String sql = "UPDATE song SET file_path = ? WHERE song_id =?;"; 
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, filePath);
			stmt.setString(2, this.songID);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public String getRecordDate() {
		return recordDate;
	}
	
	public Map<String, Artist> getSongArtists() {
		return songArtists;
	}
	public void setSongArtists(Map<String, Artist> songArtists) {
		this.songArtists = songArtists;
	}
	public DbUtilities getDb() {
		return db;
	}
	public void setDb(DbUtilities db) {
		this.db = db;
	}
	public String getSongID() {
		return songID;
	}
	
	
	
	
	
	
}