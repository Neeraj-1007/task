package com.task.poc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.task.poc1.dao.UserDAO;
import com.task.poc1.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userdao;
	

	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = false)
	public long save(UserDTO user) {
		// TODO Auto-generated method stub
		long pk=userdao.save(user);
		return pk;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = false)
	public void update(UserDTO user) {
		// TODO Auto-generated method stub
		userdao.update(user);
		
	}


	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO)findByPk(id);
		userdao.delete(user);
		
	}


	@Override
	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
		// TODO Auto-generated method stub
		UserDTO user=(UserDTO)userdao.findByPk(id);
		return user;
	}


	@Override
	@Transactional(readOnly = true)
	public List search(UserDTO user) {
		// TODO Auto-generated method stub
	List list=	userdao.search(user);
		return list;
	}


	@Override
	@Transactional(readOnly = true)
	public List search() {
		// TODO Auto-generated method stub
		List list=	userdao.search();
		return list;
	}
	
     
   

}
