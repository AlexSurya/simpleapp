/**
 * 
 */
package com.learning.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.rest.modal.Post;

/**
 * @author alexsurya
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>  {

}
