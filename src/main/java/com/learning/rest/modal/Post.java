/**
 * 
 */
package com.learning.rest.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

/**
 * @author alexsurya
 *
 */
@ApiModel
@Entity
@Table(name="tbl_post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id_;
	
	@Column(name="description")
	@NotNull(message="description could not be null")
	@Size(min=10, message="description should have atleast 10 characters")
	@ApiModelProperty(notes="description should have atleast 10 characters")
	private String description_;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserBean bean_;

	public int getId_() {
		return id_;
	}

	public void setId_(int id_) {
		this.id_ = id_;
	}

	public String getDescription_() {
		return description_;
	}

	public void setDescription_(String description_) {
		this.description_ = description_;
	}

	

	public UserBean getBean_() {
		return bean_;
	}

	public void setBean_(UserBean bean_) {
		this.bean_ = bean_;
	}

	@Override
	public String toString() {
		return "Post [id_=" + id_ + ", description_=" + description_ + "]";
	}


	
	
}
