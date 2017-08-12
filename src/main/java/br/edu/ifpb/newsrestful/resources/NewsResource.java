package br.edu.ifpb.newsrestful.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.ifpb.edu.newsrestful.entity.News;
import br.ifpb.edu.newsrestfull.DAO.NewsDAO;

@Path("news")
public class NewsResource {
	
	@GET
	@Path("list")
	@Produces("application/json;charset=utf-8")
	public Response list(){
		NewsDAO newsDAO = new NewsDAO();
		return Response.ok(newsDAO.findAll()).build();
	}
	
	@POST
	@Path("create")
	@Consumes("application/json;charset=utf-8")
	@Produces("application/json;charset=utf-8")
	public Response create(News news){
		NewsDAO noticiaDAO = new NewsDAO();
		
		if(news.getAuthor().isEmpty() || news.getTitle().isEmpty() || news.getContent().isEmpty()){
			return Response.status(Status.BAD_REQUEST).build();
		}
				
		return Response.status(Status.CREATED).entity(noticiaDAO.save(news)).build();	
	}

	@GET
	@Produces("application/json;charset=utf-8")
	public Response read(@QueryParam("id")Long id){
		
		NewsDAO newsDAO = new NewsDAO();
		News n = newsDAO.findById(id);
		
		if(n == null)
			return Response.status(Status.NOT_FOUND).build();
		
		return Response.ok(n).build();
	}
}
