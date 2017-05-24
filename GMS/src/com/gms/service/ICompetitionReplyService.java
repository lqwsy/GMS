package com.gms.service;

import java.util.List;

import com.gms.po.Competitionreply;

public interface ICompetitionReplyService {
	Competitionreply getReplyById(Long replyId);
	Long addReply(Competitionreply reply);
	void deleteReply(Long replyId);
	List getReplysByCommentId(Long commentId);
}
