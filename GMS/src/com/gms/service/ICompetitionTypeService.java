package com.gms.service;

import java.util.List;

import com.gms.po.Competitiontype;

public interface ICompetitionTypeService {
	Competitiontype getTypeById(Integer typeId);
	List getAllTypes();
}
