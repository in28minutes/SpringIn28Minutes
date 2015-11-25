package com.in28minutes.data.impl;

import org.springframework.stereotype.Repository;

import com.in28minutes.data.api.UserDataService;
import com.in28minutes.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDataServiceImpl implements UserDataService {

	@PersistenceContext
	private EntityManager entityManager;

	
	public User create(final User user) {
		entityManager.persist(user);
		return user;
	}

	
	public User update(User user) {
		return entityManager.merge(user);
	}

	
	public void remove(final User user) {
		entityManager.createNativeQuery(
				"DELETE FROM todo t WHERE t.userId = " + user.getId())
				.executeUpdate();
		User u = entityManager.find(User.class, user.getId());
		entityManager.remove(u);
	}

	
	public User getUserByEmail(final String email) {
		TypedQuery<User> query = entityManager.createNamedQuery(
				"findUserByEmail", User.class);
		query.setParameter("p_email", email);
		List<User> users = query.getResultList();
		return (users != null && !users.isEmpty()) ? users.get(0) : null;
	}

	
	public boolean login(final String email, final String password) {
		TypedQuery<User> query = entityManager.createNamedQuery(
				"findUserByEmailAndPassword", User.class);
		query.setParameter("p_email", email);
		query.setParameter("p_password", password);
		List<User> users = query.getResultList();
		return (users != null && !users.isEmpty());
	}

}
