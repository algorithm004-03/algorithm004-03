var preorderTraversal = function(root) {
    var result = [];
    function pushRoot(node){
        if(node != null){
            if(node.left != null){
                pushRoot(node.left);
            }
            result.push(node.val);
            if(node.right != null){
                pushRoot(node.right);
            } 
        }
    }
    pushRoot(root);
    return result;
};