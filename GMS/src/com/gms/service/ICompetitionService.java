package com.gms.service;

import com.gms.po.Competition;

public interface ICompetitionService {
	Competition getCompetitionById(Long competitionId);
	Long addCompetition(Competition competition);
	void verifyCompetition(Long competitionId);
	void delCompetition(Long competitionId);
	void delForeCompetition(Long competitionId);
	void updateCompetition(Competition competition);
}
