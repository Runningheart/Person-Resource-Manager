package dao;

import java.util.List;

import Models.Department;
import tool.DatabaseManager;

public class DepartmentDao {

	public void add(Department department) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.add(department);
	}
	
	public void delete(Department department) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.delete(department);
	}
	
	public void update(Department department) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.update(department);
	}
	
	public List<Department> Query(Department department) throws Exception{
		List<Department> result=null;
		String hql = "from Department";
		DatabaseManager dm = new DatabaseManager();
		dm.MyQuery(hql);
		return result;
	}
	
	public Department QueryById(int id){
		String hql = String.format("from Department a where a.id=%s", id);
		DatabaseManager dm = new DatabaseManager();
		Department dep=null;
		try {
			dep = (Department)dm.MyQuery(hql).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dep;
	}
	
	public Department QueryByName(String obj){
		String hql = String.format("from Department a where a.name='%s'", obj);
		DatabaseManager dm = new DatabaseManager();
		Department dep=null;
		try {
			dep = (Department)dm.MyQuery(hql).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dep;
	}
}
