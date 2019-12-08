/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }

    var S = s.split("");
    S.sort(function(a, b){ return a.charCodeAt(0) - b.charCodeAt(0); });
    s = S.join("");

    var T = t.split("");
    T.sort(function(a, b){ return a.charCodeAt(0) - b.charCodeAt(0); });
    t = T.join("");

    return s === t;
};

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }

    var map = {};

    for (var i = 0; i < s.length; ++i) {
        var S = s.charAt(i);
        var T = t.charAt(i);

        if (typeof map[S] === "undefined") {
            map[S] = 0;
        }

        if (typeof map[T] === "undefined") {
            map[T] = 0;
        }

        ++map[S];
        --map[T];
    }

    for (var i in map) {
        if (map[i] !== 0) {
            return false;
        }
    }

    return true;
};

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }

    var map = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

    for (var i = 0; i < s.length; ++i) {
        ++map[s.charCodeAt(i) - 97];
        --map[t.charCodeAt(i) - 97];
    }

    for (var i = 0; i < 26; ++i) {
        if (map[i]) {
            return false;
        }
    }

    return true;
};
