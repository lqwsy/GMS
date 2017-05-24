package com.gms.dao;

import java.util.List;

import com.gms.po.Competitiontype;

public interface ICompetitionTypeDao {
	Competitiontype get(Integer typeId);
	List findAll();
}
