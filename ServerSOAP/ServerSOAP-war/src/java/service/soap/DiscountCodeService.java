/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service.soap;

import app.ejb.DiscountCodeFacade;
import app.entity.DiscountCode;
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
@WebService(serviceName = "DiscountCodeService")
public class DiscountCodeService {
    @EJB
    private DiscountCodeFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createDiscountCode")
    @Oneway
    public void createDiscountCode(@WebParam(name = "entity") DiscountCode entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editDiscountCode")
    @Oneway
    public void editDiscountCode(@WebParam(name = "entity") DiscountCode entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeDiscountCode")
    @Oneway
    public void removeDiscountCode(@WebParam(name = "entity") DiscountCode entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findDiscountCode")
    public DiscountCode findDiscountCode(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllDiscountCode")
    public List<DiscountCode> findAllDiscountCode() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeDiscountCode")
    public List<DiscountCode> findRangeDiscountCode(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countDiscountCode")
    public int countDiscountCode() {
        return ejbRef.count();
    }
    
}
