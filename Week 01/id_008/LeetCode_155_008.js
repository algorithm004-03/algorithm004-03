/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.stack = [];
    this.min = [];
    this._top = null;
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.stack.push(x);
    this._top = x;

    if (this.min.length) {
        var pop = this.min[this.min.length - 1];
        this.min.push(x < pop ? x : pop);
    }
    else {
        this.min.push(x);
    }

    return x;
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.min.pop();
    this._top = this.stack.length >= 2 ? this.stack[this.stack.length - 2] : null;
    return this.stack.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this._top;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.min[this.min.length - 1];
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
