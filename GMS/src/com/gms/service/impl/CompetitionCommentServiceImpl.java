package com.gms.service.impl;

import java.util.List;

import com.gms.dao.ICompetitionCommentDao;
import com.gms.po.Competitioncomment;
import com.gms.service.ICompetitionCommentService;

public class CompetitionCommentServiceImpl implements ICompetitionCommentService{
	private ICompetitionCommentDao competitionCommentDao;

	public void setCompetitionCommentDao(ICompetitionCommentDao competitionCommentDao) {
		this.competitionCommentDao = competitionCommentDao;
	}

	@Override
	public Competitioncomment getCommentById(Long commentId) {
		// TODO Auto-generated method stub
		return competitionCommentDao.get(commentId);
	}

	@Override
	public Long addComment(Competitioncomment comment) {
		// TODO Auto-generated method stub
		return (Long)competitionCommentDao.save(comment);
	}

	@Override
	public void deleteComment(Long commentId) {
		// TODO Auto-generated method stub
		Competitioncomment comment=competitionCommentDao.get(commentId);
		competitionCommentDao.delete(comment);
	}

	@Override
	public List getCommentsByCompetitionId(Long competitionId) {
		// TODO Auto-generated method stub
		return competitionCommentDao.findByCompetitionId(competitionId);
	}
	
}
