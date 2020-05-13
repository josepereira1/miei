<!-- content -->
<div class="row">
    <div class="col-md-12">
        <div id="topBox" class="p-2 mb-2 text-black text-center">Fill fields to add game</div>
    </div>
</div>

<!-- formulário para adição de novo jogo -->
<div class="row">
    <div class="col-md-12">
        <form>
            <div class="form-group row">
                <label id="add-game" for="inputTitle" class="col-sm-2 col-form-label d-flex justify-content-end">Title</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputTitle" placeholder="">
                </div>
            </div>
            <div class="form-group row">
                <label id="add-game" for="inputYear" class="col-sm-2 col-form-label d-flex justify-content-end">Year</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputYear" placeholder="">
                </div>
            </div>

            <div class="form-group row">
                <label id="add-game" for="inputPlataform" class="col-sm-2 col-form-label d-flex justify-content-end">Plataform</label>
                <div class="col-sm-8">
                    <select id="plataform" class="w-100 p">
                        <option value="pc">PC</option>
                        <option value="megadrive">Megadrive</option>
                        <option value="playstation">Playstation</option>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label id="add-game" for="inputPicture" class="col-sm-2 col-form-label d-flex justify-content-end">Picture URL</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="inputPicture" placeholder="">
                </div>
            </div>

            <div class="form-group row">
                <label id="add-game" for="inputPlataform" class="col-sm-2 col-form-label d-flex justify-content-end">Description</label>
                <div class="col-md-8">
                    <textarea class="w-100" rows="5" id="comment"></textarea>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="button" onclick="addNewGame()" class="btn btn-light float-right">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>
