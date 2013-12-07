/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service.soap;

import app.ejb.MicroMarketFacade;
import app.entity.MicroMarket;
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
@WebService(serviceName = "MicroMarketService")
public class MicroMarketService {
    @EJB
    private MicroMarketFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createMicroMarket")
    @Oneway
    public void createMicroMarket(@WebParam(name = "entity") MicroMarket entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "editMicroMarket")
    @Oneway
    public void editMicroMarket(@WebParam(name = "entity") MicroMarket entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeMicroMarket")
    @Oneway
    public void removeMicroMarket(@WebParam(name = "entity") MicroMarket entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findMicroMarket")
    public MicroMarket findMicroMarket(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAllMicroMarket")
    public List<MicroMarket> findAllMicroMarket() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeMicroMarket")
    public List<MicroMarket> findRangeMicroMarket(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countMicroMarket")
    public int countMicroMarket() {
        return ejbRef.count();
    }
    
}
