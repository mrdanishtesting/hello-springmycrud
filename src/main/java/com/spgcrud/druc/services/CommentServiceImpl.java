   package com.spgcrud.druc.services;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spgcrud.druc.dto.CommentDto;
import com.spgcrud.druc.entities.Comment;
import com.spgcrud.druc.entities.Lead;
import com.spgcrud.druc.exception.ResourceNotFoundException;
import com.spgcrud.druc.repositories.CommentRepository;
import com.spgcrud.druc.repositories.LeadRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private LeadRepository leadRepository;

	@Override
	public CommentDto createComment(long leadId, CommentDto commentDto) {
	Lead lead=leadRepository.findById(leadId).orElseThrow(()->new ResourceNotFoundException("Post", "id", leadId) );
	Comment comment = maptoComment(commentDto);
		comment.setLead(lead);
		Comment cmt = commentRepository.save(comment);
		CommentDto dto = maptoCommentDto(cmt);
		return dto;
	}

     public CommentDto maptoCommentDto(Comment comment) {
    	 CommentDto commentDto=new CommentDto();
    	 commentDto.setId(comment.getId());
    	 commentDto.setEmail(comment.getEmail());
    	 commentDto.setName(comment.getName());
    	 commentDto.setBody(comment.getBody());
    	 return commentDto;
     }

    public Comment maptoComment(CommentDto commentDto) {
     Comment comment=new Comment();
     comment.setEmail(commentDto.getEmail());
     comment.setName(commentDto.getName());
     comment.setBody(commentDto.getBody());
    
    return comment;

}

	@Override
	public List<CommentDto> getLeadByLeadId(long leadId) {
		List<Comment> listleads = commentRepository.findByLeadId(leadId);
		return listleads.stream().map(c->maptoCommentDto(c)).collect(Collectors.toList());
		 
	}

	@Override
	public CommentDto updateComment(long leadId, long id, CommentDto commentDto) {
   leadRepository.findById(leadId)//is there a post with this id exist
		   .orElseThrow(
				   ()->new ResourceNotFoundException("post", "id",leadId)
				   );
   Comment comment = commentRepository.findById(id)//is there a cmt with this id exist
   .orElseThrow(()->new ResourceNotFoundException(
		   "comment", "id", id)
		   );
    comment.setBody(commentDto.getBody());
    comment.setEmail(commentDto.getEmail());
    comment.setName(commentDto.getName());
      Comment cmtEntity = commentRepository.save(comment);
		 return maptoCommentDto(cmtEntity);
	}
}