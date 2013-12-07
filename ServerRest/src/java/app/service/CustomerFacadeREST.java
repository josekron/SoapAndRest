/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.service;

import java.util.ArrayList;
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
import javax.xml.ws.WebServiceRef;
import service.soap.Customer;
import service.soap.CustomerService_Service;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("app.entity.customer")
public class CustomerFacadeREST extends AbstractFacade<Customer> {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ServerSOAP-war/CustomerService.wsdl")
    private CustomerService_Service service;
    @PersistenceContext(unitName = "ServerRestPU")
    private EntityManager em;

    public CustomerFacadeREST() {
        super(Customer.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Customer entity) {
        //super.create(entity);
        service.soap.CustomerService port = service.getCustomerServicePort();
        port.createCustomer(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Customer entity) {
        //super.edit(entity);
        service.soap.CustomerService port = service.getCustomerServicePort();
        port.editCustomer(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        //super.remove(super.find(id));
        service.soap.CustomerService port = service.getCustomerServicePort();
        port.removeCustomer(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Customer find(@PathParam("id") Integer id) {
        //return super.find(id);
        service.soap.CustomerService port = service.getCustomerServicePort();
        return port.findCustomer(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Customer> findAll() {
        //return super.findAll();
        service.soap.CustomerService port = service.getCustomerServicePort();
        return port.findAllCustomer();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        //return super.findRange(new int[]{from, to});
        service.soap.CustomerService port = service.getCustomerServicePort();
        List <Integer>lista = new ArrayList<Integer>();
        lista.add(from);
        lista.add(to);
        return port.findRangeCustomer(lista);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        //return String.valueOf(super.count());
        service.soap.CustomerService port = service.getCustomerServicePort();
        return Integer.toString(port.countCustomer());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }










    
}
