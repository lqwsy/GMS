package com.gms.action;

import java.util.List;

import com.gms.po.Competitioncomment;
import com.gms.po.Userinfo;
import com.gms.service.ICompetitionCommentService;
import com.gms.service.ICompetitionService;
import com.gms.service.IUserinfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompetitionCommentAction extends ActionSupport{
	private Long ci;
	private Competitioncomment comment;
	private List<Competitioncomment> comments;
	
	private IUserinfoService userinfoService;
	private ICompetitionService competitionService;
	private ICompetitionCommentService competitionCommentService;

	public Long getCi() {
		return ci;
	}

	public void setCi(Long ci) {
		this.ci = ci;
	}

	public Competitioncomment getComment() {
		return comment;
	}

	public void setComment(Competitioncomment comment) {
		this.comment = comment;
	}

	public List<Competitioncomment> getComments() {
		return comments;
	}

	public void setComments(List<Competitioncomment> comments) {
		this.comments = comments;
	}

	public void setUserinfoService(IUserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public void setCompetitionService(ICompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	public void setCompetitionCommentService(ICompetitionCommentService competitionCommentService) {
		this.competitionCommentService = competitionCommentService;
	}
	
	public String addCompetitionComment(){
		Userinfo cur_user=(Userinfo)ActionContext.getContext().getSession().get("cur_user");
		comment.setUserinfo(userinfoService.
				getUserinfoById(cur_user.getIuserId()));
		comment.setCompetition(competitionService.
				getCompetitionById(this.ci));
		Long id=competitionCommentService.addComment(comment);//±£´æ
		this.comment=competitionCommentService.getCommentById(id);//È¡³ö
		return SUCCESS;
	}
	
	public String getCompetitionComments(){
		this.comments=competitionCommentService.
				getCommentsByCompetitionId(this.ci);
		return SUCCESS;
	}
}
