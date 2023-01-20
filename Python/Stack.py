class ListNode:

    def __init__(self, a, b):
        self.data = a
        self.link = b

    def setData(self, a):
        self.data = a

    def getData(self):
        return self.data

    def setLink(self, a):
        self.link = a

    def getLink(self):
        return self.link

    def toString(self):
        print(self.data, end=" ")


class Stack:

    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head is None

    def length(self):
        count = 0
        currentNode = self.head
        while currentNode is not None:
            currentNode = currentNode.getLink()
            count += 1
        return count

    def pop(self):
        if self.head is None:
            return None
        temp = self.head.getData()
        self.head = self.head.getLink()
        return temp

    def peek(self):
        if self.head is None:
            return None
        else:
            return self.head.getData()

    def push(self, a):
        self.head = ListNode(a, self.head)

    def showStack(self):
        if self.isEmpty():
            print("Empty Stack")
        else:
            currentNode = self.head
            while currentNode is not None:
                currentNode.toString()
                currentNode = currentNode.getLink()


if __name__ == '__main__':
    s = Stack()
    s.push("A")
    s.push("B")
    s.showStack()
