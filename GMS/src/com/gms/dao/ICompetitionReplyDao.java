package com.gms.dao;

import java.util.List;

import com.gms.po.Competitionreply;

public interface ICompetitionReplyDao {
	Long save(Competitionreply reply);
	void delete(Competitionreply reply);
	Competitionreply get(Long id);
	List findByCommentId(Long id);
}
