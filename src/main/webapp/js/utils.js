var utils = {};

// использование Math.round() даст неравномерное распределение!
utils.getRandomInt = function(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
};
