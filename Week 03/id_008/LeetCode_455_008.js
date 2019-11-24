/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
	g.sort(function(a, b){ return a - b; });
	s.sort(function(a, b){ return b - a; });

	var total = 0;
	var cookie = 0;

	for (var i = 0; i < g.length; ++i) {
		while (cookie = s.pop()) {
			if (cookie >= g[i]) {
				++total;
				break;
			}
		}
	}

	return total;
};
