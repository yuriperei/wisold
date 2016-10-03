package br.com.wisold.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPErrorHandler {

	String path = "erro";
	  
	 @RequestMapping(value="/400")
	 public String error400(){
	  return path+"/400";
	 }
	  
	 @RequestMapping(value="/404")
	 public String error404(){
	  return path+"/404";
	 }
	 
}
