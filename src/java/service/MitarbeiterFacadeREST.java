/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Mitarbeiter;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lordbenz
 */
@Stateless
@Path("entity.mitarbeiter")
public class MitarbeiterFacadeREST extends AbstractFacade<Mitarbeiter> {

    @PersistenceContext(unitName = "UrlaubsAppBackandPU")
    private EntityManager em;

    public MitarbeiterFacadeREST() {
        super(Mitarbeiter.class);
    }

    @POST
    @Path("/new")
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Mitarbeiter entity) {
        super.create(entity);
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Mitarbeiter entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("/delete/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Mitarbeiter find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mitarbeiter> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mitarbeiter> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("firstname/{firstname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mitarbeiter> findFirstName(@PathParam("firstname") String firstname) {
         List fn = super.findFirstName(firstname);
         return fn;
    }
    
    @GET
    @Path("lastname/{lastname}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mitarbeiter> findLastName(@PathParam("lastname") String lastname) {
         List fn = super.findLastName(lastname);
         return fn;
    }
    
    @GET
    @Path("persnr/{nr}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mitarbeiter> findByPersNumber(@PathParam("nr") String nr) {
         List fn = super.findByPersNumber(nr);
         return fn;
    }
    
    @GET
    @Path("email/{email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mitarbeiter> findByEmail(@PathParam("email") String email) {
         List fn = super.findEmail(email);
         return fn;
    }
    
    @GET
    @Path("holidays/{holidays}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Mitarbeiter> findByHolidays(@PathParam("holidays") String holidays) {
         List fn = super.findHoliday(holidays);
         return fn;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
