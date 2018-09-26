/**
 * 
 */
package com.learning.rest.serviceImplementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.rest.modal.Post;
import com.learning.rest.repository.PostRepository;
import com.learning.rest.service.PostService;

/**
 * @author alexsurya
 *
 */
@Service
@Transactional
public class PostServiceImplementaion implements PostService {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Post> getPostList() {
		return postRepository.findAll();
	}

	@Override
	public Post addPost(Post post) {
		// TODO Auto-generated method stub
		return postRepository.save(post);
	}

	
}
