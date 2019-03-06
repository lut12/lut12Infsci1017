import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class AlbumManager {
	public void createAlbum(String title, String releaseDate, String recordingCompany, int numberOfTracks, String pmrcRating, int length){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Album g = new Album();
		
		// Album a = new Album();
		g.setAlbumID(UUID.randomUUID().toString());
		
		//g.setAlbumID(AlbumID);
		g.setTitle(title);
		g.setReleaseDate(releaseDate);
		g.setRecordingCompany(recordingCompany);
		g.setNumberOfTracks(numberOfTracks);
		g.setPmrcRating(pmrcRating);
		g.setLength(length);
		
		
		// Add the Album object to the ORM object grid
		em.persist(g);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	
	public void updateAlbum(String AlbumID, String title, String releaseDate, String recordingCompany, int numberOfTracks, String pmrcRating, int length){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album g = em.find(Album.class, AlbumID);
		
		if(!title.equals("")){
			g.setTitle(title);
		}
		
		if(!releaseDate.equals("")){
			g.setReleaseDate(releaseDate);
		}
		
		if(!recordingCompany.equals("")) {
			g.setRecordingCompany(recordingCompany);
		}
		if(!(numberOfTracks == 0)) {
			g.setNumberOfTracks(numberOfTracks);
		}
		if(!pmrcRating.equals("")) {
			g.setPmrcRating(pmrcRating);
		}
		if(!(length == 0)) {
			g.setLength(length);
		}
		em.persist(g);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteAlbum(String AlbumID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album g = em.find(Album.class, AlbumID);
		
		em.remove(g);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	public Album findAlbum(String albumID)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album g = em.find(Album.class, albumID);
		
		System.out.println(g.getAlbumID());
		System.out.println(g.getTitle());
		System.out.println(g.getReleaseDate());
		System.out.println(g.getCoverImagePath());
		System.out.println(g.getRecordingCompany());
		System.out.println(g.getNumberOfTracks());
		System.out.println(g.getPmrcRating());
		System.out.println(g.getLength());
		
		em.persist(g);
		
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
		
		return g;
	}
}
