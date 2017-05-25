package com.gms.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.gms.po.Competition;
import com.gms.po.Competitionresult;
import com.gms.po.Equitmentsuse;
import com.gms.po.Spacesuse;
import com.gms.service.ICompetitionResultService;
import com.gms.service.ICompetitionService;
import com.gms.service.ICompetitionTypeService;
import com.gms.service.IEquitmentsUseService;
import com.gms.service.ISpacesUseService;
import com.opensymphony.xwork2.ActionSupport;

public class CompetitionAction extends ActionSupport{
	private int page;
	private Competition competition;
	private Set<Competitionresult> competitionresults;//赛事结果
	private Spacesuse spacesuse;//赛事场地
	private Equitmentsuse equitmentsuse;//赛事器材
	private String keyword;//搜索关键字
	private InputStream resultStream;//ajax请求结果标识
	private List<Competition> competitions;
	
	private ICompetitionTypeService competitionTypeService;
	private ISpacesUseService spacesUseService;
	private IEquitmentsUseService equitmentsUseService;
	private ICompetitionService competitionService;
	private ICompetitionResultService competitionResultServie;
	//other module
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Set<Competitionresult> getCompetitionresults() {
		return competitionresults;
	}

	public void setCompetitionresults(Set<Competitionresult> competitionresults) {
		this.competitionresults = competitionresults;
	}

	public Spacesuse getSpacesuse() {
		return spacesuse;
	}

	public void setSpacesuse(Spacesuse spacesuse) {
		this.spacesuse = spacesuse;
	}

	public Equitmentsuse getEquitmentsuse() {
		return equitmentsuse;
	}

	public void setEquitmentsuse(Equitmentsuse equitmentsuse) {
		this.equitmentsuse = equitmentsuse;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public InputStream getResult(){
		return this.resultStream;
	}
	
	public void setResult(String result) throws Exception{
		this.resultStream=new ByteArrayInputStream(result.getBytes("UTF-8"));
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public void setCompetitionTypeService(ICompetitionTypeService competitionTypeService) {
		this.competitionTypeService = competitionTypeService;
	}

	public void setSpacesUseService(ISpacesUseService spacesUseService) {
		this.spacesUseService = spacesUseService;
	}

	public void setEquitmentsUseService(IEquitmentsUseService equitmentsUseService) {
		this.equitmentsUseService = equitmentsUseService;
	}

	public void setCompetitionService(ICompetitionService competitionService) {
		this.competitionService = competitionService;
	}
	
	public void setCompetitionResultServie(ICompetitionResultService competitionResultServie) {
		this.competitionResultServie = competitionResultServie;
	}

	//赛事申请
	public String addCompetition(){
		if(competition==null){
			return INPUT;
		}
		competition.setCompetitiontype(competitionTypeService.getTypeById(
				competition.getCompetitiontype().getIcompetitionType()));
		//TODO rely on userService#getUser
		competition.setCompetitionresults(competitionresults);//设置赛事结果
		//TODO rely on fileInfoService#getFileInfo
		competition.getSpacesuses().add(spacesuse);
		//TODO rely on equitmentService#getEquitment
		competition.getEquitmentsuses().add(equitmentsuse);
		competitionService.addCompetition(competition);
		return SUCCESS;
	}
	
	//赛事取消
	public String cancel(){
		competitionService.cancelCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//赛事认证
	public String verifyCompetition(){
		competitionService.verifyCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//开始赛事
	public String startCompetition(){
		competitionService.startCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//结束赛事
	public String endCompetition(){
		competitionService.endCoompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//删除赛事
	public String delCompetition(){
		competitionService.delCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//彻底删除赛事
	public String delForeCompetition(){
		competitionService.delForeCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//更新赛事信息
	public String updateForeCompetition(){
		Competition competitionPo=competitionService.getCompetitionById(competition.getBcompetitionId());//从数据库拉取赛事信息
		competitionPo.setCompetitiontype(competitionTypeService.getTypeById(
				competition.getCompetitiontype().getIcompetitionType()));//设置赛事类型
		
		Set results=competitionPo.getCompetitionresults();
		results.clear();
		Iterator<Competitionresult> iter=competitionresults.iterator();
		while(iter.hasNext()){
			Competitionresult result=iter.next();
			Competitionresult resultPo=competitionResultServie.getResultById(
					result.getBcompetitionResultId());
			resultPo.setVcompetitorUnit(result.getVcompetitorUnit());
			results.add(resultPo);
		}
		//TODO set the competition property
		competitionService.updateCompetition(competitionPo);
		return SUCCESS;
	}
	
	//获取赛事详情
	public String getCompetitionDetails(){
		competition=competitionService.getCompetitionById(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//获取所有赛事
	public String getAllCompetitions(){
		competitions=(List<Competition>)competitionService.getAllCompetitionsByPage(page);
		return SUCCESS;
	}
}
