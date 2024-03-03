package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.User;

//public class UserDao {
//	
//	 private static SessionFactory sessionFactory;
//
//	    static {
//	        try {
//	            Configuration configuration = new Configuration();
//	            configuration.configure("hibernate.cfg.xml");
//	            sessionFactory = configuration.buildSessionFactory();
//	        } catch (Throwable ex) {
//	            System.err.println("Initial SessionFactory creation failed." + ex);
//	            throw new ExceptionInInitializerError(ex);
//	        }
//	    }
//	
//	//saveUser
//	public String saveUser(User user)
//	{
//		String msg="User reg failed!!";
//		Session session=getFactory().openSession();
//		Transaction tx=session.beginTransaction();
//		try {
//			Integer id=(Integer) session.save(user);
//			
//			tx.commit();
//			
//			msg="User Registered SuccessFully!!!";
//			
//		} catch (RuntimeException e) {
//			// roll back Tx
//			if (tx != null)
//				tx.rollback();
//			// re throw the exc to the caller
//			throw e;
//		} finally {
//			// close session
//			if (session != null)
//				session.close();// pooled out DB cn rets to
//			// the pool n L1 cache is destroyed!
//		}
//		
//
//		// newUser : DETACHED
//		return msg;
//		
//	}
//	//getAll
//	public List<User> getAllUsers()
//	{
//		List<User> users=null;
//		String jpql="select u from User u";
//		
//		Session session=getFactory().getCurrentSession();
//		
//		Transaction tx=session.beginTransaction();
//		try {
//			users=session.createQuery(jpql,User.class).getResultList();
//			tx.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			if(tx!=null)
//			tx.rollback();
//			throw e;
//		}
//		return users;
//	}
//	
//	
//	//getById
//	public User getUserDetailsById(Integer id) {
//		User user = null;// user : does not exist
//		// 1. get session from SF
//		Session session = getFactory().getCurrentSession();
//		// 2. begin a tx
//		Transaction tx = session.beginTransaction();
//		try {
//			// get user details
//			user = session.get(User.class, id);// chks if user entity exists
//			
//		
//			tx.commit();
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//			throw e;
//		}
//		return user;// user : DETACHED
//	}
//	
//	// updateUser
//    public String updateUserDetails(User user) {
//        String message = "User update failed!";
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            session.update(user);
//            tx.commit();
//            message = "User details updated successfully!";
//        } catch (RuntimeException e) {
//            if (tx != null)
//                tx.rollback();
//            throw e;
//        } finally {
//            session.close();
//        }
//        return message;
//    }
//
//    // deleteUser
//    public String deleteUserDetails(Integer userId) {
//        String mesg = "Details deletion failed !!!!";
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            User user = session.get(User.class, userId);
//            if (user != null) {
//                session.delete(user);
//                mesg = "user details deleted!";
//            }
//            tx.commit();
//        } catch (RuntimeException e) {
//            if (tx != null)
//                tx.rollback();
//            throw e;
//        } finally {
//            session.close();
//        }
//        return mesg;
//    }
//
//	
//}
public class UserDao {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // saveUser, getAllUsers, getUserDetailsById methods

 // saveUser
    public String saveUser(User user) {
        String message = "User registration failed!";
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Integer id = (Integer) session.save(user);
            tx.commit();
            message = "User registered with ID: " + id;
        } catch (RuntimeException e) {
            throw e;
        }
        return message;
    }
    
    // updateUser
    public String updateUserDetails(int idToUpdate, User newUser) {
        String updateMessage = "User update failed!";
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            User existingUser = session.get(User.class, idToUpdate);
            if (existingUser != null) {
                existingUser.setFirstName(newUser.getFirstName());
                existingUser.setLastName(newUser.getLastName());
                existingUser.setEmail(newUser.getEmail());
                existingUser.setPassword(newUser.getPassword());
                existingUser.setAddress(newUser.getAddress());
                session.update(existingUser);
                tx.commit();
                updateMessage = "User updated successfully!";
            } else {
                updateMessage = "User not found!";
            }
        } catch (RuntimeException e) {
            throw e;
        }
        return updateMessage;
    }

    // deleteUser
    public String deleteUserDetails(Integer userId) {
        String mesg = "Details deletion failed !!!!";
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                session.delete(user);
                mesg = "user details deleted!";
            }
            tx.commit();
        } catch (RuntimeException e) {
            throw e;
        }
        return mesg;
    }

    // getAllUsers
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            users = session.createQuery("FROM User", User.class).getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
        return users;
    }

    // getUserDetailsById
    public User getUserDetailsById(Integer id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
        return user;
    }
}
