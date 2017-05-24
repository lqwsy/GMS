package com.gms.dao;

import java.util.List;

import com.gms.po.Competition;

public interface ICompetitionDao {
	Long save(Competition competition);
	void delete(Competition competition);
	void update(Competition competition);
	Competition get(Long id);
	List findAll();
}
