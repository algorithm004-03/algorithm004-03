from collections import OrderedDict

class LURCache(OrderedDict):
  def __init__(self, capacity):
    """
    :type capacity: int
    """
    self.capacity = capacity

  def get(self, key):
    """
    :type key: int
    :rtype : int
    """
    if key not in self:
      return -1
    self.move_to_end(key)
    return self[key]

  def put(self, key, value):
    """
    :type key: int
    :type value: int
    :rtype void
    """
    if key in self:
      self.move_to_end(key)
    self[key] = value
    if len(self) > self.capacity:
      self.popitem(lask=False)

# 使用有序字典数据结构，存取的时间都是O(1)
# 取值的时候根据key查字典
# 存值的时候如果如果容量满了需要移除最旧的一个元素
