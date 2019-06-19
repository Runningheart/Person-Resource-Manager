package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.CheckList;
import Models.Staff;
import tool.DatabaseManager;

public class CheckListDao {
	public void add(CheckList checkList){
		DatabaseManager dm = new DatabaseManager();
		try {
			dm.add(checkList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(CheckList checkList) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.delete(checkList);
	}
	
	public void update(CheckList checkList) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.update(checkList);
	}
	
	public List<CheckList> Query(CheckList list) throws Exception{
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<CheckList> result = null;
		String hql = "from checklist where activity like ? and dateTime like ? and staff_id like ?";
		org.hibernate.Query query = session.createQuery(hql);
		
		if(list.getActivity()!=null)
			query.setString(0, list.getActivity());
		else query.setString(0, "%");
		if(list.getDateTime()!=null)
			query.setDate(1, list.getDateTime());
		else query.setString(1, "%");
		if(list.getStaff_id()!=null)
			query.setInteger(2, list.getStaff_id().getId());
		else query.setString(2, "%");
		
		result = query.list();
		session.close();
		sessionFactory.close();
		return result;
	}
	
	public CheckList QueryById(CheckList list) throws Exception{
		String hql = String.format("from CheckList a where a.id=%s", list.getId());
		CheckList lt = new CheckList();
		DatabaseManager dm = new DatabaseManager();
		lt = (CheckList)dm.MyQuery(hql).get(0);
		return lt;
	}
	public List<CheckList> QueryAll(){
		String hql="from CheckList";
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List<CheckList> result = (List<CheckList>)query.list();
		return result;
	}
	public List<CheckList> queryPageList(int page){
		
		List<CheckList> list = null;
        String hql="from CheckList";
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
	
}
