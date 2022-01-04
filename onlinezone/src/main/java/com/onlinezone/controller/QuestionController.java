package com.onlinezone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlinezone.dao.QuestionDao;
import com.onlinezone.entities.QuestionModel;

@Controller
public class QuestionController {

	@Autowired
	private QuestionDao questionDao;

	@RequestMapping(path = "/admin/show-questions", method = RequestMethod.GET)
	public String showAllQuestion(Model model) {
		List<QuestionModel> questions = questionDao.getAllQuestion();
		if (questions.isEmpty()) {
			System.out.println("Question empty");
			model.addAttribute("notFound", false);
		} else {
			model.addAttribute("questions", questions);
		}
		return "admin/question";
	}
	
	@RequestMapping("/admin/question-detail/{studentId}/{questionId}")
	public String questionDetail(@PathVariable("studentId") int stuId,@PathVariable("questionId") int qId,Model model) {
		if(stuId>0 && qId>0) {
			QuestionModel question = questionDao.getQuestion(qId);
//			System.out.println("null or not : "+question);
			if(question!=null) {
				model.addAttribute("question", question);
				return "admin/show_question_detail";
			}else {
				return "redirect:/admin/all-subject";
			}
		}else {
			return "admin/question";
		}
	}
	
	
}
