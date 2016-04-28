/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.ssbd2016.ssbd01.mok.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.Konto;

/**
 *
 * @author Patryk
 */
@Named
@RequestScoped  
public class DodajUzytkownikaBean {
    @Inject
    private UzytkownikSession sesjaKonta;
    
    private final Konto konto = new Konto();

    public Konto getKonto() {
        return konto;
    }
    public String rejestrujKontoKlienta() {
        System.out.println(konto);
        sesjaKonta.rejestrujKlienta2(konto);
        return "success";
    }
}
