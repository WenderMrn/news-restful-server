package br.edu.ifpb.newsrestful.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.ifpb.edu.newsrestful.entity.News;
import br.ifpb.edu.newsrestfull.DAO.NewsDAO;

@Path("news")
public class NewsResource {

	// Lista todas as notícias
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		NewsDAO newsDAO = new NewsDAO();
		return Response.ok(newsDAO.findAll()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	// Cria uma notícia
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(News news) {
		NewsDAO noticiaDAO = new NewsDAO();

		if (news.getAuthor().isEmpty() || news.getTitle().isEmpty() || news.getContent().isEmpty()) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		return Response.status(Status.CREATED).entity(noticiaDAO.save(news)).build();
	}

	// Pega uma notícia pelo ID
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") Long id) {

		NewsDAO newsDAO = new NewsDAO();
		News n = newsDAO.findById(id);

		if (n == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(n).build();
	}

	// Atualiza uma notícia pelo ID, recebendo um título via QueryParam
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, @QueryParam("title") String title) {
		NewsDAO newsDAO = new NewsDAO();
		News news = newsDAO.findById(id);

		news.setTitle(title);
		newsDAO.save(news);

		return Response.ok(news).build();
	}

	// Deleta uma notícia e response a requisição com o objeto removido
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id) {
		NewsDAO newsDAO = new NewsDAO();
		News news = newsDAO.findById(id);

		if (news == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		newsDAO.remove(id);

		return Response.ok(news).build();
	}

}
