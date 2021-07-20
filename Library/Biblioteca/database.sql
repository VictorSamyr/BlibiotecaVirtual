CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    login VARCHAR(50) UNIQUE,
    senha VARCHAR(64),
    email VARCHAR(99) UNIQUE,
    sexo CHAR,
    idade INT,
    generos_preferidos TEXT);

CREATE TABLE livros(
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(99),
    sinopse TEXT,
    genero VARCHAR(50),
    autor VARCHAR(99),
    ano_lancamento INT,
    imagem VARCHAR(50));

INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('A culpa é das estrelas', 'Romance', 'John Green', 2012, 'Images/ACulpaEDasEstrelas.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('A Queda do Morcego - Volume 1', 'História em quadrinhos', 'DC Comics', 1993, 'Images/AQuedaDoMorcego.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('Blade Runner', 'Ficção científica', 'Alan E. Nourse', 1974, 'Images/BladeRunner.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('Como Fazer Amigos e Influenciar Pessoas', 'Auto-Ajuda', 'Dale Carnegie', 1936, 'Images/ComoFazerAmigosEInfluenciarPessoas.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('Crepúsculo', 'Romance', 'Stephenie Meyer', 2005, 'Images/Crepusculo.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('Invincible: Ultimate Collection 3', 'História em quadrinhos', 'Image Comics', 2007, 'Images/InvincibleUltimateCollection.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('It: a Coisa', 'Suspense', 'Stephen King', 1986, 'Images/ItACoisa.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('Neuromancer', 'Ficção científica', 'William Gibson', 1984, 'Images/Neuromancer.png');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('O Horror de Dunwich', 'Suspense', 'H.P. Lovecraft', 1929, 'Images/OHorrorDeDunwich.jpg');
INSERT INTO livros(titulo, genero, autor, ano_lancamento, imagem) VALUES('O Poder do Hábito', 'Auto-Ajuda', 'Charles Duhigg', 2012, 'Images/OPoderDoHabito.jpg');

UPDATE livros SET sinopse = 'Hazel é uma paciente terminal. Ainda que, por um milagre da medicina, seu tumor tenha encolhido bastante — o que lhe dá a promessa de viver mais alguns anos —, o último capítulo de sua história foi escrito no momento do diagnóstico. Mas em todo bom enredo há uma reviravolta, e a de Hazel se chama Augustus Waters, um garoto bonito que certo dia aparece no Grupo de Apoio a Crianças com Câncer. Juntos, os dois vão preencher o pequeno infinito das páginas em branco de suas vidas' WHERE titulo = 'A culpa é das estrelas';

UPDATE livros SET sinopse = 'Os inimigos mais mortais do Cavaleiro das Trevas escaparam do Asilo Arkham! Coringa, Duas-Caras, Chapeleiro Louco, Charada, Hera Venenosa, Espantalho, Crocodilo, Vaga-Lume e Zsasz… Um por um, Batman deve enfrentá-los em um combate perigoso. Mas, escondido no meio desse caos, está a ameaça mais perigosa de todas: Bane!' WHERE titulo = 'A Queda do Morcego - Volume 1';

UPDATE livros SET sinopse = 'Rick Deckard é um caçador de recompensas, vivendo em uma San Francisco decadente, coberta pela poeira radioativa que dizimou inúmeras espécies de animais e plantas. Um novo trabalho pode ser o ponto de virada para melhorar seu padrão de vida e realizar seu sonho de consumo: uma ovelha de verdade, para substituir a réplica elétrica que ele cria em casa. Para isso, Deckard precisa perseguir e aposentar seis androides que estão foragidos, se passando por humanos. Mas as convicções do detetive podem mudar quando percebe que a linha que separa o real do fabricado não é mais tão nítida quanto ele acreditava.' WHERE titulo = 'Blade Runner';

UPDATE livros SET sinopse = 'O guia clássico e definitivo para relacionar-se com as pessoas Não é por acaso que, mais de setenta anos depois de sua primeira edição, depois de mais de 50 milhões de exemplares vendidos, Como fazer amigos e influenciar pessoas segue sendo um livro inovador, e uma das principais referências do mundo sobre relacionamentos, seja no âmbito profissional ou pessoal. Os conselhos, métodos e as ideias de Dale Carnegie já beneficiaram milhões de pessoas, e permanecem completamente atuais. Carnegie fornece, nesse livro, técnicas e métodos, de maneira extremamente direta, para que qualquer pessoa alcance seus objetivos pessoais e profissionais.' WHERE titulo = 'Como Fazer Amigos e Influenciar Pessoas';

UPDATE livros SET sinopse = 'Isabella Swan chega à nublada e chuvosa cidadezinha de Forks - último lugar onde gostaria de viver. Tenta se adaptar à vida provinciana na qual aparentemente todos se conhecem, lidar com sua constrangedora falta de coordenação motora e se habituar a morar com um pai com quem nunca conviveu. Em seu destino está Edward Cullen. Lindo, perfeito, misterioso ele é à primeira vista, hostil à presença de Bella - o que provoca nela uma inquietação desconcertante. Ela se apaixona. Ele, no melhor estilo "amor proibido", alerta: Sou um risco para você. Ela é uma garota incomum. Ele é um vampiro. Ela precisa aprender a controlar seu corpo quando ele a toca. Ele, a controlar sua sede pelo sangue dela. Em meio a descobertas e sobressaltos, Edward é, sim, perigoso: um perigo que qualquer mulher escolheria correr.' WHERE titulo = 'Crepúsculo';

UPDATE livros SET sinopse = 'Este volume coleta a batalha violenta de Invincible com o vilão Angstrom Levy, seu reencontro com seu pai distante e a batalha sangrenta com os Viltrumites.' WHERE titulo = 'Invincible: Ultimate Collection 3';

UPDATE livros SET sinopse = 'Durante as férias escolares de 1958, em Derry, pacata cidadezinha do Maine, Bill, Richie, Stan, Mike, Eddie, Ben e Beverly aprenderam o real sentido da amizade, do amor, da confiança e... do medo. O mais profundo e tenebroso medo. Naquele verão, eles enfrentaram pela primeira vez a Coisa, um ser sobrenatural e maligno que deixou terríveis marcas de sangue em Derry. Quase trinta anos depois, os amigos voltam a se encontrar. Uma nova onda de terror tomou a pequena cidade. Mike Hanlon, o único que permanece em Derry, dá o sinal. Precisam unir forças novamente. A Coisa volta a atacar e eles devem cumprir a promessa selada com sangue que fizeram quando crianças. Só eles têm a chave do enigma. Só eles sabem o que se esconde nas entranhas de Derry. O tempo é curto, mas somente eles podem vencer a Coisa.' WHERE titulo = 'It: a Coisa';

UPDATE livros SET sinopse = 'No futuro, existe a matrix. Uma espécie de alucinação coletiva digital na qual a humanidade se conecta para, virtualmente, saber de tudo sobre tudo. Mas há uma elite que navega por essa grande rede de informação - os cowboys. Case era um deles, até o dia em que tentou ser mais esperto do que os seus patrões. Que fritaram suas conexões com o ciberespaço, tornando-o um pária entre os seus iguais. Ele vaga pelos subúrbios de Tóquio, mais envolvido do que nunca em destruir a si próprio, até ser contatado por Molly, uma bela e perigosa mulher que, assim como ele, desconfia de tudo e de todos. Os dois acabam se envolvendo numa missão cheia de mistérios e perigos. ' WHERE titulo = 'Neuromancer';

UPDATE livros SET sinopse = 'Em 1913, no vilarejo de Dunwich, a albina Lavinia Whateley dá à luz um menino com feições de bode, filho de um pai desconhecido. Wilbur causa espanto devido a seu desenvolvimento de rapidez sobrenatural. Em seus estudos, ele descobre Necronomicon — o temível compêndio de sabedoria oculta escrito pelo árabe louco Abdul Alhazred. Mais tarde, ao perceber que dispõe apenas de uma tradução inglesa incompleta do documento, Wilbur sai em busca da rara edição latina para dar continuidade ao misterioso ritual em família que atinge o ponto culminante com O horror de Dunwich.' WHERE titulo = 'O Horror de Dunwich';

UPDATE livros SET sinopse = 'Durante os últimos dois anos, uma jovem transformou quase todos os aspectos de sua vida. Parou de fumar, correu uma maratona e foi promovida. Em um laboratório, neurologistas descobriram que os padrões dentro do cérebro dela --ou seja, seus hábitos-- foram modificados de maneira fundamental para que todas essas mudanças ocorressem. Há duas décadas pesquisando ao lado de psicólogos, sociólogos e publicitários, cientistas do cérebro começaram finalmente a entender como os hábitos funcionam - e, mais importante, como podem ser transformados. Embora isoladamente pareçam ter pouca importância, com o tempo, têm um enorme impacto na saúde, na produtividade, na estabilidade financeira e na felicidade. Com base na leitura de centenas de artigos acadêmicos, entrevistas com mais de 300 cientistas e executivos, além de pesquisas realizadas em dezenas de empresas, o repórter investigativo do "New York Times" Charles Duhigg elabora, em "O Poder do Hábito", um argumento animador: a chave para se exercitar regularmente, perder peso, educar bem os filhos, se tornar uma pessoa mais produtiva, criar empresas revolucionárias e ter sucesso é entender como os hábitos funcionam. Transformá-los pode gerar bilhões e significar a diferença entre fracasso e sucesso, vida e morte.' WHERE titulo = 'O Poder do Hábito';
