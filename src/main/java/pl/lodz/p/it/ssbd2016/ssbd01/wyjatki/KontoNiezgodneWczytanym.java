/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.ssbd2016.ssbd01.wyjatki;

/**
 *
 * @author java
 */
public class KontoNiezgodneWczytanym extends IllegalArgumentException{
    private String miejsce;

    public KontoNiezgodneWczytanym(String miejsce) {
        this.miejsce = miejsce;
    }

    public String getMiejsce() {
        return miejsce;
    }
    
    
}
