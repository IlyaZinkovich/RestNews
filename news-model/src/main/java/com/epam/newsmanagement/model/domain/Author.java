package com.epam.newsmanagement.model.domain;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    private static final long serialVersionUID = -1117370177012369440L;

    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private Long id;

    @NotNull
    @Column(name = "author_name", length = 1000)
    private String name;

    @Column(name = "expired")
    private Date expired;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<News> news;

    public Author() {
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
//        this.news = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expired=" + expired +
                '}';
    }
}
