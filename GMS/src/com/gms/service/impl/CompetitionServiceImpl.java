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
	public Competition getCompetitionById(Long id) {
		// TODO Auto-generated method stub
		return competitionDao.get(id);
	}

	@Override
	public Long addCompetition(Competition competition) {
		// TODO Auto-generated method stub
		competition.setVcompetitionState(CompetitionState.TO_VERTIFY);
		return competitionDao.save(competition);
	}

	@Override
	public void verifyCompetition(Long id) {
		// TODO Auto-generated method stub
		Competition competition=competitionDao.get(id);
		competition.setVcompetitionState(CompetitionState.NORMAL);
		competitionDao.update(competition);
	}

	@Override
	public void delCompetition(Long id) {
		// TODO Auto-generated method stub
		Competition competition=competitionDao.get(id);
		competition.setVcompetitionState(CompetitionState.DELETED);
		competitionDao.update(competition);
	}

	@Override
	public void delForeCompetition(Long id) {
		// TODO Auto-generated method stub
		Competition competition=competitionDao.get(id);
		competitionDao.delete(competition);
	}

	@Override
	public void updateCompetition(Competition competition) {
		// TODO Auto-generated method stub
		competitionDao.update(competition);
	}

}
