package com.gms.dao;

import java.util.List;

import com.gms.po.Competitionresult;

public interface ICompetitionResultDao {
	Competitionresult get(Long id);
	Integer getScore(Long id);
	void update(Competitionresult result);
	List findResultsByCompetitionId(Long competitionId);
}
