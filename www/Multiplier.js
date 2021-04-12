var exec = require('cordova/exec');

exports.getValue = function (arg0, success, error) {
    exec(success, error, 'Multiplier', 'getValue', [arg0]);
};
