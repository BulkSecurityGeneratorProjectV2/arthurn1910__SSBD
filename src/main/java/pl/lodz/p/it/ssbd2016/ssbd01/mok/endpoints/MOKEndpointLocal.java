/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.ssbd2016.ssbd01.mok.endpoints;

import java.util.List;
import javax.ejb.Local;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.Konto;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.PoziomDostepu;

/**
 * Interfejs API servera dla modułu funkcjonalnego MOK
 */
@Local
public interface MOKEndpointLocal {
    void rejestrujKontoKlienta(Konto konto, PoziomDostepu poziomDostepu);
    
    List<Konto> pobierzWszystkieKonta();

    void potwierdzKonto(Konto konto);

    public void odblokujKonto(Konto rowData);

    public void zablokujKonto(Konto rowData);

    public Boolean zaloguj(String login, String haslo);

    public void dolaczPoziomAgent(Konto konto);

    public void dolaczPoziomMenadzer(Konto konto);

    public void dolaczPoziomAdministrator(Konto konto);

    public void odlaczPoziomAgent(Konto konto);

    public void odlaczPoziomMenadzer(Konto konto);

    public void odlaczPoziomAdministrator(Konto konto);

    public Boolean sprawdzPoziomAgent(Konto konto);

    public Boolean sprawdzPoziomMenadzer(Konto konto);

    public Boolean sprawdzPoziomAdministrator(Konto konto);

    public Konto pobierzUzytkownika();

    public String pobierzPoziomy(Konto kontoUzytkownika);

    /**
     * Metoda zwracająca liste niepotwierdzonych kont
     * @return          lista niepotwierdzonych kont
     */
    public List<Konto> pobierzWszystkieNiepotwierdzoneKonta();

    /**
     * Metoda zwracająca obiekt klasy konto z danym loginem
     * @param login     login użytkownika do wyszukania
     * @return          obiekt klasy konto o zadanym loginie
     */
    public Konto pobierzUzytkownika(String login);

    /**
     * Metoda zwracająca liste kont podobnych do zadanego konta
     * @param konto     obiekt zawierający kryteria wyszukania
     * @return          lista podobnych kont
     */
    public List<Konto> pobierzPodobneKonta(Konto konto);

    /**
     * Metoda dodająca dany poziom dostępu do konta
     * @param konto     konto do którego należy dodać poziom dostępu
     * @param poziom    nazwa poziomu dostępu
     * @return          potwierdzenie wykonania operacji
     */
    public void dodajPoziomDostepu(Konto konto, String poziom) throws Exception;

    /**
     * Metoda odłączająca dany poziom dostępu do konta
     * @param konto     konto od którego należy odłączyć poziom dostępu
     * @param poziom    nazwa poziomu dostępu
     * @return          potwierdzenie wykonania operacji
     */
    public void odlaczPoziomDostepu(Konto konto, String poziom) throws Exception;
}
