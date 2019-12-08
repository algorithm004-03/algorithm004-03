var postorder = function(root) {
    let res = []
    if (root == null) {
        return res;
    }
    fun(root)
    function fun(root){
        if(root == null) return;
        for (let i = 0; i < root.children.length; i++){
            fun(root.children[i]);
        }
        res.push(root.val)
    }
    return res;
};