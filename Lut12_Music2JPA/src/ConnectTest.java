import java.sql.*;
import java.net.URL;

public class ConnectTest {

	public static void main(String[] args) {
		String server = "sis-teach-01.sis.pitt.edu";
		String port = "3306";
		String userName = "infsci1017_2019";
		String password = "infsci1017_2019!";
		String dbName = "music2019";
		
		// Step 1: Define connection string
		
		String mySqlConn = "jdbc:mysql://" + server + "/" + dbName + "?user=" + userName + "&password=" + password;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(mySqlConn);
			
			String sql = "INSERT INTO genre (genre_name, description) VALUES ('blues', 'very nice music');";
			Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
			
			Statement preparedStatement = conn.createStatement();
			ResultSet rs = preparedStatement.executeQuery(sql); // Return ResultSet
            
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
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

		/*Artist a = new Artist();
		a.setFirstName("Tom");
		a.setLastName("Morello");
		a.setBandName("Rage Against The Machine");
		a.setBio("The guitarist of Rage Against the Machine");
		a.insertArtist("Tom", "Morello", "Rage Against the Machine", "Guitarist for Rage Against the Machine"); */
		
		
		
	}

}
