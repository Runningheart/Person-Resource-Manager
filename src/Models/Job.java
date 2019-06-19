package Models;

import java.util.Set;

public class Job {
	private int id;
	private String name;
	private float salary;
	
	
	private Set<Staff> staff_id;
	private Set<Job> oldJob;
	private Set<Job> nowJob;

	public Set<Job> getOldJob() {
		return oldJob;
	}

	public void setOldJob(Set<Job> oldJob) {
		this.oldJob = oldJob;
	}

	public Set<Job> getNowJob() {
		return nowJob;
	}

	public void setNowJob(Set<Job> nowJob) {
		this.nowJob = nowJob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Set<Staff> getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Set<Staff> staff_id) {
		this.staff_id = staff_id;
	}

	
	
}
