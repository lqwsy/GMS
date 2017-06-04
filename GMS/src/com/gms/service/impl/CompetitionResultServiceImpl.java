package com.gms.service.impl;

import java.util.List;

import com.gms.dao.ICompetitionResultDao;
import com.gms.po.Competitionresult;
import com.gms.service.ICompetitionResultService;

public class CompetitionResultServiceImpl implements ICompetitionResultService{
	private ICompetitionResultDao competitionResultDao;
	
	public void setCompetitionResultDao(ICompetitionResultDao competitionResultDao) {
		this.competitionResultDao = competitionResultDao;
	}

	@Override
	public Competitionresult getResultById(Long resultId) {
		// TODO Auto-generated method stub
		return competitionResultDao.get(resultId);
	}

	@Override
	public List<Competitionresult> getCompetitionResultsById(Long competitionId) {
		// TODO Auto-generated method stub
		return competitionResultDao.findResultsByCompetitionId(competitionId);
	}

	@Override
	public void addOneScore(Long resultId) {
		// TODO Auto-generated method stub
		Competitionresult result=competitionResultDao.get(resultId);
		result.setIscores(result.getIscores()+1);
		competitionResultDao.update(result);
	}

	@Override
	public void subOneScore(Long resultId) {
		// TODO Auto-generated method stub
		Competitionresult result=competitionResultDao.get(resultId);
		int score=result.getIscores()-1;
		if(score>=0){
			result.setIscores(score);
			competitionResultDao.update(result);
		}
	}

	@Override
	public Integer getScoresById(Long id) {
		// TODO Auto-generated method stub
		return competitionResultDao.getScore(id);
	}

}
