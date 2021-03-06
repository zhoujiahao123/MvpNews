package example.com.mvpnews;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table NEWS.
 */
public class News {

    private Long id;
    private String title;
    private String date;
    private String contentUrl;
    private String imageUrl;

    public News() {
    }

    public News(Long id) {
        this.id = id;
    }

    public News(Long id, String title, String date, String contentUrl, String imageUrl) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.contentUrl = contentUrl;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
