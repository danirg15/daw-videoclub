CREATE TABLE `movies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actors` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `box_office` double NOT NULL,
  `content_url` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `date` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `director` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `genre` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `plot` text COLLATE utf8_spanish2_ci NOT NULL,
  `poster_url` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `rating` double NOT NULL,
  `title` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `movies` (`id`, `actors`, `box_office`, `content_url`, `date`, `director`, `genre`, `plot`, `poster_url`, `rating`, `title`, `year`)
VALUES
	(1,'Russell Crowe,  Paul Bettany,  James D\'Arcy,  Max Pirkis',212011111,'https://www.youtube.com/embed/6oyQGHHz8U8',NULL,'Peter Weir','Aventura, ','1805. Napoleón domina Europa. Tan sólo Inglaterra se le resiste. Son tiempos de guerras napoleónicas, y ahora los mares y océanos se han convertido en un crucial y estratégico campo de batalla. En el océano Atlántico el navío de guerra inglés Surprise, capitaneado por \"Lucky\" Jack Aubrey (Crowe), es atacado de repente por un buque de guerra enemigo muy superior a él. Aubrey toma entonces una decisión memorable: a pesar de los graves daños sufridos por el Surprise y su fiel tripulación, entre los que se encuentra el cirujano Stephen Maturin (Bettany), decide navegar, asumiendo serios riesgos, a través de dos mares para interceptar y capturar a su enemigo. Es una misión que puede determinar el destino de una nación o destruir al capitán y a su tripulación, enfrentándose a un corsario mucho mejor armado e implacable, en una persecución por los mares que le lleva al otro lado del mundo.','https://image.tmdb.org/t/p/w500/9jborIJkUp32ibDpg9JIfV4QHSS.jpg',3.45,'Master and commander: Al otro lado del mundo',2003),
	(3,'Daniel Radcliffe, Emma Watson, Rupert Grint',933959197,'https://www.youtube.com/embed/JYLdTuL9Wjw',NULL,'David Yates','Aventura, Fantasía, Familia, ','En medio de los desastres que azotan a Inglaterra, Harry y sus compañeros vuelven a Hogwarts para cursar su sexto año de estudios; y aunque las medidas de seguridad han convertido al colegio en una fortaleza, algunos estudiantes son víctimas de ataques inexplicables. Harry sospecha que Draco Malfoy es el responsable de los mismos y decide averiguar la razón. Mientras tanto, Albus Dumbledore y el protagonista exploran el pasado de Lord Voldemort mediante recuerdos que el director ha recolectado. Con esto, Dumbledore planea preparar al muchacho para el día de la batalla final.','https://image.tmdb.org/t/p/w500/ttdilnbDffymQd7Tkp7pP9W8h05.jpg',3.7,'Harry Potter y el misterio del príncipe',2009),
	(4,'Johnny Depp, Geoffrey Rush, Javier Bardem',85322950,'https://www.youtube.com/embed/a5V5C8mEVzY',NULL,'Joachim Rønning, Espen Sandberg','Acción, Aventura, Comedia, Fantasía, ','Empujado hacia una nueva aventura, un sumamente desafortunado Jack Sparrow descubre que los vientos de los malos augurios soplan incluso más fuerte cuando los mortales piratas fantasma liderados por su viejo enemigo, el capitán Salazar, escapan del Triángulo del Diablo. Decididos a matar a todo pirata que encuentren en el mar, incluso al propio Sparrow. La única esperanza de supervivencia del Capitán Jack Sparrow se encuentra en la búsqueda del legendario tridente de Poseidón, un poderoso artefacto que otorga a su poseedor el control total sobre los mares.','https://image.tmdb.org/t/p/w500/gB3cNhpfxEWSjiKSGOv8nlmVdeu.jpg',4.5,'Piratas del Caribe: La venganza de Salazar',2017),
	(5,'Vin Diesel, Jason Statham, Dwayne Johnson ',1212583865,'https://www.youtube.com/embed/BLKaI3D9P2E',NULL,'F. Gary Gray','Acción, Crimen, Suspense, ','La carrera ha comenzado. Dom Toretto y su equipo volverán en esta ocasión con más ganas de guerra que nunca. No faltarán los excesos de velocidad y la adrenalina a raudales para un filme del que se espera que sea la entrega con más acción de esta saga callejera por excelencia.','https://image.tmdb.org/t/p/w500/iNpz2DgTsTMPaDRZq2tnbqjL2vF.jpg',4.35,'Fast & Furious 8',2017),
	(6,'Marlon Brando, Al Pacino, James Caan',245066411,'https://www.youtube.com/embed/sY1S34973zA',NULL,'Francis Ford Coppola','Drama, Crimen, ','Años 40. Don Vito Corleone es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York. Tiene cuatro hijos: una chica, Connie, y tres varones: el impulsivo Sonny, el pusilánime Freddie y Michael, que no quiere saber nada de los negocios de su padre. Cuando Corleone, siempre aconsejado por su consejero Tom Hagan, se niega a intervenir en el negocio de las drogas, el jefe de otra banda ordena su asesinato. Empieza entonces una violenta y cruenta guerra entre las familias mafiosas.','https://image.tmdb.org/t/p/w500/6nwJnyac60cGHo4JUtnhdTQsRsx.jpg',4.2,'El Padrino',1972),
	(7,'Daniel Craig, Olga Kurylenko, Mathieu Amalric',586090727,'https://www.youtube.com/embed/yfYC_CBNtiM',NULL,'Marc Forster','Aventura, Acción, Suspense, Crimen, ','Traicionado por Vesper, la mujer a la que amaba, 007 se plantea su nueva misión como algo personal. Durante su investigación, Bond y M interrogan a Mr. White, que les revela que la organización que chantajeó a Vesper es mucho más compleja y peligrosa de lo que imaginan. El servicio de inteligencia forense vincula a un traidor del Mi6 con una cuenta bancaria en Haití, donde Bond conoce a la bella pero combativa Camille, una mujer que tiene sus propios motivos para vengarse. Gracias a Camille, Bond descubre la existencia de Dominic Greene, despiadado hombre de negocios y miembro importante de la misteriosa organización.','https://image.tmdb.org/t/p/w500/rvEcF0645p42VZaOOqAP9QC6faN.jpg',3.05,'Quantum of Solace',2008),
	(8,'Daisy Ridley, John Boyega, Oscar Isaac',2068223624,'https://www.youtube.com/embed/sGbxmsDFVnE',NULL,'J.J. Abrams','Acción, Aventura, Ciencia ficción, Fantasía, ','Treinta años después de la victoria de la Alianza Rebelde sobre la segunda Estrella de la Muerte (hechos narrados en el Episodio VI: El retorno del Jedi), la galaxia está todavía en guerra. Una nueva República se ha constituido, pero una siniestra organización, la Primera Orden, ha resurgido de las cenizas del Imperio Galáctico. A los héroes de antaño, que luchan ahora en la Resistencia, se suman nuevos héroes: Poe Dameron, un piloto de caza, Finn, un desertor de la Primera Orden, Rey, una joven chatarrera, y BB-8, un androide rodante. Todos ellos luchan contra las fuerzas del Mal: el Capitán Phasma, de la Primera Orden, y Kylo Ren, un temible y misterioso personaje que empuña un sable de luz roja.','https://image.tmdb.org/t/p/w500/mtZ36iNsrxtHnx0mLWotdxfsW5U.jpg',3.75,'La guerra de las galaxias. Episodio VII: El despertar de la fuerza',2015),
	(9,'Sam Worthington, Zoe Saldana, Sigourney Weaver',2781505847,'https://www.youtube.com/embed/5PSNL1qE6VY',NULL,'James Cameron','Acción, Aventura, Fantasía, Ciencia ficción, ','Jake Sully, un ex-marine confinado a una silla de ruedas, es reclutado para viajar al planeta Pandora, donde un consorcio corporativo está extrayendo un mineral que será clave en la solución de la crisis energética de la Tierra. Debido a que la atmósfera de Pandora es tóxica, han creado el Programa Avatar, en el que \'conductores\' humanos tienen sus conciencias unidas a un avatar,... un cuerpo biológico controlado de manera remota que puede sobrevivir en ese entorno. Estos avatares han sido creados genéticamente como híbridos combinando ADN humano con el de los nativos de Pandora… los Na’vi. Convertido en un avatar, Jake puede volver a caminar. Se le asigna la misión de infiltrarse entre los Na’vi, que se han convertido en un obstáculo importante para la extracción del preciado mineral. Pero Neytiri, una hermosa mujer Na’vi, le salvará la vida, y esto lo cambiará todo...','https://image.tmdb.org/t/p/w500/1LMyZOtctRqkszPYVWosK6xZ2Ht.jpg',4.6,'Avatar',2009),
	(10,'Elijah Wood, Ian McKellen, Viggo Mortensen',926287400,'https://www.youtube.com/embed/LbfMDwc4azU',NULL,'Peter Jackson','Aventura, Fantasía, Acción, ','La Compañía del Anillo se ha disuelto. El portador del anillo Frodo y su fiel amigo Sam se dirigen hacia Mordor para destruir el Anillo Único y acabar con el poder de Sauron. Mientras, y tras la dura batalla contra los orcos donde cayó Boromir, el hombre Aragorn, el elfo Legolas y el enano Gimli intentan rescatar a los medianos Merry y Pipin, secuestrados por los ogros de Mordor. Por su parte, Saurón y el traidor Sarumán continúan con sus planes en Mordor, en espera de la guerra contra las razas libres de la Tierra Media.','https://image.tmdb.org/t/p/w500/eorEzOVAU2QXbDqh2vAixxVNcfo.jpg',3.95,'El señor de los anillos: Las dos torres',2002),
	(11,'Daniel Brühl, Chris Hemsworth, Olivia Wilde',90247624,'https://www.youtube.com/embed/lzNbGH1oZJc',NULL,'Ron Howard','Drama, Acción, ','Ambientada en los años 70, durante la glamourosa y espectacular Edad de Oro de la Fórmula 1, \"RUSH\" retrata la poderosa historia real de los dos mayores rivales que el mundo ha conocido: el apuesto playboy inglés James Hunt (Chris Hemsworth), y su metódico y brillante oponente, Niki Lauda (Daniel Brühl). Dentro y fuera de la pista, los dos pilotos se presionan a sí mismos hasta llegar al límite de su resistencia física y psicológica en un mundo donde no existen atajos hacia la victoria ni margen de error. Si cometes uno, mueres.','https://image.tmdb.org/t/p/w500/89wDBYrucqjOHlssOgauxpKA6F1.jpg',3.85,'Rush',2013),
	(12,'Chris Pratt, Bryce Dallas Howard, Ty Simpkins',1513528810,'https://www.youtube.com/embed/RFinNxS5KN4',NULL,'Colin Trevorrow','Acción, Aventura, Ciencia ficción, Suspense, ','Veintidós años después de lo ocurrido en Jurassic Park, la isla Nublar ha sido transformada en un parque temático, Jurassic Wold, con versiones «domesticadas» de algunos de los dinosaurios más conocidos. Cuando todo parece ir a la perfección y ser el negocio del siglo, un nuevo dinosaurio de especie todavía desconocida y que es mucho más inteligente de lo que se pensaba, comienza a causar estragos entre los visitantes del Parque.','https://image.tmdb.org/t/p/w500/7OkXsuILP3UuT32g4OkRcJ2PofU.jpg',3.25,'Jurassic World',2015),
	(13,'Jeremy Renner, Anthony Mackie, Brian Geraghty',42000000,'https://www.youtube.com/embed/oa6RZgUMRz0',NULL,'Kathryn Bigelow','Drama, Suspense, Guerra, ','En Irak, una unidad de élite de artificieros norteamericanos actúa en una caótica ciudad donde cualquier persona puede ser un enemigo y cualquier objeto, una bomba. El jefe del grupo, el sargento Thompson, muere en el transcurso de una misión y es sustituido por el impredecible y temerario sargento William James (Jeremy Renner). Cuando falta poco para que la brigada sea relevada, el imprudente comportamiento de James hará que dos de sus subordinados, se planteen seriamente el riesgo que corren.','https://image.tmdb.org/t/p/w500/oqbTg6hMBRt92quQcLqbyPr9JPh.jpg',3.6,'En tierra hostil',2008),
	(14,'Bradley Cooper, Sienna Miller, Kyle Gallner',542307423,'https://www.youtube.com/embed/99k3u9ay1gs',NULL,'Clint Eastwood','Guerra, Acción, ','Adaptación a la gran pantalla de la autobiografía del Navy SEAL Chris Kyle, un tejano con el récord de muertes como francotirador del ejército norteamericano. El marine del grupo de operaciones especiales de la Marina de Estados Unidos Chris Kyle es enviado a Irak con una sola misión: proteger a sus compañeros de ejército. Su precisión milimétrica salva incontables vidas en el campo de batalla y, a medida que se extienden sus valientes hazañas, se gana el apodo de “Leyenda”. Sin embargo, su reputación también crece detrás de las líneas enemigas, de manera que ponen precio a su cabeza y se convierte en objetivo prioritario de los insurgentes. Al mismo tiempo también se está enfrentando a otra batalla en casa: ser un buen marido y padre desde el otro lado del mundo.','https://image.tmdb.org/t/p/w500/4WxmCmJbKxLDHWSaLHNttBqOGnE.jpg',3.7,'El francotirador',2014),
	(16,'Denzel Washington, Chris Pratt, Ethan Hawke',160437812,'https://www.youtube.com/embed/q-RBA0xoaWU',NULL,'Antoine Fuqua','Aventura, Acción, Western, ','Siete forajidos son contratados por los desesperados habitantes del pueblo de Rose Creek para que les defiendan de la amenaza de un despiadado extorsionador llamado Bartholomew Bogue. Mientras preparan el pueblo para la violenta confrontación que saben se avecina inevitablemente, estos siete mercenarios se encontrarán luchando por algo más que el simple dinero.','https://image.tmdb.org/t/p/w500/2tZ4yKJyHb7UR1zCfcUwHclPwNs.jpg',2.85,'Los siete magníficos',2016),
	(17,'Denzel Washington, Nadine Velazquez, Don Cheadle',161772375,'https://www.youtube.com/embed/Aqn2L6kQQt8',NULL,'Robert Zemeckis','Drama, ','Tras un aterrizaje de emergencia en medio del campo gracias al cual salvan la vida un centenar de pasajeros, el comandante Whip Whitaker (Denzel Washington), que pilotaba el avión, es considerado un héroe nacional. Sin embargo, cuando se pone en marcha la investigación para determinar las causas de la avería, se averigua que el capitán tenía exceso de alcohol en la sangre y que puede ir a la cárcel si se demuestra que pilotó el avión en estado de embriaguez.','https://image.tmdb.org/t/p/w500/zNpvMQQsUqLtBradYyog50jLGGu.jpg',3.25,'El vuelo',2012),
	(18,'Johnny Depp, Orlando Bloom, Keira Knightley',1065659812,'https://www.youtube.com/embed/ozk0-RHXtFw',NULL,'Gore Verbinski','Aventura, Fantasía, Acción, ','Will Turner y Elizabeth Swann se van a casar, pero ambos son hechos prisioneros por Lord Cutler Beckett y acusados de haber liberado al Capitán Jack Sparrow. Para salvar su vida Will tendrá que encontrar a Jack y conseguir su misteriosa brújula, que esconde un gran poder además de la clave de una deuda de sangre del pirata con un temible y siniestro Davy Jones, el legendario Capitán del barco fantasma Holandés Errante.','https://image.tmdb.org/t/p/w500/oukMfgvEtWUHSJFFwC6jLMmsJeH.jpg',3.45,'Piratas del Caribe: El cofre del hombre muerto',2006);
