
/**
 * A função loadGames carrega a lista de jogos do servidor para uma tabela. 
 * 
 * @param {type} colocar a 0 (zero) para uma tabela com links para as páginas dos jogos, outro valor caso contrário
 * @param {iteration} o valor da iteração (salto) dos valores na tabela
 */
function loadGames(page, type, path, logedIn){
        url = "http://localhost:8080/GMSBaseIJ_war_exploded/ListGamesJSON?gamesPages=" + page + "&type=" + type;
        $.get(url) .done(function(jsonData) {
            $('#myTable').html("");
            for(i = 0; i < jsonData.length; ){

                //  onclick=location.href=\"game.html?name=\'" + encodeURIComponent(jsonData[i].name) + "\'\">

                //content = "<tr onclick=location.href=\"" + path + "/GameInfo?gameName=\'" + encodeURIComponent(jsonData[i].name) + "\'><td>" + jsonData[i].name + "</td><td id=\"year\"" + ">" + jsonData[i].year + "</td><td>" + jsonData[i].platform + "</td></tr>";

                if(logedIn)content = "<tr onclick=location.href=\"" + path + "/GameInfo?gameName=" + encodeURIComponent(jsonData[i].name) + "\"><td>" + jsonData[i].name + "</td><td id=\"year\"" + ">" + jsonData[i].year + "</td><td>" + jsonData[i].platform + "</td></tr>";
                else content = "<tr><td>" + jsonData[i].name + "</td><td id=\"year\"" + ">" + jsonData[i].year + "</td><td>" + jsonData[i].platform + "</td></tr>";

                $('#myTable').append(content);

                i = i + 1;
            }
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
