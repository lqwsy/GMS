package com.gms.action;

import java.util.List;

import com.gms.po.Announcement;
import com.gms.service.IAnnouncementService;
import com.opensymphony.xwork2.ActionSupport;

public class AnnouncementAction extends ActionSupport{
	private int page;
	private Announcement announcement;
	private List<Announcement> announcements;
	
	private IAnnouncementService announcementService;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

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

	//���淢��
	public String addAnnouncement(){
		announcementService.addAnnouncement(announcement);
		return SUCCESS;
	}
	
	//����ɾ��
	public String deleteAnnouncement(){
		announcementService.deleteAnnouncement(announcement.getBannouncementId());
		return SUCCESS;
	}
	
	//�������
	public String updateAnnouncement(){
		Announcement announcementPo=announcementService.getAnnouncementById(
				announcement.getBannouncementId());
		announcementPo.setVannouncementTitle(announcement.getVannouncementTitle());
		announcementPo.setVannouncementDetails(announcement.getVannouncementDetails());
		announcementService.updateAnnouncement(announcementPo);
		return SUCCESS;
	}
	
	//��ȡ���й���
	public String getAllAnnouncements(){
		announcements=announcementService.getAnnouncementsByPage(page);
		return SUCCESS;
	}
}
