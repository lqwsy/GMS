package com.gms.dao;

import java.util.List;

import com.gms.po.Announcement;

public interface IAnnouncementDao {
	Long save(Announcement announcement);
	void delete(Announcement announcement);
	void update(Announcement announcement);
	Announcement get(Long id);
	List findAll();
}
