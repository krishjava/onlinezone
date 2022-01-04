package com.onlinezone.front.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.onlinezone.dao.AnswerDao;
import com.onlinezone.dao.LoginDao;
import com.onlinezone.dao.QuestionDao;
import com.onlinezone.entities.AnswerModel;
import com.onlinezone.entities.QuestionModel;
import com.onlinezone.front.dao.UserDao;
import com.onlinezone.front.model.User;

@Controller
public class HomeController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<QuestionModel> topTenRows = questionDao.getTopQuestionRows();
		model.addAttribute("recentRows", topTenRows);
		return "frontview/home";
	}
	
	@RequestMapping("/register")
	public String register(HttpSession session) {
		
		System.out.println("register");
		
		return "frontview/register";
	}
	
	@RequestMapping(path = {"/question","/question/page/{pageno}"})
	public String question(@PathVariable(required = false) Integer pageno,Model model,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null && session.getAttribute("USER_ID")!=null) {
			int paginationButtons=5;
			int pageNumber;
			pageNumber=pageno==null ? 1:pageno;
			int perPageRecords=3;
			int rows=questionDao.maxRows();
			int lastPage=(int) Math.ceil((float)rows/perPageRecords);
			int half=Math.floorDiv(paginationButtons,2);  //pagination_buttons/2
			model.addAttribute("paginationButtons",paginationButtons);
			model.addAttribute("pageNumber",pageNumber);
			model.addAttribute("perPageRecords",perPageRecords);
			model.addAttribute("rows",rows);
			model.addAttribute("lastPage",lastPage);
			model.addAttribute("half",half);
			
			List<QuestionModel> questionRows;
			if(pageno == null) {
				questionRows= questionDao.paginatedRows(1,perPageRecords);
				model.addAttribute("questionRows",questionRows);
				return "frontview/question";
			}else {
				if(pageno>=1 && pageno<=lastPage ) {
					questionRows= questionDao.paginatedRows(pageno,perPageRecords);
					model.addAttribute("pageNo",pageno);
					model.addAttribute("questionRows",questionRows);
					return "frontview/question";
				}else {
					questionRows= questionDao.paginatedRows(1,perPageRecords);
					model.addAttribute("pageNumber",1);
					model.addAttribute("questionRows",questionRows);
					return "frontview/question";
				}
			}
	}else {
		return "redirect:/onlinezone.com/login";
	}
	}
	
	@RequestMapping("/add-question")
	public String addQuestion(HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null && session.getAttribute("USER_ID")!=null) {
			return "frontview/add-question";
		}else {
			return "frontview/register";
		}
	}
	
	@RequestMapping(path = "/save-question",method =  RequestMethod.POST)
	public String saveQuestion(@Valid @ModelAttribute("questionFrom") QuestionModel question,BindingResult result,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null && session.getAttribute("USER_ID")!=null) {
				if(result.hasErrors()) {
					return "frontview/add-question";
				}else {
					User userInfo = userDao.getUserByEmail((String)session.getAttribute("USER_EMAIL"));
					System.out.println("userinfo : "+userInfo);
					question.setUser_id(userInfo.getId());
					questionDao.savequestion(question);
					return "redirect:/onlinezone.com/question";
				}
		}else {
			return "frontview/register";
		}
		
	}
	
	@RequestMapping("/question-detail/{id}")
	public String questionDetail(@PathVariable("id") int id,Model model,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null && session.getAttribute("USER_ID")!=null) {
				if(id>0) {
					QuestionModel fullQuestion = questionDao.getQuestion(id);
					User user = userDao.getUserById(questionDao.getQuestion(id).getUser_id());
					List<AnswerModel> answers = answerDao.getAnswerById(id);
					model.addAttribute("answers",answers);
					model.addAttribute("fullQuestion", fullQuestion);
					model.addAttribute("user",user);
					return "frontview/question_detail";
				}else {
					return "frontview/question";
				}
		}else {
			return "frontview/register";
		}
	}
	
	@RequestMapping("/profile")
	public String profile(HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null && session.getAttribute("USER_ID")!=null) {
			return "frontview/profile";
		}else {
			return "frontview/register";
		}
	}
	
	@RequestMapping(path = "/add-user",method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,BindingResult result,Model model,HttpServletRequest request,HttpSession session) {
		if(result.hasErrors()) {
			for(ObjectError error:result.getAllErrors()) {
				System.out.println(error);
			}
			model.addAttribute("user", user);
			return "frontview/register";
		}else {
			String check = userDao.getUserEmail(user.getEmail());
			if(check.equals("none")) {
				userDao.createUser(user);
				return "redirect:/onlinezone.com/login";
			}else {
				model.addAttribute("userExist","* user not available");
				return "frontview/register";
			}
		}
	}
	
	@RequestMapping("/answer/{id}")
	public String answerFrom(@PathVariable("id") int id,Model model,HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null && session.getAttribute("USER_ID")!=null) {
			model.addAttribute("id", id);
			return "frontview/answer-form";
		}else {
			return "frontview/register";
		}
	}
	
	@RequestMapping(path = "/saveanswer",method = RequestMethod.POST) 
	public String saveAnswer(@Valid @ModelAttribute("answer") AnswerModel answer,BindingResult result,Model model) { 
		if(result.hasErrors()) { 
			return "question-detail/"+answer.getQuestion_id(); 
		}else { 
			answerDao.saveAnswer(answer); 
			return "redirect:/onlinezone.com/question-detail/"+answer.getQuestion_id(); 
		} 
	}
	
	@RequestMapping("/login")
	public String loginUser() {
		return "frontview/login";
	}
	
	@RequestMapping(path = "/loginprocess",method = RequestMethod.POST)
	public String loginUserProcess(@RequestParam("email") String email,@RequestParam("password") String password,Model model,HttpSession session) {
		if(email.equals("") || email==null || password.equals("") || password==null) {
			model.addAttribute("invalidUser", "* provide valid credentials");
			return "frontview/login";
		}else {
			boolean validateFrontUser = loginDao.validateFrontUser(email, password);
			if(validateFrontUser!=false) {
				session.setAttribute("USER_EMAIL",email);
				session.setAttribute("USER_ID",userDao.getUserByEmail(email).getId());
				System.out.println("Session email : "+session.getAttribute("USER_EMAIL"));
				System.out.println("Session id : "+session.getAttribute("USER_ID"));
				return "redirect:/onlinezone.com/question";
			}else {
				model.addAttribute("invalidUser", "* provide valid credentials");
				return "frontview/login";
			}
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("USER_EMAIL")!=null && session.getAttribute("USER_ID")!=null) {
			session.invalidate();
			return "frontview/login";
		}else {
			return "frontview/register";
		}
	}
}
