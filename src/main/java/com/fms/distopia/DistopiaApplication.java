package com.fms.distopia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fms.distopia.repository.CategoryRepository;
import com.fms.distopia.repository.CinemaRepository;
import com.fms.distopia.repository.CityRepository;
import com.fms.distopia.repository.CustomerRepository;
import com.fms.distopia.repository.MovieRepository;
import com.fms.distopia.security.RoleRepository;
import com.fms.distopia.security.UuserRepository;

@SpringBootApplication
public class DistopiaApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UuserRepository uuserRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder encoder;

	

	public static void main(String[] args) {
		SpringApplication.run(DistopiaApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		
		/*********** Movies categories ***********/
//		Category asian = new Category("ASIAN", null);
//		Category kids = new Category("KIDS", null);
//		Category romance = new Category("ROMANCE", null);
//		Category drama = new Category("DRAMA", null);
//		Category fiction = new Category("FICTION", null);
//		Category horror = new Category("HORROR", null);
//		categoryRepository.save(asian);
//		categoryRepository.save(kids);
//		categoryRepository.save(romance);
//		categoryRepository.save(drama);
//		categoryRepository.save(fiction);
//		categoryRepository.save(horror);

		/*********** Movies ***********/
//		Movie ipman = new Movie(null, "Ipman",
//				"In 1935, Foshan is a hub of Southern Chinese martial arts, where the various schools' students compete against each other..",
//				"Raymond Wong", LocalDate.parse("2022-04-11"), LocalTime.parse("01:45:35"), "img/ipman.jfif", asian,
//				null);
//		movieRepository.save(ipman);
//		Movie mowgli = new Movie(null, "Mowgli",
//				"Enfant, Mowgli est eleve par une meute de loups au c??ur de la jungle indienne...",
//				"Warner Bros Pictures", LocalDate.parse("2022-05-18"), LocalTime.parse("01:37:45"), "img/mowgli.jfif",
//				kids, null);
//		movieRepository.save(mowgli);
//		movieRepository.save(new Movie(null, "Maman j'ai rat?? l'avion",
//				"La famille McCallister prend l'avion pour Paris pour y passer les f??tes. ?? bord, Kate McCallister...",
//				"20th Century Fox", LocalDate.parse("2022-06-05"), LocalTime.parse("01:39:39"),
//				"img/mamanjairatelavion.jfif", kids, null));
//		movieRepository.save(new Movie(null, "The last song",
//				"?? 17 ans, Veronica ?? Ronnie ?? Miller (Miley Cyrus) est aussi rebelle qu'apr??s le divorce difficile de ses parents et",
//				"Touchstone Pictures", LocalDate.parse("2022-05-28"), LocalTime.parse("01:42:14"), "img/romance3.jfif",
//				romance, null));
//		movieRepository.save(new Movie(null, "There will be blood",
//				"In 1898, Daniel Plainview finds silver while prospecting in New Mexico but breaks his leg. Dragging...",
//				"Ghoulardi Film", LocalDate.parse("2022-06-02"), LocalTime.parse("02:39:32"), "img/blood.jfif", drama,
//				null));
//		movieRepository.save(new Movie(null, "First love",
//				"Jim, un lyc??en de terminal vit les hauts et les bas d'une premi??re relation amoureuse avec Ann. Au m??me moment, les...",
//				"Amazon Prime", LocalDate.parse("2022-04-02"), LocalTime.parse("01:32:12"), "img/romance1.jfif",
//				romance, null));
//		movieRepository.save(new Movie(null, "The words",
//				"Clayton Hammond (Dennis Quaid) is speaking at a public reading of his new book, The Words. Clayton begins...",
//				"Animus Films", LocalDate.parse("2022-04-15"), LocalTime.parse("01:29:42"), "img/romance2.jfif",
//				romance, null));
//		movieRepository.save(new Movie(null, "Les 3 royaumes",
//				"Cao Cao, premier ministre de l'empereur Han, pousse celui-ci ?? attaquer le Royaume de Shu. Cao Cao souhaite s'empare...",
//				"Chine", LocalDate.parse("2022-06-18"), LocalTime.parse("03:19:05"), "img/troisroyaumes.jfif", asian,
//				null));
//		movieRepository.save(new Movie(null, "L'??ge de glace",
//				"Le film se d??roule au temps pr??historique, au d??but de ?? l'??re de glace ??, il y a 20 000 ans. Un troupeau d'animaux de toutes...",
//				"Blue Sky Studios", LocalDate.parse("2022-07-05"), LocalTime.parse("02:10:15"), "img/glace.jfif", kids,
//				null));
//		movieRepository.save(new Movie(null, "Shutter island",
//				"In 1954, U.S. Marshal Daniels and his new partner Chuck Aule travel to Ashecliffe Hospital for the criminally insane on Shutter Island, Boston Harbor to investigate...",
//				"Phoenix Pictures", LocalDate.parse("2022-07-01"), LocalTime.parse("02:18:00"), "img/shuteriland.jfif",
//				fiction, null));
//		movieRepository.save(new Movie(null, "Saw",
//				"Saw is a 2004 American psychological horror film directed by James Wan, in his feature directorial debut, and...",
//				"Twisted Pictures", LocalDate.parse("2022-06-30"), LocalTime.parse("01:52:20"), "img/saw.jfif", horror,
//				null));
//		movieRepository.save(new Movie(null, "La cit?? interdite",
//				"De retour ?? la Cit?? interdite apr??s une longue absence, l'empereur d??couvre qu'un complot se trame au c??ur...",
//				"Chine", LocalDate.parse("2022-07-02"), LocalTime.parse("03:12:52"), "img/citeinterdite.jfif", asian,
//				null));
//		movieRepository.save(new Movie(null, "Les ??vad??s",
//				"Red, condamn?? ?? perp??tuit??, et Andy Dufresne, un gentil banquier injustement condamn?? pour meurtre, se lient...",
//				"Columbia pictures", LocalDate.parse("2022-07-04"), LocalTime.parse("03:19:05"), "img/evadees.jfif",
//				drama, null));
//		movieRepository.save(new Movie(null, "Zombie",
//				"Zombie est d'abord connu en tant que sommet du gore : les cervelles explosent, le sang gicle, les entrailles...",
//				"Laurel Group", LocalDate.parse("2022-07-06"), LocalTime.parse("01:19:05"), "img/zombie.jfif", horror,
//				null));

		/*********** Cities ***********/
//		City toulouse = new City(null, "Toulouse", 31, null);
//		cityRepository.save(toulouse);
//		City paris = new City(null, "Paris", 75, null);
//		cityRepository.save(paris);
//		cityRepository.save(new City(null, "Bordeaux", 33, null));
//		cityRepository.save(new City(null, "Bourges", 18, null));
//		cityRepository.save(new City(null, "Millau", 12, null));
//		cityRepository.save(new City(null, "Montpelier", 34, null));
//		cityRepository.save(new City(null, "Marseille", 13, null));
//		cityRepository.save(new City(null, "Nante", 44, null));
//		cityRepository.save(new City(null, "Lille", 59, null));
//		cityRepository.save(new City(null, "Lyon", 69, null));
//		cityRepository.save(new City(null, "Rennes", 35, null));
//		cityRepository.save(new City(null, "Clermont Ferrand", 63, null));

		/*********** Addresses ***********/
//		Address labege = new Address("15 rue lab??ge", "porte est", "Toulouse", "31547", "France");
//		Address toulouseC = new Address("1 all??e J Jaur??s", "metro JJ", "Toulouse", "31000", "France");
//		Address Muret = new Address("30 rue J Chaban", "C Commercial", "Toulouse", "31600", "France");
//		Address Blagnac = new Address("36 rue de Blagnac", "Sortie 12", "Toulouse", "31700", "France");
//
//		Address A16eme = new Address("15 rue Bastide", "porte est", "Paris", "75000", "France");
//		Address A18eme = new Address("1 rue Montreuil", "metro JJ", "Paris", "75000", "France");
//		Address A11eme = new Address("30 rue J Chaban", "C Commercial", "Paris", "75000", "France");
//		Address A1eme = new Address("36 rue de Mairie", "Mairie de paris", "Paris", "75000", "France");

		/*********** Cinemas ***********/
//		cinemaRepository.save(new Cinema(null, "Distopia Jean Jaur??s", toulouseC, toulouse, null));
//		cinemaRepository.save(new Cinema(null, "Distopia Bastide", A16eme, paris, null));
	}

}
