package Models;

import java.sql.Date;
import java.util.Set;

public class Staff {
	
	private int id;
	private String name;
	private String num;
	private String health;
	private Date birthday;
	private String political;
	private String isOnline;
	
	
	private Job job_id;
	private Department dep_id;
	
	
	private Set<Attendance> attendance;
	private Set<PersonnelChange> personnelChange;
	private Set<CheckList> checkList;
	
	
	public Set<CheckList> getCheckList() {
		return checkList;
	}
	public void setCheckList(Set<CheckList> checkList) {
		this.checkList = checkList;
	}
	public String getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	public Set<PersonnelChange> getPersonnelChange() {
		return personnelChange;
	}
	public void setPersonnelChange(Set<PersonnelChange> personnelChange) {
		this.personnelChange = personnelChange;
	}
	public Set<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}
	public Department getDep_id() {
		return dep_id;
	}
	public void setDep_id(Department dep_id) {
		this.dep_id = dep_id;
	}
	public Job getJob_id() {
		return job_id;
	}
	public void setJob_id(Job job_id) {
		this.job_id = job_id;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	
	
}
