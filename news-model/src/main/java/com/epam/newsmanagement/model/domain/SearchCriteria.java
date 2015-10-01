package com.epam.newsmanagement.model.domain;

import java.util.List;

public class SearchCriteria {
    private Long authorId;
    private List<Long> tagsId;

    public SearchCriteria() {
    }

    public SearchCriteria(Long authorId, List<Long> tagsId) {
        this.authorId = authorId;
        this.tagsId = tagsId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public List<Long> getTagsId() {
        return tagsId;
    }

    public void setTagsId(List<Long> tagsId) {
        this.tagsId = tagsId;
    }


}
