package in.bhel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import in.bhel.dao.CableStoreDao;
import in.bhel.db.AWSUtil;
import in.bhel.db.JDBCUtil;
import in.bhel.entity.CableOverview;
import in.bhel.entity.CableSchedule;
import in.bhel.entity.CableStore;
import in.bhel.entity.RivData;

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
			if (cs.getLength() > 420 && cs.getLength() < 580) {

				drumType = "B";

			} else if (cs.getLength() > 650 && cs.getLength() < 850) {
				drumType = "C";

			} else if (cs.getLength() > 900 && cs.getLength() < 1100) {
				drumType = "D";

			} else {
				drumType = "A";
			}
			String sqlInsertQuery = "insert into " + table
					+ " (`length`, `dbNo`, `dbDate`, `cableCode`, `drumNo`, `uniqueCode`, `drumType`) values (?,?,?,?,?,?,?)";
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

	@Override
	public int updateStatusCableDrum(String table, double dbNo, String drumNo, String status) {

		int flag = 0;

		try {
			connection = AWSUtil.getJdbcConnection();

			String sqlUpdateQuery = "update " + table + " set status = ? where dbNo = ? and drumNo = ?";
			pstmt = connection.prepareStatement(sqlUpdateQuery);
			pstmt.setString(1, status);
			pstmt.setDouble(2, dbNo);
			pstmt.setString(3, drumNo);

			flag = pstmt.executeUpdate();

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
	public TreeSet<Double> getDbNumber(String cableCode) {
		// TODO Auto-generated method stub

		TreeSet<Double> hs = new TreeSet<Double>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select dbNo from " + cableCode + " where status = 'store'";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getDouble("dbNo"));
				hs.add(resultSet.getDouble("dbNo"));
			}

			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hs;
	}

	@Override
	public TreeSet<String> getDrumNumber(String cableCode, String dbNo) {
		// TODO Auto-generated method stub
		TreeSet<String> hs = new TreeSet<String>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select drumNo from " + cableCode + " where dbNo = ? and status = 'store'";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			pstmt.setString(1, dbNo);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("drumNo"));
				hs.add(resultSet.getString("drumNo"));
			}

			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hs;
	}

	@Override
	public boolean insertRivDataAWS(RivData rd) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			connection = AWSUtil.getJdbcConnection();
			String sqlInsertQuery = "insert into rivdata (`length`, `dbNo`, `cableCode`,`rivNo`, `rivDate`, `gpNo`, `gpDate`, `drumNo`, `uniqueCode`) values (?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setDouble(1, rd.getLength());
			pstmt.setDouble(2, rd.getDbNo());
			pstmt.setString(3, rd.getCableCode());
			pstmt.setString(4, rd.getRivNo());
			pstmt.setString(5, rd.getRivDate());
			pstmt.setString(6, rd.getGpNo());
			pstmt.setString(7, rd.getGpDate());
			pstmt.setString(8, rd.getDrumNo());
			pstmt.setString(9, rd.getUniqueCode());
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
	public double getDrumLength(String cableCode, String dbNo, String drumNo) {
		// TODO Auto-generated method stub
		double drumLength = 0;
		try {
			double dbNumber = Double.parseDouble(dbNo);
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select length from " + cableCode + " where dbNo = ? and drumNo =?";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			pstmt.setDouble(1, dbNumber);
			pstmt.setString(2, drumNo);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				drumLength = resultSet.getDouble("length");
			}

			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return drumLength;
	}

	@Override
	public ArrayList getStoreData(String table) {
		// TODO Auto-generated method stub

		ArrayList al = new ArrayList();
		double drumLength = 0;
		int i = 0;
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select length from " + table;
			pstmt = connection.prepareStatement(sqlSelectQuery);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				drumLength = drumLength + resultSet.getDouble("length");
				i++;
			}
			al.add(i);
			al.add(drumLength);

			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public boolean insertCableOverview(CableOverview co) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			connection = AWSUtil.getJdbcConnection();
			String sqlInsertQuery = "insert into cablesOverview (`cableCode`, `storeQuantity`, `storeDrums`) values (?,?,?)";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setString(1, co.getCableCode());
			pstmt.setDouble(2, co.getStoreQuantity());
			pstmt.setInt(3, co.getStoreDrums());
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
	public ArrayList<String> getDbNoFromDrumNo(String drumNo, String table) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select dbNo from " + table + " where drumNo =  ? and status = 'store'";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			pstmt.setString(1, drumNo);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				al.add(resultSet.getString("dbNo"));
			}
			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<String> getDrumNoFromCableCode(String table) {
		// TODO Auto-generated method stub

		ArrayList<String> al = new ArrayList<String>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select drumNo from " + table + " where status = 'store'";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				al.add(resultSet.getString("drumNo"));
			}
			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<CableStore> getCableData(String table) {
		// TODO Auto-generated method stub
		ArrayList<CableStore> al = new ArrayList<CableStore>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select * from " + table;
			pstmt = connection.prepareStatement(sqlSelectQuery);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				CableStore cs = new CableStore();
				cs.setCableCode(resultSet.getString("cableCode"));
				cs.setLength(resultSet.getDouble("length"));
				cs.setDbNo(resultSet.getDouble("dbNo"));
				cs.setDbDate(resultSet.getString("dbDate"));
				cs.setDrumNo(resultSet.getString("drumNo"));
				cs.setUniqueCode(resultSet.getString("uniqueCode"));
				cs.setDrumType(resultSet.getString("drumType"));
				cs.setStatus(resultSet.getString("status"));
				al.add(cs);
			}
			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public ArrayList<String> getDrumNoFromRiv(String table, String vendor) {
		// TODO Auto-generated method stub

		ArrayList<String> al = new ArrayList<String>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select drumNo from rivdata where status = ? and cableCode = ?";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			pstmt.setString(1, vendor);
			pstmt.setString(2, table);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				al.add(resultSet.getString("drumNo"));
			}
			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public boolean insertCableScheduleAws(String table, CableSchedule cs) {
		// TODO Auto-generated method stub
		boolean flag = false;

		try {

			connection = AWSUtil.getJdbcConnection();
			String sqlInsertQuery = "insert into "+table+" (`cableFrom`, `cableTo`, `purpose`, `cableDetails`,`cableCode`,`remarks`,`length`,`cableNo`) values (?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setString(1, cs.getCableFrom());
			pstmt.setString(2, cs.getCableTo());
			pstmt.setString(3, cs.getPurpose());
			pstmt.setString(4, cs.getCableDetails());
			pstmt.setString(5, cs.getCableCode());
			pstmt.setString(6, cs.getRemarks());
			pstmt.setDouble(7, cs.getLength());
			pstmt.setString(8, cs.getCableNo());
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
	public TreeSet<String> getCableFrom(String table) {
		// TODO Auto-generated method stub
		TreeSet<String> hs = new TreeSet<String>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select cableFrom from " + table;
			pstmt = connection.prepareStatement(sqlSelectQuery);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				hs.add(resultSet.getString("cableFrom"));
			}

			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hs;
	}

	@Override
	public ArrayList<String> getCableTo(String table, String cableFrom) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		try {
			connection = AWSUtil.getJdbcConnection();
			String sqlSelectQuery = "select cableTo from "+table+" where cableFrom = ?";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			pstmt.setString(1, cableFrom);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				al.add(resultSet.getString("cableTo"));
			}
			AWSUtil.cleanUp(connection, pstmt, resultSet);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
