package com.onlinezone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinezone.dao.AnswerDao;
import com.onlinezone.entities.AnswerModel;
import com.onlinezone.entities.QuestionModel;

@Controller
public class AnswerController {

	@Autowired
	private AnswerDao answerDao;
	
	@RequestMapping("admin/show-answer")
	public String showAllAnswer(Model model) {
		List<AnswerModel> answers = answerDao.getAllAnswer();
		if (answers.isEmpty()) {
			System.out.println("Answer empty");
			model.addAttribute("notFound", false);
		} else {
			model.addAttribute("answers", answers);
		}
		return "admin/answer";
	}
	
	@RequestMapping("/admin/answer-detail/{answerId}")
	public String questionDetail(@PathVariable("answerId") int aId,Model model) {
		if(aId>0) {
			AnswerModel answer = answerDao.getAnswer(aId);
			if(answer!=null) {
				model.addAttribute("answer", answer);
				return "admin/show_answer_detail";
			}else {
				return "redirect:/admin/all-subject";
			}
		}else {
			return "admin/answer";
		}
	}
	
}
