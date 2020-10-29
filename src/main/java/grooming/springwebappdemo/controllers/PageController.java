package grooming.springwebappdemo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import grooming.springwebappdemo.dto.Customer;
import grooming.springwebappdemo.service.CustomerService;

@Controller
public class PageController {

	@Autowired
	private CustomerService customerService;

	// request handling methods

	@RequestMapping("/")
	public String displayIndex() {
		return "index";
	}

	@RequestMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET) before spring 5
	@GetMapping("/register") // from spring 5 version
	public String register(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "register";
	}

//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public String registerProcess(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "login";
	}

}
