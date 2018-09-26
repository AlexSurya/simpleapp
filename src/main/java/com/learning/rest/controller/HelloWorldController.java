/**
 * 
 */
package com.learning.rest.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alexsurya
 *
 */
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
//	@GetMapping(path="hello-internationalized")
//	public String HelloWorld(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//		return messageSource.getMessage("good.morning.message",null, locale);
//	}
	//instead of
	@GetMapping(path="hello-internationalized")
	public String HelloWorld() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
}
