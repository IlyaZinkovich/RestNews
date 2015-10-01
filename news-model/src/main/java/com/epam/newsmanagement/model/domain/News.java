package com.epam.newsmanagement.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "news")
public class News implements Serializable {

    private static final long serialVersionUID = -2401617129682260390L;

    @Id
    @GeneratedValue
    @Column(name = "news_id")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "short_text")
    private String shortText;

    @NotNull
    @Size(max = 2000)
    @Column(name = "full_text")
    private String fullText;

    @NotNull
    @Size(max = 30)
    @Column(name = "title")
    private String title;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;

    @Version
    private int version;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
//    @JsonBackReference
    private Author author;

    public News() {
    }


    public News(Long id, String shortText, String fullText, String title, Date creationDate, Date modificationDate) {
        this.id = id;
        this.shortText = shortText;
        this.fullText = fullText;
        this.title = title;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o != null && o.getClass() != this.getClass()) return false;

        News news = (News) o;

        if (!Objects.equals(id, news.id)) return false;
        if (!creationDate.equals(news.creationDate)) return false;
        if (!fullText.equals(news.fullText)) return false;
        if (!modificationDate.equals(news.modificationDate)) return false;
        if (!shortText.equals(news.shortText)) return false;
        if (!title.equals(news.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 31;
        if (id != null) {
            result = (int) (id ^ (id >>> 32));
        }
        result = 31 * result + shortText.hashCode();
        result = 31 * result + fullText.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + modificationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", shortText='" + shortText + '\'' +
                ", fullText='" + fullText + '\'' +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", version=" + version +
                ", author=" + author +
                '}';
    }
}