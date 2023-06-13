package in.bhel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.bhel.dao.CableStoreDao;
import in.bhel.db.JDBCUtil;
import in.bhel.entity.CableStore;

public class CableStoreImpl implements CableStoreDao {
	
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;

	@Override
	public boolean insertDrumToStore(CableStore cs) {
		
		boolean flag = false;
		
		try {
			connection = JDBCUtil.getJdbcConnection();	
			String sqlInsertQuery = "insert into drumatstore (`length`, `dbNo`, `dbDate`, `cableCode`, `drumNo`, `uniqueCode`) values (?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setDouble(1, cs.getLength());
			pstmt.setDouble(2, cs.getDbNo());
			pstmt.setString(3, cs.getDbDate());
			pstmt.setString(4, cs.getCableCode());
			pstmt.setString(5, cs.getDrumNo());
			pstmt.setString(6, cs.getUniqueCode());
			flag = pstmt.execute();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}	
		try {
			JDBCUtil.cleanUp(connection, pstmt, resultSet);
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return flag;
	}

}
