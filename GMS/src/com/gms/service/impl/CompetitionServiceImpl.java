package com.gms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	public List getToVerifyCompetitions() {
		// TODO Auto-generated method stub
		String hql="from Competition c where c.vcompetitionState=?";
		return competitionDao.findCompetitions(hql, CompetitionState.TO_VERTIFY);
	}

	@Override
	public List getMyCompetitions(Integer userId) {
		// TODO Auto-generated method stub
		String hql="from Competition c where c.userinfo.iuserId=?";
		return competitionDao.findCompetitions(hql, userId);
	}

	@Override
	public List getAllToVerifyCompetitionsByPage(int page) {
		// TODO Auto-generated method stub
		String hql="from Competition c where c.vcompetitionState=?";
		return competitionDao.findByPage(hql, CompetitionState.TO_VERTIFY, 
				(page-1)*20, 20);
	}

	@Override
	public List getLiveCompetitions() {
		// TODO Auto-generated method stub
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		String hql="from Competition c where c.vcompetitionState=? or (c.vcompetitionState='"
				+ CompetitionState.NORMAL+"' and c.dcompetitionDate='"
						+dateString+"')";
		return competitionDao.
				findCompetitions(hql, CompetitionState.IN_PLAY);
	}

	@Override
	public List searchCompetitions(String keyword) {
		// TODO Auto-generated method stub
		String hql="select distinct c from Competition c inner join c.competitionresults r "
				+ "where (c.competitiontype.vcompetitionName like '%"+keyword+"%' or "
						+ "c.vmainUnit like '%"+keyword+"%' or "
								+ "r.vcompetitorUnit like '%"+keyword+"%' ) and "
										+ "c.vcompetitionState !='"+CompetitionState.CANCELLED+"' and "
												+ "c.vcompetitionState != '"+CompetitionState.TO_VERTIFY+"'";
		return competitionDao.findCompetitions(hql);
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
		competition=competitionDao.get(competitionId);
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
