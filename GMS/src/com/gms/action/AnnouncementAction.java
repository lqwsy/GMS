package com.gms.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gms.po.Announcement;
import com.gms.service.IAnnouncementService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AnnouncementAction extends ActionSupport{
	
	private int page;
	private Announcement announcement;
	private List<Announcement> announcements;
	private IAnnouncementService announcementService;
	private String ann_result;
	

	public String getAnn_result() {
		return ann_result;
	}

	public void setAnn_result(String ann_result) {
		this.ann_result = ann_result;
	}

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
		if(announcement==null){
			this.setAnn_result("�����빫����Ϣ");
			return INPUT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		announcement.setDannouncementTime(sdf.format(new Date()));
		announcementService.addAnnouncement(announcement);
		this.setAnn_result("��ӳɹ�");
		return SUCCESS;
	}
	
	//����ɾ��
	public String deleteAnnouncement(){
		announcementService.deleteAnnouncement(announcement.getBannouncementId());
		getAllAnnouncements();
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
	@SuppressWarnings("unchecked")
	public String getAllAnnouncements(){
		announcements=announcementService.getAnnouncements();
		if(!announcements.isEmpty()){
			Map<String,Object> map=ActionContext.getContext().getSession();
			map.remove("all_announcements");
			map.put("all_announcements", announcements);//��session����������й�����Ϣ
			System.out.println("�ܹ���"+announcements.size()+"������");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
