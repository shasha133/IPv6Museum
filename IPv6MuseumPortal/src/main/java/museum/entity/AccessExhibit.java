package museum.entity;

public class AccessExhibit {
    private String userId;
    private Integer exhibitsId;

    public String getUserId() {
        return userId;
    }

    public Integer getExhibitsId() {
        return exhibitsId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setExhibitsId(Integer exhibitsId) {
        this.exhibitsId = exhibitsId;
    }
}
