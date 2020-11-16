package com.LeagueSocial.Services.Test;

import com.LeagueSocial.Domain.*;
import com.LeagueSocial.Domain.enums.KindSex;
import com.LeagueSocial.Domain.enums.Perfil;
import com.LeagueSocial.Repositories.*;
import com.LeagueSocial.Services.utils.PublicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired private AccountRepository accountRepository;
    @Autowired private StateRepository stateRepository;
    @Autowired private CityRepository cityRepository;
    @Autowired private AddressRepository addressRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private AssociatesRepository fallowingRepository;
    @Autowired private PublicationRepository publicationRepository;
    @Autowired private CommentRepository commentRepository;
    @Autowired private BCryptPasswordEncoder bc;

    public void InstantiateTestDatabase() throws ParseException {

        Account account1 = new Account
                ("Naruto Uzumaki",null, "uzumakinaruto.kage@socialmedia.com",bc.encode("Kurama9"), KindSex.MASCULINO);
        Account account2 = new Account
                ("Hinata Uzumaki",null, "hinata.hyuga@socialmedia.com",bc.encode("MylittleFamyly"), KindSex.FEMININO);
        Account account3 = new Account
                ("Ambu Sai",null, "sai.yamanaka@socialmedia.com",bc.encode("EmotionsAreImportant"), KindSex.PERSONALIZADO);
        Account account4 = new Account
                ("Ino Yamanaka",null, "ino.yamanaka@socialmedia.com",bc.encode("IgotBigBoobs22"), KindSex.FEMININO);
        Account account5 = new Account
                ("Sasuke Uchiha",null, "sasuke.uchiha@socialmedia.com",bc.encode("RebornOntheRightSide"), KindSex.MASCULINO);
        Account account6 = new Account
                ("Sakura Uchiha",null, "sakura.uchiha@socialmedia.com",bc.encode("I.finallyReachThey"), KindSex.FEMININO);
        Account account7 = new Account
                ("Shikamaru Nara",null, "shikamaru.nara@socialmedia.com",bc.encode("TheBatterStraterWar"), KindSex.MASCULINO);
        Account account8 = new Account
                ("Temari Nara",null, "temari.nara@socialmedia.com",bc.encode("FinallyMyBatterPlace"), KindSex.FEMININO);
        Account account9 = new Account
                ("Minato Namikaze",null, "minato.kage@socialmedia.com",bc.encode("MyOnlySonIsTheMostBrilliantLightOfTheSky"), KindSex.MASCULINO);
        Account account10 = new Account
                ("Kushina Uzumaki",null, "kushina.uzumaki@socialmedia.com",bc.encode("TheRedHairButSoBeutifull"), KindSex.FEMININO);
        Account account11 = new Account
                ("Kakashi Hatake",null, "kakashi.hatake@socialmedia.com",bc.encode("CopyNinja"), KindSex.MASCULINO);
        Account account12 = new Account
                ("Itachi Uchiha",null, "itachi.uchiha@socialmedia.com",bc.encode("TheNinjaLiviningInTheDarkness"), KindSex.MASCULINO);
        Account account13 = new Account
                ("Ichigo Kurusaki",null, "kurasaki.ichigo@socialmedia.com",bc.encode("TenzaZangetsu"), KindSex.MASCULINO);
        Account account14 = new Account
                ("Inoue Orihime",null, "inoue.orihime@socialmedia.com",bc.encode("IDaeForKursakiKun"), KindSex.FEMININO);
        Account account15 = new Account
                ("Toushiro Hitsugaya",null, "hitsugaya.capita@socialmedia.com",bc.encode("TheMostColdBankai"), KindSex.MASCULINO);
        Account account16 = new Account
                ("Urahara kisuke",null, "urahara.kisuke@socialmedia.com",bc.encode("TheBestStoreOfKarakuraCity"), KindSex.MASCULINO);
        Account account17 = new Account
                ("Rangiku Matsumoto",null, "matsumto.Rangiku@socialmedia.com",bc.encode("SwordofWild"), KindSex.FEMININO);
        Account account18 = new Account
                ("Yoruichi Shihoin",null, "yoruichi.shihoin@socialmedia.com",bc.encode("EbonyPrincessOrLightnhin"), KindSex.FEMININO);
        Account account19 = new Account
                ("Saori Kido",null, "saori.athena@socialmedia.com",bc.encode("SeyaIsMyBestMan"), KindSex.FEMININO);
        Account account20 = new Account
                ("Ash Ketchum",null, "ash.ketchum@socialmedia.com",bc.encode("TheMostPateticTrainner"), KindSex.MASCULINO);
        Account account21 = new Account
                ("Serena ketchum",null, "serena.ketchum@socialmedia.com",bc.encode("TheGirlAreLoveThePateticTrainner"), KindSex.FEMININO);
        Account account22 = new Account
                ("Kirigaya Kazuto",null, "kazuto.kirigaya@socialmedia.com",bc.encode("TheDarkenesWarrior"), KindSex.MASCULINO);
        Account account23 = new Account
                ("Yuuki Asuna",null, "asuna.yuuki@socialmedia.com",bc.encode("TheFantasyWoman"), KindSex.FEMININO);
        Account account24 = new Account
                ("Meliodas",null, "meliodas@socialmedia.com",bc.encode("TheSonOfDemon"), KindSex.MASCULINO);
        Account account25 = new Account
                ("Elizabeth Liones",null, "elizabeth.liones@socialmedia.com",bc.encode("TheSonOfGods"), KindSex.FEMININO);

        Account account26 = new Account("Italo Bonfim",null, "italo.bonfim@socialmedia.com", bc.encode(" Fakemsg320"), KindSex.MASCULINO);
        account26.getTelephone().addAll(Arrays.asList("(18) 74555-7839","(51) 80834-6723","(14) 84587-8859"));
        account26.addPerfil(Perfil.ADMIN);

        accountRepository.saveAll(Arrays.asList(account1,account2,account3,account4,account5,account6,account7,
                account8,account9,account10,account11,account12,account13,account14,account15,account16,account17,
                account18,account19,account20,account21,account22,account23,account24,account25, account26));

        Associates association1 = new Associates(account1,account3,false);
        Associates association2 = new Associates(account8,account2,false);
        Associates association3 = new Associates(account2,account1,false);
        Associates association4 = new Associates(account22,account23,false);
        Associates association5 = new Associates(account23,account22,false);
        Associates association6 = new Associates(account24,account25,false);
        Associates association7 = new Associates(account25,account24,false);
        Associates association8 = new Associates(account4,account5,false);
        Associates association9 = new Associates(account5,account6,false);
        Associates association10 = new Associates(account9,account10,false);
        Associates association11 = new Associates(account3,account20,false);
        Associates association12 = new Associates(account5,account11,false);
        Associates association13 = new Associates(account1,account10,false);
        Associates association14 = new Associates(account10,account17,false);
        Associates association15 = new Associates(account8,account21,false);
        Associates association16 = new Associates(account15,account10,false);
        Associates association17 = new Associates(account15,account1,false);
        Associates association18 = new Associates(account18,account8,false);
        Associates association19 = new Associates(account5,account12,false);
        Associates association20 = new Associates(account2,account5,false);
        Associates association21 = new Associates(account2,account4,false);

        fallowingRepository.saveAll(Arrays.asList(association1,association2,association3,association4,
                association5,association6,association7,association8,association9,association10,association11,
                association12,association13,association14,association15,association16,association17,association18,
                association19,association20,association21));

        Category FPS = new Category("FPS");
        Category animes = new Category("Animes");
        Category Estrategy = new Category("Estrategy");
        Category Mobile = new Category("Mobile");
        Category Sports = new Category("Sports");
        Category Race = new Category("Race");
        Category Combat = new Category("Combat");

        categoryRepository.saveAll(Arrays.asList(FPS,animes,Estrategy,Mobile,Sports,Race,Combat));

        SimpleDateFormat mask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        PublicationUtils util = new PublicationUtils();

        Publication publication01 = new Publication(null,"Vamos ver qual que é dessa plataforma",util.getTime());
        publication01.getUser().add(account1);

        Publication publication02 = new Publication(null,"Sera que Naruto-kun está aqui também?",util.getTime());
        publication02.getUser().add(account2);

        Publication publication03 = new Publication(null,"hoje sou uma pessoa totalmente diferente, talvez mesta plataforma nova, eu consiga demonstrar isso",util.getTime());
        publication03.getUser().add(account3);

        Publication publication04 = new Publication(null,"Vamos ver qual que é dessa plataforma",util.getTime());
        publication04.getUser().add(account4);

        Publication publication05 = new Publication(null,"O mundo junto ao sai é incrivel",util.getTime());
        publication05.getUser().add(account5);

        Publication publication06 = new Publication(null,"olá a todos",util.getTime());
        publication06.getUser().add(account6);

        Publication publication07 = new Publication(null,"uma plataforma de interação nova né, que saco!",util.getTime());
        publication07.getUser().add(account7);

        Publication publication08 = new Publication(null,"Devo visitar a vila oculta da Areia em breve junto com meu filho...", util.getTime());
        publication08.getUser().add(account8);

        Publication publication09 = new Publication(null,"Quando sera que vão continuar Bleack afinal de contas?",util.getTime());
        publication09.getUser().add(account9);

        Publication publication10 = new Publication(null,"Devo me tornar mais forte para poder lutar junto com o ichigo",util.getTime());
        publication10.getUser().add(account10);

        Publication publication11 = new Publication(null,"Por que os roteristas são tão burrus a ponto de separar" +
                " do protagonista principal um dos melhores pokemons que ja teve",util.getTime());
        publication11.getUser().add(account11);

        Publication publication12 = new Publication(null,"Sera que o kakashi um dia vai casar?",util.getTime());
        publication12.getUser().add(account12);

        publicationRepository.saveAll(Arrays.asList(publication01,publication02,publication03,publication04,
                publication05,publication06,publication07,publication08,publication09,publication10,publication11,
                publication12));

        Comments comments01 = new Comments("Dificil dizer, uma vez que parece não haver qualque engajamento a respeito da serie",account13,publication09);
        Comments comments02 = new Comments("Mor, o que tem achado da plataforma, acha segura?",account25,publication09);
        Comments comments03 = new Comments("Você já provou que se tornou diferente amor, não gaster suas forças com algo que todos já saber",account4,publication03);
        Comments comments04 = new Comments("kkkkkkk, aguardem as cenas do proximo capitulo... eternamente",account13,publication09);
        Comments comments05 = new Comments("kakashi, quando você ira casar e ter uma familia, estamos todos aguardando",account1,publication12);
        Comments comments06 = new Comments("Kakashi, que me tornar tia antes de morrer kkkkkkk",account2,publication12);
        Comments comments07 = new Comments("ash é muito burro, como despensão o greninja, um dos melhores pokemons que a serie já teve, que saco!",account7,publication11);
        Comments comments08 = new Comments("não fale assim do ash, ele ainda esta treinando, assim como eu estou! ;(",account21,publication12);
        Comments comments09 = new Comments("Sasuke, sera que... podemos nos... encontrar hoje?",account6,publication06);
        Comments comments10 = new Comments("Hmmmm, sei exatamente o que você deseja sakura",account4,publication06);
        Comments comments11 = new Comments("Eiiii... não sei o que vocês acham, mas querem jogar um jogo?" +
                "chama-se Sword Art Online",account22,publication12);
        Comments comments12 = new Comments("Não se preocupe Orihime, eu sempre estarei lá por você!",account13,publication10);

        commentRepository.saveAll(Arrays.asList(comments01,comments02,comments03,comments04,comments05,comments06,
                comments07,comments08,comments09,comments10,comments11,comments12));







    }
}
