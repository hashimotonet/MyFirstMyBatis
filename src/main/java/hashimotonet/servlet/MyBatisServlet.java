package hashimotonet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hashimotonet.db.SqlSessionHandler;

/**
 * Servlet implementation class MyBatisServlet
 */
@WebServlet(description = "A Servlet uses MyBatis as O/RMapper.", urlPatterns = { "/MyBatisServlet" })
public class MyBatisServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected static final Logger parentLogger = LogManager.getLogger();

	private Logger log = parentLogger;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBatisServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			log.info(Charset.forName("Windows-31J").displayName());
			log.debug(System.getProperties().toString().replaceAll(",", "\r\n"));

			response.setCharacterEncoding(Charset.forName("Windows-31J").displayName());
			response.setContentType("text/html;charset=Windows-31J");
			response.getWriter().append("Served at: ").append(request.getContextPath()).append("<br/><hr/>");

			PrintWriter out = response.getWriter();

			String output = getFromRepository().toString();

			log.info("output = " + output);
			out.println(output);

		} catch (IOException e) {
			log.catching(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected List<Map<String, Object>> getFromRepository()
			throws IOException {
		SqlSessionHandler sessionHandler = new SqlSessionHandler();
		List<Map<String,Object>> result = sessionHandler.dbAccess();

		return result;
	}

}
