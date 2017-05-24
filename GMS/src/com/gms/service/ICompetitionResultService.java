package com.gms.service;

import com.gms.po.Competitionresult;

public interface ICompetitionResultService {
	Competitionresult getResultById(Long resultId);
	void addOneScore(Long resultId);
	void subOneScore(Long resultId);
}
