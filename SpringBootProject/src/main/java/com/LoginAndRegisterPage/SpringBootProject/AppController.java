package com.LoginAndRegisterPage.SpringBootProject;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private  UserRepository repo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/registerpage")
	public String showSignUpPage(Model mod) {
		mod.addAttribute("user", new User());
		return "register1";
	}

	@GetMapping("/loginpage")
	public String login() {
		return "login";
	}


	@GetMapping("/login")
	public String iHaveAccount() {
		return "login";
	}

	@GetMapping("/createnewaccount")
	public String creteNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "register1";
	}



	@PostMapping("/process_register")
	public String processRegistration(User user, ServletRequest request, Model model){
		
		Long l=0l;
		
		
		try {
			 User user1= repo.save(user);
			 l=user1.getId();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			String uemail=request.getParameter("email");
			if (l>0) {
				model.addAttribute("useruser", "success");
				return "register1";
			}
			else {
				List<User> ls= repo.findAll();
				for (User user2 : ls) {
					String email=user2.getEmail();
					if (email.equals(uemail)) {
						model.addAttribute("useruser", "useremailfailed");
						return "register1";
					}

				}
			}
		}    
    return "register1";
	}	
	
	
	@PostMapping("/mainpage")
	public String logInMainPage(ServletRequest request, Model mode) {

		String uemail=request.getParameter("username");
		String upwd=request.getParameter("password");	
	
	List<User> all=repo.findAll();
	
	for (User user : all) {
		
		String email=user.getEmail();
		String pass=user.getPassword();
		if (email.equals(uemail) && pass.equals(upwd)) {
			return "booking";
		}
		else {
			mode.addAttribute("useruser", "faild");
			return "login";
		}	
	}
	
		return "login";
	}
	
	
	@GetMapping("/BookingMainPage")
	public String bookingMainPage() {
		System.out.println("hello");
		
		return "";
	}
	
	
}
