package com.gms.service;

import java.util.List;

import com.gms.po.Competitioncomment;

public interface ICompetitionCommentService {
	Competitioncomment getCommentById(Long commentId);
	Long addComment(Competitioncomment comment);
	void deleteComment(Long commentId);
	List getCommentsByCompetitionId(Long competitionId);
}
