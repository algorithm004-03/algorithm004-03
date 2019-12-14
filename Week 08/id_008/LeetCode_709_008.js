/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function(str) {
    var s = [];

    for (var i = 0; i < str.length; ++i) {
        var a = str.charCodeAt(i);

        if (a >= 65 && a <= 90) {
            s.push(String.fromCharCode(a ^ 32));
        }
        else {
            s.push(str.charAt(i));
        }
    }

    return s.join("");
};
