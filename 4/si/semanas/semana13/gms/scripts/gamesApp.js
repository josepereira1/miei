class Game{
    //  private fields
    #id; #name; #year; #platform; #price; #description;

    //  construtor
    constructor(id, name, year, platform, price, description){
        this.#id = id;
        this.#name = name;
        this.#year = year;
        this.#platform = platform;
        this.#price = price;
        this.#description = description;
    }

    //  getters

    get id(){return this.#id;}
    get name(){return this.#name;}
    get year(){return this.#year;}
    get platform(){return this.#platform;}
    get price(){return this.#price;}
    get description(){return this.#description;}
}

var vm = new Vue({
    el: "#gameApp",
    data: {
        appName: "Games App",
        userName: "José Pereira",
        serviceGamesURL: "http://ivy.di.uminho.pt:8080/GamesLibraryProvider/GamesService?action=list",
        message: "",
        games: [],
        selYear: "no selection",
        selPlatform: "no selection",
        maxPerPage: 4,
        page: 0,
        selGame: "",
        },
    created: async function(){
        try{
            const response = await fetch(this.serviceGamesURL);
            this.games = await response.json();
            this.message = "Sucess!";
        }catch{
            this.message = "Error to load!";
        }
    },  
    computed:{
        years: function(){
            var list = [];
            list.push("no selection");
            this.games.forEach(function(g){
                if(!(list.includes(g.year))){
                    list.push(g.year);
                }
            });
            return list;
        },
        platforms: function(){
            var list = [];
            list.push("no selection");
            this.games.forEach(function(g){
                if(!(list.includes(g.platform))){
                    list.push(g.platform);
                }
            });
            return list;
        },
        gamesFiltered: function(){
            var list = [];
            let year = this.selYear;
            let platform = this.selPlatform;
            if(this.selYear == "no selection" && this.selPlatform == "no selection")return this.games;
            else{
                if(this.selYear != "no selection" && this.selPlatform != "no selection"){
                    this.games.forEach(function(g){
                        if(g.year == year && g.platform == platform){
                            list.push(g);
                        }
                    });
                }else{

                    if(this.selYear != "no selection"){
                        this.games.forEach(function(g){
                            if(g.year == year){
                                list.push(g);
                            }
                        });
                    }

                    if(this.selPlatform != ""){
                        this.games.forEach(function(g){
                            if(g.platform == platform){
                                list.push(g);
                            }
                        });
                    }
                }
                return list;
            }
        },
        gamesPaginated: function(){
            var arr = [];
            for(i = 0, k = 0; i < this.gamesFiltered.length; i = i + this.maxPerPage, k++){
                var elem = [];                                  
                //  i + 1, para ir buscar o primeiro jogo da página seguinte
                for(j = i; j < this.gamesFiltered.length && j < (k + 1) * this.maxPerPage; j = j +1){
                    elem.push(this.gamesFiltered[j]);
                }
                arr.push(elem);
            }
            return arr;
        },
    }
})

Vue.component('game-show', {
    props: ['game'],
    template: '<div><h3>{{game.name}}</h3><p>Id: {{game.id}}<br/>Year: {{game.year}}<br/>Price: {{game.price}}<br/>Description: {{game.description}}<br/>Platform: {{game.platform}}<br/></p><button v-on:click="$emit(\'back\')">Back</button></button></div>'
})

// Vue.component('games-filter', {
//     props: ['listOfGames', 'selYear', 'selPlat'],
//     computed: {
//         years: function (){
//             var list = [];
//             list.push("no selection");
//             vm.games.forEach(function(g){
//                 if(!(list.includes(g.year))){
//                     list.push(g.year);
//                 }
//             });
//             return list;
//         },
//         platforms: function (){
//             var list = [];
//             list.push("no selection");
//             vm.games.forEach(function(g){
//                 if(!(list.includes(g.platform))){
//                     list.push(g.platform);
//                 }
//             });
//             return list;
//         },
//         data: function (){
//             return {
//                 year: this.selYear,
//                 platform: this.selPlat,
//             }
//         }
//     },
//     template:
//         '<form class="align-middle pb-4">\
//             <select class="w-100 mt-3" v-model.number="year" v-on:change="$emit(\'newyear\', year)">\
//                 <option v-for="y in years">{{y}}</option>\
//             </select>\
//         </form>'
// })


Vue.component('games-filter', {
    props: ['listOfGames', 'selYear', 'selPlatform'],
    computed: {
        years: function () {
            var list = [];
            list.push("no selection");
            vm.games.forEach(function (g) {
                if (!(list.includes(g.year))) {
                    list.push(g.year); 
                }
            });
            return list.sort();
        },
        platforms: function () {
            var list = [];
            list.push("no selection");
            vm.games.forEach(function (g) {
                if (!(list.includes(g.platform))) {
                    list.push(g.platform); 
                }
            });
            return list.sort();
        }
    },
    data: function () {
        return {
            year: this.selYear,
            platform: this.selPlatform
        }
    },
    template:  '<form class="align-middle pb-4"> \
                    <select class="w-100 mt-3" v-model.number="year" v-on:change="$emit(\'newyear\', year)"> \
                        <option v-for="y in years">{{y}}</option> \
                    </select> \
                    <select class="w-100 mt-3" v-model="platform" v-on:change="$emit(\'newplatform\', platform)"> \
                        <option v-for="p in platforms">{{p}}</option> \
                    </select> \
                </form>'
})


{/* <select id="plataform" class="w-100 mt-3" v-model.text="selPlatform">\
                    <option v-for="p in platforms">{{p}}</option>\
                </select>\ */}