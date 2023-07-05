package in.bhel.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;

/**
 * Servlet implementation class DrumNoFromCableCode
 */
@WebServlet("/DrumNoFromCableCode")
public class DrumNoFromCableCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
		response.setContentType("application/json");

		CableStoreDao csd = new CableStoreImpl();
		String table = request.getParameter("cableCode");
		ArrayList<String> al = csd.getDrumNoFromCableCode(table);
		JSONArray jArray = new JSONArray();
		int i = 0;
		while (i < al.size()) {
			jArray.add(al.get(i));
			i++;

		}
		PrintWriter out = response.getWriter();
		out.print(jArray);
		jArray.clear();
		out.flush();

	}
}
