class Node:

	def __init__(self, v):

		self.pre, self.nxt, self.v = None, None, v



class MyCircularDeque:

	def __init__(self, k: 'int'):

		self.head, self.tail, self.k, self.cnt = Node(0), Node(0), k, 0

		self.head.nxt, self.tail.pre = self.tail, self.head



	def _addAfter(self, node, toAdd):

		nxt = node.nxt

		node.nxt = toAdd

		toAdd.pre = node

		toAdd.nxt = nxt

		nxt.pre = toAdd



	def _delAfter(self, node):

		nxt = node.nxt.nxt

		node.nxt = nxt

		nxt.pre = node

	

	def insertFront(self, value: 'int') -> 'bool':



		if self.cnt == self.k:

		return False

		self.cnt += 1

		self._addAfter(self.head, Node(value))

		return True















    def insertLast(self, value: 'int') -> 'bool':







        if self.cnt == self.k: return False







        self.cnt += 1







        self._addAfter(self.tail.pre, Node(value))







        return True















    def deleteFront(self) -> 'bool':







        if self.cnt == 0: return False







        self.cnt -= 1







        self._delAfter(self.head)







        return True















    def deleteLast(self) -> 'bool':







        if self.cnt == 0: return False







        self.cnt -= 1







        self._delAfter(self.tail.pre.pre)







        return True















    def getFront(self) -> 'int':







        return self.head.nxt.v if self.cnt else -1















    def getRear(self) -> 'int':







        return self.tail.pre.v if self.cnt else -1















    def isEmpty(self) -> 'bool':







        return self.cnt == 0

   def isFull(self) -> 'bool':

        return self.cnt == self.k
