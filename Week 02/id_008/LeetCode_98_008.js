/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */

// 双重检查

var isValidBST = function(root) {
    return check(root);

    function check(node){
        if (!node) {
            return true;
        }

        if (node.left) {
            if (!checkMax(node.left, node.val)) {
                return false;
            }
        }

        if (node.right) {
            if (!checkMin(node.right, node.val)) {
                return false;
            }
        }

        if (node.left) {
            if (!check(node.left)) {
                return false;
            }
        }

        if (node.right) {
            if (!check(node.right)) {
                return false;
            }
        }

        return true;
    }

    function checkMax(node, max){
        if (node.val >= max) {
            return false;
        }

        if (node.left) {
            if (node.left.val >= max) {
                return false;
            }

            if (!checkMax(node.left, max)) {
                return false;
            }
        }

        if (node.right) {
            if (node.right.val >= max) {
                return false;
            }

            if (!checkMax(node.right, max)) {
                return false;
            }
        }

        return true;
    }

    function checkMin(node, min){
        if (node.val <= min) {
            return false;
        }

        if (node.left) {
            if (node.left.val <= min) {
                return false;
            }

            if (!checkMin(node.left, min)) {
                return false;
            }
        }

        if (node.right) {
            if (node.right.val <= min) {
                return false;
            }

            if (!checkMin(node.right, min)) {
                return false;
            }
        }

        return true;
    }
};

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */

// 范围收敛

var isValidBST = function(root) {
    return check(root, -Infinity, Infinity);

    function check(node, L, R){
        if (!node) {
            return true;
        }

        if (node.val <= L || node.val >= R) {
            return false;
        }

        if (node.left && !check(node.left, L, node.val)) {
            return false;
        }

        if (node.right && !check(node.right, node.val, R)) {
            return false;
        }

        return true;
    }
};

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */

// 中序遍历从小到大有序

var isValidBST = function(root) {
    if (!root) {
        return root;
    }

    var min = -Infinity;
    return search(root);

    function search(node){
        if (node.left && !search(node.left)) {
            return false;
        }

        if (node.val <= min) {
            return false;
        }

        min = node.val;

        if (node.right && !search(node.right)) {
            return false;
        }

        return true;
    }
};
