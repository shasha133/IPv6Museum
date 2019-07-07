package museum.entity;

import java.util.Date;

/**
 * Exhibits entity. @author MyEclipse Persistence Tools
 */

public class Exhibits{
	// Fields
	private Integer exhibitsId;
	private Nation nation;
    private Integer valueId;
	private Apply apply;
	private int applyId;
	private State state;
    private Integer stateId;
	private int dynastyId;
	private Dynasty dynasty;
	private Material material;
	private int materialId;
	private Hall hall;
	private Integer hallId;
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
		return exhibitsId;
	}

	public Nation getNation() {
		return nation;
	}

	public Integer getValueId() {
		return valueId;
	}

	public Apply getApply() {
		return apply;
	}

	public int getApplyId() {
		return applyId;
	}

	public State getState() {
		return state;
	}

	public Integer getStateId() {
		return stateId;
	}

	public int getDynastyId() {
		return dynastyId;
	}

	public Dynasty getDynasty() {
		return dynasty;
	}

	public Material getMaterial() {
		return material;
	}

	public int getMaterialId() {
		return materialId;
	}

	public Hall getHall() {
		return hall;
	}

	public Integer getHallId() {
		return hallId;
	}

	public Religion getReligion() {
		return religion;
	}

	public Value getValue() {
		return value;
	}

	public Integer getExhibitsCherish() {
		return exhibitsCherish;
	}

	public String getExhibitsName() {
		return exhibitsName;
	}

	public String getExhibitsProducePlace() {
		return exhibitsProducePlace;
	}

	public Date getExhibitsProduceTime() {
		return exhibitsProduceTime;
	}

	public String getExhibitsExcavatePlace() {
		return exhibitsExcavatePlace;
	}

	public Date getExhibitsExcavateTime() {
		return exhibitsExcavateTime;
	}

	public Integer getExhibitsLocationX() {
		return exhibitsLocationX;
	}

	public Integer getExhibitsLocationY() {
		return exhibitsLocationY;
	}

	public Integer getExhibitsLocationNumber() {
		return exhibitsLocationNumber;
	}

	public String getExhibitsAppearance() {
		return exhibitsAppearance;
	}

	public String getExhibitsDetail() {
		return exhibitsDetail;
	}

	public String getExhibitsVoice() {
		return exhibitsVoice;
	}

	public String getExhibitsImagefull() {
		return exhibitsImagefull;
	}

	public Integer getExhibitsUpvote() {
		return exhibitsUpvote;
	}

	public Integer getExhibitsBrowse() {
		return exhibitsBrowse;
	}

	public String getExhibitsDamage() {
		return exhibitsDamage;
	}

	public String getExhibitsImagecut() {
		return exhibitsImagecut;
	}

	public void setExhibitsId(Integer exhibitsId) {
		this.exhibitsId = exhibitsId;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public void setDynastyId(int dynastyId) {
		this.dynastyId = dynastyId;
	}

	public void setDynasty(Dynasty dynasty) {
		this.dynasty = dynasty;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public void setExhibitsCherish(Integer exhibitsCherish) {
		this.exhibitsCherish = exhibitsCherish;
	}

	public void setExhibitsName(String exhibitsName) {
		this.exhibitsName = exhibitsName;
	}

	public void setExhibitsProducePlace(String exhibitsProducePlace) {
		this.exhibitsProducePlace = exhibitsProducePlace;
	}

	public void setExhibitsProduceTime(Date exhibitsProduceTime) {
		this.exhibitsProduceTime = exhibitsProduceTime;
	}

	public void setExhibitsExcavatePlace(String exhibitsExcavatePlace) {
		this.exhibitsExcavatePlace = exhibitsExcavatePlace;
	}

	public void setExhibitsExcavateTime(Date exhibitsExcavateTime) {
		this.exhibitsExcavateTime = exhibitsExcavateTime;
	}

	public void setExhibitsLocationX(Integer exhibitsLocationX) {
		this.exhibitsLocationX = exhibitsLocationX;
	}

	public void setExhibitsLocationY(Integer exhibitsLocationY) {
		this.exhibitsLocationY = exhibitsLocationY;
	}

	public void setExhibitsLocationNumber(Integer exhibitsLocationNumber) {
		this.exhibitsLocationNumber = exhibitsLocationNumber;
	}

	public void setExhibitsAppearance(String exhibitsAppearance) {
		this.exhibitsAppearance = exhibitsAppearance;
	}

	public void setExhibitsDetail(String exhibitsDetail) {
		this.exhibitsDetail = exhibitsDetail;
	}

	public void setExhibitsVoice(String exhibitsVoice) {
		this.exhibitsVoice = exhibitsVoice;
	}

	public void setExhibitsImagefull(String exhibitsImagefull) {
		this.exhibitsImagefull = exhibitsImagefull;
	}

	public void setExhibitsUpvote(Integer exhibitsUpvote) {
		this.exhibitsUpvote = exhibitsUpvote;
	}

	public void setExhibitsBrowse(Integer exhibitsBrowse) {
		this.exhibitsBrowse = exhibitsBrowse;
	}

	public void setExhibitsDamage(String exhibitsDamage) {
		this.exhibitsDamage = exhibitsDamage;
	}

	public void setExhibitsImagecut(String exhibitsImagecut) {
		this.exhibitsImagecut = exhibitsImagecut;
	}
}