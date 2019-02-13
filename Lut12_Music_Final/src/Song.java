import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID; 

public class Song {
	
	private static String songID;
	private String title;
	private int length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private Map<String, Artist> songArtists;
	
	private DbUtilities db;
	
	public Song(String title,int length,String releaseDate,String recordDate) {
		
		db = new DbUtilities();
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		UUID.fromString(songID);//creates UUID
		String sql = "INSERT INTO song (title,length,release_date,record_date) VALUES  ('" + title+"', '"+ length+ "','"+releaseDate+"','"+recordDate+"');";//creates a new object record
		System.out.println(sql);
		db.executeQuery(sql);
}
	public Song(String songID) {
		this.songID = songID;	//constructor
		db = new DbUtilities();
		String sql1 = "SELECT title,length,release_date,record_date from song WHERE song_id = "+ this.songID+";";//Retrieves an existing record from the database using songID as the key
	try {
			ResultSet rs = db.getResultSet(sql1);
			if(rs.next()) {
				this.title = rs.getString("title");
				this.length = rs.getInt("length");
				this.releaseDate = rs.getString("release_date");
				this.recordDate = rs.getString("record_date");
				//song object created
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void deleteArtist(String aristID) {
		db = new DbUtilities();
		String sql = "DELETE FROM song_artist WHERE fk_artist_id = "+ aristID+";";
		System.out.println(sql);
		db.executeQuery(sql);	
}
	public void deleteArtist2 (Artist artist) {
		db = new DbUtilities();
		String sql = "DELETE FROM song_artist WHERE fk_artist_id  "+ artist.getArtistID()+";";
		System.out.println(sql);
		db.executeQuery(sql);
}
	public void deleteSong(String songID) { 

		this.songID = songID;
		db = new DbUtilities();
		String sql = "DELETE FROM song WHERE song_id = "+ this.songID+";";//Deletes a song from the database using songID as the key
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public void addArtist(String artistID) {
		db = new DbUtilities();
		artistID = Artist.getArtistID();
		String sql = "INSERT INTO song_artist (fk_song_id,fk_artist_id) VALUES  ('" + songID+"', '"+artistID+"');";
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		String sql = "UPDATE title SET title = '"+title+"'WHERE song_id = "+ this.songID + ";"; 
		this.title = title;
		System.out.println(sql);
		db.executeQuery(sql);
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
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
	public static String getSongID(){
		return songID;
	}
	
	
	
	
	
}