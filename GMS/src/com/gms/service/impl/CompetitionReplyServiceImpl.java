package com.gms.service.impl;

import java.util.List;

import com.gms.dao.ICompetitionReplyDao;
import com.gms.po.Competitionreply;
import com.gms.service.ICompetitionReplyService;

public class CompetitionReplyServiceImpl implements ICompetitionReplyService{
	private ICompetitionReplyDao competitionReplyDao;
	public void setCompetitionReplyDao(ICompetitionReplyDao competitionReplyDao) {
		this.competitionReplyDao = competitionReplyDao;
	}

	@Override
	public Competitionreply getReplyById(Long replyId) {
		// TODO Auto-generated method stub
		return competitionReplyDao.get(replyId);
	}

	@Override
	public Long addReply(Competitionreply reply) {
		// TODO Auto-generated method stub
		return competitionReplyDao.save(reply);
	}

	@Override
	public void deleteReply(Long replyId) {
		// TODO Auto-generated method stub
		Competitionreply reply=competitionReplyDao.get(replyId);
		competitionReplyDao.delete(reply);
	}

	@Override
	public List getReplysByCommentId(Long commentId) {
		// TODO Auto-generated method stub
		return competitionReplyDao.findByCommentId(commentId);
	}

}
