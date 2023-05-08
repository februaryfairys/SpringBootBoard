package com.springBootBoard.comment;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.springBootBoard.answer.Answer;
import com.springBootBoard.answer.AnswerService;
import com.springBootBoard.question.Question;
import com.springBootBoard.question.QuestionService;
import com.springBootBoard.user.SiteUser;
import com.springBootBoard.user.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService	answerService;
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = {"/create/question/{id}", "/create/answer/{id}"})
	public String createComment(CommentForm commentForm) {
		
		return "comment_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/question/{id}")
	public String createQuestionComment(@PathVariable("id") Integer id, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
		
		if (bindingResult.hasErrors()) {
			return "comment_form";
		}
		
		Question question = this.questionService.getQuestion(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		
		Comment comment = this.commentService.create(question, siteUser, commentForm.getContent());
		return String.format("redirect:/question/detail/%s", comment.getQuestionId());
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/answer/{id}")
	public String createAnswerComment(@PathVariable("id") Integer id, @Valid CommentForm commentForm, BindingResult bindingResult, Principal principal) {
		
		if (bindingResult.hasErrors()) {
			return "comment_form";
		}
		
		Answer answer = this.answerService.getAnswer(id);
		SiteUser siteUser = this.userService.getUser(principal.getName());
		
		Comment comment = this.commentService.create(answer, siteUser, commentForm.getContent());
		return String.format("redirect:/question/detail/%s", comment.getQuestionId());
	}
	
	@GetMapping("/modify/{id}")
	@PreAuthorize("isAuthenticated()")
	public String commentModify(CommentForm commentForm, @PathVariable("id") Integer id, Principal principal) {
		
		Comment comment = this.commentService.getComment(id);
		
		if(!comment.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Authenticated.");
		}
		
		commentForm.setContent(comment.getContent());
		
		return "comment_form";
	}
	
	@PostMapping("/modify/{id}")
	@PreAuthorize("isAuthenticated()")
	public String commentModify(CommentForm commentForm, BindingResult bindingResult, @PathVariable("id") Integer id, Principal principal) {
		
		if (bindingResult.hasErrors()) {
			return "comment_form";
		}
		
		Comment comment = this.commentService.getComment(id);
		
		if(!comment.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Authenticated.");
		}
		
		if(comment.getQuestionId().equals(null)) {
			id = comment.getAnswer().getQuestion().getId();
		} else {
			id = comment.getQuestionId();
		}
		
		this.commentService.modify(comment, commentForm.getContent());
		return String.format("redirect:/question/detail/%s", id);
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("isAuthenticated()")
	public String commentDelete(Principal principal, @PathVariable("id") Integer id) {
		
		Comment comment = this.commentService.getComment(id);
		
		if(!comment.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Authenticated");
		}
		
		if(comment.getQuestionId().equals(null)) {
			id = comment.getAnswer().getQuestion().getId();
		} else {
			id = comment.getQuestionId();
		}
		
		this.commentService.delete(comment);
		return String.format("redirect:/question/detail/%s", id);
	}
}
