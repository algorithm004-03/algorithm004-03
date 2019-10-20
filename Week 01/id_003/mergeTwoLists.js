var mergeTwoLists = function(l1, l2) {
    var prehead = {
        val:null,
        next:null
    };
    var pre = prehead;
    while (l1 != null && l2 != null) {
        if ( l1.val <= l2.val ) {
            pre.next = l1;
            l1 = l1.next;
        } else {
            pre.next = l2;
            l2 = l2.next;
        }
        pre = pre.next;
        
    }
    pre.next = l1 == null ? l2 : l1;
    return prehead.next;
};