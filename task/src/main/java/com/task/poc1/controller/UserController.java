package com.task.poc1.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.poc1.dto.UserDTO;
import com.task.poc1.form.UserForm;
import com.task.poc1.service.UserService;

//@RestController
@Controller
@RequestMapping("user")
public class UserController {
	public static final String SAVE = "SAVE";
	public static final String DELETE = "DELETE";
	public static final String CANCEL = "CANCEL";
	public static final String LIST = "LIST";
	public static final String SEARCH = "Search";
	public static final String BACK = "Back";
	public static final String UPDATE = "Update";
	public static final String DOB = "dob";
	public static final String PINCODE = "Pincode";
	public static final String REDIRECT = "Redirect";

	@Autowired
	private UserService userService;

	@GetMapping()
	public String display() {
		return "Welcome";
	}

	@GetMapping("Register")
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") UserForm form, Model model) {

		if (id != null && id > 0) {
			form.populate(userService.findByPk(id));
		}
		return "Register";

	}

	@PostMapping("Register")
	public String submit(@RequestParam String operation, Model model, @ModelAttribute("form") @Valid UserForm form,
			BindingResult result, HttpServletRequest request) {
		System.out.println("in controller");
		if (result.hasErrors()) {
			System.out.println("in error");

			return "Register";
		}
		UserDTO user = (UserDTO) form.getDTO();

//		String op = request.getParameter("operation");

		if (SAVE.equalsIgnoreCase(operation)) {

			if (user.getId() > 0) {
				userService.update(user);
				return "List";

			} else {
				System.out.println("brfore calling add of baseservice");
				System.out.println("in save method controller");
				userService.save(user);

			}
		} else if (CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Welcome";
		}

		else if (UPDATE.equalsIgnoreCase(operation)) {
			userService.update(user);
			return "Register";

		} else if (LIST.equalsIgnoreCase(operation)) {

			return "redirect:list";

		}
		return "Register";

	}

	@GetMapping("get/{id}")
	public UserDTO get(@PathVariable long id) {

		UserDTO user = userService.findByPk(id);

		return user;
	}

	@GetMapping("list")
	public String display(Model model, @ModelAttribute("form") UserForm form) {
		System.out.println();
		model.addAttribute("firstName", "firstName");
		model.addAttribute("lastName", "lastName");
		model.addAttribute("pincode", "pincode");

		List list = userService.search();
		model.addAttribute("list", list);
		model.addAttribute("name", "neeraj");
		System.out.println(list);

		return "List";

	}

	@SuppressWarnings("unchecked")
	@PostMapping("list")
	public String submit(@RequestParam String operation, Model model, @ModelAttribute("form") UserForm form) {
		model.addAttribute("firstName", "firstName");
		model.addAttribute("lastName", "lastName");
		model.addAttribute("pincode", "pincode");

		if (SEARCH.equalsIgnoreCase(operation)) {
			UserDTO user = (UserDTO) form.getDTO();
			List list=null;
			if(user!=null) {
			 list = userService.search(user);
			model.addAttribute("list", list);
			System.out.println(list);
			}else {
				list=userService.search();
			model.addAttribute("list",list);
			System.out.println(list);
			}
			

		} else if (BACK.equalsIgnoreCase(operation)) {
			return "redirect:list";
		} else if (DELETE.equalsIgnoreCase(operation)) {

			if (form.getChk_1() != null) {
				for (long id : form.getChk_1()) {
					userService.delete(id);
				}

				model.addAttribute("success", "Successfully deleted");
			} else {

				model.addAttribute("error", "Error While deleting");
			}

		} else if (DOB.equalsIgnoreCase(operation)) {
			List list = userService.search();
			Collections.sort(list, new Comparator<UserDTO>() {

				@Override
				public int compare(UserDTO o1, UserDTO o2) {
					// TODO Auto-generated method stub
					return o1.getDob().compareTo(o2.getDob());

				}
			});
			model.addAttribute("list", list);

		} else if (REDIRECT.equalsIgnoreCase(operation)) {
			return "redirect:list";
		}
		return "List";

	}
}
