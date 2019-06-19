package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.PersonnelChange;
import Models.Staff;
import tool.DatabaseManager;



public class PersonnelChangeDao {
	public void add(PersonnelChange personnelChange){
		DatabaseManager dm = new DatabaseManager();
		try {
			dm.add(personnelChange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(PersonnelChange personnelChange) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.delete(personnelChange);
	}
	
	public void update(PersonnelChange personnelChange) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.update(personnelChange);
	}
	
	public List<PersonnelChange> Query(PersonnelChange personnelChange)  throws Exception{
		String hql = "from PersonnelChange p where p.activity like ? and p.dateTime like ? and p.staff_id like ? and p.oldJob like ? and p.nowJob like ?";
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery(hql);
			if(personnelChange.getActivity()!=null)
				query.setString(0, personnelChange.getActivity());
			else query.setString(0, "%");
			if(personnelChange.getDateTime()!=null)
				query.setDate(1, personnelChange.getDateTime());
			else query.setString(1, "%");
			if(personnelChange.getStaff_id()!=null)
				query.setInteger(2, personnelChange.getStaff_id().getId());
			else query.setString(2, "%");
			if(personnelChange.getOldJob()!=null)
				query.setInteger(3, personnelChange.getOldJob().getId());
			else query.setString(3, "%");
			if(personnelChange.getNowJob()!=null)
				query.setInteger(4, personnelChange.getNowJob().getId());
			else query.setString(4, "%");
			List result = query.list();
			return result;
		}catch(Exception e){
			System.out.println(e.getMessage());
			throw new Exception("���ݿ��쳣��ɾ��ʧ��");
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	public List<PersonnelChange> QueryAll(){
		String hql="from PersonnelChange";
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List<PersonnelChange> result = (List<PersonnelChange>)query.list();
		return result;
	}
	public List<PersonnelChange> queryPageList(int page){
		
		List<PersonnelChange> list = null;
        String hql="from PersonnelChange";
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
	
	public PersonnelChange QueryById(PersonnelChange obj) throws Exception{
		String hql = String.format("from PersonnelChange a where a.id=%s", obj.getId());
		DatabaseManager dm = new DatabaseManager();
		obj = (PersonnelChange)dm.MyQuery(hql).get(0);
		return obj;
	}
}
