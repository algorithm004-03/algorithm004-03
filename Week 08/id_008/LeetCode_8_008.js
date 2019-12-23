/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    if (!str) {
		return 0;
	}

	var i = 0;
	var total = 0;
	var is_neg = 0;

	while (str[i] === " " || str[i] === "\r" || str[i] === "\n" || str[i] === "\t") {
		++i;
	}

	if (str[i] === '-') {
		is_neg = 1;
		++i;
	}
	else if (str[i] === '+') {
		++i;
	}

	while (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57) {
		total = total * 10 + (str.charCodeAt(i++) - 48);

        if (total > 2147483648) {
            break;
        }
	}

    if (is_neg && total > 2147483648) {
        return -2147483648;
    }

    if (!is_neg && total > 2147483647) {
        return 2147483647;
    }

	return is_neg ? -total : total;
};
