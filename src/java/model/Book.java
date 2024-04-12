package model;

import java.sql.Timestamp;

/**
 *
 * @author nonle
 */
public class Book {

    private int id;
    private String title, author, description, genre;
    private String image, content;
    private Timestamp datecreated;
   
    public Book() {
    }
//    
    
    public Book(int id, String title, String author, String description, String genre, String image, String content, Timestamp datecreated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.image = image;
        this.content = content;
        this.datecreated = datecreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", author='" + author + '\''
                + ", description='" + description + '\''
                + ", genre='" + genre + '\''
                + ", image='" + image + '\''
                + ", content='" + content + '\''
                + ", datecreated=" + datecreated
                + '}';
    }
}
