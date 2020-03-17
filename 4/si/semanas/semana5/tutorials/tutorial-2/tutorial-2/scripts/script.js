var globalVarUsername = "";
var dict = {"username" : "password",
    "josepereira" : "password1",
    "joaofernandes" : "password2",
    "ritaaraujo" : "password3",
    "paulotavares" : "password4"};

function login(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    var flag = 0;

    for(var key in dict) {
        if (username == key){
            if (password == dict[key]){
                var path = "pages/all-games.html?username='";
                var res = path.concat(key+"'");

                location.href=res;
                flag = 1;
                break;  //  não precisa de procurar mais
            }else{
                document.getElementById('loginError').style.visibility = "visible";
            }
        }
    }
    if(flag == 0)document.getElementById('loginError').style.visibility = "visible";
}

function getUsernameFromURL(){
    url = parent.document.URL.substring(parent.document.URL.indexOf('username='), parent.document.URL.length);
    var username = url.split("27")[1];                      //  url = "username=%27username%27", temos que remover o lixo, split no <<27>> 
    username = username.substring(0, username.length - 1);  //  após o split, o output será username%, logo temos que remover o último caracter 
    document.getElementById('userName').innerHTML = username;
    globalVarUsername = username;
}

function addNewGame(){
    document.getElementById('topBox').style.backgroundColor = "rgb(102, 255, 153)";
    document.getElementById("topBox").innerHTML = "Game added to collection!";
}

function redirect(url){
    var res = url.concat("?username='"+globalVarUsername+"'");
    location.href=res;
}