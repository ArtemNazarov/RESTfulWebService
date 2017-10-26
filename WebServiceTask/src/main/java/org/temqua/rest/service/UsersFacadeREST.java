package org.temqua.rest.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.temqua.rest.Users;

@Stateless
@Path("users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "org.temqua_WebServiceTask_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, Users entity) {
        Users existingUser = em.find(Users.class, id);
        existingUser.setLogin(entity.getLogin());
        existingUser.setPassword(entity.getPassword());
        existingUser.setName(entity.getName());
        existingUser.setSurname(entity.getSurname());
        existingUser.setPatronymic(entity.getPatronymic());
        existingUser.setAddress(entity.getAddress());
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Path("findByLogin/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> findByLogin(@PathParam("login") String login) {
        TypedQuery<Users> query = em.createNamedQuery("Users.findByLogin", Users.class);
        query.setParameter("login", login);
        return query.getResultList();
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
