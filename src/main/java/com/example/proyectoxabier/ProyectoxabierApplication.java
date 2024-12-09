package com.example.proyectoxabier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.proyectoxabier.models.Alfombra;
import com.example.proyectoxabier.models.Almohada;
import com.example.proyectoxabier.models.Bebe;
import com.example.proyectoxabier.models.Cojin;
import com.example.proyectoxabier.models.Colchon;
import com.example.proyectoxabier.models.Edredon;
import com.example.proyectoxabier.models.Funda;
import com.example.proyectoxabier.models.Ofertas;
import com.example.proyectoxabier.models.Pijama;
import com.example.proyectoxabier.models.Sabana;
import com.example.proyectoxabier.services.AlfombraService;
import com.example.proyectoxabier.services.AlmohadaService;
import com.example.proyectoxabier.services.BebeService;
import com.example.proyectoxabier.services.CojinService;
import com.example.proyectoxabier.services.ColchonService;
import com.example.proyectoxabier.services.EdredonService;
import com.example.proyectoxabier.services.FundaService;
import com.example.proyectoxabier.services.OfertasService;
import com.example.proyectoxabier.services.PijamaService;
import com.example.proyectoxabier.services.SabanaService;

@SpringBootApplication
public class ProyectoxabierApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoxabierApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(OfertasService ofertasService, SabanaService sabanaService, EdredonService edredonService, ColchonService colchonService,
	AlfombraService alfombraService, CojinService cojinService, AlmohadaService almohadaService, PijamaService pijamaService, FundaService fundaService,
	BebeService bebeService) {
		return args -> {
			//Ofertas
			ofertasService.guardarOferta(new Ofertas("Edredón de Microfibra", "¡Aprovecha esta oferta especial!", 49.99, 39.99));
            ofertasService.guardarOferta(new Ofertas("Colchón Ortopédico", "No te pierdas esta oferta exclusiva", 299.99, 249.99));

			//Sabanas
			sabanaService.guardarSabana(new Sabana("Sabana Premium", "Algodón", "Blanco", 29.99));
            sabanaService.guardarSabana(new Sabana("Sabana Clásica", "Poliéster", "Azul", 19.99));
            sabanaService.guardarSabana(new Sabana("Sabana Deluxe", "Seda", "Crema", 49.99));

			//Edredones
			edredonService.guardarEdredon(new Edredon("Edredón Primavera", "Edredón ligero para primavera", 49.99));
            edredonService.guardarEdredon(new Edredon("Edredón Invierno", "Edredón grueso para invierno", 79.99));
            edredonService.guardarEdredon(new Edredon("Edredón Verano", "Edredón fresco para verano", 39.99));

			//Colchones
			colchonService.guardarColchon(new Colchon("Colchón King", "Espuma", "King", 299.99));
            colchonService.guardarColchon(new Colchon("Colchón Queen", "Látex", "Queen", 249.99));
            colchonService.guardarColchon(new Colchon("Colchón Individual", "Resortes", "Individual", 199.99));

			//Alfombras
			alfombraService.guardarAlfombra(new Alfombra("Alfombra Oriental", "Lana", "200x300 cm", 199.99));
            alfombraService.guardarAlfombra(new Alfombra("Alfombra Moderna", "Algodón", "150x200 cm", 129.99));
            alfombraService.guardarAlfombra(new Alfombra("Alfombra Clásica", "Seda", "180x250 cm", 299.99));

			//Cojines
			cojinService.guardarCojin(new Cojin("Cojin Decorativo", "Algodón", "40x40 cm", 15.99));
            cojinService.guardarCojin(new Cojin("Cojin Lumbar", "Lana", "50x30 cm", 20.99));
            cojinService.guardarCojin(new Cojin("Cojin Ergonómico", "Espuma", "45x45 cm", 25.49));

			//Almohadas
			almohadaService.guardarAlmohada(new Almohada("Almohada Ergonómica", "Espuma de memoria", "60x40 cm", 25.99));
            almohadaService.guardarAlmohada(new Almohada("Almohada de Plumas", "Pluma de ganso", "70x50 cm", 35.49));
            almohadaService.guardarAlmohada(new Almohada("Almohada de Gel", "Gel frío", "65x45 cm", 29.99));

			//Pijamas
			pijamaService.guardarPijama(new Pijama("Pijama de Algodón", "Algodón orgánico", "M", 19.99));
            pijamaService.guardarPijama(new Pijama("Pijama de Seda", "Seda natural", "L", 49.99));
            pijamaService.guardarPijama(new Pijama("Pijama Infantil", "Poliéster", "S", 15.99));

			//Fundas
			fundaService.guardarFunda(new Funda("Cojín", "Algodón", "Blanco", 10.99));
            fundaService.guardarFunda(new Funda("Sofá", "Poliéster", "Gris", 25.49));
            fundaService.guardarFunda(new Funda("Cama", "Seda", "Rojo", 50.75));

			//Articulos para bebes
			bebeService.guardarBebe(new Bebe("Manta para cuna", "Algodón", "Blanco", 15.99));
            bebeService.guardarBebe(new Bebe("Almohada para bebé", "Espuma", "Azul", 9.49));
            bebeService.guardarBebe(new Bebe("Funda para cuna", "Seda", "Rosa", 12.75));
		};
	}
}
