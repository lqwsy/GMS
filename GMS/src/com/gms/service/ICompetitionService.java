package com.gms.service;

import com.gms.po.Competition;

public interface ICompetitionService {
	Competition getCompetitionById(Long id);
	Long addCompetition(Competition competition);
	void verifyCompetition(Long id);
	void delCompetition(Long id);
	void delForeCompetition(Long id);
	void updateCompetition(Competition competition);
}
