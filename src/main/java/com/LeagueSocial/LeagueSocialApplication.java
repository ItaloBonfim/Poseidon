package com.LeagueSocial;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.LeagueSocial.Domain.*;
import com.LeagueSocial.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LeagueSocial.Domain.enums.KindSex;

@SpringBootApplication
public class LeagueSocialApplication implements CommandLineRunner {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private FallowingRepository fallowingRepository;


	public static void main(String[] args) {
		SpringApplication.run(LeagueSocialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat SDFF = new SimpleDateFormat("dd/MM/yyyy");

		Account account1 = new Account(null, "Italo Bonfim", "@italoBonfim02", KindSex.MASCULINO, "italobonfim@hotmail.com", "123456");
		account1.getTelephone().addAll(Arrays.asList("11 96760-1483", "11 5896-6437"));

		Account account2 = new Account(null, "Maria","@CeciliaBonfim60", KindSex.FEMININO, "m.cbcecilia@hotmail.com", "12345");
		account2.getTelephone().addAll(Arrays.asList("21 99564-4910", "21 3553-2353"));
		
		Account account3 = new Account(null, "Caroline", "@Carrols20", KindSex.FEMININO, "carolbonfim@gmail.com", "654321");
		account3.getTelephone().addAll(Arrays.asList("11 99626-8394","11 3755-8957"));
		
		Account account4 = new Account(null, "Leonardo Miguel", "@Lmiguel", KindSex.MASCULINO, "leoniguel@outlook.com", "124598");
		account4.getTelephone().addAll(Arrays.asList("61 99930-9107", "61 2637-5795"));

		accountRepository.saveAll(Arrays.asList(account1, account2, account3, account4));

		AssociatedFollowings AFx1 = new AssociatedFollowings();
		AssociatedFollowings AFx2 = new AssociatedFollowings();
		AssociatedFollowings AFx3 = new AssociatedFollowings();

		fallowingRepository.saveAll(Arrays.asList(AFx1,AFx2,AFx3));


		State stateSp = new State(null, "São Paulo");
		State stateRj = new State(null, "Rio de Janeiro");
		State stateDf = new State(null, "Distrito Federal");
		State stateEs = new State(null, "Espirito Santo");
		State stateSc = new State(null, "Santa Catarina");
		
		City citySp = new City(null, "São Paulo", stateSp);
		City cityRj = new City(null, "Rio De Janeiro", stateRj);
		City cityDf = new City(null, "Brasilia", stateDf);
		City cityEs = new City(null, "Vitoria", stateEs);
		City citySc = new City(null, "Florianópolis", stateSc);
		
		Address addressSp1 = new Address(null, "Rua Correia de Lemos", "04140-904", "790", "Chácara Inglesa", null, account1, citySp);
		Address addressRj = new Address(null, "Av. Atlântica", "22041-001", "2320", "Copacabana", null, account2, cityRj);
		Address addressRj2 = new Address(null, "Av. Atlântica", "22041-001", "2320", "Copacabana", null, account1, cityRj);
		Address addressSp2 = new Address(null, "Rua Quinta da Conraria", "05852-480", "355", "Parque Santo Antônio", null, account3, citySp);
		Address addressDf = new Address(null, "Quadra QS", "72320-522", "410", "Samambaia Norte (Samambaia)", "Conjunto B", account4, cityDf);
		
	//	stateRepository.saveAll(Arrays.asList(stateSp, stateRj, stateDf, stateEs, stateSc));
	//	cityRepository.saveAll(Arrays.asList(citySp, cityRj, cityDf, cityEs, citySc));
	//	addressRepository.saveAll(Arrays.asList(addressSp1, addressRj, addressRj2, addressSp2, addressDf));
		
		
		Category fps = new Category(null, "First Person Shooter");
		Category esporte = new Category(null, "Esporte");
		Category estrategia = new Category(null, "Estrategia");
		Category combate = new Category(null, "Combate");
		
		Product cs = new Product(null, "Counter Strike Global Ofensive", 150.00);//fps
		Product rs6 = new Product(null, "Tom Clancy's: Raibow Six siege", 165.00);//fps - estrategia
		Product overwatch = new Product(null, "Overwatch", 180.00);//fps
		Product pes = new Product(null, "Pro Evolution Soccer 2020", 200.00);//esporte
		Product fifa = new Product(null, "FIFA 20", 200.00);//esporte
		Product lol = new Product(null, "League of Legends", 00.00); // estrategia
		Product sf = new Product(null,  "Streat Fighter 6", 170.00); //combate
		Product mk = new Product(null,"Mortal Kombat", 79.50); //combate
		Product sc = new Product(null, "SoulCalibur", 79.90); //combate
		
		fps.getProduct().addAll(Arrays.asList(cs,rs6,overwatch));
		esporte.getProduct().addAll(Arrays.asList(pes,fifa));
		estrategia.getProduct().addAll(Arrays.asList(lol,rs6));
		combate.getProduct().addAll(Arrays.asList(sf,mk,sc));
		
		cs.getCategories().addAll(Arrays.asList(fps));
		rs6.getCategories().addAll(Arrays.asList(fps,estrategia));
		overwatch.getCategories().addAll(Arrays.asList(fps));
		pes.getCategories().addAll(Arrays.asList(esporte));
		fifa.getCategories().addAll(Arrays.asList(esporte));
		lol.getCategories().addAll(Arrays.asList(estrategia));
		sf.getCategories().addAll(Arrays.asList(combate));
		mk.getCategories().addAll(Arrays.asList(combate));
		sc.getCategories().addAll(Arrays.asList(combate));
		
	//	categoryRepository.saveAll(Arrays.asList(fps, esporte, estrategia, combate));
	//	productRepository.saveAll(Arrays.asList(cs, rs6, overwatch, pes, fifa, lol, sf,mk,sc));
		
	}
}
