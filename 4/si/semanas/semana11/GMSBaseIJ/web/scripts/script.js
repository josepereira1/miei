
/**
 * A função loadGames carrega a lista de jogos do servidor para uma tabela. 
 * 
 * @param {type} colocar a 0 (zero) para uma tabela com links para as páginas dos jogos, outro valor caso contrário
 * @param {iteration} o valor da iteração (salto) dos valores na tabela
 */
function loadGames(type, iteration){
    $(document).ready(function(){
        platforms = new Set();
        years = new Set();
        content = "";
   
        $.get("http://ivy.di.uminho.pt:8080/GamesLibraryProvider/GamesService?action=list") .done(function(data) {
            jsonData = JSON.parse(data);
            for(i = 0; i < jsonData.length; ){
                //  guardo os "years" e "platforms" que aparecem para atualizar o "Filer" mais adiante
                platforms.add(jsonData[i].platform);
                years.add(jsonData[i].year);
                
                //  no index.html não é suposto ter links para as páginas dos jogos, logo nesse caso o type != 0
                if(type == 0)content = "<tr onclick=location.href=\"game.html?name=\'" + encodeURIComponent(jsonData[i].name) + "\'\"><td>" + jsonData[i].name + "</td><td id=\"year\"" + ">" + jsonData[i].year + "</td><td>" + jsonData[i].platform + "</td></tr>";
                else content = "<tr><td>" + jsonData[i].name + "</td><td id=\"year\"" + ">" + jsonData[i].year + "</td><td>" + jsonData[i].platform + "</td></tr>";
                
                //  append do conteúdo definido em cima, visto que pode ter link ou não
                $('#myTable').append(content);
                
                //  a iteração é útil para a página "My-Games" onde queremos apenas apresentar alguns jogos, logo
                //  percorremos a lista dos jogos, com saltos, salto esse definido no argumento "iteration"
                i = i + iteration;
            }

            //  como usei uma Set(), significa que não há repetivos, mas é necessário ordenar
            years = [...years].sort();
            platforms = [...platforms].sort();
            
            //  atualizar os campos do "Filter" da side bar com os dados recolhidos dos anos e plataformas de forma ordenada
            for(index in years){
                $("#yearSideBar").append("<option value=" + years[index] + ">" + years[index] + "</option>");
            }
            for(index in platforms){
                $("#platformSideBar").append("<option value=" + platforms[index] + ">" + platforms[index] + "</option>");
            }
        });
    });
}

/**
 * Carrega a informação detalhada de um jogo.
 */
function loadGameInfo(){
    $(document).ready(function(){   //  verificar se o document existe
        //  buscar o nome do jogo ao argumento "name" do link
        var name = new URLSearchParams(window.location.search).get('name');
        
        if(name != null || name != ""){   //  verificar se o nome é válido
            //  buscar a info do jogo 
            //  temos que usar o substr para tirar as aspas do argumento "name" do link e o encode e decode, devido aos caracteres especiais
            url = decodeURIComponent(encodeURIComponent("http://ivy.di.uminho.pt:8080/GamesLibraryProvider/GamesService?action=get&value=" + name.substr(1, name.length - 2)));
            
            $.get(url) .done(function(data) {
                jsonData = JSON.parse(data);
                $("#gameTitle").html(jsonData.name);
                $("#gameYear").html(jsonData.year);
                $("#gameDescription").html(jsonData.description);
            });
        }
    });
}

/**
 * Efeito de backgroung verde quando o jogo é adicionado com sucesso.
 */
function addNewGame(){
    $(document).ready(function() {
        $("#topBox").css("background-color", "rgb(102, 255, 153)");
        $("#topBox").text("Game added to collection!");
    });
}
