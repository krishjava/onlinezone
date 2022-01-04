package com.onlinezone.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinezone.dao.LoginDao;
import com.onlinezone.dao.SubjectDao;
import com.onlinezone.entities.Subject;
import com.onlinezone.util.SessionUtility;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private LoginDao loginDao;

	@RequestMapping("/admin/all-subject")
	public String showSubject(Model model,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null) {
			model.addAttribute("title", "All-Subjects");
			List<Subject> allSubject = subjectDao.getAllSubject();
			if(allSubject.isEmpty()) {
				System.out.println("empty");
				model.addAttribute("notFound",false);
			}else {
				System.out.println(allSubject);
				model.addAttribute("subjectData", allSubject);
			}
			return "admin/all_subject";
		}else {
			return "admin/admin_login";
		}
		
	}
	
	@RequestMapping("/admin/subject-form")
	public String showSubjectForm(Model model,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null) {
			model.addAttribute("title", "Add-Subject");
			return "admin/subject";
		}else {
			return "admin/admin_login";
		}
		
	}
	
	@RequestMapping(path = "/admin/addsubject",method = RequestMethod.POST)
	public String addsubject(@Valid @ModelAttribute("subjectData") Subject subject,BindingResult result ,HttpServletRequest request,Model model) {
		if(request.getSession().getAttribute("USER_EMAIL")!=null) {
			System.out.println("request parameter : "+request.getParameter("id"));
			if(result.hasErrors()) {
//				List<ObjectError> allErrors = result.getAllErrors();
//				
//				for(ObjectError error:allErrors) {
//					System.out.println(error);
//				}
				
				model.addAttribute("subject", subject);   
				return "admin/subject";
			}else {
				boolean createSubject = subjectDao.createSubject(subject);
				if(createSubject) {
					return "redirect:/onlinezone.com/admin/all-subject";
				}else {
					model.addAttribute("addError","SubjectCode & SubjectName already exist");
					model.addAttribute("subject", subject);   
					return "admin/subject";
				}
			}
		}else {
			return "admin/admin_login";
		}
		
	}
	
	@RequestMapping(path  = "/admin/update-subject/{status}/{id}")
	public String updateSubjectForm(@PathVariable("status") String status,@PathVariable("id") int id,Model model,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null) {
			model.addAttribute("title", "Update Subject Details");
			
			if(status.equals("update") && id>0) {
				Subject subject = subjectDao.getSubject(id);
				model.addAttribute("subjectDetail", subject);
				return "admin/updatesubject";
			}else {
				return "redirect:/onlinezone.com/admin/all-subject";
			}
		}else {
			return "admin/admin_login";
		}
		
	}
	
	@RequestMapping(path = "/admin/delete-subject/{status}/{id}")
	public String deleteSubjectForm(@PathVariable("status") String status ,@PathVariable("id") int id, Model model,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null) {
			if(status.equals("delete") && id>0) {
				Subject subject = subjectDao.getSubject(id);
				subjectDao.deleteSubject(subject);
				return "redirect:/onlinezone.com/admin/all-subject";
			}else {
				return "redirect:/admin/all-subject";
			}
		}else {
			return "admin/admin_login";
		}
		
	}
	
	@InitBinder
	public void initBinder() {
		System.out.println("inside binder");
	}
	

	
}
