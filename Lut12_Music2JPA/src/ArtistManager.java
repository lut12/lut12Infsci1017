import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.UUID;

public class ArtistManager {
	public void createArtist(String firstName, String lastName, String bandName, String bio){
		EntityManagerFactory emFactory = 
				Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Artist g = new Artist();
		
		// Artist a = new Artist();
		g.setArtistID(UUID.randomUUID().toString());
		
		//g.setArtistID(ArtistID);
		g.setFirstName(firstName);
		g.setLastName(lastName);
		g.setBandName(bandName);
		g.setBio(bio);
		
		
		// Add the Artist object to the ORM object grid
		em.persist(g);
		
		// Commit transaction
		em.getTransaction().commit();
		
		// Close connection to persistence manager
		em.close();
		emFactory.close();
	}
	
	
	public void updateArtist(String ArtistID, String firstName, String lastName, String bandName, String bio){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist g = em.find(Artist.class, ArtistID);
		
		if(!firstName.equals("")){
			g.setFirstName(firstName);
		}
		
		if(!lastName.equals("")){
			g.setLastName(lastName);
		}
		
		if(!bandName.equals("")) {
			g.setBandName(bandName);
		}
		if(!bio.equals("")) {
			g.setBio(bio);
		}
		em.persist(g);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	
	public void deleteArtist(String ArtistID){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist g = em.find(Artist.class, ArtistID);
		
		em.remove(g);
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
	}
	public Artist findArtist(String artistID)
	{
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist g = em.find(Artist.class, artistID);
		
		System.out.println(g.getArtistID());
		System.out.println(g.getFirstName());
		System.out.println(g.getLastName());
		System.out.println(g.getBandName());
		System.out.println(g.getBio());
		
		
		em.persist(g);
		
		em.getTransaction().commit();
		
		em.close();
		emFactory.close();
		
		return g;
	}
}
