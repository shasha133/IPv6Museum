package museum.entity;

import java.util.Date;

public class Activity {
    // Fields

    private Integer activityId;
    private ActivityType activityType;
    private String activityTitle;
    private String activityContext;
    private String activityImage;
    private String activityAbstract;
    private Date activityTime;
    private Date activityTimeStart;
    private Date activityTimeEnd;
    private String activityState;
    private Integer activityTop;
    private Integer activityTypeId;
    private String activityTypeName;

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }
// Constructors

    /** default constructor */
    public Activity() {
    }



    public Integer getActivityTop() {
        return activityTop;
    }



    public void setActivityTop(Integer activityTop) {
        this.activityTop = activityTop;
    }



    /** full constructor */
    public Activity(ActivityType activityType, String activityTitle,
                    String activityContext, String activityImage,
                    String activityAbstract, Date activityTime, Date activityTimeStart,
                    Date activityTimeEnd, String activityState) {
        this.activityType = activityType;
        this.activityTitle = activityTitle;
        this.activityContext = activityContext;
        this.activityImage = activityImage;
        this.activityAbstract = activityAbstract;
        this.activityTime = activityTime;
        this.activityTimeStart = activityTimeStart;
        this.activityTimeEnd = activityTimeEnd;
        this.activityState = activityState;
    }

    // Property accessors

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public ActivityType getActivityType() {
        return this.activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getActivityTitle() {
        return this.activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityContext() {
        return this.activityContext;
    }

    public void setActivityContext(String activityContext) {
        this.activityContext = activityContext;
    }

    public String getActivityImage() {
        return this.activityImage;
    }

    public void setActivityImage(String activityImage) {
        this.activityImage = activityImage;
    }

    public String getActivityAbstract() {
        return this.activityAbstract;
    }

    public void setActivityAbstract(String activityAbstract) {
        this.activityAbstract = activityAbstract;
    }

    public Date getActivityTime() {
        return this.activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getActivityTimeStart() {
        return this.activityTimeStart;
    }

    public void setActivityTimeStart(Date activityTimeStart) {
        this.activityTimeStart = activityTimeStart;
    }

    public Date getActivityTimeEnd() {
        return this.activityTimeEnd;
    }

    public void setActivityTimeEnd(Date activityTimeEnd) {
        this.activityTimeEnd = activityTimeEnd;
    }

    public String getActivityState() {
        return this.activityState;
    }

    public void setActivityState(String activityState) {
        this.activityState = activityState;
    }

}