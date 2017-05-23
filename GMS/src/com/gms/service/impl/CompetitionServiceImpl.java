package com.gms.service.impl;

import com.gms.dao.ICompetitionDao;
import com.gms.po.Competition;
import com.gms.service.ICompetitionService;
import com.gms.util.CompetitionState;

public class CompetitionServiceImpl implements ICompetitionService{
	private ICompetitionDao competitionDao;
	
	public void setCompetitionDao(ICompetitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}

	@Override
	public Competition getCompetitionById(Long competitionId) {
		// TODO Auto-generated method stub
		return competitionDao.get(competitionId);
	}

	@Override
	public Long addCompetition(Competition competition) {
		// TODO Auto-generated method stub
		competition.setVcompetitionState(CompetitionState.TO_VERTIFY);
		return competitionDao.save(competition);
	}

	@Override
	public void verifyCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		Competition competition=competitionDao.get(competitionId);
		competition.setVcompetitionState(CompetitionState.NORMAL);
		competitionDao.update(competition);
	}

	@Override
	public void delCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		Competition competition=competitionDao.get(competitionId);
		competition.setVcompetitionState(CompetitionState.DELETED);
		competitionDao.update(competition);
	}

	@Override
	public void delForeCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		Competition competition=competitionDao.get(competitionId);
		competitionDao.delete(competition);
	}

	@Override
	public void updateCompetition(Competition competition) {
		// TODO Auto-generated method stub
		competitionDao.update(competition);
	}

}
