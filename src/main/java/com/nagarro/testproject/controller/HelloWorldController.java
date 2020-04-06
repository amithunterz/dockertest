package com.nagarro.testproject.controller;


/*import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value="/")
	public String HomePage() {
		return "index";
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(@RequestParam(value="t1") String n, @RequestParam(value="t2") String t) //(HttpServletRequest request, HttpServletResponse resp) 
	{
//		String n=request.getParameter("t1");
//		String t=request.getParameter("t2");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("next");
		mv.addObject("naam",n);
		mv.addObject("techno",t);
		
		//System.out.println("HelloWorldController");
		return mv;
		
	}
	
	/*
	 * @RequestMapping(value="/next") public String nextpage() { return "next"; }
	 */

}