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
    template: '<div class="col-md-8">\
                    <h3>{{game.name}}</h3>\
                    <p>Id: {{game.id}}\
                    <br/>Year: {{game.year}}\
                    <br/>\
                    Price: {{game.price}}\
                    <br/>\
                    Description: {{game.description}}\
                    <br/>\
                    Platform: {{game.platform}}\
                    <br/>\
                    </p>\
                    <button v-on:click="$emit(\'back\')">Back</button>\
                </div>'
})

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
    template:  '<div class="col-md-4">\
                    <aside>\
                        <b>Filter</b>\
                        <form class="align-middle pb-4"> \
                            <select class="w-100 mt-3" v-model.number="year" v-on:change="$emit(\'newyear\', year); $emit(\'newpage\', 0)"> \
                                <option v-for="y in years">{{y}}</option> \
                            </select> \
                            <select class="w-100 mt-3" v-model="platform" v-on:change="$emit(\'newplatform\', platform); $emit(\'newpage\', 0)"> \
                                <option v-for="p in platforms">{{p}}</option> \
                            </select> \
                        </form>\
                        </aside>\
                        </div>'
})

Vue.component('games-list', {
    props: ['gamesPaginatedProp', 'pageProp', 'gamesFilteredProp', 'pageSize'],
    data: function() {
        return {
            actualPage: this.pageProp,
        }
    },
    template: '<div class="col-md-8">\
                    <table class="table table-striped table-hover">\
                        <thead>\
                            <tr>\
                                <th scope="col">Games</th>\
                                <th id="year" scope="col">Year</th>\
                                <th scope="col">Plataform</th>\
                            </tr>\
                        </thead>\
                        <tbody>\
                            <tr v-for="g in gamesPaginatedProp[pageProp]" v-bind:key="g.id" v-on:click="$emit(\'newgame\', g)">\
                                <td><a class="text-decoration-none" style="color: black" data-toggle="modal">{{g.name}}</a></td>\
                                <td id="year">{{g.year}}</td>\
                                <td>{{g.platform}}</td>\
                            </tr>\
                        </tbody>\
                    </table>\
                    <nav class="d-flex justify-content-end" v-if="gamesFilteredProp.length>pageSize">\
                        <form class="pagination">\
                            <button type="button" v-bind:disabled="actualPage===0" v-on:click="actualPage -= 1;$emit(\'newpage\', actualPage)">&Lt;</button>\
                            <button type="button" v-bind:disabled="actualPage===i - 1" v-for="i in gamesPaginatedProp.length" v-on:click="actualPage = i - 1; $emit(\'newpage\', actualPage)">{{i}}</button>\
                            <button type="button" v-bind:disabled="actualPage===gamesPaginatedProp.length - 1" v-on:click="actualPage += 1; $emit(\'newpage\', actualPage)">&Gt;</button>\
                        </form>\
                    </nav>\
                </div>'
})