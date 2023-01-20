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


class GraphNode:

    def __init__(self, a, b):
        self.vertice = a
        self.verticelink = b
        self.edgelink = None
        self.marked = False
        self.markedRed = False
        self.markedBlue = False

    def setVerticeLink(self, a):
        self.verticelink = a

    def getVerticeLink(self):
        return self.verticelink

    def setEdgeLink(self, a):
        self.edgelink = a

    def getEdgeLink(self):
        return self.edgelink

    def setVertice(self, a):
        self.vertice = a

    def getVertice(self):
        return self.vertice

    def setMarked(self, a):
        self.marked = a

    def getMarked(self):
        return self.marked

    def setMarkedRed(self, a):
        self.markedRed = a

    def getMarkedRed(self):
        return self.markedRed

    def setMarkedBlue(self, a):
        self.markedBlue = a

    def getMarkedBlue(self):
        return self.markedBlue

    def toString(self):
        print(str(self.vertice) + " is connected to:", end=" ")


class Edge:

    def __init__(self, a, b, c):
        self.verticelink = a
        self.weight = b
        self.edgelink = c

    def setWeight(self, a):
        self.weight = a

    def getWeight(self):
        return self.weight

    def setVerticeLink(self, a):
        self.verticelink = a

    def getVerticeLink(self):
        return self.verticelink

    def setEdgeLink(self, a):
        self.edgelink = a

    def getEdgeLink(self):
        return self.edgelink

    def toString(self):
        print(str(self.verticelink.getVertice()))


class Stack:
    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head is None

    def length(self):
        count = 0
        currentNode = self.head
        while currentNode is not None:
            currentNode = currentNode.getVerticeLink()
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


class Graph:
    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head is None

    def length(self):
        count = 0
        currentNode = self.head
        while currentNode is not None:
            currentNode = currentNode.getVerticeLink()
            count += 1
        return count

    def showGraph(self):
        currentNode = self.head
        while currentNode is not None:
            currentNode.toString()
            edgeNode = currentNode.getEdgeLink()
            while edgeNode is not None:
                edgeNode.toString()
                edgeNode = edgeNode.getEdgeLink()
            print('\n')
            currentNode = currentNode.getVerticeLink()

    def hasVertice(self, a):
        currentNode = self.head
        if self.head is None:
            return None
        else:
            while currentNode is not None:
                if a == currentNode.getVertice():
                    return currentNode
                currentNode = currentNode.getVerticeLink()
        return None

    def addVertice(self, a):
        newNode = GraphNode(a, None)
        currentNode = self.head
        if self.head is None:
            self.head = newNode
        else:
            while currentNode.getVerticeLink() is not None:
                currentNode = currentNode.getVerticeLink()
            currentNode.setVerticeLink(newNode)

    def markVertice(self, a):
        if self.hasVertice(a) is not None:
            currentNode = self.head
            while currentNode is not None:
                if a == currentNode.getVertice():
                    currentNode.setMarked(True)
                    break
                else:
                    currentNode = currentNode.getVerticeLink()

    def markVerticeRed(self, a):
        if self.hasVertice(a) is not None:
            currentNode = self.head
            while currentNode is not None:
                if a == currentNode.getVertice():
                    currentNode.setMarkedRed(True)
                    break
                else:
                    currentNode = currentNode.getVerticeLink()

    def markVerticeBlue(self, a):
        if self.hasVertice(a) is not None:
            currentNode = self.head
            while currentNode is not None:
                if a == currentNode.getVertice():
                    currentNode.setMarkedBlue(True)
                    break
                else:
                    currentNode = currentNode.getVerticeLink()

    def isMarked(self, a):
        if self.hasVertice(a) is not None:
            currentNode = self.head
            while currentNode is not None:
                if a == currentNode.getVertice():
                    return currentNode.getMarked()
                else:
                    currentNode = currentNode.getVerticeLink()
        return False

    def isMarkedRed(self, a):
        if self.hasVertice(a) is not None:
            currentNode = self.head
            while currentNode is not None:
                if a == currentNode.getVertice():
                    return currentNode.getMarkedRed()
                else:
                    currentNode = currentNode.getVerticeLink()
        return False

    def isMarkedBlue(self, a):
        if self.hasVertice(a) is not None:
            currentNode = self.head
            while currentNode is not None:
                if a == currentNode.getVertice():
                    return currentNode.getMarkedBlue()
                else:
                    currentNode = currentNode.getVerticeLink()
        return False

    def addEdge(self, From, to, weight):
        if self.hasVertice(From) is None or self.hasVertice(to) is None:
            return False
        else:
            currentNode = self.head
            while currentNode is not None:
                if From == currentNode.getVertice():  # 1. A != B 2. B == B
                    temp = self.hasVertice(to)
                    newNode = Edge(temp, weight, None)  # temp = verticelink
                    edgeNode = currentNode.getEdgeLink()  # B ---
                    if edgeNode is None:
                        currentNode.setEdgeLink(
                            newNode)  # B --- C if adding an edge without an existing edge it should be currentNode.
                    else:
                        while edgeNode.getEdgeLink() is not None:  # Moving on to the next edge
                            edgeNode = edgeNode.getEdgeLink()  # 1. B --- / 2. B ---
                        edgeNode.setEdgeLink(
                            newNode)  # 1. B --- D / 2 B --- E if adding an edge after an existing edge it should be edgeNode.
                    return True
                else:
                    currentNode = currentNode.getVerticeLink()  # Moving on to the next existing vertice if the vertice does not match From
        return False

    def isEdge(self, From, to):
        if self.hasVertice(From) is None or self.hasVertice(to) is None:
            return False
        else:
            currentNode = self.head
            while currentNode is not None:
                if From == currentNode.getVertice():
                    temp = self.hasVertice(to)
                    edgeNode = currentNode.getEdgeLink()
                    if edgeNode is None:
                        return False
                    else:
                        while edgeNode is not None:
                            if edgeNode.getVerticeLink() == temp:  # edge Node == temp(to) Node
                                return True
                            edgeNode = edgeNode.getEdgeLink()

                else:
                    currentNode = currentNode.getVerticeLink()
        return False

    def getWeight(self, From, to):
        if self.isEdge(From, to):
            currentNode = self.head
            while currentNode is not None:
                if From == currentNode.getVerticeLink():
                    temp = self.hasVertice(to)
                    edgeNode = currentNode.getEdgeLink()
                    while edgeNode is not None:
                        if edgeNode.getVerticeLink() == temp:
                            return edgeNode.getWeight
                        edgeNode = edgeNode.getEdgeLink()
                else:
                    currentNode = currentNode.getVerticeLink()
        return None

    def getAdjacent(self, a):
        arr = []
        if self.hasVertice(a) is not None:
            currentNode = self.head
            while currentNode is not None:
                if a == currentNode.getVertice():
                    edgeNode = currentNode.getEdgeLink()  # root to edge
                    while edgeNode is not None:
                        arr.append(edgeNode.getVerticeLink().getVertice())  # Getting the vertice of the edge
                        edgeNode = edgeNode.getEdgeLink()  # root same edge different
                    break
                else:
                    currentNode = currentNode.getVerticeLink()
        return arr

    def deleteEdge(self, From, to):
        if not self.isEdge(From, to):
            return False
        else:
            currentNode = self.head
            while currentNode is not None:
                if From == currentNode.getVertice():
                    temp = self.hasVertice(to)
                    previousNode = None
                    edgeNode = currentNode.getEdgeLink()
                    while edgeNode is not None:
                        if edgeNode.getVerticeLink() == temp:
                            if previousNode is None:
                                currentNode.setEdgeLink(edgeNode.getEdgeLink())
                            else:
                                previousNode.setEdgeLink(edgeNode.getEdgeLink())
                            return True
                        else:
                            previousNode = edgeNode
                            edgeNode = edgeNode.getEdgeLink()
                else:
                    currentNode = currentNode.getVerticeLink()
        return False


def DFS(start, end):
    s = Stack()
    s.push(start)
    track = []
    while s.isEmpty() is False:
        x = 0
        data = s.pop()
        track += data
        if data == end:
            print(track)
            return True

        else:
            graph.markVertice(data)
            aj = graph.getAdjacent(data)
            while x < len(aj):
                if graph.isMarked(aj[x]) is False:
                    s.push(aj[x])
                x += 1


def DFS2(start, end):
    s = Stack()
    s.push(start)
    track = []
    while s.isEmpty() is False:
        x = 0
        data = s.pop()
        print(data)
        track.append(data)
        if data == end:
            print(track)

        else:
            aj = graph.getAdjacent(data)
            graph.markVertice(data)
            while 0 != len(aj):
                if graph.isMarked(aj[x]) is False and 0 != len(aj):
                    s.push(aj[x])
                    aj = graph.getAdjacent(aj[x])
                    graph.markVertice(aj[x])

                if graph.isMarked(aj[x]) is True and 0 == len(aj):
                    x += 1


def DFSBipartite(start):
    s = Stack()
    s.push(start)
    flag = True
    track = []
    log = ""
    log1 = ""
    while s.isEmpty() is False:
        x = 0
        i = 0
        j = 0
        data = s.pop()
        track.append(data)
        if graph.isMarkedRed(data):
            red = graph.getAdjacent(data)
            while i < len(red):
                if graph.isMarkedRed(red[i]):
                    flag = False
                    log = "The graph is NOT Bipartite because " + str(data) + " is connected to " + str(red[i])
                    log1 = str(data) + " has a same colour of adjacent vertices [" + str(red[i]) + "] which is RED"
                i += 1

        elif graph.isMarkedBlue(data):
            blue = graph.getAdjacent(data)
            while j < len(blue):
                if graph.isMarkedBlue(blue[j]):
                    flag = False
                    log = "The graph is NOT BIPARTITE because " + str(data) + " is connected to " + str(blue[i])
                    log1 = str(data) + " has a same colour of adjacent vertices [" + str(red[i]) + "] which is BLUE"
                j += 1

        graph.markVertice(data)
        aj = graph.getAdjacent(data)
        while x < len(aj):
            if graph.isMarked(aj[x]) is False:
                s.push(aj[x])
            x += 1
    print("The traversal of the Depth First Search (DFS) is \n", track)
    if flag is True:
        print("The graph is BIPARTITE because each vertices does not have adjacent vertices with the same colour")
    else:
        print(log, '\n', log1)


if __name__ == '__main__':
    graph = Graph()

    graph.addVertice("A1")
    graph.addVertice("A2")
    graph.addVertice("A3")
    graph.addVertice("B1")
    graph.addVertice("B2")

    graph.addEdge("A1", "B1", 1)
    graph.addEdge("B1", "A2", 1)
    graph.addEdge("A2", "B2", 1)
    # graph.addEdge("A2", "A3", 1)
    graph.addEdge("B2", "A3", 1)

    graph.markVerticeRed("A1")
    graph.markVerticeRed("A2")
    graph.markVerticeRed("A3")
    graph.markVerticeBlue("B1")
    graph.markVerticeBlue("B2")

    DFSBipartite("A1")
