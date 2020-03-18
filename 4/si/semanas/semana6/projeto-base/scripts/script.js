// temos que garantir que o código jquery apenas é executado, após o document estar preparado

function loadGames(){
    var platforms = new Set();
    var years = new Set();
    $(document).ready(function(){
        $.get("http://ivy.di.uminho.pt:8080/GamesLibraryProvider/GamesService?action=list") .done(function(data) {
            jsonData = JSON.parse(data);
            for(index in jsonData){
                platforms.add(jsonData[index].platform);
                years.add(jsonData[index].year);
                $('#myTable').append('<tr><td>' +jsonData[index].name +'</td><td id="year">' +jsonData[index].year +'</td><td>' +jsonData[index].platform +'</td></tr>');
            }
            years = [...years].sort();
            platforms = [...platforms].sort();
            
            for(index in years){
                $("#yearSideBar").append("<option value=" + years[index] + ">" + years[index] + "</option>");
            }
            for(index in platforms){
                $("#platformSideBar").append("<option value=" + platforms[index] + ">" + platforms[index] + "</option>");
            }
        });
    });
}

//  função anónima, para chamar sempre o load games
$(document).ready(function() {
    loadGames();
});