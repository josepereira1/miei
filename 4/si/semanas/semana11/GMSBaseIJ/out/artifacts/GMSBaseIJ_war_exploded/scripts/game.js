class Game {
    //constructor
    constructor(){
        this._name = "Oxenfree";
        this._year = 2017;
    }

    //getter for _nome
    get name() {
        return this._name;
    }

    //setter for _nome
    set name(v){
        this._name = v;
    }

    //example method
    toString(){
        return "Games(" + this._name + ", " + this._year + ")";
    }

    moreRecent(game){
        if (this._year > game.year) return true;
        else return false;
    }
}