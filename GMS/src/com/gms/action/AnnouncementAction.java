package com.gms.action;

import java.util.List;

import com.gms.po.Announcement;
import com.gms.service.IAnnouncementService;
import com.opensymphony.xwork2.ActionSupport;

public class AnnouncementAction extends ActionSupport{
	private Announcement announcement;
	private List<Announcement> announcements;
	
	private IAnnouncementService announcementService;

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	public void setAnnouncementService(IAnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public String addAnnouncement(){
		announcementService.addAnnouncement(announcement);
		return SUCCESS;
	}
	
	public String deleteAnnouncement(){
		announcementService.deleteAnnouncement(announcement.getBannouncementId());
		return SUCCESS;
	}
	
	public String updateAnnouncement(){
		Announcement announcementPo=announcementService.getAnnouncementById(
				announcement.getBannouncementId());
		announcementPo.setVannouncementTitle(announcement.getVannouncementTitle());
		announcementPo.setVannouncementDetails(announcement.getVannouncementDetails());
		announcementService.updateAnnouncement(announcementPo);
		return SUCCESS;
	}
	
	public String getAllAnnouncements(){
		announcements=announcementService.getAllAnnouncements();
		return SUCCESS;
	}
}
