package com.museum.domain;

import java.util.Date;

/**
 * Exhibits entity. @author MyEclipse Persistence Tools
 */

public class Exhibits implements java.io.Serializable {

	// Fields

	private Integer exhibitsId;
	private Nation nation;
	private Apply apply;
	private State state;
	private Dynasty dynasty;
	private Material material;
	private Hall hall;
	private Religion religion;
	private Value value;
	private Integer exhibitsCherish;
	private String exhibitsName;
	private String exhibitsProducePlace;
	private Date exhibitsProduceTime;
	private String exhibitsExcavatePlace;
	private Date exhibitsExcavateTime;
	private Integer exhibitsLocationX;
	private Integer exhibitsLocationY;
	private Integer exhibitsLocationNumber;
	private String exhibitsAppearance;
	private String exhibitsDetail;
	private String exhibitsVoice;
	private String exhibitsImagefull;
	private Integer exhibitsUpvote;
	private Integer exhibitsBrowse;
	private String exhibitsDamage;
	private String exhibitsImagecut;

	// Constructors

	/** default constructor */
	public Exhibits() {
	}

	/** minimal constructor */
	public Exhibits(Nation nation, Apply apply, State state, Dynasty dynasty,
			Material material, Hall hall, Religion religion, Value value,
			Integer exhibitsCherish, String exhibitsName,
			Integer exhibitsLocationX, Integer exhibitsLocationY,
			Integer exhibitsLocationNumber, String exhibitsAppearance,
			String exhibitsDetail, String exhibitsVoice,
			String exhibitsImagefull, Integer exhibitsUpvote,
			Integer exhibitsBrowse, String exhibitsDamage,
			String exhibitsImagecut) {
		this.nation = nation;
		this.apply = apply;
		this.state = state;
		this.dynasty = dynasty;
		this.material = material;
		this.hall = hall;
		this.religion = religion;
		this.value = value;
		this.exhibitsCherish = exhibitsCherish;
		this.exhibitsName = exhibitsName;
		this.exhibitsLocationX = exhibitsLocationX;
		this.exhibitsLocationY = exhibitsLocationY;
		this.exhibitsLocationNumber = exhibitsLocationNumber;
		this.exhibitsAppearance = exhibitsAppearance;
		this.exhibitsDetail = exhibitsDetail;
		this.exhibitsVoice = exhibitsVoice;
		this.exhibitsImagefull = exhibitsImagefull;
		this.exhibitsUpvote = exhibitsUpvote;
		this.exhibitsBrowse = exhibitsBrowse;
		this.exhibitsDamage = exhibitsDamage;
		this.exhibitsImagecut = exhibitsImagecut;
	}

	/** full constructor */
	public Exhibits(Nation nation, Apply apply, State state, Dynasty dynasty,
			Material material, Hall hall, Religion religion, Value value,
			Integer exhibitsCherish, String exhibitsName,
			String exhibitsProducePlace, Date exhibitsProduceTime,
			String exhibitsExcavatePlace, Date exhibitsExcavateTime,
			Integer exhibitsLocationX, Integer exhibitsLocationY,
			Integer exhibitsLocationNumber, String exhibitsAppearance,
			String exhibitsDetail, String exhibitsVoice,
			String exhibitsImagefull, Integer exhibitsUpvote,
			Integer exhibitsBrowse, String exhibitsDamage,
			String exhibitsImagecut) {
		this.nation = nation;
		this.apply = apply;
		this.state = state;
		this.dynasty = dynasty;
		this.material = material;
		this.hall = hall;
		this.religion = religion;
		this.value = value;
		this.exhibitsCherish = exhibitsCherish;
		this.exhibitsName = exhibitsName;
		this.exhibitsProducePlace = exhibitsProducePlace;
		this.exhibitsProduceTime = exhibitsProduceTime;
		this.exhibitsExcavatePlace = exhibitsExcavatePlace;
		this.exhibitsExcavateTime = exhibitsExcavateTime;
		this.exhibitsLocationX = exhibitsLocationX;
		this.exhibitsLocationY = exhibitsLocationY;
		this.exhibitsLocationNumber = exhibitsLocationNumber;
		this.exhibitsAppearance = exhibitsAppearance;
		this.exhibitsDetail = exhibitsDetail;
		this.exhibitsVoice = exhibitsVoice;
		this.exhibitsImagefull = exhibitsImagefull;
		this.exhibitsUpvote = exhibitsUpvote;
		this.exhibitsBrowse = exhibitsBrowse;
		this.exhibitsDamage = exhibitsDamage;
		this.exhibitsImagecut = exhibitsImagecut;
	}

	// Property accessors

	public Integer getExhibitsId() {
		return this.exhibitsId;
	}

	public void setExhibitsId(Integer exhibitsId) {
		this.exhibitsId = exhibitsId;
	}

	public Nation getNation() {
		return this.nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public Apply getApply() {
		return this.apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Dynasty getDynasty() {
		return this.dynasty;
	}

	public void setDynasty(Dynasty dynasty) {
		this.dynasty = dynasty;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Hall getHall() {
		return this.hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Religion getReligion() {
		return this.religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public Value getValue() {
		return this.value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Integer getExhibitsCherish() {
		return this.exhibitsCherish;
	}

	public void setExhibitsCherish(Integer exhibitsCherish) {
		this.exhibitsCherish = exhibitsCherish;
	}

	public String getExhibitsName() {
		return this.exhibitsName;
	}

	public void setExhibitsName(String exhibitsName) {
		this.exhibitsName = exhibitsName;
	}

	public String getExhibitsProducePlace() {
		return this.exhibitsProducePlace;
	}

	public void setExhibitsProducePlace(String exhibitsProducePlace) {
		this.exhibitsProducePlace = exhibitsProducePlace;
	}

	public Date getExhibitsProduceTime() {
		return this.exhibitsProduceTime;
	}

	public void setExhibitsProduceTime(Date exhibitsProduceTime) {
		this.exhibitsProduceTime = exhibitsProduceTime;
	}

	public String getExhibitsExcavatePlace() {
		return this.exhibitsExcavatePlace;
	}

	public void setExhibitsExcavatePlace(String exhibitsExcavatePlace) {
		this.exhibitsExcavatePlace = exhibitsExcavatePlace;
	}

	public Date getExhibitsExcavateTime() {
		return this.exhibitsExcavateTime;
	}

	public void setExhibitsExcavateTime(Date exhibitsExcavateTime) {
		this.exhibitsExcavateTime = exhibitsExcavateTime;
	}

	public Integer getExhibitsLocationX() {
		return this.exhibitsLocationX;
	}

	public void setExhibitsLocationX(Integer exhibitsLocationX) {
		this.exhibitsLocationX = exhibitsLocationX;
	}

	public Integer getExhibitsLocationY() {
		return this.exhibitsLocationY;
	}

	public void setExhibitsLocationY(Integer exhibitsLocationY) {
		this.exhibitsLocationY = exhibitsLocationY;
	}

	public Integer getExhibitsLocationNumber() {
		return this.exhibitsLocationNumber;
	}

	public void setExhibitsLocationNumber(Integer exhibitsLocationNumber) {
		this.exhibitsLocationNumber = exhibitsLocationNumber;
	}

	public String getExhibitsAppearance() {
		return this.exhibitsAppearance;
	}

	public void setExhibitsAppearance(String exhibitsAppearance) {
		this.exhibitsAppearance = exhibitsAppearance;
	}

	public String getExhibitsDetail() {
		return this.exhibitsDetail;
	}

	public void setExhibitsDetail(String exhibitsDetail) {
		this.exhibitsDetail = exhibitsDetail;
	}

	public String getExhibitsVoice() {
		return this.exhibitsVoice;
	}

	public void setExhibitsVoice(String exhibitsVoice) {
		this.exhibitsVoice = exhibitsVoice;
	}

	public String getExhibitsImagefull() {
		return this.exhibitsImagefull;
	}

	public void setExhibitsImagefull(String exhibitsImagefull) {
		this.exhibitsImagefull = exhibitsImagefull;
	}

	public Integer getExhibitsUpvote() {
		return this.exhibitsUpvote;
	}

	public void setExhibitsUpvote(Integer exhibitsUpvote) {
		this.exhibitsUpvote = exhibitsUpvote;
	}

	public Integer getExhibitsBrowse() {
		return this.exhibitsBrowse;
	}

	public void setExhibitsBrowse(Integer exhibitsBrowse) {
		this.exhibitsBrowse = exhibitsBrowse;
	}

	public String getExhibitsDamage() {
		return this.exhibitsDamage;
	}

	public void setExhibitsDamage(String exhibitsDamage) {
		this.exhibitsDamage = exhibitsDamage;
	}

	public String getExhibitsImagecut() {
		return this.exhibitsImagecut;
	}

	public void setExhibitsImagecut(String exhibitsImagecut) {
		this.exhibitsImagecut = exhibitsImagecut;
	}

}