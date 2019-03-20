package com.mycompany.unicafe;

import org.junit.*;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp(){
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void onOlemassa(){
        assertNotNull(kassa);
    }
    @Test
    public void alussaOikeatArvot(){
        assertThat(kassa.kassassaRahaa(),is(100000));
        assertThat(kassa.maukkaitaLounaitaMyyty(),is(0));
        assertThat(kassa.edullisiaLounaitaMyyty(),is(0));
    }
    @Test
    public void kateisostoEdullisesti(){
        kassa.syoEdullisesti(240);
        assertThat(kassa.kassassaRahaa(),is(100000+240));
        assertThat(kassa.edullisiaLounaitaMyyty(),is(1));
    }
    @Test
    public void kateisostoEdullisestiEiRahaa(){
        kassa.syoEdullisesti(1);
        assertThat(kassa.kassassaRahaa(),is(100000));
        assertThat(kassa.edullisiaLounaitaMyyty(),is(0));
    }
    @Test
    public void kateisostoMaukkaasti(){
        kassa.syoMaukkaasti(400);
        assertThat(kassa.kassassaRahaa(),is(100000+400));
        assertThat(kassa.maukkaitaLounaitaMyyty(),is(1));

    }
    @Test
    public void kateisostoMaukkaastiEiRahaa(){
        kassa.syoMaukkaasti(1);
        assertThat(kassa.maukkaitaLounaitaMyyty(),is(0));
        assertThat(kassa.kassassaRahaa(),is(100000));
    }
    @Test
    public void kortillaEdullisesti(){
        kassa.syoEdullisesti(kortti);
        assertThat(kassa.edullisiaLounaitaMyyty(),is(1));
        assertThat(kassa.kassassaRahaa(),is(100000));
        assertThat(kassa.syoEdullisesti(kortti),is(true));
    }
    @Test
    public void kortillaEiSyodaEdullisesti(){
        Maksukortti tyhja = new Maksukortti(0);
        kassa.syoEdullisesti(tyhja);
        assertThat(kassa.kassassaRahaa(),is(100000));
        assertThat(kassa.edullisiaLounaitaMyyty(),is(0));
        assertThat(kassa.syoEdullisesti(tyhja),is(false));
    }
    @Test
    public void kortillaMaukkaasti(){
        kassa.syoMaukkaasti(kortti);
        assertThat(kassa.kassassaRahaa(),is(100000));
        assertThat(kassa.maukkaitaLounaitaMyyty(),is(1));
        assertThat(kassa.syoMaukkaasti(kortti),is(true));
    }
    @Test
    public void kortillaEiSyodaMaukkaasti(){
        Maksukortti tyhja = new Maksukortti(0);
        kassa.syoMaukkaasti(tyhja);
        assertThat(kassa.kassassaRahaa(),is(100000));
        assertThat(kassa.maukkaitaLounaitaMyyty(),is(0));
        assertThat(kassa.syoMaukkaasti(tyhja),is(false));
    }
    @Test
    public void kortilleVoiLadataRahaa(){
        kassa.lataaRahaaKortille(kortti,100);
        assertThat(kassa.kassassaRahaa(),is(100000+100));
    }
    @Test
    public void kortilleEiVoiLadataNegatiivistaSummaa(){
        kassa.lataaRahaaKortille(kortti,-10);
        assertThat(kassa.kassassaRahaa(),is(100000));
    }
}
