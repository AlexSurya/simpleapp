/**
 * 
 */
package com.learning.rest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.rest.modal.Post;
import com.learning.rest.modal.UserBean;
import com.learning.rest.service.PostService;
import com.learning.rest.service.UserService;

/**
 * @author alexsurya
 *
 */
@RestController
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="postlist")
	public List<Post> getPostList() {
		
		List<Post> posts = postService.getPostList();
		return posts;
	}
	

	@PostMapping(path="/user/{id}/savepost")
	public ResponseEntity<Object>  savePost(@Valid @PathVariable int id, @RequestBody Post post) {
		
		Optional<UserBean> bean = userService.getUser(id);
		
		if(!(bean.isPresent())) {
			throw new UserNotFoundException("id-" + id);
		}
		
		UserBean userBean = bean.get();
		post.setBean_(userBean);
		
		postService.addPost(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId_())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
