package in.bhel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.bhel.dao.CableStoreDao;
import in.bhel.db.AWSUtil;
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

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			JDBCUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean insertDrumDataAWS(CableStore cs) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			connection = AWSUtil.getJdbcConnection();
			String sqlInsertQuery = "insert into drumdata (`length`, `dbNo`, `dbDate`, `cableCode`, `drumNo`, `uniqueCode`) values (?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setDouble(1, cs.getLength());
			pstmt.setDouble(2, cs.getDbNo());
			pstmt.setString(3, cs.getDbDate());
			pstmt.setString(4, cs.getCableCode());
			pstmt.setString(5, cs.getDrumNo());
			pstmt.setString(6, cs.getUniqueCode());
			flag = pstmt.execute();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean insertDrumIntoCableDrum(String table, CableStore cs) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {
			String drumType = "";

			connection = AWSUtil.getJdbcConnection();
			if(cs.getLength() >420 && cs.getLength() < 580) {
				
				drumType = "B";
				
			} else if(cs.getLength() >650 && cs.getLength() < 850) {
				drumType = "C";
				
			}else if(cs.getLength() >900 && cs.getLength() < 1100) {
				drumType = "D";
				
			}else {
				drumType = "A";
			}
			String sqlInsertQuery = "insert into "+table+" (`length`, `dbNo`, `dbDate`, `cableCode`, `drumNo`, `uniqueCode`, `drumType`) values (?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setDouble(1, cs.getLength());
			pstmt.setDouble(2, cs.getDbNo());
			pstmt.setString(3, cs.getDbDate());
			pstmt.setString(4, cs.getCableCode());
			pstmt.setString(5, cs.getDrumNo());
			pstmt.setString(6, cs.getUniqueCode());
			pstmt.setString(7, drumType);
			flag = pstmt.execute();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return flag;
	}

}
