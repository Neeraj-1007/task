package com.task.poc1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.task.poc1.dto.UserDTO;

public interface UserDAO {

	public long save(UserDTO user);
	public void update(UserDTO user);
	public void delete(UserDTO user);
	public UserDTO findByPk(long id);
	public List search(UserDTO user);
	public List search();
	

}
