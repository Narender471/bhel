package in.bhel.dao;

import in.bhel.entity.CableStore;

public interface CableStoreDao {
	
	public boolean insertDrumToStore(CableStore cs);
	
	public boolean insertDrumDataAWS(CableStore cs);
	
	public boolean insertDrumIntoCableDrum(String table, CableStore cs);
	
	

}
