package in.bhel.entity;

public class CableSchedule {
	
	private int sno = 0;
	private String cableFrom = "";
	private String cableTo = "";
	private String purpose = "";
	private String cableDetails = "";
	private String cableCode = "";
	private String remarks = "";
	private double length = 0;
	private String cableNo = "";
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	public String getCableFrom() {
		return cableFrom;
	}
	public void setCableFrom(String cableFrom) {
		this.cableFrom = cableFrom;
	}
	public String getCableTo() {
		return cableTo;
	}
	public void setCableTo(String cableTo) {
		this.cableTo = cableTo;
	}

	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getCableDetails() {
		return cableDetails;
	}
	public void setCableDetails(String cableDetails) {
		this.cableDetails = cableDetails;
	}
	public String getCableCode() {
		return cableCode;
	}
	public void setCableCode(String cableCode) {
		this.cableCode = cableCode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public String getCableNo() {
		return cableNo;
	}
	public void setCableNo(String cableNo) {
		this.cableNo = cableNo;
	}

	
}
