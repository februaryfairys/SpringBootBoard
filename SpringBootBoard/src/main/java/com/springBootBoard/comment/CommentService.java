package com.springBootBoard.comment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootBoard.DataNotFoundException;
import com.springBootBoard.answer.Answer;
import com.springBootBoard.question.Question;
import com.springBootBoard.user.SiteUser;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment create(Question question, SiteUser author, String content) {
		
		Comment comment = new Comment();
		
		comment.setContent(content);
		comment.setCreateDate(LocalDateTime.now());
		comment.setQuestion(question);
		comment.setAuthor(author);
		comment = this.commentRepository.save(comment);
		
		return comment;
	}
	
	public Comment create(Answer answer, SiteUser author, String content) {
		
		Comment comment = new Comment();
		
		comment.setContent(content);
		comment.setCreateDate(LocalDateTime.now());
		comment.setAnswer(answer);
		comment.setAuthor(author);
		comment = this.commentRepository.save(comment);
		return comment;
	}
	
	public Comment getComment(Integer id) {
		
		Optional<Comment> comment = this.commentRepository.findById(id);
		
		if(comment.isPresent()) {
			return comment.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}
	
	public Comment modify(Comment comment, String content) {
		
		comment.setContent(content);
		comment.setModifyDate(LocalDateTime.now());
		comment = this.commentRepository.save(comment);
		
		return comment;
	}
	
	public void delete(Comment comment) {
		
		this.commentRepository.delete(comment);
	}
}
