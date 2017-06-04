package com.gms.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Competitioncomment entity. @author MyEclipse Persistence Tools
 */

public class Competitioncomment implements java.io.Serializable {

	// Fields

	private Long bcommentId;
	private Userinfo userinfo;
	private Competition competition;
	private String vcommentDetails;
	private Timestamp dcommentTime=new Timestamp(new java.util.Date().getTime());

	// Constructors

	/** default constructor */
	public Competitioncomment() {
	}

	/** full constructor */
	public Competitioncomment(Userinfo userinfo, Competition competition,
			String vcommentDetails, Timestamp dcommentTime) {
		this.userinfo = userinfo;
		this.competition = competition;
		this.vcommentDetails = vcommentDetails;
		this.dcommentTime = dcommentTime;
	}

	// Property accessors

	public Long getBcommentId() {
		return this.bcommentId;
	}

	public void setBcommentId(Long bcommentId) {
		this.bcommentId = bcommentId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@JSON(serialize=false)
	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public String getVcommentDetails() {
		return this.vcommentDetails;
	}

	public void setVcommentDetails(String vcommentDetails) {
		this.vcommentDetails = vcommentDetails;
	}

	public Timestamp getDcommentTime() {
		return this.dcommentTime;
	}

	public void setDcommentTime(Timestamp dcommentTime) {
		this.dcommentTime = dcommentTime;
	}

}