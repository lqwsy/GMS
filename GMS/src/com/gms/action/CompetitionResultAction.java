package com.gms.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.gms.po.Competition;
import com.gms.po.Competitionresult;
import com.gms.service.ICompetitionResultService;
import com.gms.service.ICompetitionService;
import com.opensymphony.xwork2.ActionSupport;

public class CompetitionResultAction extends ActionSupport{
	private Long ci;
	private Long competitionResultId;
	private Competition competition;
	private List<Competitionresult> competitionResults;
		
	private InputStream resultStream;//ajax请求结果标识
	
	private ICompetitionService competitionService;
	private ICompetitionResultService competitionResultService;

	/**
	 * @return the ci
	 */
	public Long getCi() {
		return ci;
	}

	/**
	 * @param ci the ci to set
	 */
	public void setCi(Long ci) {
		this.ci = ci;
	}

	public Long getCompetitionResultId() {
		return competitionResultId;
	}

	public void setCompetitionResultId(Long competitionResultId) {
		this.competitionResultId = competitionResultId;
	}

	/**
	 * @return the competition
	 */
	public Competition getCompetition() {
		return competition;
	}

	/**
	 * @param competition the competition to set
	 */
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	/**
	 * @return the competitionResults
	 */
	public List<Competitionresult> getCompetitionResults() {
		return competitionResults;
	}

	/**
	 * @param competitionResults the competitionResults to set
	 */
	public void setCompetitionResults(List<Competitionresult> competitionResults) {
		this.competitionResults = competitionResults;
	}

	public InputStream getResult(){
		return this.resultStream;
	}
	
	public void setResult(String result) {
		try{
			this.resultStream=new ByteArrayInputStream(result.getBytes("UTF-8"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @param competitionService the competitionService to set
	 */
	public void setCompetitionService(ICompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	public void setCompetitionResultService(ICompetitionResultService competitionResultService) {
		this.competitionResultService = competitionResultService;
	}

	//直播页面
	public String competitionLive(){
		if(this.ci!=null){
			this.competition=competitionService.getCompetitionById(ci);
			this.competitionResults=competitionResultService.getCompetitionResultsById(this.ci);
		}
		return SUCCESS;
	}
	
	//加一分
	public String addOneScore(){
		try{
			competitionResultService.addOneScore(competitionResultId);
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
	//减一分
	public String subOneScore(){
		try{
			competitionResultService.subOneScore(competitionResultId);
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
	//查询得分
	public String getScores(){
		try{
			int score=competitionResultService.getScoresById(competitionResultId);
			this.setResult(String.valueOf(score));
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
}
