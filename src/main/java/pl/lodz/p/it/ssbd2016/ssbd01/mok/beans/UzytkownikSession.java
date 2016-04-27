/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.lodz.p.it.ssbd2016.ssbd01.mok.beans;
import javax.ejb.EJB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.Konto;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.PoziomDostepu;
import static pl.lodz.p.it.ssbd2016.ssbd01.encje.ssbd01adminPU.PoziomDostepu_.poziom;
import pl.lodz.p.it.ssbd2016.ssbd01.mok.endpoints.MOKEndpointLocal;
/*
 *
 * @author Patryk
 */
@SessionScoped
public class UzytkownikSession implements Serializable {
    @EJB
    private MOKEndpointLocal MOKEndpoint;
    private Konto kontoUzytkownika;

    /***
     * Funkcja zwracająca kontoUzytkownika
     * @return 
     */
    public Konto getKontoUzytkownika() {
        ustawKontoUzytkownika();
        return kontoUzytkownika;
    }
    /***
     * Metoda ustawiajaca kontoUzytkownika
     */
    public void ustawKontoUzytkownika(){
        kontoUzytkownika=MOKEndpoint.pobierzUzytkownika();
    }
    
    /**
 * Rejestruje konto, nadając mu poziom dostępu klienta
 * @param  k  konto, które ma zostać zarejestrowane
 */
    public void rejestrujKlienta(Konto k) {
        Konto kontoRejestracja = new Konto();
        kontoRejestracja.setLogin(k.getLogin());
        kontoRejestracja.setHaslo("2cd002d71ed9bc76bd123059c6beccef"); //!!! Hasło powinno być w postaci skrótu np. MD5!
        kontoRejestracja.setImie(k.getImie());
        kontoRejestracja.setNazwisko(k.getNazwisko());
        kontoRejestracja.setEmail(k.getEmail());
        kontoRejestracja.setDataUtworzenia(new Date());
        kontoRejestracja.setTelefon(k.getTelefon());

        PoziomDostepu poziomDostepu = new PoziomDostepu();
        poziomDostepu.setPoziom("KLIENT");
        poziomDostepu.setAktywny(true);
        poziomDostepu.setKontoId(k);
        MOKEndpoint.rejestrujKontoKlienta(kontoRejestracja,poziomDostepu);
    }
    
    /**
 * Rejestruje konto, nadając mu jeden z poziomów dostępu (klient, agent, menadzer, administrator)
 * @param  k  konto, które ma zostać zarejestrowane
 * @param  poziom  poziom dostępu, który ma mieć nowo tworzone konto
 */
    public void utworzKonto(Konto k, String poziom)
    {
        Konto kontoRejestracja = new Konto();
        kontoRejestracja.setLogin(k.getLogin());
        kontoRejestracja.setHaslo("2cd002d71ed9bc76bd123059c6beccef"); //!!! Hasło powinno być w postaci skrótu np. MD5!
        kontoRejestracja.setImie(k.getImie());
        kontoRejestracja.setNazwisko(k.getNazwisko());
        kontoRejestracja.setEmail(k.getEmail());
        kontoRejestracja.setDataUtworzenia(new Date());
        kontoRejestracja.setTelefon(k.getTelefon());

        PoziomDostepu poziomDostepu = new PoziomDostepu();
        poziomDostepu.setPoziom(poziom.toUpperCase());
        poziomDostepu.setAktywny(true);
        poziomDostepu.setKontoId(k);
        MOKEndpoint.rejestrujKontoKlienta(kontoRejestracja,poziomDostepu);
    }
    
  /**
 * Pobiera z endpointa listę kont, których dane pasują do wzorców zawartych w obiekcie Konto, przekazywanym jako parametr
 * @param  k  konto, które zawiera wzorce
 * @return lista kont spełniających wymagania dotyczące wzorców
 */
    List<Konto> pobierzPodobneKonta(Konto k) {
//        List<Konto> konta = MOKEndpoint.pobierzPodobneKonta(k);
        // tymczasowo
        List<Konto> konta = MOKEndpoint.pobierzWszystkieKonta();
        return konta;
    }
    
    List<Konto> pobierzWszystkieKonta() {
        return MOKEndpoint.pobierzWszystkieKonta();
    }
    
    /***
     * Metoda przekazująca parametr do metody potwierdzKonto w MOKEndpoint
     * @param rowData 
     */
    void potwierdzKonto() {
        MOKEndpoint.potwierdzKonto(kontoUzytkownika);
    }
    /***
     * Metoda przekazująca parametr do metody odblokujKonto w MOKEndpoint
     * @param rowData 
     */
    void odblokujKonto() {
        MOKEndpoint.odblokujKonto(kontoUzytkownika);
    }
    /***
     * Metoda przekazująca parametr do metody zablokujKonto w MOKEndpoint
     * @param rowData 
     */
    void zablokujKonto() {
        MOKEndpoint.zablokujKonto(kontoUzytkownika);
    }

    /***
     * Metoda przekazująca paraqmetr do metody dolaczPoziomAgent w MOKEndpoint
     * @param konto 
     */
    void dolaczPoziomAgent(){
        MOKEndpoint.dolaczPoziomAgent(kontoUzytkownika);
    }
    /***
     * Metoda przekazująca paraqmetr do metody dolaczPoziomMenadzer w MOKEndpoint
     * @param konto 
     */
    void dolaczPoziomMenadzer(){
         MOKEndpoint.dolaczPoziomMenadzer(kontoUzytkownika);
    }
    /***
     * Metoda przekazująca paraqmetr do metody dolaczPoziomAdministrator w MOKEndpoint
     * @param konto 
     */
    void dolaczPoziomAdministrator(){
         MOKEndpoint.dolaczPoziomAdministrator(kontoUzytkownika);
    }
    /***
     * Metoda przekazująca paraqmetr do metody odlaczPoziomAgent w MOKEndpoint
     * @param konto 
     */
    void odlaczPoziomAgent(){
        MOKEndpoint.odlaczPoziomAgent(kontoUzytkownika);
    }
    /***
     * Metoda przekazująca paraqmetr do metody odlaczPoziomMenadzer w MOKEndpoint
     * @param konto 
     */
    void odlaczPoziomMenadzer(){
        MOKEndpoint.odlaczPoziomMenadzer(kontoUzytkownika);
    }
    /***
     * Metoda przekazująca paraqmetr do metody odlaczPoziomAdministrator w MOKEndpoint
     * @param konto 
     */
    void odlaczPoziomAdministrator(){
        MOKEndpoint.odlaczPoziomAdministrator(kontoUzytkownika);
    }
    /***
     * Funkcja przekazująca paraqmetr do funkcji sprawdzPoziomAgent w MOKEndpoint pobierająca typ Boolean i zwracająca go 
     * @param konto
     * @return 
     */
    Boolean sprawdzPoziomAgent(){
        return MOKEndpoint.sprawdzPoziomAgent(kontoUzytkownika);
    }
    /***
     * Funkcja przekazująca paraqmetr do funkcji sprawdzPoziomMenadzer w MOKEndpoint pobierająca typ Boolean i zwracająca go 
     * @param konto
     * @return 
     */
    Boolean sprawdzPoziomMenadzer(){
        return MOKEndpoint.sprawdzPoziomMenadzer(kontoUzytkownika);
    }
    /***
     * Funkcja przekazująca paraqmetr do funkcji sprawdzPoziomAdministrator w MOKEndpoint pobierająca typ Boolean i zwracająca go 
     * @param konto
     * @return 
     */
    Boolean sprawdzPoziomAdministrator(){
        return MOKEndpoint.sprawdzPoziomAdministrator(kontoUzytkownika);
    }
    /***
     * Funkcja przekazująca parametr kontoUzytkownika do funkcji pobierzPoziomy w MOKEndpoint i zwracająca typ String
     * @return 
     */
    String pobierzPoziomy() {
        return MOKEndpoint.pobierzPoziomy(kontoUzytkownika);
    }

    void potwierdzKonto(Konto rowData) {
        MOKEndpoint.potwierdzKonto(rowData);
    }

    List<Konto> pobierzWszystkieNiepotwierdzoneKonta() {
        return MOKEndpoint.pobierzWszystkieNiepotwierdzoneKonta();
    }

    Konto pobierzUrzytkownika(String login) {
        return MOKEndpoint.pobierzUzytkownika(login);
    }

    void dodajPoziomDostepu(Konto konto, String poziom) throws Exception {
        MOKEndpoint.dodajPoziomDostepu(konto, poziom);
    }

    void odlaczPoziomDostepu(Konto konto, String poziom) throws Exception {
        MOKEndpoint.odlaczPoziomDostepu(konto, poziom);
    }
}
