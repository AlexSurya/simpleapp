/**
 * 
 */
package com.learning.rest.service;

import java.util.List;

import com.learning.rest.modal.Post;

/**
 * @author alexsurya
 *
 */
public interface PostService {

	public List<Post> getPostList();
	public Post addPost(Post post); 
}
