import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class SongManager {
	public void createSong(String title, int length, String filePath, String releaseDate, String recordDate){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Song s = new Song();
		
		// Song a = new Song();
		s.setSongID(UUID.randomUUID().toString());
		
		//s.setSongID(SongID);
		s.setTitle(title);
		s.setLength(length);
		s.setFilePath(filePath);
		s.setReleaseDate(releaseDate);
		s.setRecordDate(recordDate);
		
		
		// Add the Song object to the ORM object grid
		em.persist(s);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	
	public void updateSong(String SongID, String title, int length, String filePath, String releaseDate, String recordDate){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song g = em.find(Song.class, SongID);
		
		if(!title.equals("")){
			g.setTitle(title);
		}
		
		if(!(length == 0)){
			g.setLength(length);
		}
		
		if(!filePath.equals("")) {
			g.setFilePath(filePath);
		}
		if(!releaseDate.equals("")) {
			g.setReleaseDate(releaseDate);
		}
		if(!recordDate.equals("")) {
			g.setRecordDate(recordDate);
		}
		em.persist(g);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteSong(String SongID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song g = em.find(Song.class, SongID);
		
		em.remove(g);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	public Song findSong(String songID)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Song g = em.find(Song.class, songID);
		
		System.out.println(g.getSongID());
		System.out.println(g.getTitle());
		System.out.println(g.getLength());
		System.out.println(g.getFilePath());
		System.out.println(g.getReleaseDate());
		System.out.println(g.getReleaseDate());
		
		em.persist(g);
		
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
		
		return g;
	}
}
