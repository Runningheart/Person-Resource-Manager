package tool;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {
	
	//向数据库中添加数据
	public void add(Object obj)throws Exception{
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			session.save(obj);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
			System.out.println(e.getMessage());
			throw new Exception("���ݿ��쳣�����ʧ��");
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	
	//向数据库中修改数据
	public void update(Object obj)throws Exception{
		Configuration cfg = new Configuration();
		cfg.configure();
				
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			session.update(obj);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
			System.out.println(e.getMessage());
			throw new Exception("���ݿ��쳣���޸�ʧ��");
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	
	//向数据库中删除数据
	public void delete(Object obj)throws Exception{
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		try{
			session.delete(obj);
			ts.commit();
		}catch(Exception e){
			ts.rollback();
			System.out.println(e.getMessage());
			throw new Exception("���ݿ��쳣��ɾ��ʧ��");
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	
	public List MyQuery(String hql)throws Exception{
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery(hql);
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
}
