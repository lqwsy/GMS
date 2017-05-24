package com.gms.service;

import java.util.List;

import com.gms.po.Announcement;

public interface IAnnouncementService {
	Long addAnnouncement(Announcement announcement);
	void deleteAnnouncement(Long announcementId);
	void updateAnnouncement(Announcement announcement);
	List getAllAnnouncements();
}
