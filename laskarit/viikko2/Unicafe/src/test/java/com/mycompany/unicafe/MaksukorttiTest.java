package com.mycompany.unicafe;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertThat(kortti.toString(), is("saldo: 10.0"));
    }

    @Test
    public void rahanLatausKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(500);
        assertThat(kortti.toString(), is("saldo: 15.0"));
    }

    @Test
    public void saldoVaheneeJosRahaaOn() {
        kortti.otaRahaa(500);
        assertThat(kortti.toString(), is("saldo: 5.0"));
    }

    @Test
    public void saldoEiMuutuJosEiRahaa() {
        kortti.otaRahaa(5000);
        assertThat(kortti.toString(), is("saldo: 10.0"));
    }
    @Test
    public void otaRahaaPalauttaaTrueJosRiittavastiRahaa(){

        assertThat(kortti.otaRahaa(500),is(true));
    }
    @Test
    public void otaRahaaPalauttaaFalseJosRahaEiRiita(){

        assertThat(kortti.otaRahaa(500000),is(false));
    }
    @Test
    public void saldoToimii(){
        assertThat(kortti.saldo(),is(1000));
    }

}
