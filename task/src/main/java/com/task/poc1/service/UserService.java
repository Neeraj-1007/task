package com.task.poc1.service;

import java.util.List;

import com.task.poc1.dto.UserDTO;

public interface UserService {

	public long save(UserDTO user);
	public void update(UserDTO user);
	public void delete(long id);
	public UserDTO findByPk(long id);
	public List search(UserDTO user);
	public List search();
}
