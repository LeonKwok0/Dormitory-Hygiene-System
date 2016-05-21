package entity;

public class Dormitory extends User {
	private String dorId;
	private String time;
	private String reasons;
	private int deductPoints;
	private int allpoints;
	
	public String getDorId() {
		return dorId;
	}
	
	public void setDorId(String dorId) {
		this.dorId = dorId;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReasons() {
		return reasons;
	}
	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
	public int getDeductPoints() {
		return deductPoints;
	}
	public void setDeductPoints(int deductPoints) {
		this.deductPoints = deductPoints;
	}
	public int getAllpoints() {
		return allpoints;
	}
	public void setAllpoints(int allpoints) {
		this.allpoints = allpoints;
	}
	
}
