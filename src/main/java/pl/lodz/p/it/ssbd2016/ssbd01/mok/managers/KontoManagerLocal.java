package pl.lodz.p.it.ssbd2016.ssbd01.mok.managers;

import java.util.List;
import javax.ejb.Local;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.Konto;
import pl.lodz.p.it.ssbd2016.ssbd01.wyjatki.BladPoziomDostepu;
import pl.lodz.p.it.ssbd2016.ssbd01.wyjatki.BrakAlgorytmuKodowania;
import pl.lodz.p.it.ssbd2016.ssbd01.wyjatki.NieobslugiwaneKodowanie;
import pl.lodz.p.it.ssbd2016.ssbd01.wyjatki.NiezgodneHasla;
import pl.lodz.p.it.ssbd2016.ssbd01.wyjatki.NiezgodnyLogin;
import pl.lodz.p.it.ssbd2016.ssbd01.wyjatki.PoziomDostepuNieIstnieje;

/**
 * Interfejs dla KontoManager
 */
@Local
public interface KontoManagerLocal {
    
    /**
     * Metoda zmienia hasło obecnie zalogowanego użytkownika, pod warunkiem:
     * konto należy do tego użytkownika, stareHaslo zgadza się z stanem w bazie.
     * @param konto     konto obecnie zalogowanego użytkownika
     * @param noweHaslo  nowe hasło w postaci jawnej
     * @param stareHaslo stare hasło w w postaci jawnej
     * @throws java.lang.Exception rzucany gdy hasła się nie zgadzają lub konto nie należy do obecnie zalogowanego użytkownika
     */
    void zmienMojeHaslo(Konto konto, String noweHaslo, String stareHaslo) throws PoziomDostepuNieIstnieje, NieobslugiwaneKodowanie, BrakAlgorytmuKodowania, NiezgodneHasla, NiezgodnyLogin ;

    /**
     * Metoda zmienia hasło podanego konta
     * @param konto     konto, które ma mieć zmienione hasło
     * @param noweHaslo nowe hasło
     */
    void zmienHaslo(Konto konto, String noweHaslo) throws PoziomDostepuNieIstnieje, NieobslugiwaneKodowanie, BrakAlgorytmuKodowania;
    
    /**
     * Metoda wprowadza do systemu konto klienta (niepotwierdzone)
     * @param konto informacje kontcie do utworzenia
     */
    void rejestrujKontoKlienta(Konto konto) throws PoziomDostepuNieIstnieje, NieobslugiwaneKodowanie, BrakAlgorytmuKodowania;
    
    /**
     * Metoda wprowadza do systemu konto o dowolnym, niewykluczajacym sie poziomie dostepu
     * @param konto informacje kontcie do utworzenia
     * @param poziomyDostepu lista poziomów dostępu jakie beda przypisane
     */
    void utworzKonto(Konto konto, List<String> poziomyDostepu) throws NieobslugiwaneKodowanie, BrakAlgorytmuKodowania, PoziomDostepuNieIstnieje;
    
    
    /**
     * Metoda zwracająca liste kont podobnych do zadanego konta
     * @param konto     obiekt zawierający kryteria wyszukania
     * @return          lista podobnych kont
     */
    public List<Konto> znajdzPodobne(Konto konto);
    
    /**
     * Metoda dodająca dany poziom dostępu do konta
     * @param konto     konto do którego należy dodać poziom dostępu
     * @param poziom    nazwa poziomu dostępu
     * @throws java.lang.Exception rzucany gdy nie można dodać poziomu dostępu
     */
    public void dodajPoziomDostepu(Konto konto, String poziom) throws BladPoziomDostepu, PoziomDostepuNieIstnieje;
    
    /**
     * Metoda odłączająca dany poziom dostępu do konta
     * @param konto     konto od którego należy odłączyć poziom dostępu
     * @param poziom    nazwa poziomu dostępu
     * @throws java.lang.Exception rzucany gdy nie można odłączyć poziomu dostępu
     */
    public void odlaczPoziomDostepu(Konto konto, String poziom) throws BladPoziomDostepu;
}
