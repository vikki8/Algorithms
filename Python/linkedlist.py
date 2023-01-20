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


class LinkedList:

    def __init__(self):
        self.head = None

    def addNode(self, newdata):
        NewNode = ListNode(newdata, None)
        CurrentNode = self.head
        if self.head is None:
            self.head = NewNode
            return
        else:
            while CurrentNode.getLink() is not None:
                CurrentNode = CurrentNode.getLink()
            CurrentNode.setLink(NewNode)

    def contains(self, data):
        found = False
        currentNode = self.head
        while currentNode is not None:
            if data == currentNode.getData():
                found = True
                break
            currentNode = currentNode.getLink()
        return found

    def length(self):
        count = 0
        currentNode = self.head
        while currentNode is not None:
            currentNode = currentNode.getLink()
            count += 1
        return count

    def showList(self):
        currentNode = self.head
        while currentNode is not None:
            currentNode.toString()
            currentNode = currentNode.getLink()
        print('\n')


if __name__ == '__main__':
    l = LinkedList()

    l.addNode(2)
    l.addNode(3)
    l.addNode(2)
    l.showList()
    print(l.contains(5))
    print(l.length())
