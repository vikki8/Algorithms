class MapNode:

    def __init__(self, a, b, c):
        self.key = a
        self.value = b
        self.link = c

    def setKey(self, a):
        self.key = a

    def getKey(self):
        return self.key

    def setValue(self, a):
        self.value = a

    def getValue(self):
        return self.value

    def setLink(self, a):
        self.link = a

    def getLink(self):
        return self.link

    def toString(self):
        print(str(self.key) + " : " + str(self.value))


class HashTable:

    def __init__(self):
        self.head = None

    def length(self):
        count = 0
        i = 0
        currentNode = self.head
        while i < 20:
            currentNode = currentNode.getLink()
            count += 1
        return count

    def showHashTable(self):
        currentNode = self.head
        while currentNode is not None:
            currentNode.toString()
            currentNode = currentNode.getLink()
        print('\n')

    def isEmpty(self):
        return self.head is None

    def addfront(self, k, v):
        self.head = MapNode(k, v, self.head)

    def addpos(self, k, v):
        if k == 0:
            self.addfront(v)
        elif k == self.length():
            self.put(k, v)

    def put(self, k, v):
        if self.head is None:
            self.head = MapNode(k, v, None)
        else:
            newNode = MapNode(k, v, None)
            currentNode = self.head
            previousNode = None
            while currentNode is not None:
                if k == currentNode.getKey():
                    temp = currentNode.getValue()
                    currentNode.setValue(v)
                    return temp
                else:
                    previousNode = currentNode
                    currentNode = currentNode.getLink()
            if previousNode is None:
                newNode.setLink(self.head)
                self.head = newNode
            else:
                previousNode.setLink(newNode)
                newNode.setLink(currentNode)
        return None

    def containsKey(self, k):
        currentNode = self.head
        while currentNode is not None:
            if k == currentNode.getKey():
                return True
            else:
                currentNode = currentNode.getLink()
        return False

    def containsValue(self, k):
        currentNode = self.head
        while currentNode is not None:
            if k == currentNode.getValue():
                return True
            else:
                currentNode = currentNode.getLink()
        return False

    def get(self, k):
        currentNode = self.head
        while currentNode is not None:
            if k == currentNode.getValue():
                return currentNode.getValue()
            else:
                currentNode = currentNode.getLink()
        return None

    def remove(self, k):
        if self.isEmpty():
            return None
        else:
            currentNode = self.head
            previousNode = None
            found = False
            while currentNode is not None:
                if k == currentNode.getKey():
                    found = True
                    break
                else:
                    previousNode = currentNode
                    currentNode = currentNode.getLink
            if found:
                temp = currentNode.getValue()
                if previousNode is None:
                    self.head = self.head.getLink()
                else:
                    previousNode.setLink(currentNode.getLink)
                return temp
            else:
                return None


def BKDRHash(string):
    seed = 131
    hash = 0
    for ch in string:
        hash = (hash * seed) + ord(ch)
    return str(hash & 0x7FFFFFFF)


def GPhash(key):
    hval = 0x0
    for i in range(len(key)):
        a = ord(key[i]) & 0xFF
        tmp1 = rightRotate(a, 4)
        tmp2 = rightRotate((hval ^ a), 2)
        hval = rightRotate((tmp1 * tmp2), 1)
        hval = hval % (2 ** 32)
    hval = hval % 20
    return hval


def rightRotate(value, shifts):
    return (value >> shifts) | (value << (32 - shifts)) & 0xFFFFFFFF


if __name__ == '__main__':
    HT1 = HashTable()
    HT1.put("hash", GPhash("Name"))
    HT1.showHashTable()

    print("The hash table has " + str(HT1.length()) + " values")
