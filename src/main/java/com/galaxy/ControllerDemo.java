package com.galaxy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Student;
import model.StudentDao;

@Controller
public class ControllerDemo {
	
	
	private ApplicationContext conn;
	@RequestMapping("/home")
	public String view1()
	{
		return "home";
	}
	@RequestMapping("/register")
	public String view2(Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Student stud= conn.getBean("info",Student.class);
		m.addAttribute("bean",stud);
		return "register";
	}
	
	@RequestMapping("/store")
	public String view3(@ModelAttribute("bean") Student s , Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
		obj.save(s);
		m.addAttribute("msg","Record Inserted Succesfully...");
		return "register";
	}
	
	
	@RequestMapping("/display")
	public String view4(Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
		List list=obj.display();
		m.addAttribute("data",list);
		return "display";
	}
	
	@RequestMapping("/find")
	public String view5(Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Student stud=conn.getBean("info",Student.class);
		m.addAttribute("bean",stud);
		return "search";
	}
	
	@RequestMapping("/search")
	public String view6(@ModelAttribute("bean") Student s ,Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
		List list= obj.search(s);
		if(!list.isEmpty())
		{
			m.addAttribute("data",list);
		}
		else
		{
			m.addAttribute("msg","Oopss ! Record Not Found");
		}
		return "search";
		
	}
	
	@RequestMapping("/edit")
	public String view7(@ModelAttribute("bean") Student s, Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
		List list = obj.update(s);
		m.addAttribute("data",list);
		m.addAttribute("msg","Record Update Successfully");
		return "search";
	}
	
	@RequestMapping("/delete")
	public String view8(@ModelAttribute("bean") Student s, Model m)
	{
		conn= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		StudentDao obj=conn.getBean("dao",StudentDao.class);
		List list = obj.delete(s);
		m.addAttribute("data",list);
		m.addAttribute("msg","Record Deleted Successfully....");
		return "search";
	}
	
}
