package com.gms.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.gms.po.Competition;
import com.gms.po.Competitionresult;
import com.gms.po.Competitiontype;
import com.gms.po.Equitmentsuse;
import com.gms.po.Fieldinfo;
import com.gms.po.Fieldtype;
import com.gms.po.Spacesuse;
import com.gms.po.Userinfo;
import com.gms.service.ICompetitionResultService;
import com.gms.service.ICompetitionService;
import com.gms.service.ICompetitionTypeService;
import com.gms.service.IEquitmentsUseService;
import com.gms.service.IFieldinfoService;
import com.gms.service.IFieldtypeService;
import com.gms.service.ISpacesUseService;
import com.gms.service.IUserinfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompetitionAction extends ActionSupport{
	private int page;
	private String operation;
	private Long ci;
	private Competition competition;
	private Set<Competitionresult> competitionresults;//���½��
	private Spacesuse spacesuse;//���³���
	private Equitmentsuse equitmentsuse;//��������
	private String keyword;//�����ؼ���
	private InputStream resultStream;//ajax��������ʶ
	private List<Competitiontype> competitionTypes;
	private List<Competition> competitions;
	
	//����
	private Long fieldtypeId;
	private List<Fieldtype> fieldTypes;
	private List<Fieldinfo> fieldInfos;
	
	private String actionName;
	
	//ҵ�����
	private IUserinfoService userinfoService;
	private ICompetitionTypeService competitionTypeService;
	private ISpacesUseService spacesUseService;
	private IEquitmentsUseService equitmentsUseService;
	private ICompetitionService competitionService;
	private ICompetitionResultService competitionResultService;
	
	private IFieldtypeService fieldtypeService;
	private IFieldinfoService fieldinfoService;
	//other module service
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

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
	
	public void setResult(String result) {
		try{
			this.resultStream=new ByteArrayInputStream(result.getBytes("UTF-8"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Competitiontype> getCompetitionTypes() {
		return competitionTypes;
	}

	public void setCompetitionTypes(List<Competitiontype> competitionTypes) {
		this.competitionTypes = competitionTypes;
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}

	public Long getFieldtypeId() {
		return fieldtypeId;
	}

	public void setFieldtypeId(Long fieldtypeId) {
		this.fieldtypeId = fieldtypeId;
	}

	public List<Fieldtype> getFieldTypes() {
		return fieldTypes;
	}

	public void setFieldTypes(List<Fieldtype> fieldTypes) {
		this.fieldTypes = fieldTypes;
	}

	public List<Fieldinfo> getFieldInfos() {
		return fieldInfos;
	}

	public void setFieldInfos(List<Fieldinfo> fieldInfos) {
		this.fieldInfos = fieldInfos;
	}

	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public void setUserinfoService(IUserinfoService userinfoService) {
		this.userinfoService = userinfoService;
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
	
	public void setCompetitionResultService(ICompetitionResultService competitionResultService) {
		this.competitionResultService = competitionResultService;
	}

	public void setFieldtypeService(IFieldtypeService fieldtypeService) {
		this.fieldtypeService = fieldtypeService;
	}

	public void setFieldinfoService(IFieldinfoService fieldinfoService) {
		this.fieldinfoService = fieldinfoService;
	}

	//�������� done
	public String addCompetition(){
		Userinfo cur_user=(Userinfo)ActionContext.getContext().getSession().get("cur_user");
		if(competition==null){
			fieldTypes=fieldtypeService.getAllFieldtype();
			competitionTypes=competitionTypeService.getAllTypes();
			return INPUT;
		}
		competition.setCompetitiontype(competitionTypeService.getTypeById(
				competition.getCompetitiontype().getIcompetitionType()));
		competition.setUserinfo((Userinfo)userinfoService.getUserinfoById(cur_user.getIuserId()));
		competition.setCompetitionresults(competitionresults);//�������½��
		Fieldinfo fieldPo=fieldinfoService.getFieldinfoById(spacesuse.getFieldinfo().getFieldId());
		spacesuse.setFieldinfo(fieldPo);
		competition.getSpacesuses().add(spacesuse);
		//TODO rely on equitmentService#getEquitment
		//competition.getEquitmentsuses().add(equitmentsuse);
		try{
			competitionService.addCompetition(competition);
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
	public String getFields(){
		fieldInfos=fieldinfoService.getFieldinfoByFieldtypeId(fieldtypeId);
		return SUCCESS;
	}
	
	//����ȡ��done
	public String cancelCompetition(){
		Userinfo cur_user=(Userinfo)ActionContext.getContext().getSession().get("cur_user");
		Competition competitionPo=competitionService.
				getCompetitionById(this.ci);//�����ݿ���ȡ������Ϣ
		if(cur_user.getIuserId().intValue()!=competitionPo.getUserinfo().getIuserId().intValue()){
			this.setResult("-1");
			return SUCCESS;
		}
		try{
			competitionService.cancelCompetition(this.ci);
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
	//������֤>>>>>>>����Ա*****done
	public String verifyCompetition(){
		if(this.ci==null){
			competitions=(List<Competition>)competitionService.getAllToVerifyCompetitionsByPage(page);
			return INPUT;
		}
		try{
			if("pass".equals(this.operation)){
				competitionService.verifyCompetition(this.ci);
			}
			else{
				competitionService.cancelCompetition(this.ci);
			}
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
	//��ʼ����>>>>>>>����Ա******done
	public String startCompetition(){
		try{
			competitionService.startCompetition(this.ci);
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
	//��������>>>>>>����Ա******done
	public String endCompetition(){
		try{
			competitionService.endCoompetition(this.ci);
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
//	//ɾ������
//	public String delCompetition(){
//		competitionService.delCompetition(competition.getBcompetitionId());
//		return SUCCESS;
//	}
//	
//	//����ɾ������
//	public String delForeCompetition(){
//		competitionService.delForeCompetition(competition.getBcompetitionId());
//		return SUCCESS;
//	}
//	
	//����������Ϣ done
	public String updateCompetition(){
		Userinfo cur_user=(Userinfo)ActionContext.getContext().getSession().get("cur_user");
		if(this.ci!=null){
			competitionTypes=competitionTypeService.getAllTypes();
			competition=competitionService.getCompetitionById(this.ci);
			if(cur_user.getIuserId().intValue()!=competition.getUserinfo().getIuserId().intValue()){
				return "noauthority";
			}
			return INPUT;
		}
		Competition competitionPo=competitionService.
				getCompetitionById(competition.getBcompetitionId());//�����ݿ���ȡ������Ϣ
		if(cur_user.getIuserId().intValue()!=competitionPo.getUserinfo().getIuserId().intValue()){
			this.setResult("-1");
			return SUCCESS;
		}
		competitionPo.setCompetitiontype(competitionTypeService.getTypeById(
				competition.getCompetitiontype().getIcompetitionType()));//������������
		//���½��
		Set results=competitionPo.getCompetitionresults();
		results.clear();
		Iterator<Competitionresult> iter=competitionresults.iterator();
		while(iter.hasNext()){
			Competitionresult result=iter.next();
			Competitionresult resultPo=competitionResultService.getResultById(
					result.getBcompetitionResultId());
			resultPo.setVcompetitorUnit(result.getVcompetitorUnit());
			results.add(resultPo);
		}
		//������������
		competitionPo.setDcompetitionDate(competition.getDcompetitionDate());
		competitionPo.setVcompetitionDetails(competition.getVcompetitionDetails());
		competitionPo.setVlinkMan(competition.getVlinkMan());
		competitionPo.setVphoneNumber(competition.getVphoneNumber());
		competitionPo.setVmainUnit(competition.getVmainUnit());
		competitionPo.setVunitAddress(competition.getVunitAddress());
		try{
			competitionService.updateCompetition(competitionPo);
			this.setResult("1");
		}
		catch(Exception e){
			e.printStackTrace();
			this.setResult("0");
		}
		return SUCCESS;
	}
	
	//��ȡ��������  done
	public String getCompetitionDetails(){
		if(this.ci==null){
			return "mylist";
		}
		competition=competitionService.getCompetitionById(this.ci);
		return SUCCESS;
	}
	
	//��ȡ�ҵ����� done
	public String getMyCompetitions(){
		Userinfo cur_user=(Userinfo)ActionContext.getContext().getSession().get("cur_user");
		competitions=competitionService.getMyCompetitions(cur_user.getIuserId());
		return SUCCESS;
	}
	
	//��ȡֱ������done
	public String getLiveComeptitions(){
		competitions=competitionService.getLiveCompetitions();
		return SUCCESS;
	}
	
	//��������
	public String searchCompetitions(){
		if(keyword!=null){
			competitions=competitionService.searchCompetitions(keyword.trim());
		}
		return SUCCESS;
	}
	
}
