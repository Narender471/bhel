package in.bhel.dao;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import in.bhel.entity.CableOverview;
import in.bhel.entity.CableSchedule;
import in.bhel.entity.CableStore;
import in.bhel.entity.RivData;

public interface CableStoreDao {
	
	public boolean insertDrumToStore(CableStore cs);
	
	public boolean insertDrumDataAWS(CableStore cs);
	
	public boolean insertRivDataAWS(RivData rd);
	
	public boolean insertDrumIntoCableDrum(String table, CableStore cs);
	
	public boolean insertCableOverview(CableOverview co);
	
	public boolean insertCableScheduleAws(String table, CableSchedule cs);
	
	public int updateStatusCableDrum(String table, double dbNo, String drumNo, String status);
	
	public ArrayList getStoreData(String table);
	
	public TreeSet<Double> getDbNumber(String cableCode);
	
	public TreeSet<String> getDrumNumber(String cableCode, String dbNo);
	
	public ArrayList<String> getDbNoFromDrumNo(String drumNo, String table);
	
	public ArrayList<String> getDrumNoFromCableCode(String table);	
	
	public double getDrumLength(String cableCode, String dbNo, String drumNo);
	
	public ArrayList<CableStore> getCableData(String table);
	
	public ArrayList<String> getDrumNoFromRiv(String table, String vendor);
	
	public TreeSet<String> getCableFrom(String table);
	
	public ArrayList<String> getCableTo(String table, String cableFrom);
	
	

}
