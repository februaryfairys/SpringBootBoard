package com.springBootBoard.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String Subject);
	Page<Question> findAll(Pageable pageable);
	Page<Question> findAll(Specification<Question> spec, Pageable pageable);
	
	@Query("SELECT "
		+ "DISTINCT q "
		+ "FROM Question q "
		+ 	"LEFT OUTER JOIN SiteUser u1 ON q.author   = u1 "
		+ 	"LEFT OUTER JOIN Answer   a  ON a.question = q "
		+ 	"LEFT OUTER JOIN SiteUser u2 ON a.author   = u2 "
		+ "WHERE 1=1 "
		+  "AND q.subject LIKE %:kw% "
		+ 	"OR q.content LIKE %:kw% "
		+ 	"OR a.content LIKE %:kw% "
		+ 	"OR u1.username LIKE %:kw% "
		+ 	"OR u2.username LIKE %:kw%")
	Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}