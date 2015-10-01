package com.epam.newsmanagement.service;


import com.epam.newsmanagement.model.domain.Author;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public interface AuthorWebService {

    @GET
    List<Author> getAllAuthors();

    @GET
    List<Author> getAuthorsIfExpired(@QueryParam("expired") Boolean expired);

    @GET
    @Path("/{id}")
    Author getAuthor(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void addAuthor(Author author);

    @GET
    Author getAuthorByNewsId(@QueryParam("newsId")Long id);

    @PUT
    @Path("/{id}")
    void updateAuthor(@PathParam("id") Long id, Author author);

    @DELETE
    @Path("/{id}")
    void deleteAuthor(@PathParam("id") Long id);

}
