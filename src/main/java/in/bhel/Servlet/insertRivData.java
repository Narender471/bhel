package in.bhel.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;
import in.bhel.entity.CableStore;
import in.bhel.entity.RivData;

/**
 * Servlet implementation class insertRivData
 */
@WebServlet("/insertRivData")
public class insertRivData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int recordUpdated = 0;
		RivData rd = new RivData();
		PrintWriter out = response.getWriter();
		CableStoreDao csd = new CableStoreImpl();
		rd.setCableCode(request.getParameter("cableCode"));
		rd.setLength(Double.valueOf(request.getParameter("length")));
		rd.setDbNo(Double.valueOf(request.getParameter("dbNo")));
		rd.setDrumNo(request.getParameter("drumNo"));
		rd.setUniqueCode(request.getParameter("dbNo") + " " + request.getParameter("drumNo"));
		rd.setRivNo(request.getParameter("rivNo"));
		rd.setRivDate(request.getParameter("rivDate"));
		rd.setGpNo(request.getParameter("gpNo"));
		rd.setGpDate(request.getParameter("gpDate"));
		recordUpdated = csd.updateStatusCableDrum(rd.getCableCode(), rd.getDbNo(), rd.getDrumNo(), "prv");
		
			if (!csd.insertRivDataAWS(rd)) {
				request.setAttribute("transactionStatus", "Data Got inserted");
				
			} else {
				request.setAttribute("transactionStatus", "Data insertion failed");
			}
			RequestDispatcher reqDisp = request.getRequestDispatcher("/riv.jsp");
			reqDisp.include(request, response);
			
	
		

	}

}
