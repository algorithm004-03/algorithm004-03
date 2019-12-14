int myAtoi(char * str){
	if (str == NULL) {
		return 0;
	}

	int i = 0;
	long total = 0;
	int is_neg = 0;

	while (isspace(str[i])) {
		++i;
	}

	if (str[i] == '-') {
		is_neg = 1;
		++i;
	}
	else if (str[i] == '+') {
		++i;
	}

	while (str[i] >= '0' && str[i] <= '9') {
		total = total * 10 + (str[i++] - '0');

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
}
