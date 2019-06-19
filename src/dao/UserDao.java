package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Models.Admin;
import Models.Job;
import tool.DBFactory;
import tool.DatabaseManager;

public class UserDao {
	public Admin login(String name,String password) {
		DBFactory factory =new DBFactory();
		Session session=factory.getSession();
		Transaction ts = session.beginTransaction();
		
		
		Admin admin;
		String hql = "from Admin ad where ad.user= '"+name+"' and ad.password = '"+password+"'";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		if(query.list().isEmpty()) {
			return null;
		}else {
			admin = (Admin)query.list().get(0);
		}
		
		
		ts.commit();
		factory.close();
		return admin;
	}
	public void update(Admin admin){
		DatabaseManager dm = new DatabaseManager();
		try {
			dm.update(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
