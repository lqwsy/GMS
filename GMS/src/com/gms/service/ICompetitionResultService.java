package com.gms.service;

import java.util.List;

import com.gms.po.Competitionresult;

public interface ICompetitionResultService {
	Competitionresult getResultById(Long resultId);
	void addOneScore(Long resultId);
	void subOneScore(Long resultId);
	List<Competitionresult> getCompetitionResultsById(Long competitionId);
	Integer getScoresById(Long id);
}
