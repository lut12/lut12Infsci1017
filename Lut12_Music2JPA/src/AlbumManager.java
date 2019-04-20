/**
 * this class manages CRUD operations for the Album class
 * based on Dr. Babichenko's MusicJPA example code from the GenreManager class
 * @author Luke Tuite
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.json.JSONArray;

public class AlbumManager {
	
	/**
	 * uses an EntityManager to add an Album record to the database
	 * @param title
	 * @param releaseDate
	 * @param coverImagePath
	 * @param recordingCompany
	 * @param numberOfTracks
	 * @param pmrcRating
	 * @param length
	 */
	public void createAlbum(String title, String releaseDate, String coverImagePath, String recordingCompany, int numberOfTracks, String pmrcRating, int length) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Album al = new Album();
		
		al.setTitle(title);
		al.setReleaseDate(releaseDate);
		al.setCoverImagePath(coverImagePath);
		al.setRecordingCompany(recordingCompany);
		al.setNumberOfTracks(numberOfTracks);
		al.setPmrcRating(pmrcRating);
		al.setLength(length);
		
		em.persist(al);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}
	
	/**
	 * uses the albumID to find a record within the database and update its attributes as the user defines them
	 * @param albumID
	 * @param title
	 * @param releaseDate
	 * @param coverImagePath
	 * @param recordingCompany
	 * @param numberOfTracks
	 * @param pmrcRating
	 * @param length
	 */
	public void updateAlbum(String albumID, String title, String releaseDate, String coverImagePath, String recordingCompany, int numberOfTracks, String pmrcRating, int length) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album al = em.find(Album.class, albumID);
		
		if (!title.equals("")) {
			al.setTitle(title);
		}
		
		if (!releaseDate.equals("")) {
			al.setReleaseDate(releaseDate);
		}
		
		if (!coverImagePath.equals("")) {
			al.setCoverImagePath(coverImagePath);
		}
		
		if (!recordingCompany.equals("")) {
			al.setRecordingCompany(recordingCompany);
		}
		
		if (numberOfTracks != 0) {
			al.setNumberOfTracks(numberOfTracks);
		}
		
		if (!pmrcRating.equals("")) {
			al.setPmrcRating(pmrcRating);
		}
		
		if(length != 0) {
			al.setLength(length);
		}
		
		em.persist(al);
		em.getTransaction().commit();		
		em.close();
		emFactory.close();
	}
	/**
	 * uses an EntityManager to delete an Album record with the given ID
	 * @param albumID
	 */
	public void deleteAlbum(String albumID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album al = em.find(Album.class, albumID);
		em.remove(al);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
	}
	/**
	 * uses an EntityManager to find an Album record with the given ID and allows the user to access it (similar to a getter)
	 * @param albumID
	 * @return Album object
	 */
	public Album findAlbum(String albumID) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		Album al = em.find(Album.class, albumID);
		em.getTransaction().commit();
		em.close();
		emFactory.close();
		return al;
	}
	public JSONArray getAlbumList(String searchTerm, String searchType) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Lut12_Music2JPA");
		EntityManager em = emFactory.createEntityManager();
		
		// Note that you are querying the object grid, not the database!
		String qry = "SELECT al.albumID FROM Album al ";
		
		if(!searchTerm.equals("")) {
			if(searchType.equalsIgnoreCase("equals")){
				qry += "WHERE al.title = '" + searchTerm + "'";
			}
			else if(searchType.equalsIgnoreCase("begin")){
				qry += "WHERE al.title LIKE '" + searchTerm + "%'";
			}
			else if(searchType.equalsIgnoreCase("ends")){
				qry += "WHERE al.title LIKE '%" + searchTerm + "'";
			}
			else{
				qry += "WHERE al.title LIKE '%" + searchTerm + "%'";
			}
		}
		List<String> albumIDs = em.createQuery(qry).getResultList();
		JSONArray albumListJSON = new JSONArray();
		for(String albumID : albumIDs) {
			Album al = em.find(Album.class, albumID);
			albumListJSON.put(al.toJSON());
		}
		em.close();
		emFactory.close();
		
		return albumListJSON;
	}
		
}
