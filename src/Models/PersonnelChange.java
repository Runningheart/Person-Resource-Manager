package Models;

import java.sql.Date;

public class PersonnelChange {
	private int id;
	private String activity;
	private Date dateTime;
	
	private Job oldJob;
	private Job nowJob;
	private Staff staff_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Job getOldJob() {
		return oldJob;
	}
	public void setOldJob(Job oldJob) {
		this.oldJob = oldJob;
	}
	public Job getNowJob() {
		return nowJob;
	}
	public void setNowJob(Job nowJob) {
		this.nowJob = nowJob;
	}
	public Staff getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Staff staff_id) {
		this.staff_id = staff_id;
	}
	
	
}
