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
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;
import in.bhel.db.AWSUtil;
import in.bhel.entity.CableOverview;
import in.bhel.entity.CableSchedule;
import in.bhel.entity.CableStore;
import in.bhel.excel.ExcelEntry;

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

		String[] tables = {"1p1kv630001c","1p1kv400001c","1p1kv035001c","1p1kv120001c","1p1kv010002c","1p1kv025002c","1p1kv050002c","1p1kv095002c","1p1kv010003c","1p1kv025003c","1p1kv050003c","1p1kv095003c","1p1kv150003c","1p1kv185003c","1p1kv240003c","1p1kv0253p5c","1p1kv0503p5c","1p1kv0953p5c","1p1kv1853p5c","1p1kv010004c","1p1kv2p5002c","1p1kv2p5003c", "1p1kv006002c", "1p1kv004005c","1p1kv2p5005c","1p1kv2p5007c","1p1kv2p5012c","11pkv240001c", "11pkv240003c", "11pkv630001c", "3p3kv185003c", "3p3kv240001c"};

//		CableStoreDao csd = new CableStoreImpl();
//		Set<Double> hs = csd.getDbNumber("11pkv240003c");
//		System.out.println(hs);
		
//		for(String table : tables) {
//			CableStoreDao csd = new CableStoreImpl();
//			ArrayList al = csd.getStoreData(table);
//			CableOverview co = new CableOverview();
//			co.setCableCode(table);
//			co.setStoreDrums((int) al.get(0));
//			co.setStoreQuantity((double) al.get(1));
//			System.out.println(csd.insertCableOverview(co));
//			
//		}
//		CableStoreDao csd = new CableStoreImpl();
//		ArrayList al = csd.getDbNoFromDrumNo("59", "11pkv240001c");
//		System.out.println(al);
//		System.out.println(al.size());
//		System.out.println(al.get(0));
		
//		CableStoreDao csd = new CableStoreImpl();
//		ArrayList al = csd.getDrumNoFromCableCode("11pkv240001c");
//		System.out.println(al);
//		System.out.println(al.size());
//		System.out.println(al.get(0));
		
//		CableStoreDao csd = new CableStoreImpl();
//		ArrayList<CableStore> al = csd.getCableData("11pkv240001c");
//		
//		System.out.println(al);
		
//		CableStoreDao csd = new CableStoreImpl();
//		ArrayList<String> al = csd.getDrumNoFromRiv("1p1kv1853p5c", "prv");
//		
//		System.out.println(al);
		
//		String excelFilePath = "C:\\Users\\Narender\\Desktop\\cable schedules\\0BBR0.xlsx";
////		
//		ExcelEntry ee = new ExcelEntry();
//		CableStoreDao csd = new CableStoreImpl();
//		ArrayList<CableSchedule> al = ee.getDataFromExcel(excelFilePath);
//		for(CableSchedule cs : al) {
//			System.out.println(cs.getCableCode());
//			System.out.println(cs.getCableNo());
//			System.out.println(csd.insertCableScheduleAws("0bb", cs));
//		}
		
		CableStoreDao csd = new CableStoreImpl();
		System.out.println(csd.getCableFrom("0bb").size());
		
	}
	
}
