/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.ssbd2016.ssbd01.wyjatki;

import javax.ejb.ApplicationException;

/**
 *
 * @author java
 */
@ApplicationException(rollback = true)
public class BladDeSerializacjiObiektu extends ClassNotFoundException{
    private String miejsce;
    private String opis;
    public BladDeSerializacjiObiektu(String miejsce) {
        super();
        this.miejsce=miejsce;
        this.opis="BladDeSerializacjiObiektu";
    }

    public String getMiejsce() {
        return miejsce;
    }
}
