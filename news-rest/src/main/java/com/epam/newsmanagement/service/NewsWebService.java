package com.epam.newsmanagement.service;

import com.epam.newsmanagement.model.domain.News;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/news")
@Produces(MediaType.APPLICATION_JSON)
public interface NewsWebService {

    @GET
    List<News> getNewsList(@QueryParam("page") Integer page,
                           @QueryParam("size") Integer size,
                           @QueryParam("authorId") Long authorId,
                           @QueryParam("tagsId") List<Long> tagsId);

    @GET
    @Path("/{id}")
    News getSingleNews(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void addNews(News news);

    @PUT
    @Path("/{id}")
    void updateNews(@PathParam("id") Long id, News news);
//
//    @DELETE
//    void deleteNews(@QueryParam("newsIdList") List<Long> newsIdList);

    @DELETE
    @Path("/{id}")
    void deleteNews(@PathParam("id") Long id);
}
