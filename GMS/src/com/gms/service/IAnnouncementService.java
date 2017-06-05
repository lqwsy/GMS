package com.gms.service;

import java.util.List;

import com.gms.po.Announcement;

public interface IAnnouncementService {
	Announcement getAnnouncementById(Long id);
	Long addAnnouncement(Announcement announcement);
	void deleteAnnouncement(Long announcementId);
	void updateAnnouncement(Announcement announcement);
	List getAnnouncementsByPage(int page);
	List getAnnouncements();
}
