/**
 * this class manages CRUD operations for the Artist class
 * based on Dr. Babichenko's MusicJPA example code from the GenreManager class
 * @author Luke Tuite
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.JSONArray;


public class ArtistManager {
	
	public JSONArray getArtistList(String searchTerm, String searchType){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		
		// Note that you are querying the object grid, not the database!
		String qry = "SELECT a.artistID FROM Artist a ";
		
		if(!searchTerm.equals("")){
			if(searchType.equalsIgnoreCase("equals")){
				qry += "WHERE a.bandName = '" + searchTerm + "'";
			}
			else if(searchType.equalsIgnoreCase("begin")){
				qry += "WHERE a.bandName LIKE '" + searchTerm + "%'";
			}
			else if(searchType.equalsIgnoreCase("ends")){
				qry += "WHERE a.bandName LIKE '%" + searchTerm + "'";
			}
			else{
				qry += "WHERE a.bandName LIKE '%" + searchTerm + "%'";
			}
		}
		
		List<String> artistIDs = em.createQuery(qry).getResultList();
		JSONArray artistListJSON = new JSONArray();
		for(String artistID : artistIDs) {
			Artist a = em.find(Artist.class, artistID);
			artistListJSON.put(a.toJSON());
		}
		em.close();
		emFactory.close();
		
		return artistListJSON;
	}
	/**
	 * uses an EntityManager to create a new Artist record in the database
	 * @param firstName
	 * @param lastName
	 * @param bandName
	 * @param bio
	 */
	public void createArtist(String firstName, String lastName, String bandName, String bio) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Artist a = new Artist();
		
		a.setFirstName(firstName);
		a.setLastName(lastName);
		a.setBandName(bandName);
		a.setBio(bio);
		
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}
	/**
	 * pulls an Artist object from the database based on its ID and then edits its attributes
	 * @param artistID
	 * @param firstName
	 * @param lastName
	 * @param bandName
	 * @param bio
	 */
	public void updateArtist(String artistID, String firstName, String lastName, String bandName, String bio) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
		
		if (!firstName.equals("")) {
			a.setFirstName(firstName);
		}
		
		if (!lastName.equals("")) {
			a.setLastName(lastName);
		}
		
		if (!bandName.equals("")) {
			a.setBandName(bandName);
		}
		
		if (!bio.equals("")) {
			a.setBio(bio);
		}
		
		em.persist(a);
		em.getTransaction().commit();		
		em.close();
		emFactory.close();
	}
	/**
	 * deletes an Artist record with the given ID from the database
	 * @param artistID
	 */
	public void deleteArtist(String artistID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
		em.remove(a);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}
	/**
	 * retrieves an Artist record with the given ID from the database
	 * @param artistID
	 * @return Artist object
	 */
	public Artist findArtist(String artistID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Artist a = em.find(Artist.class, artistID);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
		return a;
	}
}
