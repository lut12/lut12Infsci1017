import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public class Album {
	private String albumID;
	private String title;
	private String releaseDate;
	private String coverImagePath;
	private String recordingCompany;
	private int numberOfTracks;
	private String pmrcRating;
	private int length;
	private Map<String,Song>albumSongs;
	private DbUtilities db;
	
	public Album(String title,String releaseDate,String coverImagePath,String recordingCompany) {
		
		db = new DbUtilities();
		this.title = title;
		this.releaseDate = releaseDate;
		this.coverImagePath= coverImagePath;
		this.recordingCompany = recordingCompany;
		UUID.fromString(albumID);//creates UUID
		String sql = "INSERT INTO song (title,release_date,cover_image_path,recording_company) VALUES  ('" + title+"', '"+ releaseDate+ "','"+coverImagePath+"','"+recordingCompany+"');";//creates a new object record
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public Album(String albumID) {
		this.albumID = albumID;	//constructor
		db = new DbUtilities();
		String sql = "SELECT title, release_date, cover_image_path, recording_company_name from album WHERE album_id = "+this.albumID+";";
		try {
			ResultSet rs = db.getResultSet(sql);
			
			if(rs.next()) {
			
				this.title = rs.getString("title");
				this.length = rs.getInt("release_date");
				this.releaseDate = rs.getString("cover_image_path");
				this.recordingCompany= rs.getString("recording_company_name");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//all setters for database updating
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		String sql = "UPDATE album SET title = '"+title+"'WHERE album_id = "+ this.albumID + ";"; 
		this.title = title;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		String sql = "UPDATE album SET release_date = '"+releaseDate+"'WHERE album_id = "+ this.albumID + ";"; 
		this.releaseDate = releaseDate;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public String getCoverImagePath() {
		return coverImagePath;
	}
	public void setCoverImagePath(String coverImagePath) {
		String sql = "UPDATE album SET cover_image_path = '"+coverImagePath+"'WHERE album_id = "+ this.albumID + ";"; 
		this.coverImagePath = coverImagePath;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public String getRecordingCompany() {
		return recordingCompany;
	}
	public void setRecordingCompany(String recordingCompany) {
		String sql = "UPDATE album SET recording_company_name = '"+recordingCompany+"'WHERE album_id = "+ this.albumID + ";"; 
		this.recordingCompany = recordingCompany;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public int getNumberOfTracks() {
		return numberOfTracks;
	}
	public void setNumberOfTracks(int numberOfTracks) {
		String sql = "UPDATE album SET numberOfTracks= '" + numberOfTracks + "';";
		this.numberOfTracks = numberOfTracks;
		System.out.println(sql);
	}
	public String getPmrcRating() {
		return pmrcRating;
	}
	public void setPmrcRating(String pmrcRating) {
		String sql = "UPDATE album SET pmrcRating= '" + pmrcRating + "';";
		this.pmrcRating= pmrcRating;
		System.out.println(sql);
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		String sql = "UPDATE album SET length= '" + length + " WHERE album_id = "+this.albumID+"';";
		this.length = length;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public void addSong(String songID) {
		db = new DbUtilities();
		songID =  Song.getSongID();
		String sql = "INSERT INTO song_album (fk_song_id,fk_album_id) VALUES  ('" + albumID+"', '"+ songID +"');";
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public void deleteSong(String songID) {
		db = new DbUtilities();
		String sql = "DELETE FROM song_artist WHERE fk_song_id = "+ songID+";";
		System.out.println(sql);
		db.executeQuery(sql);
		
	}
	public void deleteSong2 (Song song) {
		db = new DbUtilities();
		
		String sql = "DELETE FROM song_artist WHERE fk_song_id  "+ song.getSongID()+";";
		System.out.println(sql);
		db.executeQuery(sql);
		
	}
	
	public void deleteAlbum(String artistID)
	{
		this.albumID = albumID;
		db = new DbUtilities();
		String sql = "DELETE FROM album WHERE album_id= "+ this.albumID+";";//Deletes an album from the database with AlbumID as key
		System.out.println(sql);
		db.executeQuery(sql);
	
		
		
	}
}
