package Models;

import java.util.Set;

public class Department {
	private int id;
	private String name;
	private String managerName;
	
	private Set<Staff> staff_id;

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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Set<Staff> getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Set<Staff> staff_id) {
		this.staff_id = staff_id;
	}
	
	
}
