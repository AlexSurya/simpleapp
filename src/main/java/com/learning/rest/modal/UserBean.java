/**
 * 
 */
package com.learning.rest.modal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author alexsurya
 *
 */
@ApiModel
//@JsonFilter("UserBeanFilter")
@Entity
@Table(name="tbl_user")
public class UserBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id_;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Name should be 2 characters")
	@Column(name="name")
	private String name_;
	
	@Column(name="password")
	private String password_;
	
	@OneToMany(mappedBy="bean_")
	private List<Post> post;
	
	public UserBean() {
		super();
	}

	public UserBean(Integer id_, String name_, String password_) {
		super();
		this.id_ = id_;
		this.name_ = name_;
		this.password_ = password_;
	}
	
	public Integer getId_() {
		return id_;
	}
	public void setId_(Integer id_) {
		this.id_ = id_;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public String getPassword_() {
		return password_;
	}
	public void setPassword_(String password_) {
		this.password_ = password_;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "UserBean [id_=" + id_ + ", name_=" + name_ + ", password_=" + password_ + "]";
	}
	
	
	
	
}
