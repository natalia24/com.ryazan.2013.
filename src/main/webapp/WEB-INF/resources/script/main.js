$(function () {
    flashlights.run();

    games = new GamesCollection;

    var personsView = new PersonListView({
        model: games
    });

    setInterval(function(){
        games.fetch({reset: true});
    },200);

});

var Game = Backbone.Model.extend({
    initialize: function () {
        //some code
    },
    defaults: {
        id: -1,
        message: "xz"
    }
});

var GamesCollection = Backbone.Collection.extend({
    model: Game,
    url: 'http://localhost:8066/game/test'
});

var PersonListView = Backbone.View.extend({

    initialize: function () {
        this.model.on('change', this.render, this);
        this.model.on('reset', this.render, this);

    },

    render: function () {
        $("#person-list").empty();
        this.model.forEach(function(book){
            $("#person-list").append(book.get("message"));
        });
        return this;
    }
});

