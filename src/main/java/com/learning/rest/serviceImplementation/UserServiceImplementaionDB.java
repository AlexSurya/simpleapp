/**
 * 
 */
package com.learning.rest.serviceImplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.rest.modal.UserBean;
import com.learning.rest.repository.UserRepository;
import com.learning.rest.service.UserService;

/**
 * @author alexsurya
 *
 */
@Service
public class UserServiceImplementaionDB implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserBean> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<UserBean> getUser(int id) {

//		for (UserBean user : userBeans) {
//			if (user.getId_() == id) {
//				return user;
//			}
//		}
		Optional<UserBean> bean = userRepository.findById(id);
		return bean;
	}

	@Override
	public UserBean addUser(UserBean userBean) {

		return	userRepository.save(userBean);
	}

	@Override
	public void deleteUser(int id) {

		userRepository.deleteById(id);
	}

	@Override
	public Optional<UserBean> getUserPost(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

}
