public class Solution {

    public boolean isValid(String s) {
        if (s.length() < 1) {
            return true;
        }
        Stack stack = new Stack();
        String[] args = s.split("");
        int i = 0;
        HashMap map = new HashMap();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        while (i < args.length) {

            String item = args[i];
            if (!stack.empty()) {
                if (map.containsKey(item)) {
                    if (map.get(item).equals(stack.peek())) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.add(item);
                }
            } else {
                stack.add(item);
            }
            i++;
        }
        return stack.empty();
    }
}