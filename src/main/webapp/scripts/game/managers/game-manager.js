var GameManager = {

    models: {
        /**
         * модель пользователей - список пользователй, который обновляется с сервером.
         * автоматически подает сигнал всем вью, которые подписаны на обновление.
         */
        users: null,//для рисовалки
        userList: null,//список тех, кого уже взяли

        //предыдущие данные по пользователю
        oldUsers: null
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
        delay: 300 //количество милисекунд между запросами о обновлении с сервером.
    },

    //id пользователя, которым ща играем.
    meId: null,

    init: function () {
        //init model
        this.models.users = new UserModelCollection;

        //todo test
        this.meId = "4000741400000894543";

        //init all views
        this._initViews();

        //подписываемся к обновлению с сервером
        setInterval($.proxy(function () {
            this.models.oldUsers = this.models.users.clone();
            this.models.users.fetch({reset: true});
        },this), this.settings.delay);
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
    },

    sendNewCoordinates: function(coordinates) {
        //todo test
        var me = this.models.users.findWhere({
            id: this.meId
        });
        if (!me || me.length == 0) {
            return;
        }
        //send
        me.set("x",coordinates.x);
        me.set("y",coordinates.y);
    },

    getOldUserInfo: function(user) {
        if (!this.models.oldUsers || this.models.oldUsers.length != this.models.users.length ) {
            return;
        }
        return this.models.oldUsers.findWhere({
            id: user.get("id")
        });
    }

};