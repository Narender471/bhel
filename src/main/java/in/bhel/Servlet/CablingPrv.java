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
 * Servlet implementation class CablingPrv
 */
@WebServlet("/CablingPrv")
public class CablingPrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CablingPrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");
		response.setContentType("application/json");

		String vendor = "prv";
		String table = request.getParameter("cableCode");
		PrintWriter out = response.getWriter();
		CableStoreDao csd = new CableStoreImpl();
		ArrayList<String> al = csd.getDrumNoFromRiv(table, vendor);
		JSONArray jArray = new JSONArray();
		for(String str : al) {
			jArray.add(str);
		}
		out.println(jArray);
		out.flush();
		
	}

	

}
