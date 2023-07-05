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
import org.json.simple.JSONObject;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;
import in.bhel.entity.CableStore;

/**
 * Servlet implementation class CableData
 */
@WebServlet("/CableData")
public class CableData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CableData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
		response.setContentType("application/json");

		JSONArray jArray = new JSONArray();

		String table = request.getParameter("cableCode");
		PrintWriter out = response.getWriter();

		CableStoreDao csd = new CableStoreImpl();
		ArrayList<CableStore> al = csd.getCableData(table);
		for (CableStore cs : al) {
			JSONObject jobj = new JSONObject();
			jobj.put("cableCode", cs.getCableCode());
			jobj.put("dbDate", cs.getDbDate());
			jobj.put("drumNo", cs.getDrumNo());
			jobj.put("drumType", cs.getDrumType());
			jobj.put("status", cs.getStatus());
			jobj.put("uniqueCode", cs.getUniqueCode());
			jobj.put("dbNo", cs.getDbNo());
			jobj.put("length", cs.getLength());

			jArray.add(jobj);

		}
		out.print(jArray);
		out.flush();
	}

}
