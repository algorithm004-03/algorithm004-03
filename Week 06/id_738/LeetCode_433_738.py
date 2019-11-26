class Solution(object):
    def minMutation(self, start, end, bank):
        """
        最小基因变化：https://leetcode-cn.com/problems/minimum-genetic-mutation/#/description

        :type start: str
        :type end: str
        :type bank: List[str]
        :rtype: int
        """
        # 双向BFS
        bank = set(bank)
        if end not in bank:
            return -1
        change = {'A': 'TCG', 'T': 'ACG', 'C': 'ATG', 'G': 'ATC'}
        head = {start}
        tail = {end}
        step = 0
        while head:
            step += 1
            next_head = set()
            for n in head:
                for i in range(len(n)):
                    for c in change[n[i]]:
                        new_n = n[:i] + c + n[i + 1:]
                        if new_n in tail:
                            return step
                        if new_n in bank:
                            next_head.add(new_n)
                            bank.remove(new_n)
            head = next_head
            if len(head) > len(tail):
                head, tail = tail, head
        return -1


#####################################################################

        # BFS
        change = {'A': 'TCG', 'T': 'ACG', 'C': 'ATG', 'G': 'ATC'}
        queue = [start]
        step = -1
        bank = set(bank)
        while queue:
            l = []
            step += 1
            while queue:
                n = queue.pop()
                if n == end:
                    return step
                l.append(n)
            for n in l:
                for i in range(len(n)):
                    for c in change[n[i]]:
                        new_n = n[:i] + c + n[i + 1:]
                        if new_n in bank:
                            queue.append(new_n)
                            bank.remove(new_n)
        return -1
