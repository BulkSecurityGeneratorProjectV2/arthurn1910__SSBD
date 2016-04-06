/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.ssbd2016.ssbd01.moo.fasady;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.lodz.p.it.ssbd2016.ssbd01.fasady.AbstractFacade;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.Ogloszenie;

/**
 *
 * @author java
 */
@Stateless
public class OgloszenieFacade extends AbstractFacade<Ogloszenie> implements OgloszenieFacadeLocal {

    @PersistenceContext(unitName = "ssbd01mooPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OgloszenieFacade() {
        super(Ogloszenie.class);
    }
    
}
