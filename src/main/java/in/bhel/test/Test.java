package in.bhel.test;

import in.bhel.dao.CableStoreDao;
import in.bhel.dao.impl.CableStoreImpl;
import in.bhel.entity.CableStore;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		CableStore cs = new CableStore();
		cs.setCableCode("121");
		cs.setDbDate("asdf");
		cs.setDbNo(12);
		cs.setDrumNo("asdf");
		cs.setLength(1212);
		cs.setUniqueCode("asdf");
		CableStoreDao csd = new CableStoreImpl();
		csd.insertDrumToStore(cs);

	}

}
