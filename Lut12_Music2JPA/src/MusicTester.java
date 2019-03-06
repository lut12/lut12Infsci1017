import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MusicTester
{
	public static void main(String [] args)
	{
		//Uncomment manager object creation to reach each query
		AlbumManager bm = new AlbumManager();
		bm.createAlbum("Either Or", "2014-10-08 00:00:00" , "Columbia", 12, "Mature", 5);
		//bm.updateAlbum("69b8f309-16c0-4d42-89b4-b47670a114d7", "Either Orr", "2014-10-08 00:00:00" , "Columbia", 13, "Mature", 5);
		//bm.findAlbum("69b8f309-16c0-4d42-89b4-b47670a114d7");
		//bm.deleteAlbum("69b8f309-16c0-4d42-89b4-b47670a114d7");
		
		//Uncomment manager object creation to reach each query
		//ArtistManager am = new ArtistManager();
		//am.createArtist("Elliot", "Smith", "Elliot Smith", "He is dead");
		//am.updateArtist("057613cf-6f2d-4039-8147-83d01ed49289", "Elliot", "Smith", "Elliot Smith", "He is still dead");
		//am.findArtist("64dd8eb6-0801-4fff-9cab-f75b0ca8108f");
		//am.deleteArtist("64dd8eb6-0801-4fff-9cab-f75b0ca8108f");
		
		//Uncomment manager object creation to reach each query
		//SongManager sm = new SongManager();
		//sm.createSong("Speed Trials", 4, "songs/elliotsmith/speedtrials.mp3", "2001-10-10 00:00:00", "2001-10-10 00:00:00");
		//sm.updateSong("0304f2e8-f12b-4938-9d87-3323c51ee105", "Speed Trials2", 4, "songs/elliotsmith/speedtrials.mp3", "2001-10-10 00:00:00", "2001-10-10 00:00:00");
		//sm.findSong("55ca3f81-6f0e-42e5-a759-704c39c066b0");
		//sm.deleteSong("b6d62186-3988-4bd6-9eb9-bd5eedb37a57");
	}
}
