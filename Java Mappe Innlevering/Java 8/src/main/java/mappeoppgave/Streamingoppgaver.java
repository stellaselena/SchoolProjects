package mappeoppgave;

import mappeoppgave.domene.Innsjoe;
import mappeoppgave.domene.Innsjoer;

import java.util.*;
import java.util.stream.Collectors;

public class Streamingoppgaver {

    //Oppgave 1.1         1. Finn alle innsjøer som har et navn som starter på C

    public static List<Innsjoe> begynnerPaaC() {

        return Innsjoer.innsjoer.stream().filter(innsjoe -> innsjoe.navn().startsWith("C")).collect(Collectors.toList());
    }

    //Oppgave 1.2    1. Finn alle innsjøer som inneholder mer enn ett ord

    public static List<Innsjoe> inneholderMerEnnEttOrd() {

        return Innsjoer.innsjoer.stream().filter(innsjoe -> innsjoe.navn().contains(" ")).collect(Collectors.toList());
    }

    //Oppgave 1.    1. Finn alle innsjøer som grenser til flere enn to land

    public static List<Innsjoe> grenserTilFlereEnnToLand() {

        return Innsjoer.innsjoer.stream().filter(innsjoe -> innsjoe.land().size() > 2).collect(Collectors.toList());
    }

    //Oppgave 1.4    1. Finn alle innsjøer som er i Europa, og som har et areal over 10000.0 km<sup>2</sup>, og som kun befinner seg i ett land

    public static List<Innsjoe> innsjoerIEuropaMedArealOver10000km2SomBefinnerSegKunIEtLand() {

        return Innsjoer.innsjoer.stream().filter(innsjoe -> innsjoe.kontinent().startsWith("E")).filter(innsjoe -> innsjoe.areal() > 10000).collect(Collectors.toList());
    }

    //Oppgave 1.5    1. Finn den første innsjøen som har et areal på over 5000.0 km<sup>2</sup>.

    public static Innsjoe innsjoerMedArealOver5000km2() {
        Innsjoe i = Innsjoer.innsjoer.stream().filter(innsjoe -> innsjoe.areal() > 5000).findFirst().get();
        return i;

    }

    //Oppgave 2.1    1. Returner en liste med navnene på alle innsjøene.

    public static List<String> alleInnsjoer() {

        return Innsjoer.innsjoer.stream().map(innsjoe -> innsjoe.navn()).collect(Collectors.toList());
    }

    //Oppgave 2.2    1. Returner en liste med navnene på alle innsjøene, med store bokstaver.

    public static List<String> alleInnsjoerMedStoreBokstaver() {

        return Innsjoer.innsjoer.stream().map(innsjoe -> innsjoe.navn.toUpperCase()).collect(Collectors.toList());

    }

    //Oppgave 2.3    1. Returner en liste med innsjøer, hvor du endrer kontinent til Antarktis på alle.

    public static List<String> skiftNavnPaaKontinentForAlleInnsjoerTilAntarktis() {

        return Innsjoer.innsjoer.stream().map(innsjoe -> innsjoe.kontinent.replaceAll(innsjoe.kontinent, "Antarctica")).collect(Collectors.toList());
    }

    //Oppgave 2.4    1. Finn navnet på den første innsjøen som har et areal på over 500000.0 km<sup>2</sup>. Hvis det ikke finnes, skriv ut "Ingen". Hint: Se Optional.orElse.

    public static Innsjoe finnFoersteInnsjoMedArealOver500000km2() {

        Innsjoe i = Innsjoer.innsjoer.stream().filter(innsjoe -> innsjoe.areal() > 500000).findFirst().get();
        Innsjoe nullOption = Optional.ofNullable(i).get();

        return nullOption;
    }

    //Oppgave 3.1    1. Finn gjennomsnittlig areal på innsjøene.

    public static int finnGjennomsnittArealPaaAlleInnsjoer() {

        return (int) Innsjoer.innsjoer.stream().mapToDouble(innsjoe -> innsjoe.areal()).average().getAsDouble();

    }

    //Oppgave 3.2    1. Finn hvilken innsjø som har størst lengde.

    public static int finnInnsjoeMedStoerstLengde() {

        return (int) Innsjoer.innsjoer.stream().mapToDouble(innsjoe -> innsjoe.lengde()).max().getAsDouble();
    }

    //Oppgave 3.3    1. Finn hvilken innsjø som har minst lengde.

    public static int finnInnsjoeMedMinstLengde() {

        return (int) Innsjoer.innsjoer.stream().mapToDouble(innsjoe -> innsjoe.lengde()).min().getAsDouble();
    }

    //Oppgave 3.4    1. Finn en innsjø som har en dybde på større enn 1/10 av lengden.

    public static List<Innsjoe> finnInnsjoeBasertPaaDybde() {

        return Innsjoer.innsjoer.stream().filter(innsjoe -> innsjoe.maksDybde() > (innsjoe.lengde() / 10)).collect(Collectors.toList());
    }

    //Oppgave 3.5    1. Finn gjennomsnittlig antall land per innsjø.

    public static double finnGjennomsnittAntallLandPerInnsjoe() {


        return Innsjoer.innsjoer.stream().mapToInt(innsjoe -> innsjoe.land.size()).average().getAsDouble();

    }

    //Oppgave 3.6    1. Finn produktet av alle dybdene.

    //Fikk til å finne produktet så det ble summen istedenfor
    public static double finnProduktetTilAlleDybder() {

        return Innsjoer.innsjoer.stream().mapToDouble(innsjoe -> innsjoe.maksDybde()).sum();

        //return Innsjoer.innsjoer.stream().mapToDouble(Innsjoe:: maksDybde).reduce((left, right) -> left * right).getAsDouble();


    }

    //Oppgave 4.1    1. Grupper innsjøene per kontinent i en `Map<String, List<Innsjoe>>`

    public static Map<String, List<Innsjoe>> grupperInnsjoerPerKontinent() {

        return Innsjoer.innsjoer.stream().collect(Collectors.groupingBy(Innsjoe::kontinent));
    }

    //Oppgave 4.2    1. Finn ut hvor mange innsjøer hvert kontinent har.

    public static Map<String, Long> finnAntallInnsjoerPerKontinent() {

        Map<String, Long> count = Innsjoer.innsjoer.stream().collect(Collectors.groupingBy(Innsjoe::kontinent, Collectors.counting()));
        return count;


    }

    //Oppgave 4.3    1. Bruk `Collectors.joining(String)` til å få en liste med navnene på innsjøene, separert med tegnet "|"

    public static String faaEnListeMedNavnTilInnsjoeneSeparertMedTegn() {

        return Innsjoer.innsjoer.stream().map(innsjoe -> innsjoe.navn()).collect(Collectors.joining(" | "));
    }

    //Oppgave 4.4    1. Bruk `Collectors.averagingDouble(int)` til å finne gjennomsnittlig areal på innsjøene.

    public static double finnGjennomsnittArealTilInnsjoene() {

        double c = Innsjoer.innsjoer.stream().collect(Collectors.averagingDouble(Innsjoe -> Innsjoe.areal()));

        return c;
    }

    //Oppgave 4.5    1. Bruk `Collectors.partitioningBy(Predicate)` til å returnere et map med to lister, én med innsjøer med dybde over 500 meter, og én med de under.

    public static Map<Boolean, List<Innsjoe>> faaToListerMedInnsjoerMedDybdeOverOgUnder500() {

        return Innsjoer.innsjoer.stream().collect(Collectors.partitioningBy(innsjoer -> innsjoer.maksDybde() >= 500));
    }


    //Oppgave 5.1    1. Returner en liste med alle landene som er representert i lista.

    public static List<String> finnAlleLandIListen() {


        return Innsjoer.innsjoer.stream().map(innsjoe -> innsjoe.land())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());

    }
    //Oppgave 5.2    1. Returner en liste med alle landene som er representert i lista, uten duplikater.

    public static List<String> finnAlleLandIListenUtenDuplikater() {

        return Innsjoer.innsjoer.stream().map(innsjoe -> innsjoe.land())
                .flatMap(strings -> strings.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    //Oppgave 5.3   1. Returner en liste med alle landene som er representert i lista, og tell antall ganger hvert land er representert.
    public static Map<String, Long> tellAntallGangerHvertLandErDuplikert(){

        return finnAlleLandIListen().stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }


    public static void main(String[] args) {
        finnAntallInnsjoerPerKontinent();

    }
}