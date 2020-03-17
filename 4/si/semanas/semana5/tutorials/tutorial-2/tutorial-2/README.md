Pontos importantes a realçar sobre o tutorial 2:

    1 - Para experimentar completamente a user interface, vai ser necessário fazer login numa das seguintes contas:
        username = "username" password = "password"
        username = "josepereira" password = "password1"
        ... (para mais contas, ficheiro script/script.js)

        nota: eu coloquei como valores iniciais a conta do com username = username, por isso basta carregar no botão login na janela do login, no entanto, será interessante experimentar diferentes contas, para se verificar que o username apresentado nas páginas, muda consoante a conta.

    2 - Poderão ser adicionadas mais contas no ficheiro scripts/script.js na variável dict.

    3 - O login vai mesmo testar estas credênciais, caso não as coloque corretamente ele vai mostrar uma mensagem "Username or password wrong!"

    4 - Se não for feito login, as opções "My Games" "Add Game", bem como ver as infos de cada jogo, não estão disponíveis, aparecendo um pop-up a avisar do mesmo (fiz isto, pois no diagrama de estados, o professor, dá a entender, que no ínicio apenas aparecem a homepage com a tabela dos jogos). 

    5 - Depois do login ser aceite, envia-se o username inserido, pelo link, para que o mesmo apareça na navbar em todas as páginas, desta forma, isto é um passo repetitivo sempre que se muda de página.

    6 - A lógica necessária para o login, bem como enviar o username para as páginas, foi definida script/script.js, e sei que provavelmente não era pedido pelo professor para se fazer, mas achei interessante ver isto a acontecer. Também reconheço que não é a forma mais correta de se fazer. Seria necessário uma base de dados e não eram enviados dados como este pelo link, mas foi para ficar bonito, dinâmico e aparecer os diferentes usernames nas páginas.

    7 - Por fim, na página add game quando se carrega no botão "save" aparece em cima a verde que o jogo foi adiconado com sucesso, obviamente que isto é só visual, visto que não existe sistema de ficheiros ou base de dados. Ainda aqui, importa referir, que segundo o diagrama de estados, após carregar no "save" deveria encaminhar para a página "My Games", eu não o fiz, exclusivamente para aparecer a animação em cima a verde.

    8 - Todas as funcionalidades que não possam ser efetuadas em algum estado, aparecem à mesma os botões, mas aparece um pop-up a avisar que não está disponível. Casos disso como já foi referido, é no ínicio antes de fazer login, não se pode executar o "My games", "Add game", nem ver a info dos jogos. Segundo o diagrama, quando estamos no Game (info de um jogo), não podemos usar o "Add game", logo isso foi levado em conta, aparecendo um pop-up a avisar do mesmo. 