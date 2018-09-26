/**
 * 
 */
package com.learning.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learning.rest.modal.UserBean;
import com.learning.rest.serviceImplementation.UserServiceImplementaionDB;

/**
 * @author alexsurya
 *
 */
@RestController
public class FilterController {

	@Autowired
	UserServiceImplementaionDB userServiceImplementation;
	
	//filtering name and password
	@GetMapping(path = "filterOne")
	public MappingJacksonValue filterOne() {
		
		List<UserBean> bean = userServiceImplementation.listUsers();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name_","password_");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filterProvider);
		return mapping;
	}
	
	
	//filtering id and name
		@GetMapping(path = "filterTwo")
		public MappingJacksonValue filterTwo() {
			
			List<UserBean> bean = userServiceImplementation.listUsers();
			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id_","name_");
			FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
			MappingJacksonValue mapping = new MappingJacksonValue(bean);
			mapping.setFilters(filterProvider);
			return mapping;
		}
}
