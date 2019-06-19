package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Models.Attendance;
import Models.Staff;
import tool.DatabaseManager;

public class AttendanceDao {
	public void add(Attendance attendance) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.add(attendance);
	}
	
	public void delete(Attendance attendance) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.delete(attendance);
	}
	
	public void update(Attendance attendance) throws Exception{
		DatabaseManager dm = new DatabaseManager();
		dm.update(attendance);
	}
	
	public List<Attendance> MyQuery(Attendance attendance) throws Exception{
		String hql = "from Attendance a where a.activity like ? and a.dateTime like ? and a.staff_id like ?";
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery(hql);
			if(attendance.getActivity()!=null)
				query.setString(0, attendance.getActivity());
			else query.setString(0, "%");
			if(attendance.getDateTime()!=null)
				query.setDate(1, attendance.getDateTime());
			else query.setString(1, "%");
			if(attendance.getStaff_id()!=null)
				query.setInteger(2, attendance.getStaff_id().getId());
			else query.setString(2, "%");
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
	public List<Attendance> QueryAll(){
		String hql="from Attendance";
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery(hql);
		List<Attendance> result = (List<Attendance>)query.list();
		return result;
	}
	public List<Attendance> queryPageList(int page){
		
		List<Attendance> list = null;
        String hql="from Attendance";
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
	
	public Attendance QueryById(Attendance attendance) throws Exception{
		String hql = String.format("from attendance a where a.id=%s", attendance.getId());
		Attendance at = new Attendance();
		DatabaseManager dm = new DatabaseManager();
		at = (Attendance)dm.MyQuery(hql).get(0);
		return at;
	}
	
	
}
