
var preorderTraversal = function(root) {
    var result = [];
    function pushRoot(node){
        if(node != null){
            result.push(node.val);
            if(node.left != null){
                pushRoot(node.left);
            }
            if(node.right != null){
                pushRoot(node.right);
            } 
        }
    }
    pushRoot(root);
    return result;
};