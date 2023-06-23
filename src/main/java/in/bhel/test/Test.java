package in.bhel.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;
import in.bhel.db.AWSUtil;
import in.bhel.entity.CableStore;

public class Test {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
//		JSONParser parser = new JSONParser();
//		try(FileReader reader = new FileReader("C:\\Users\\Narender\\Downloads\\drumdata.json")) {
//				Object obj = parser.parse(reader);
//				JSONArray emplist = (JSONArray)obj;
//				for (int i = 0; i< 487;i++) {
//					JSONObject jobj = (JSONObject) emplist.get(i);
//					CableStore cs = new CableStore();
//					cs.setLength(Double.parseDouble(jobj.get("length").toString()));
//					cs.setDbNo(Double.parseDouble(jobj.get("dbNo").toString()));
//					cs.setDbDate(jobj.get("dbDate").toString());
//					cs.setCableCode(jobj.get("cableCode").toString());
//					cs.setDrumNo(jobj.get("drumNo").toString());
//					cs.setUniqueCode(jobj.get("uniqueCode").toString());
//					CableStoreDao csd = new CableStoreImpl();
//					System.out.println(csd.insertDrumDataAWS(cs));
//					
//				}
//				
//				
//			
//			
//		}catch(FileNotFoundException e) { e.printStackTrace(); }
//		catch(IOException e) { e.printStackTrace(); }
//		catch(Exception e) { e.printStackTrace(); }
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//		ResultSet resultSet = null;
//		try {
//			connection = AWSUtil.getJdbcConnection();
//			String sqlSelectQuery = "select * from drumdata where cableCode = '1p1kv004005c'";
//			pstmt = connection.prepareStatement(sqlSelectQuery);
//			resultSet = pstmt.executeQuery();
//			while(resultSet.next()) {
//				CableStore cs = new CableStore();
//				CableStoreDao csd = new CableStoreImpl();
//				cs.setLength(resultSet.getDouble("length"));
//				cs.setDbNo(resultSet.getDouble("dbNo"));
//				cs.setDbDate(resultSet.getString("dbDate"));
//				cs.setCableCode(resultSet.getString("cableCode"));
//				cs.setDrumNo(resultSet.getString("drumNo"));
//				cs.setUniqueCode(resultSet.getString("uniqueCode"));
//				System.out.println(csd.insertDrumIntoCableDrum("1p1kv004005c", cs ));
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			AWSUtil.cleanUp(connection, pstmt, resultSet);
//		}

		

	}
	
}
