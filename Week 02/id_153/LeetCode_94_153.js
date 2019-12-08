var inorderTraversal = function(root) {
  let result = [];
  const inorderTree = root => {
    if (root) {
      if (root.left) {
        inorderTree(root.left);
      }
      result.push(root.val);
      if (root.right) {
        inorderTree(root.right);
      }
    }
  };

  inorderTree(root);
  return result;
};
