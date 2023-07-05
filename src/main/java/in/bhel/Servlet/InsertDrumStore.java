package in.bhel.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;
import in.bhel.entity.CableStore;

/**
 * Servlet implementation class InsertDrumStore
 */
@WebServlet("/InsertDrumToStore")
public class InsertDrumStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CableStore cs = new CableStore();
		PrintWriter out = response.getWriter();
		CableStoreDao csd = new CableStoreImpl();
		cs.setLength(Double.valueOf(request.getParameter("length")));
		cs.setDbNo(Double.valueOf(request.getParameter("dbNo")));
		cs.setDbDate(request.getParameter("dbDate"));
		cs.setCableCode(request.getParameter("cableCode"));
		cs.setDrumNo(request.getParameter("drumNo"));
		cs.setUniqueCode(request.getParameter("dbNo") + " " + request.getParameter("drumNo"));

		
			if (csd.insertDrumDataAWS(cs)) {
				System.out.println("Insertion Completed");
				out.println("Insertion completed");
			} else {
				out.println("Insertion failed");
			}

		

	}

}
