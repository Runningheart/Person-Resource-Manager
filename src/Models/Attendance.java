package Models;

import java.sql.Date;

public class Attendance {
	private int id;
	private String activity;
	private Date dateTime;
	private float timeLength;
	
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

	public float getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(float timeLength) {
		this.timeLength = timeLength;
	}

	public Staff getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Staff staff_id) {
		this.staff_id = staff_id;
	}
	
	
}
