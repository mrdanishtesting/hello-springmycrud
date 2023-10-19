package com.spgcrud.druc.restcontroller;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spgcrud.druc.dto.CommentDto;
import com.spgcrud.druc.entities.Comment;
import com.spgcrud.druc.services.CommentService;

@RestController
@RequestMapping("/api/post")
public class CommentController {


	@Autowired
	private CommentService commentService;
	
	//localhost:9090/api/post/{leadId}/comment
	@PostMapping("/{leadId}/comment")
	public ResponseEntity<CommentDto> createComment(@PathVariable (value ="leadId")long leadId,@RequestBody CommentDto commentDto){
				return new ResponseEntity<>(commentService.createComment(leadId,commentDto),HttpStatus.CREATED);
		
	}
	
	//localhost:9090/api/post/{leadId}/comment
	//localhost:9090/api/post/1/comment
	@GetMapping("/{leadId}/comment")
	public List<CommentDto> getByLeadId(@PathVariable long leadId ){
		List<CommentDto> dto = commentService.getLeadByLeadId(leadId);
		return dto;		
		
	}
	//localhost:9090/api/post/{leadId}/comment/id
	@PutMapping("/{leadId}/comment/{id}")
	public ResponseEntity<CommentDto> updateCommentDto(
			@PathVariable(value="leadId") long leadId,
			@PathVariable (value="id")long id,
			@RequestBody CommentDto commentDto
			){
		
		CommentDto dto = commentService.updateComment(leadId,id,commentDto);
	return	new ResponseEntity<CommentDto>(dto,HttpStatus.CREATED);
				 
		
	}
}
