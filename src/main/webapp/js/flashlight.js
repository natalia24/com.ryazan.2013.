var flashlights = {
    selector: "#light",
    lightOn: "light-on"
};

flashlights.lightsOn = function () {
    $(flashlights.selector).toggleClass(flashlights.lightOn);
};

flashlights.lightsOff = function () {
    $(flashlights.selector).removeClass(flashlights.lightOn);
};

flashlights.run = function(){
    flashlights.doTheRandomOn();
};

flashlights.doTheRandomOn = function(){
    random = utils.getRandomInt(100, 2000);
    flashlights.lightsOn();
    setTimeout(flashlights.doTheRandomOff, random);
};

flashlights.doTheRandomOff = function(){
    random = utils.getRandomInt(100, 500);
    flashlights.lightsOff();
    setTimeout(flashlights.doTheRandomOn, random);
};

