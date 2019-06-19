package tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBFactory {
	private Session session;
	private SessionFactory sessionFactory;
	public Session getSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		
		return session;
	}
	public boolean close() {
		try {
			session.close();
			sessionFactory.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
