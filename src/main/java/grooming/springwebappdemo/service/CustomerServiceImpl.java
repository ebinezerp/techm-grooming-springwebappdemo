package grooming.springwebappdemo.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import grooming.springwebappdemo.dto.Customer;

@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer save(Customer customer) {
		/*
		 * Session session = sessionFactory.openSession(); Transaction tx =
		 * session.beginTransaction(); try { session.save(customer); tx.commit(); return
		 * customer; } catch (Exception e) { e.printStackTrace(); tx.rollback();
		 * session.clear(); return null; } finally { session.close(); }
		 */

		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(customer);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
			return null;
		}
	}

	@Override
	public Customer update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(customer);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
			return null;
		}
	}

	@Override
	public Customer get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer get(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		try {

			/*
			 * select * from Customer where email=? and password = ? SQL prepared statement
			 */
			Query<Customer> query = session.createQuery("From Customer where email=:em and password=:pass",
					Customer.class);

			/*
			 * ps.setString(1,email); ps.setString(2,password);
			 * 
			 */

			query.setParameter("em", email);
			query.setParameter("pass", password);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Customer> get() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Customer> query = session.createQuery("From Customer", Customer.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		try {

			/* for update and delete queries, type should not be mentioned */
			Query query = session.createQuery("delete from Customer where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
