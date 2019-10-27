var preorderTraversal = function(root) {
  let result = [];
  const preorderTree = root => {
    if (root) {
      result.push(root.val);
      if (root.left) {
        preorderTree(root.left);
      }
      if (root.right) {
        preorderTree(root.right);
      }
    }
  };

  preorderTree(root);
  return result;
};
