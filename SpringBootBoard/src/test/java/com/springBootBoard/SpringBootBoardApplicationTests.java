package com.springBootBoard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springBootBoard.answer.AnswerRepository;
import com.springBootBoard.question.QuestionRepository;
import com.springBootBoard.question.QuestionService;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	
//	@Test
//	void testJpa() {
	
		/*Insert*/
//		Question q1 = new Question();
//		q1.setSubject("Test Subject #01");
//		q1.setContent("Test Content #01");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		q2.setSubject("Test Subject #02");
//		q2.setContent("Test Content #02");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
		
		/*-SELECT *- */
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("Test Subject #01", q.getSubject());
		
		/*-SELECT WHERE-*/
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("Test Subject #01", q.getSubject());
//		}
		
//		/*-SELECT WHERE-*/
//		Question q;
//		List<Question> qList;
//		q = this.questionRepository.findBySubject("Test Subject #01");
//		assertEquals(1, q.getId());
//		
//		q = this.questionRepository.findBySubjectAndContent("Test Subject #01", "Test Content #01");
//		assertEquals(1, q.getId());
//		
//		qList= this.questionRepository.findBySubjectLike("Test%");
//		q = qList.get(0);
//		assertEquals("Test Content #01", q.getContent());
		
		/*-UPDATE-*/
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setContent("Updated Test Content #01");
//		this.questionRepository.save(q);
		
		/*-DELETE-*/
//		long count;
//		
//		count = this.questionRepository.count();
//		assertEquals(2,count);
//		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		
//		Question q = oq.get();
//		
//		this.questionRepository.delete(q);
//		
//		count = this.questionRepository.count();
//		assertEquals(1,count);
//	}
	
//	@Test
//	@Transactional 
//	void testJpa() {
		
		/*Insert*/
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("Test Answer #01");
//		a.setQuestion(q);
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
		
		/*SELECT*/
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
		
		/**/
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		List<Answer> answerList = q.getAnswerList();
//		
//		assertEquals(1, answerList.size());
//		assertEquals("Test Answer #01", answerList.get(0).getContent());
//	}
	
//	@Test
//	void testJpa() {
//		for (int i = 1; i <= 300; i++) {
//			String subject = String.format("Test Date %03d", i);
//			String content = String.format(subject, i);
//			
//			this.questionService.create(subject, content, null);
//		}
		
//	}

}