package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import Models.Staff;
import tool.DatabaseManager;


public class StaffDao {
	public void add(Staff staff) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.add(staff);
	}
	
	public void delete(Staff staff) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.delete(staff);
	}
	
	public void update(Staff staff){
		DatabaseManager dm = new DatabaseManager();
		try {
			dm.update(staff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Staff> Query(Staff staff) {
		String hql = "from Staff s where s.name like ? and s.num like ? and s.political like ? and s.job_id like ? and s.dep_id like ? and s.isOnline like ?";
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery(hql);
			if(staff.getName()!=null)
				query.setString(0, staff.getName());
			else query.setString(0, "%");
			if(staff.getNum()!=null)
				query.setString(1, staff.getNum());
			else query.setString(1, "%");
			if(staff.getPolitical()!=null)
				query.setString(2, staff.getPolitical());
			else query.setString(2, "%");
			if(staff.getJob_id()!=null)
				query.setInteger(3, staff.getJob_id().getId());
			else query.setString(3, "%");
			if(staff.getDep_id()!=null)
				query.setInteger(4, staff.getDep_id().getId());
			else query.setString(4, "%");
			if(staff.getIsOnline()!=null)
				query.setString(5,staff.getIsOnline());
			else query.setString(5, "%");
			List result = query.list();
			return result;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	public List<Staff> QueryAll(){
		String hql="from Staff";
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List<Staff> result = (List<Staff>)query.list();
		for(Staff s:result) {
			System.out.println(s.getNum()+"#"+s.getDep_id().getName()+s.getJob_id().getName());
		}
		return result;
	}
	public List<Staff> queryPageList(int page){
		
		List<Staff> list = null;
        String hql="from Staff";
        Query query;
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
		query = session.createQuery(hql);
		query.setMaxResults(10);
		query.setFirstResult((page-1)*10);
		list =query.list();
		}catch(Exception e) {
			session.close();
			sessionFactory.close();
		}
		
		return list;
		
    }
	
	public Staff QueryById(Staff obj){
		String hql = String.format("from Staff a where a.id=%s", obj.getId());
		DatabaseManager dm = new DatabaseManager();
		try {
			obj = (Staff)dm.MyQuery(hql).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public List<Staff> QueryByNum(String num){
		String hql = String.format("from Staff a where a.num='%s'", num);
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List<Staff> result = (List<Staff>)query.list();
		for(Staff s:result) {
			System.out.println(s.getNum()+"#"+s.getDep_id().getName()+s.getJob_id().getName());
		}
		return result;
	}
	public List<Staff> QueryByName(String name) {
		String hql = String.format("from Staff a where a.name='%s'", name);
		DatabaseManager dm = new DatabaseManager();
		List<Staff> staff=null;
		try {
			staff = dm.MyQuery(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}
	
	public List<Staff> QueryByJobid(int job_id) {
		String hql = String.format("from Staff a where a.job_id=%s", job_id);
		DatabaseManager dm = new DatabaseManager();
		List<Staff> staff=null;
		try {
			staff = dm.MyQuery(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}
	
	public List<Staff> QueryByDepid(int dep_id) {
		String hql = String.format("from Staff a where a.dep_id=%s", dep_id);
		DatabaseManager dm = new DatabaseManager();
		List<Staff> staff=null;
		try {
			staff = dm.MyQuery(hql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}
	

}
