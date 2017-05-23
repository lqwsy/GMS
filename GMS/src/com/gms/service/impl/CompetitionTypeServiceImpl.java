package com.gms.service.impl;

import java.util.List;

import com.gms.dao.ICompetitionTypeDao;
import com.gms.po.Competitiontype;
import com.gms.service.ICompetitionTypeService;

public class CompetitionTypeServiceImpl implements ICompetitionTypeService{

	private ICompetitionTypeDao competitionTypeDao;

	public void setCompetitionTypeDao(ICompetitionTypeDao competitionTypeDao) {
		this.competitionTypeDao = competitionTypeDao;
	}

	@Override
	public Competitiontype getTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		return competitionTypeDao.get(typeId);
	}

	@Override
	public List getAllTypes() {
		// TODO Auto-generated method stub
		return competitionTypeDao.findAll();
	}

}
