
package ohtu.komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author pqkallio
 */
public class Nollaus implements Komento {
    private final Sovelluslogiikka sovellus;
    private final JTextField tuloskentta;
    private final JTextField syotekentta;
    private int edellinenTulos;

    public Nollaus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinenTulos = 0;
    }
    @Override
    public void suorita() {
        edellinenTulos = sovellus.tulos();
        sovellus.nollaa();
        
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        sovellus.asetaTulos(edellinenTulos);
        tuloskentta.setText("" + edellinenTulos);
        edellinenTulos = 0;
    }
    
}
