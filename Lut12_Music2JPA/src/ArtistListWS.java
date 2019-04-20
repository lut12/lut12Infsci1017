import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SongListWS
 */
@WebServlet("/ArtistListWS")
public class ArtistListWS extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistListWS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		ArtistManager am = new ArtistManager();
		String bandName = "";
		String searchType = "";
		
		if(request.getParameter("bandName") != null && request.getParameter("searchType") != null){
			bandName = request.getParameter("bandName");
			searchType = request.getParameter("searchType");
		}
		// If genreName and searchType are blank, than return everything.
		response.getWriter().print(am.getArtistList(bandName, searchType));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
