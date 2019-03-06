import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.*;
import java.util.*;
import javax.persistence.*;


	@Entity
	@Table(name="album")
	public class Album {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		@Column(name = "album_id")
		private String albumID;
		
		@Column(name = "title")
		private String title;
		
		@Column(name = "release_date")
		private String releaseDate;
		
		@Column(name = "recording_company_name")
		private String recordingCompany;
		
		@Column(name = "number_of_tracks")
		private int numberOfTracks;
		
		@Column(name = "pmrc_rating")
		private String pmrcRating;
		
		@Column(name = "cover_image_path")
		private String coverImagePath;
		
		@Column(name = "length")
		private int length;
	
	/*public Album(String title,String releaseDate,String recordingCompany,int numberOfTracks, String pmrcRating, int length) {
		
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
	public Album(String albumID) {
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
	*///}
	//all setters for database updating
	public void setAlbumID(String albumID) {
		this.albumID = albumID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getAlbumID() {
		
		return albumID;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCoverImagePath() {
		return coverImagePath;
	}
	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}
	public String getRecordingCompany() {
		return recordingCompany;
	}
	public void setRecordingCompany(String recordingCompany) {
		this.recordingCompany = recordingCompany;
	}
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}
	public String getPmrcRating() {
		return pmrcRating;
	}
	public void setPmrcRating(String pmrcRating) {
		this.pmrcRating = pmrcRating;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	/*public void addSong(Song song) {
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
	public void deleteSong(String songID) {
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
	public void deleteSong2 (Song song) {
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
	
	public void deleteAlbum(Album album)
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
	
	
		
		
	}*/
}
