package museum.entity;

import java.util.Date;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
public class News {

    // Fields

    private Integer newsId;
    private String newsTitle;
    private String newsAbstract;
    private String newsContext;
    private String newsImage;
    private Date newsTime;

    // Constructors

    /** default constructor */
    public News() {
    }

    /** full constructor */
    public News(String newsTitle, String newsAbstract, String newsContext,
                String newsImage, Date newsTime) {
        this.newsTitle = newsTitle;
        this.newsAbstract = newsAbstract;
        this.newsContext = newsContext;
        this.newsImage = newsImage;
        this.newsTime = newsTime;
    }

    // Property accessors

    public Integer getNewsId() {
        return this.newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return this.newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsAbstract() {
        return this.newsAbstract;
    }

    public void setNewsAbstract(String newsAbstract) {
        this.newsAbstract = newsAbstract;
    }

    public String getNewsContext() {
        return this.newsContext;
    }

    public void setNewsContext(String newsContext) {
        this.newsContext = newsContext;
    }

    public String getNewsImage() {
        return this.newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public Date getNewsTime() {
        return this.newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

}