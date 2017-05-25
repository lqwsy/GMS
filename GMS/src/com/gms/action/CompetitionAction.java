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
	private Set<Competitionresult> competitionresults;//���½��
	private Spacesuse spacesuse;//���³���
	private Equitmentsuse equitmentsuse;//��������
	private String keyword;//�����ؼ���
	private InputStream resultStream;//ajax��������ʶ
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

	//��������
	public String addCompetition(){
		if(competition==null){
			return INPUT;
		}
		competition.setCompetitiontype(competitionTypeService.getTypeById(
				competition.getCompetitiontype().getIcompetitionType()));
		//TODO rely on userService#getUser
		competition.setCompetitionresults(competitionresults);//�������½��
		//TODO rely on fileInfoService#getFileInfo
		competition.getSpacesuses().add(spacesuse);
		//TODO rely on equitmentService#getEquitment
		competition.getEquitmentsuses().add(equitmentsuse);
		competitionService.addCompetition(competition);
		return SUCCESS;
	}
	
	//����ȡ��
	public String cancel(){
		competitionService.cancelCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//������֤
	public String verifyCompetition(){
		competitionService.verifyCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//��ʼ����
	public String startCompetition(){
		competitionService.startCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//��������
	public String endCompetition(){
		competitionService.endCoompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//ɾ������
	public String delCompetition(){
		competitionService.delCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//����ɾ������
	public String delForeCompetition(){
		competitionService.delForeCompetition(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//����������Ϣ
	public String updateForeCompetition(){
		Competition competitionPo=competitionService.getCompetitionById(competition.getBcompetitionId());//�����ݿ���ȡ������Ϣ
		competitionPo.setCompetitiontype(competitionTypeService.getTypeById(
				competition.getCompetitiontype().getIcompetitionType()));//������������
		
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
	
	//��ȡ��������
	public String getCompetitionDetails(){
		competition=competitionService.getCompetitionById(competition.getBcompetitionId());
		return SUCCESS;
	}
	
	//��ȡ��������
	public String getAllCompetitions(){
		competitions=(List<Competition>)competitionService.getAllCompetitionsByPage(page);
		return SUCCESS;
	}
}
