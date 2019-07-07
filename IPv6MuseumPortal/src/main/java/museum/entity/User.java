package museum.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * UserController entity. @author MyEclipse Persistence Tools
 */

public class User{

	// Fields

	private String userId;
	private String userName;
	private String userPassword;
	private String userRoot;
	private String userImage;
	private Set records = new HashSet(0);
	private Set collects = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String userPassword, String userRoot,
			String userImage) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRoot = userRoot;
		this.userImage = userImage;
	}

	/** full constructor */
	public User(String userName, String userPassword, String userRoot,
			String userImage, Set records, Set collects) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRoot = userRoot;
		this.userImage = userImage;
		this.records = records;
		this.collects = collects;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRoot() {
		return this.userRoot;
	}

	public void setUserRoot(String userRoot) {
		this.userRoot = userRoot;
	}

	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public Set getRecords() {
		return this.records;
	}

	public void setRecords(Set records) {
		this.records = records;
	}

	public Set getCollects() {
		return this.collects;
	}

	public void setCollects(Set collects) {
		this.collects = collects;
	}

    @Override
    public String toString() {
        return "UserController [collects=" + collects + ", records=" + records
                + ", userId=" + userId + ", userImage=" + userImage
                + ", userName=" + userName + ", userPassword=" + userPassword
                + ", userRoot=" + userRoot + "]";
    }
}