package com.spgcrud.druc.services;

import java.util.List;

import com.spgcrud.druc.dto.CommentDto;
import com.spgcrud.druc.entities.Comment;

public interface CommentService {

CommentDto createComment(long leadId, CommentDto commentDto);

List<CommentDto> getLeadByLeadId(long leadId);

CommentDto updateComment(long leadId, long id, CommentDto commentDto);
}
