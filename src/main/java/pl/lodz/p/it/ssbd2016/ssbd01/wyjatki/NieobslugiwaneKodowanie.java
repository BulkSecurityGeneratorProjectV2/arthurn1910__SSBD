/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.ssbd2016.ssbd01.wyjatki;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author java
 */
public class NieobslugiwaneKodowanie extends UnsupportedEncodingException{
    private String miejsce;
    public NieobslugiwaneKodowanie(String miejsce) {
        super();
        this.miejsce=miejsce;
    }

    public String getMiejsce() {
        return miejsce;
    }
    
    
}
