package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;


public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User getUser(String name) {
		List<User> userList = em.createQuery(" FROM User AS user WHERE user.name = :USER_NAME ", 
				User.class).setParameter("USER_NAME", name).getResultList();
		
		if (userList.isEmpty()) {
			return null;
		}
		
		return userList.get(0);
	}

	@Override
	public User getUser(Integer id) {
		return em.find(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

}
