package lostontrelokiv.installer;



/**
 *
 * @author jedi
 */
public class StoryLine {

    private final int MAX_NODES = 10;
    private final String[] STORY_FIN = new String[MAX_NODES];
    private final String[] QUESTIONS_FIN = new String[MAX_NODES];

    public StoryLine() {

        STORY_FIN[1] = "Päässäsi jyskyttää. Poskesi on vasten jotain kylmää. Avaat silmät "
                + "varovasti muistamatta missä olet tai mitä olit tekemässä. Hetkeen et ymmärrä "
                + "mitä katselet, mutta tila näyttää kaukaisesti tutulta. Vasemmalla puolella näet "
                + "3D näytöt ja skannaustietokoneen yksiköt. Suoraan edessä on kommunikaationäytön "
                + "haljennut 80 tuumainen näyttö. Sen oikealla puolella oli gyrovakaimet jotka "
                + "näyttävät kuin työntäisivät kieltä ulos suusta. Vakainten käyttöaineena oleva "
                + "helium-katonisoitu kaasu reagoi voimakkaasti joutuessaan kosketuksiin ilman hapen kanssa."
                + "Helium itsessään on reagoimaton jalokaasu, mutta katonisaatio-menetelmä palauttaa "
                + "sen palo-ominaisuudet.\n"
                + "Muistat vähitellen, että  "
                + "olet tutkimusaluksesi komentosillalla. Otit vastaan toimeksiannon etsiä "
                + "kiillepölyplatiniumia Henneloran neljännestä kuusta, Trelok IV:stä. "
                + "Aluksesi nimi on Space Research Ship SORATAK. "
                + "Puistelet päätäsi kuin yrittäen saada siellä palaset järjestykseen "
                + "palauttaaksesi mieleen hetkeä ennen räjähdystä. Olitte suorittamassa "
                + "geostationaarisia skannauksia Trelok IV:n kiertoradan stationaaritasolla "
                + "Melloran meren yllä, NW-kvadrantissa. "
                + "Et kuitenkaan muista räjähdyksestä mitään, mutta päättelet  "
                + " automaattisen palontorjunnan jäljiltä kytemään jääneistä "
                + "palopesäkkeistä ja gyrovakainten ilmeestä, että kyseessä oli "
                + "todennäköisimmin happikonsentraation "
                + "saturoitumisesta aiheutunut reaktio joka sytytti hallitsemattomasti komentosillan "
                + "gyrovakainten kaasut. Uskoisit, että 3D-näytöt saattaisivat "
                + "lähteä käyntiin lokaalikäynnistyksellä. Hätävirran merkkivalo on päällä, joten "
                + "näyttölaitteet saavat virtaa. 3D-näytöistä voisi yrittää selvittää mikä osa "
                + "aluksesta on vielä ehjä ja saako poimumoottoreita käyntiin. "
                + "Jos saisit ohjattua aluksen Trelok IV:n pinnalle voisi vahinkoja tutkia "
                + "hallitussa ympäristössä. Alus pysyy vielä hetken geostationaarisella radalla. "
                + "Poimumoottoreiden kuorma oli aiemmin minimaalinen. Radalla oli helppo pysyä ilman "
                + "suurempia manoveerauksia.\n "
                + "Toisaalta räjähdys saattoi aiheuttaa mikrohalkeamia runkoon ja komentosilta on vasten "
                + "avaruutta. Riippuen halkeamista ja vallitsevasta paineesta runko "
                + "komentosillan kohdala saattaa repeytyä auki, jolloin imeydyt avaruuteen eikä "
                + "sinulla ole päällä ympäristöpukua. "
                + "Olisi tarpeellista varmistaa nopea ulospääsy komentosillalta aluksen muihin osiin.\n\n";
        QUESTIONS_FIN[1] = "Mitä haluat tehdä:\n"
                + "a) Tutki missä on lähin ulospääsy.\n"
                + "b) Tutki tietokoneen konsoleita jos niistä löytyisi lisää dataa rungon vakavuudesta.\n";

        STORY_FIN[2] = "Kompastut aseeseen. Tietokoneet lähtevät käyntiin ja löydät viestin.\n\n";
        QUESTIONS_FIN[2] = "a) Lue viesti.\n";

        STORY_FIN[3] = "\"Tulkaa nopeasti hangaariin B2, täällä on... täällä on jotain... "
                + "en pysty kuvailemaan sitä mutta se lisääntyy hurjaa vauhtia. Se kasvaa ja syö alleen kaiken."
                + " Se.. se lähestyy... se kasvaa nyt\" <kriih> kommunikaattorin lähettämä viesti "
                + "katkeaa metalliseen säröön. Samassa huomaat että ympärilläsi kasvaa outoa vihreää ainetta. "
                + "Se lähestyy ja lisääntyy joka suunnasta. Peräännyt huoneen nurkkaan, mutta se on turhaa. "
                + "Viime hetkellä käsität että räjähdystä ei aiheuttanut happisaturaatio vaan Scross - Henneloran "
                + "satelliittiromunkerääjä joka erehtyi luulemaan SORATAKia romuraudaksi. Sen lähettämä ionipulssi "
                + "sekoitti koneet ja aiheutti ketjureaktion gyrovaikainten kaasussa. Scross rampauttaa "
                + "satelliitit juuri ennen sulatustoiminnon aloitusta. Lisääntyvä kasvava aine ei ole mitään muuta "
                + "kuin aluksesi SORATAKin materiaali, joka sulaa. "
                + "Loppusi on käsillä.....\n\n";
        QUESTIONS_FIN[3] = "Loppu";

        STORY_FIN[4] = "Rukkaat näyttöjä ja painelet reset-painiketta. Näyttö värisee ja vääristynyt kuva "
                + "tarkentuu pikku hiljaa. Pääset aluksen lokiin sekä kamerajärjestelmään.\n\n";
        QUESTIONS_FIN[4] = "Mitä haluat tehdä:\n"
                + "a) Tutki lokia.\n"
                + "b) Tutki kamerajärjestelmää.\n";

        STORY_FIN[5] = "Komentosillan hätäuloskäynti on takavasemmalla rojun peitossa. "
                + "Tietä raivatessasi tonkiessasi löydät avaruusrosvoja "
                + "vastaan palkatun puolisotilaan ilmeisestikin henkensä heittäneenä. Huomaat hänen "
                + " laserpistoolinsa minkä tiedät olevan  "
                + "varmatoiminen työjuhta näille joukoille. Se ei pienistä räjähdyksistä hätkähdä. Otat pistoolin ja "
                + "työnnät sen työpukusi varustevyöhön. "
                + "Raivaat tiesi ovelle mutta se on jumissa.\n\n";
        QUESTIONS_FIN[5] = "Mitä haluat tehdä:\n"
                + "a) Ammu pistoolilla oven ohjausmekanismiin toivoen että se avaa oven.\n"
                + "b) Yritä yhdistää johdot ja tiirikoida ovi.\n";

        STORY_FIN[6] = "Peräännyt kauemmaksi ja tähtäät oven ohjausmekanismia. Et ole varma säädöistä, ja aseen mukana "
                + "ei tullut käyttöohjetta. Pyörittelet asetta kunnes ohitat varmistimen ja "
                + "ase alkaa latautumaan. Se humisee hiljaa ja indikoi täyttä varausta. Muistelet akatemian "
                + "aikuisia tähtäysoppeja ja päätät vetää lonkalta. Työnnät vapaana olevan käden sormen "
                + "korvaan ja tähtäät paneelia. Vedät liipaisimesta ja lähes nolla-rekyylillä "
                + "pistooli sylkäisee kolme suihkua kohti paneelia. Yksi osuu suoraan paneeliin mutta tähtäyksesi "
                + "on hieman pielessä jaa loput osuvat paineoveen. Ne kimpoavat kohti komentosillan etuseinää. "
                + "Laserin osumakohdasta halkeamat alkavat kasvaa ulospäin. "
                + "Juokset nopeasti yhden panssarivahvistetun ikkunan luo ja näet "
                + "kuinka vakuumi alkaa imeä ilmaa ja tomua suihkuina ulos halkeamista. Vain hetki ja ensimmäinen "
                + "pala SORATAKin ulkokuorta lentää avaruuteen. Katselet lumoutuneena sen pyörimistä jatkaessaan "
                + "matkaa kohti Trelok IV:n kaasukehää. Hetken kuluttua komentosilta luhistuu ja vedät viimeisen "
                + "kerran SORATAKin ilmaa keuhkoihisi ja suljet silmäsi.\n";
        QUESTIONS_FIN[6] = "Loppu";

        STORY_FIN[7] = "Yhdistät johdot ja onnistut tiirikoimaan oven auki. Päästyäsi oven "
                + "toiselle puolelle näet kuinka komentosillan seinä alkaa romahtamaan. Pystyt sulkemaan paineoven "
                + "ulkoapäin. Ohjauspaneeli on täysin ehjä. Juuri oven sulkeutuessa tunnet kuinka "
                + "vakuumi alkaa kiskoa ilmaa ympäriltäsi. Oven ympärille syttyy punainen valo, joka kertoo "
                + "että tila ei ole enää paineistettu. \"Hienoa\",  sanot ääneen. Nyt joudut "
                + "ohjaamaan SORATAKin sokkona konehuoneesta pelkkien analogisensoreiden avulla.\n";
        QUESTIONS_FIN[7] = "Loppu";
    }


    public String getStoryForNode(int nodeId) {
        return STORY_FIN[nodeId];
    }


    public String getQuestionForNode(int nodeId) {
        return QUESTIONS_FIN[nodeId];
    }


}
