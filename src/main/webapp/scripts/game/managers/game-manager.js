var GameManager = {

    models: {
        /**
         * модель пользователей - список пользователй, который обновляется с сервером.
         * автоматически подает сигнал всем вью, которые подписаны на обновление.
         */
        users: null,//для рисовалки
        userList: null//список тех, кого уже взяли
    },

    views: {
        /**
         * Метод render будет вызываться как будет проходить обновление модели, на которую мы подписались, т.е.
         * обновление списка наших пользователей.
         *
         * чтобы переопределить метод самого получения данных, т.е. сформировать данные из jSON - переопределить метод sync
         */
        userListView: null,
        canvasView: null
    },

    settings: {
        delay: 500 //количество милисекунд между запросами о обновлении с сервером.
    },

    init: function () {
        //init model
        this.models.users = new UserModelCollection;

        //TODO test
        for (var i = 0; i < 100; i++) {
            this.models.users.add(new UserModel({
                id: globalId++,
                x: utils.getRandomInt(0,CanvasManager.width),
                y: utils.getRandomInt(0,CanvasManager.height)
            }));
        }

        //init all views
        this._initViews();

        //подписываемся к обновлению с сервером
        //TODO recomment
//        setInterval(function () {
//            this.models.users.fetch({reset: true});
//        }, this.settings.delay);
    },

    _initViews: function () {
        //список пользователей, что будет снизу
        //TODO fix
//        this.views.userListView = new UserListView({
//            model: this.models.userList
//        });
        this.views.canvasView = new CanvasView({
            model: this.models.users
        });
        this.views.canvasView.render();
    }
};