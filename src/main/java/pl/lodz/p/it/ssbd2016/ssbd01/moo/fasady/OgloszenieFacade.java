/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.ssbd2016.ssbd01.moo.fasady;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import pl.lodz.p.it.ssbd2016.ssbd01.fasady.AbstractFacade;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.Konto;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.Ogloszenie;
import pl.lodz.p.it.ssbd2016.ssbd01.interceptors.TrackerInterceptor;
import pl.lodz.p.it.ssbd2016.ssbd01.mok.managers.KontoManagerLocal;

/**
 *
 * @author java
 */
@Stateless
@Interceptors({TrackerInterceptor.class})
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class OgloszenieFacade extends AbstractFacade<Ogloszenie> implements OgloszenieFacadeLocal {

    @EJB
    private KontoManagerLocal kontoManager;
    @PersistenceContext(unitName = "ssbd01mooPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OgloszenieFacade() {
        super(Ogloszenie.class);
    }

    @Override
    public Ogloszenie znajdzPoID(Long ID) {
        Query q = em.createNamedQuery("Ogloszenie.findById");
        q.setParameter("id", ID);
        return (Ogloszenie) q.getSingleResult();
    }   
}
