/**
 * 
 */
package com.learning.rest.controller;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.rest.modal.Post;
import com.learning.rest.modal.UserBean;
import com.learning.rest.service.UserService;

/**
 * @author alexsurya
 *
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	// get userList
	@GetMapping(path = "listUsers")
	public List<UserBean> getUsers() {
		List<UserBean> userBean = userService.listUsers();
		return userBean;
	}

	// listUser
	@GetMapping(path = "listUser/{id}")
	public Resource<UserBean> findUser(@PathVariable int id) {
		Optional<UserBean> userBean = userService.getUser(id);
		if (userBean == null)
			throw new UserNotFoundException("id-" + id);

		// retriveAllUsers
		Resource<UserBean> resource = new Resource<UserBean>(userBean.get());
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUsers());
		Link selfLink = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getUsers())
				.withRel("All-Users");
		resource.add(selfLink);

		return resource;
	}

	// deleteUser
	@DeleteMapping(path = "deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {

	 userService.deleteUser(id);

	}

	// addUser
	@PostMapping(path = "addUser")
	public ResponseEntity<Object> addUser(@Valid @RequestBody UserBean userBean) {

		UserBean bean = userService.addUser(userBean);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bean.getId_())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	//getPostByUser
	@GetMapping(path="user/{id}/post")
	public List<Post> getUserPost(@PathVariable int id) {
		
		Optional<UserBean> userBean = userService.getUserPost(id);
		
		if(!(userBean.isPresent())) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return userBean.get().getPost();
	}
}
