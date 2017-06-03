package com.gms.po;

import java.sql.Timestamp;

import org.apache.struts2.json.annotations.JSON;

/**
 * Competitionreply entity. @author MyEclipse Persistence Tools
 */

public class Competitionreply implements java.io.Serializable {

	// Fields

	private Long breplyId;
	private Competitioncomment competitioncomment;
	private Userinfo userinfo;
	private String vreplyContents;
	private Timestamp dreplyTime=new Timestamp(new java.util.Date().getTime());

	// Constructors

	/** default constructor */
	public Competitionreply() {
	}

	/** full constructor */
	public Competitionreply(Competitioncomment competitioncomment,
			Userinfo userinfo, String vreplyContents, Timestamp dreplyTime) {
		this.competitioncomment = competitioncomment;
		this.userinfo = userinfo;
		this.vreplyContents = vreplyContents;
		this.dreplyTime = dreplyTime;
	}

	// Property accessors

	public Long getBreplyId() {
		return this.breplyId;
	}

	public void setBreplyId(Long breplyId) {
		this.breplyId = breplyId;
	}

	@JSON(serialize=false)
	public Competitioncomment getCompetitioncomment() {
		return this.competitioncomment;
	}

	public void setCompetitioncomment(Competitioncomment competitioncomment) {
		this.competitioncomment = competitioncomment;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getVreplyContents() {
		return this.vreplyContents;
	}

	public void setVreplyContents(String vreplyContents) {
		this.vreplyContents = vreplyContents;
	}

	public Timestamp getDreplyTime() {
		return this.dreplyTime;
	}

	public void setDreplyTime(Timestamp dreplyTime) {
		this.dreplyTime = dreplyTime;
	}

}