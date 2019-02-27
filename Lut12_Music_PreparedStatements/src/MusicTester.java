import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MusicTester
{
	public static void main(String [] args)
	{	//pulled the connection syntax from connecttest in order to create a connection object
		String server = "sis-teach-01.sis.pitt.edu";
		String port = "3306";
		String userName = "infsci1017_2019";
		String password = "infsci1017_2019!";
		String dbName = "music2019";
		Connection conn = null;
		
		String mySqlConn = "jdbc:mysql://" + server + "/" + dbName + "?user=" + userName + "&password=" + password;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(mySqlConn);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//all statements pass in the connection (conn) to establish a connection with the database
		
		//select statements for the object
		//Song s1 = new Song("f632da70-03d9-45b5-aef5-841ca2fd2d01", conn);
		//System.out.println(s1.getTitle());
		//System.out.println(s1.getLength());
		//System.out.println(s1.getRecordDate());
		//System.out.println(s1.getReleaseDate());
		
		//Artist a1 = new Artist("0208d02c-191e-4e58-9103-f474b9253581", conn);
		//System.out.println(a1.getFirstName());
		//System.out.println(a1.getLastName());
		//System.out.println(a1.getBandName());
		//System.out.println(a1.getBio());
		
		//Album b1 = new Album("3823f03f-a519-42c5-a23c-b094f6ea35e7", conn);
		//System.out.println(b1.getTitle());
		//System.out.println(b1.getReleaseDate());
		//System.out.println(b1.getCoverImagePath());
		//System.out.println(b1.getRecordingCompany());
		
		
		//Artist a3 = new Artist("newestguy", "Maus", "John Maus", conn); //creates a new artist
		//Artist a2 = new Artist("37bc01d1-4c6e-4e7c-afcc-25a1b661dd00", conn);	//uses an artist's UUID and selects all its info
		//a2.setBandName("John Maus", conn);	//setters for an existing artist
		//a2.setFirstName("hisfirstname", conn);
		//a2.setLastName("hislastname", conn);
		//a2.setBio("testMusiciann", conn);
		//a2.deleteArtist(conn);
		
		
		//Song s3 = new Song("Here's a new song", 4,"1969-05-08 00:00:00", "1969-05-08 00:00:00", conn); //creates a new song
		//Song s2 = new Song("f632da70-03d9-45b5-aef5-841ca2fd2d01", conn);//gets song info
		//s3.setFilePath("songs/thecombine.mp3", conn);
		//s3.addArtist(a2, conn); //adds an artist object in the relations table, also adds this artist to the Map datatype
		//s2.deleteArtist("03ce000c-08a7-4bbb-8919-0565bbde3742", conn);	//deletes by an artist ID
		//s2.deleteArtist2(a2, conn);	//deletes by artist object
		//s2.deleteSong("0304f2e8-f12b-4938-9d87-3323c51ee105",conn); 	
		
		
		
		
		
		
		//Album b3 = new Album("Screen Memories", "1969-05-08 00:00:00", "Epic", 10, "m", 10, conn);	//creates a new album in the database
		
		
		//Album b2 = new Album("cbc0fada-356c-4713-acf8-cf8e6fa51643", conn);//gets an existing album's info
		//b2.setTitle("Screen MemoriesTest", conn);		//album setters
		//b2.setReleaseDate("1969-05-08 00:00:00", conn);
		//b2.setCoverImagePath("images/revolver.jpg", conn);
		//b2.setRecordingCompany("Epic", conn);
		//b2.addSong(s2); //adds a song object in the relations table, also adds this song to the Map datatype
		//b2.deleteSong("0304f2e8-f12b-4938-9d87-3323c51ee105");	//deletes song by ID
		///b2.deleteSong2(s2);	//deletes song by object
		//b2.deleteAlbum("c964a7fe-0528-11e8-a67a-005056881e07", conn);	//deletes an album by its uuid
		
		
		
		
		
	}
}
