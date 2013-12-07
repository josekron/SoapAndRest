/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service.soap;

import app.ejb.CustomerFacade;
import app.entity.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "CustomerService")
public class CustomerService {
    @EJB
    private CustomerFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createCustomer")
    @Oneway
    public void createCustomer(@WebParam(name = "entity") Customer entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editCustomer")
    @Oneway
    public void editCustomer(@WebParam(name = "entity") Customer entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeCustomer")
    @Oneway
    public void removeCustomer(@WebParam(name = "entity") Customer entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findCustomer")
    public Customer findCustomer(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllCustomer")
    public List<Customer> findAllCustomer() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeCustomer")
    public List<Customer> findRangeCustomer(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countCustomer")
    public int countCustomer() {
        return ejbRef.count();
    }
    
}
