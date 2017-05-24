package com.gms.dao;

import java.util.List;

import com.gms.po.Competitioncomment;

public interface ICompetitionCommentDao {
	Long save(Competitioncomment competitionComment);
	void delete(Competitioncomment competitionComment);
	Competitioncomment get(Long id);
	List findByCompetitionId(Long id);
}
