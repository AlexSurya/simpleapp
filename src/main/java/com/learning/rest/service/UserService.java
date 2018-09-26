/**
 * 
 */
package com.learning.rest.service;

import java.util.List;
import java.util.Optional;

import com.learning.rest.modal.UserBean;

/**
 * @author alexsurya
 *
 */
public interface UserService {

	List<UserBean> listUsers();
	Optional<UserBean> getUser(int id);
	UserBean addUser(UserBean userBean);
	void deleteUser(int id);	
	Optional<UserBean> getUserPost(int id);
}
