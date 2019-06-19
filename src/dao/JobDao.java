package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Job;
import Models.Staff;
import tool.DatabaseManager;



public class JobDao {
	public void add(Job job) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.add(job);
	}
	
	public void delete(Job job) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.delete(job);
	}
	
	public void update(Job job){
		DatabaseManager dm = new DatabaseManager();
		try {
			dm.update(job);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Job> Query(Job job) throws Exception{
		List<Job> result=null;
		String hql = "from Job";
		DatabaseManager dm = new DatabaseManager();
		dm.MyQuery(hql);
		return result;
	}
	public List<Job> QueryAll(){
		String hql="from Job";
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List<Job> result = (List<Job>)query.list();
		return result;
	}
	public List<Job> queryPageList(int page){
		
		List<Job> list = null;
        String hql="from Job";
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
	
	public Job QueryById(int id){
		String hql = String.format("from Job a where a.id=%s", id);
		DatabaseManager dm = new DatabaseManager();
		Job job=null;
		try {
			job = (Job)dm.MyQuery(hql).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
	}
	
	public Job QueryByName(String obj){
		String hql = String.format("from Job a where a.name='%s'", obj);
		DatabaseManager dm = new DatabaseManager();
		Job job=null;
		try {
			job = (Job)dm.MyQuery(hql).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
	}
}
