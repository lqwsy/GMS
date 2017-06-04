package com.gms.action;

import java.util.List;

import com.gms.po.Competitionreply;
import com.gms.po.Userinfo;
import com.gms.service.ICompetitionCommentService;
import com.gms.service.ICompetitionReplyService;
import com.gms.service.IUserinfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompetitionReplyAction extends ActionSupport{
	private Long commentId;
	private Competitionreply reply;
	private List<Competitionreply> replies;
	
	private IUserinfoService userinfoService;
	private ICompetitionCommentService competitionCommentService;
	private ICompetitionReplyService competitionReplyService;
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Competitionreply getReply() {
		return reply;
	}
	public void setReply(Competitionreply reply) {
		this.reply = reply;
	}
	public List<Competitionreply> getReplies() {
		return replies;
	}
	public void setReplies(List<Competitionreply> replies) {
		this.replies = replies;
	}
	public void setUserinfoService(IUserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	public void setCompetitionCommentService(ICompetitionCommentService competitionCommentService) {
		this.competitionCommentService = competitionCommentService;
	}
	public void setCompetitionReplyService(ICompetitionReplyService competitionReplyService) {
		this.competitionReplyService = competitionReplyService;
	}
	
	public String addCompetitionReply(){
		Userinfo cur_user=(Userinfo)ActionContext.getContext().getSession().get("cur_user");
		reply.setUserinfo(userinfoService.
				getUserinfoById(cur_user.getIuserId()));
		reply.setCompetitioncomment(competitionCommentService.
				getCommentById(commentId));
		Long id=competitionReplyService.addReply(reply);
		this.reply=competitionReplyService.getReplyById(id);
		return SUCCESS;
	}
	
	public String getCompetitionReplies(){
		this.replies=competitionReplyService.getReplysByCommentId(this.commentId);
		return SUCCESS;
	}
}
