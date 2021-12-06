package com.task.poc1.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.websocket.Session;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.poc1.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
//		 this.sessionFactory =
//		 entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
	}

	@Override
	public long save(UserDTO user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
		return user.getId();
	}

	@Override
	public void update(UserDTO user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);

	}

	@Override
	public void delete(UserDTO user) {
		// TODO Auto-generated method stub
//		UserDTO user=(UserDTO)findByPk(id);

		entityManager.remove(user);

	}

	@Override
	public UserDTO findByPk(long id) {
		// TODO Auto-generated method stub
		UserDTO user = entityManager.find(UserDTO.class, id);
		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List search(UserDTO user) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = cb.createQuery(UserDTO.class);
		Root<UserDTO> from = cq.from(UserDTO.class);

		List<Predicate> predicates = new ArrayList();

		if (user.getFirstName() != null) {
			System.out.println(user.getFirstName());
			predicates.add(cb.like(from.<String>get("firstName"), "%" + user.getFirstName() + "%"));
		}
		if (user.getLastName() != null) {
			predicates.add(cb.like(from.<String>get("lastName"), "%" + user.getLastName() + "%"));
		}
		if (user.getPincode() != null) {
			predicates.add(cb.like(from.<String>get("pincode"), "%" + user.getPincode() + "%"));
		}
		
		cq.where(predicates.toArray(new Predicate[0]));

		TypedQuery<UserDTO> query = entityManager.createQuery(cq);

		List list = query.getResultList();

		Collections.sort(list, new Comparator<UserDTO>() {

			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				// TODO Auto-generated method stub
				int a = 0;
				if(user.getFirstName()!=null) {
				     a= o1.getFirstName().compareTo(o2.getFirstName());
				}
				if(user.getLastName()!=null) {
					 a= o1.getLastName().compareTo(o2.getLastName());
				}
				if(user.getPincode()!=null) {
					 a= o1.getPincode().compareTo(o2.getPincode());
				}
				if(user.getDob()!=null) {
					 a= o1.getDob().compareTo(o2.getDob());
				}
				return a;
			}
		});

		return list;
	}

	@Override
	public List search() {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<UserDTO> cq = cb.createQuery(UserDTO.class);
		Root<UserDTO> from = cq.from(UserDTO.class);

		List<Predicate> predicates = new ArrayList();
		cq.where(predicates.toArray(new Predicate[0]));

		TypedQuery<UserDTO> query = entityManager.createQuery(cq);

		List list = query.getResultList();

		return list;
	}

}
