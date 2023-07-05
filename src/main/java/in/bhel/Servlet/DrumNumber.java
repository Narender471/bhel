package in.bhel.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;

/**
 * Servlet implementation class DrumNumber
 */
@WebServlet("/DrumNumber")
public class DrumNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String cableCode = request.getParameter("cableCode");
		String dbNo = request.getParameter("dbNo");
		CableStoreDao csd = new CableStoreImpl();
		TreeSet<String> hs = csd.getDrumNumber(cableCode, dbNo);
		JSONArray jArray = new JSONArray();
		for (String d : hs) {
			jArray.add(d);
		}
		out.print(jArray);
		out.flush();
	}

}
