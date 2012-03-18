
package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class VarastoTest {
 
    Varasto varasto;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
 
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void vaaraAlustus(){
        Varasto varasto2;
        varasto2 = new Varasto(-1);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.paljonkoMahtuu(), vertailuTarkkuus);
        
    }
    
    @Test
    public void vaaraAlustus2(){
        Varasto varasto2;
        varasto2 = new Varasto(-1, -1);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.paljonkoMahtuu(), vertailuTarkkuus);
        
    }    
    
    @Test
    public void oikeaAlustus(){
        Varasto varasto2;
        varasto2 = new Varasto(1, 1);
        assertEquals(1, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.paljonkoMahtuu(), vertailuTarkkuus);
        
    }   
    
    @Test
    public void oikeaAlustus2(){
        Varasto varasto2;
        varasto2 = new Varasto(2, 1);
        assertEquals(1, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(1, varasto2.paljonkoMahtuu(), vertailuTarkkuus);
        
    }    
    
    @Test
    public void oikeaAlustus3(){
        Varasto varasto2;
        varasto2 = new Varasto(1, 2);
        assertEquals(1, varasto2.getSaldo(), vertailuTarkkuus);
        assertEquals(0, varasto2.paljonkoMahtuu(), vertailuTarkkuus);
        
    }      
    
    @Test
    public void lisataanVaarin() {
        varasto.lisaaVarastoon(-1);
 
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }    
    
    @Test
    public void lisataanOikein() {
        varasto.lisaaVarastoon(1);
 
        assertEquals(9, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }   
    
    @Test
    public void lisataanLiikaa() {
        varasto.lisaaVarastoon(11);
 
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }    
    
    @Test
    public void otetaanVaarin() {
        varasto.otaVarastosta(-1);
 
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }   
    
    @Test
    public void otetaanLiikaa() {
        varasto.lisaaVarastoon(1);
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(1, saatuMaara, vertailuTarkkuus);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
        assertEquals(0, 1);
    }    
    
    
    @Test
    public void testaaTulostus() {
        varasto.lisaaVarastoon(1);        
 
        assertEquals("saldo = 1.0, vielä tilaa 9.0", varasto.toString());        
    }        
}