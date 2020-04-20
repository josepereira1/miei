//alert("Hello world!");                    /* pop-up */
//console.log("Hello world!");              /* print to console */

function sayHello(){                        /* function that print "Hello world!" to console */
    console.log("Hello, world!");
}

/* contador feito utilizando o Javascript */
counter = 0;
function fun(){
    document.getElementById("myIdjs").innerHTML = counter;
    counter++;
}



/* contador feito utilizando o jQuery */
$counter = 0;
$(document).ready(function() {
    $("#jquerybutton").click( function(){
        $("#myIdjquery").html($counter);
        $counter++;
    });
});



$.get("http://ivy.di.uminho.pt:8080/GamesLibraryProvider/GamesService?action=list") .done(function(data) {
$("#myDiv").html(data); });
