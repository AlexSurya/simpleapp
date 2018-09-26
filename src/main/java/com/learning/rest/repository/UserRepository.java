/**
 * 
 */
package com.learning.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.rest.modal.UserBean;

/**
 * @author alexsurya
 *
 */
public interface UserRepository extends JpaRepository<UserBean, Integer> {

}
