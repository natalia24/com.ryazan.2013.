var globalId = 0;

var UserModel = Backbone.Model.extend({
    initialize: function () {
        //init user
    },
    defaults: {
        //TODO defaulted values
        x: utils.getRandomInt(0,CanvasManager.width),
        y: utils.getRandomInt(0,CanvasManager.height),
        id: globalId
    }
});

var UserModelCollection = Backbone.Collection.extend({
    model: UserModel,
    url: 'http://localhost:8083/game/test'//todo change url
});

