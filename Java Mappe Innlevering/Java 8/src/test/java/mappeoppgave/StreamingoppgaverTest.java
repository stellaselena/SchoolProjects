package mappeoppgave;

import mappeoppgave.domene.Innsjoe;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static mappeoppgave.Streamingoppgaver.alleInnsjoerMedStoreBokstaver;
import static org.junit.Assert.*;

public class StreamingoppgaverTest {

    //Oppgave 5.3
    @Test
    public void tellAntallGangerHvertLandErDuplikert() throws Exception{

        Map<String, Long> map = Streamingoppgaver.tellAntallGangerHvertLandErDuplikert();

        assertTrue(map.get("Iran") == 2);

    }
    //Oppgave 5.2
    @Test
    public void finnAlleLandIListenUtenDuplikater() throws Exception {

        List<String> inneholderAlleLand = Streamingoppgaver.finnAlleLandIListenUtenDuplikater();

        assertEquals(inneholderAlleLand.size(), 25);
    }

    //Oppgave 5.1
    @Test
    public void finnAlleLandIListen() throws Exception {

        List<String> inneholderAlleLand = Streamingoppgaver.finnAlleLandIListen();

        assertEquals(inneholderAlleLand.size(), 57);

    }


    //4.5
    @Test
    public void faaToListerMedInnsjoerMedDybdeOverOgUnder500() throws Exception {

        Map<Boolean, List<Innsjoe>> testList = Streamingoppgaver.faaToListerMedInnsjoerMedDybdeOverOgUnder500();

        assertEquals(testList.size(), 2);
    }

    //4.4
    @Test
    public void finnGjennomsnittArealTilInnsjoene() throws Exception {

        double expected = Streamingoppgaver.finnGjennomsnittArealTilInnsjoene();
        int e = (int) expected;
        int actual = 30353;

        assertEquals(e, actual);
    }

    //4.3
    @Test
    public void faaEnListeMedNavnTilInnsjoeneSeparertMedTegn() throws Exception {

        String s = Streamingoppgaver.faaEnListeMedNavnTilInnsjoeneSeparertMedTegn();
        String actual = "Caspian Sea | Superior | Victoria | Huron | Michigan | Tanganyika | Baikal | Great Bear Lake | Malawi | Great Slave Lake | Erie | Winnipeg | Ontario | Ladoga | Balkhash | Vostok | Onega | Titicaca | Nicaragua | Athabasca | Taymyr | Turkana | Reindeer Lake | Issyk-Kul | Urmia | Vänern | Winnipegosis | Albert | Mweru | Nettilling | Sarygamysh Lake | Nipigon | Manitoba | Great Salt Lake | Saimaa | Khanka";

        assertEquals(s, actual);
    }

    //4.2
    @Test
    public void finnAntallInnsjoerPerKontinent() throws Exception {
        Map<String, Long> m = Streamingoppgaver.finnAntallInnsjoerPerKontinent();
        long d = m.get("Asia");
        assertEquals(d, 8);
    }

    //4.1
    @Test
    public void grupperInnsjoerPerKontinent() throws Exception {

        Map<String, List<Innsjoe>> map = Streamingoppgaver.grupperInnsjoerPerKontinent();

        assertEquals(map.size(), 6);
    }

    //3.6
    @Test
    public void finnProduktetTilAlleDybder() throws Exception {

        double a = Streamingoppgaver.finnProduktetTilAlleDybder();
        double b = 9010979.9;
        assertTrue(a == b);
    }

    //3.5
    @Test
    public void finnGjennomsnittAntallLandPerInnsjoe() throws Exception {

        double a = Streamingoppgaver.finnGjennomsnittAntallLandPerInnsjoe();
        double b = 1.5833333333333333;
        assertTrue(a == b);
    }

    //3.4
    @Test
    public void finnInnsjoeBasertPaaDybde() throws Exception {

        List<Innsjoe> list = Streamingoppgaver.finnInnsjoeBasertPaaDybde();

        assertEquals(list.size(), 30);
    }

    //3.3
    @Test
    public void finnInnsjoeMedMinstLengde() throws Exception {

        int a = Streamingoppgaver.finnInnsjoeMedMinstLengde();

        assertEquals(a, 90);
    }

    //3.2
    @Test
    public void finnInnsjoeMedStoerstLengde() throws Exception {

        int a = Streamingoppgaver.finnInnsjoeMedStoerstLengde();

        assertEquals(a, 13700);
    }

    //3.1
    @Test
    public void finnGjennomsnittArealPaaAlleInnsjoer() throws Exception {

        int a = Streamingoppgaver.finnGjennomsnittArealPaaAlleInnsjoer();

        assertEquals(a, 30353);
    }

    //2.4
    @Test(expected = NoSuchElementException.class)
    public void finnFoersteInnsjoMedArealOver500000km2() {

        Streamingoppgaver.finnFoersteInnsjoMedArealOver500000km2();
    }

    //2.3
    @Test
    public void skiftNavnPaaKontinentForAlleInnsjoerTilAntarktis() throws Exception {

        List<String> list = Streamingoppgaver.skiftNavnPaaKontinentForAlleInnsjoerTilAntarktis();

        assertEquals(list.get(0), "Antarctica");
        assertEquals(list.get(5), "Antarctica");
        assertEquals(list.get(35), "Antarctica");
    }

    //2.2
    @Test
    public void skalGjoereOmAlleInnsjoeNavnTilStoreBokstaver() throws Exception {

        List<String> stringList = alleInnsjoerMedStoreBokstaver();

        assertEquals(stringList.get(0), "CASPIAN SEA");
        assertNotEquals(stringList.get(0), "caspian sea");
    }

    //2.1
    @Test
    public void skalFinneAlleInnsjoer() throws Exception {

        List<String> alleInnsjoer = Streamingoppgaver.alleInnsjoer();

        assertEquals(36, alleInnsjoer.size());
    }

    //1.5
    @Test
    public void skalFinneAlleInnsjoerMedArealOver5000km2() throws Exception {

        Innsjoe innsjoerOver5000km2 = Streamingoppgaver.innsjoerMedArealOver5000km2();

        assertEquals("Caspian Sea", innsjoerOver5000km2.navn());
    }

    //1.4
    @Test
    public void skalFinneAlleInnsjoerIEuropaMedArealOver10000km2SomBefinnerSegKunIEtLand() throws Exception {

        List<Innsjoe> innsjoerIEuropaOver10000 = Streamingoppgaver.innsjoerIEuropaMedArealOver10000km2SomBefinnerSegKunIEtLand();
        assertEquals(1, innsjoerIEuropaOver10000.size());
    }

    //1.3
    @Test
    public void skalFinneAlleSomGrenserTilFlereEnnToLand() throws Exception {

        List<Innsjoe> grenserTilFlereEnnToLand = Streamingoppgaver.grenserTilFlereEnnToLand();
        assertEquals(4, grenserTilFlereEnnToLand.size());
    }

    //1.2
    @Test
    public void skalFinneAlleSomInneholderMerEnnEttOrd() throws Exception {

        List<Innsjoe> innsjoerSominneholderMerEnnEttOrd = Streamingoppgaver.inneholderMerEnnEttOrd();
        assertEquals(6, innsjoerSominneholderMerEnnEttOrd.size());

    }
    //1.1
    @Test
    public void skalFinneAlleSomStarterPaaC() throws Exception {

        List<Innsjoe> innsjoerSomBegynnerPaaC = Streamingoppgaver.begynnerPaaC();
        assertEquals(1, innsjoerSomBegynnerPaaC.size());
    }
}