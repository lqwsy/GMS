package com.gms.service.impl;

import java.util.List;

import com.gms.dao.ICompetitionDao;
import com.gms.po.Competition;
import com.gms.service.ICompetitionService;
import com.gms.util.CompetitionState;

public class CompetitionServiceImpl implements ICompetitionService{
	Competition competition=null;
	private ICompetitionDao competitionDao;
	//TODO rely on userService
	
	public void setCompetitionDao(ICompetitionDao competitionDao) {
		this.competitionDao = competitionDao;
	}

	@Override
	public Competition getCompetitionById(Long competitionId) {
		// TODO Auto-generated method stub
		return competitionDao.get(competitionId);
	}

	@Override
	public List getAllCompetitions() {
		// TODO Auto-generated method stub
		return competitionDao.findAll();
	}

	@Override
	public Long addCompetition(Competition competition) {
		// TODO Auto-generated method stub
		competition.setVcompetitionState(CompetitionState.TO_VERTIFY);
		return competitionDao.save(competition);
	}

	@Override
	public void cancelCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		competition.setVcompetitionState(CompetitionState.TO_VERTIFY);
		competition.setVcompetitionState(CompetitionState.CANCELLED);
		competitionDao.update(competition);
	}

	@Override
	public void verifyCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		competition=competitionDao.get(competitionId);
		competition.setVcompetitionState(CompetitionState.NORMAL);
		competitionDao.update(competition);
	}

	@Override
	public void startCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		competition=competitionDao.get(competitionId);
		competition.setVcompetitionState(CompetitionState.IN_PLAY);
		competitionDao.update(competition);
	}

	@Override
	public void endCoompetition(Long competitionId) {
		// TODO Auto-generated method stub
		competition=competitionDao.get(competitionId);
		competition.setVcompetitionState(CompetitionState.OVER);
		competitionDao.update(competition);
	}

	@Override
	public void delCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		competition=competitionDao.get(competitionId);
		competition.setVcompetitionState(CompetitionState.DELETED);
		competitionDao.update(competition);
	}

	@Override
	public void delForeCompetition(Long competitionId) {
		// TODO Auto-generated method stub
		competition=competitionDao.get(competitionId);
		competitionDao.delete(competition);
	}

	@Override
	public void updateCompetition(Competition competition) {
		// TODO Auto-generated method stub
		competitionDao.update(competition);
	}

}
