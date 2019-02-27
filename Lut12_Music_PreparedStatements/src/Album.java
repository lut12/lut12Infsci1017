import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;
import java.sql.*;
import java.util.*;

public class Album {
	private String albumID;
	private String title;
	private String releaseDate;
	private String coverImagePath;
	private String recordingCompany;
	private int numberOfTracks;
	private String pmrcRating;
	private int length;
	private Map<String,Song>albumSongs = new HashMap<String,Song>();
	private Connection conn;
	private PreparedStatement stmt;
	
	public Album(String title,String releaseDate,String recordingCompany,int numberOfTracks, String pmrcRating, int length, Connection conn) {
		
		this.title = title;
		this.releaseDate = releaseDate;
		this.recordingCompany = recordingCompany;
		this.numberOfTracks= numberOfTracks;
		this.pmrcRating= pmrcRating;
		this.length = length;
		UUID uuidAlbum= UUID.randomUUID();
		albumID = uuidAlbum.toString();//creates UUID
		String sql = "INSERT INTO album (album_id, title, release_date, recording_company_name,number_of_tracks, pmrc_rating, length) VALUES  (?,?,?,?,?,?,?);";//creates a new object record
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, albumID);
			stmt.setString(2, title);
			stmt.setString(3, releaseDate);
			stmt.setString(4, recordingCompany);
			stmt.setInt(5, numberOfTracks);
			stmt.setString(6, pmrcRating);
			stmt.setInt(7, length);
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println(i+" records inserted"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public Album(String albumID, Connection conn) {
		this.albumID = albumID;	//constructor
		String sql = "SELECT title, release_date, cover_image_path, recording_company_name from album WHERE album_id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, albumID);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
			
				this.title = rs.getString("title");
				this.length = rs.getInt("release_date");
				this.releaseDate = rs.getString("cover_image_path");
				this.recordingCompany= rs.getString("recording_company_name");
				System.out.println(this.title);
				System.out.println(this.length);
				System.out.println(this.releaseDate);
				System.out.println(this.recordingCompany);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//all setters for database updating
	public String getTitle() {
		return title;
	}
	public void setTitle(String title, Connection conn) {
		String sql = "UPDATE album SET title = ? WHERE album_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, albumID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	private String getAlbumID() {
		
		return albumID;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Album album, String releaseDate, Connection conn) {
		String sql = "UPDATE album SET release_date = ? WHERE album_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, releaseDate);
			stmt.setString(2, album.getAlbumID());
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public String getCoverImagePath() {
		return coverImagePath;
	}
	public void setCoverImagePath(String coverImagePath, Connection conn) {
		String sql = "UPDATE album SET cover_image_path = ? WHERE album_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, coverImagePath);
			stmt.setString(2, albumID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public String getRecordingCompany() {
		return recordingCompany;
	}
	public void setRecordingCompany(String recordingCompany, Connection conn) {
		String sql = "UPDATE album SET recording_company_name = ? WHERE album_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, recordingCompany);
			stmt.setString(2, albumID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	public void setNumberOfTracks(int numberOfTracks, Connection conn) {
		String sql = "UPDATE album SET number_of_tracks = ? WHERE album_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, numberOfTracks);
			stmt.setString(2, albumID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public String getPmrcRating() {
		return pmrcRating;
	}
	public void setPmrcRating(String pmrcRating, Connection conn) {
		String sql = "UPDATE album SET pmrc_rating = ? WHERE album_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pmrcRating);
			stmt.setString(2, albumID);
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
	public void setLength(int length, Connection conn) {
		String sql = "UPDATE album SET length = ? WHERE album_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, length);
			stmt.setString(2, albumID);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public void addSong(Song song, Connection conn) {
		String sql = "INSERT INTO song_album (fk_song_id,fk_album_id) VALUES  (?,?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, song.getSongID());
			System.out.println(albumID);
			albumSongs.put(song.getSongID(), song); //adds the song object to the albumSongs map
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	public void deleteSong(String songID, Connection conn) {
		String sql = "DELETE FROM song_artist WHERE fk_song_id = ?;";
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
	public void deleteSong2 (Song song, Connection conn) {
		String sql = "DELETE FROM song_artist WHERE fk_song_id  ?;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, song.getSongID());
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
	}
	
	public void deleteAlbum(Album album, Connection conn)
	{
		String sql = "DELETE FROM album WHERE album_id = ?;";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, album.getAlbumID());
			System.out.println(stmt);
			int i = stmt.executeUpdate();
			System.out.println(i+" records updated"); 
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
	
	
		
		
	}
}
