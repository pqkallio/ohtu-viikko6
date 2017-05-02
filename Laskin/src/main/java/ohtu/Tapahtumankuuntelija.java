package ohtu;

import ohtu.komennot.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private final Map<JButton, Komento> komennot;
    private final JButton nollaa;
    private final JButton undo;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private final Sovelluslogiikka sovellus;
    private Komento edellinen;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.komennot = new HashMap<>();
        this.nollaa = nollaa;
        this.undo = undo;
        this.undo.setEnabled(false);
        this.sovellus = new Sovelluslogiikka();
        komennot.put(plus, new Summa(sovellus, tuloskentta, syotekentta));
        komennot.put(miinus, new Erotus(sovellus, tuloskentta, syotekentta));
        komennot.put(nollaa, new Nollaus(sovellus, tuloskentta, syotekentta));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Komento komento = komennot.get(ae.getSource());
 
        if (komento != null) {
            komento.suorita();
            edellinen = komento;
        } else {
            edellinen.peru();
            edellinen = null;
        }
        
        nollaa.setEnabled(sovellus.tulos() != 0);
        undo.setEnabled(edellinen != null);
    }
 
}