package Models;

import java.sql.Date;

public class CheckList{
	//员工号 奖罚情况 奖罚时间 奖罚原因
	private int id;
	private String activity;
	private Date dateTime;
	private String comments;
	
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Staff getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Staff staff_id) {
		this.staff_id = staff_id;
	}

	


}
