from collections import defaultdict as d

from collections import defaultdict
class GraphNode:

    def __init__(self, a, node):
        self.vertice = a
        self.verticelink = node
        self.edgelink = None
        self.marked = False

    def setVertices(self, a):
        self.vertice = a

    def getVertice(self):
        return self.vertice

    def setMarked(self, a):
        self.marked = a

    def getMarked(self):
        return self.marked

    def setVerticeLink(self, a):
        self.verticelink = a

    def getVerticeLink(self):
        return self.verticelink

    def setEdgeLink(self, a):
        self.edgelink = a

    def getEdgeLink(self):
        return self.edgelink

    def toString(self):
        return self.vertice + " ---> "


class Graph:

    def __init__(self):
        self.graph = d(list)

    def isEmpty(self):
        return self.GraphNode is None

    def getSize(self):
        count = 0
        while self.GraphNode is not None:
            self.GraphNode.getVerticeLink()
            count += 1
        return count

    def showGraph(self):
        while self.GraphNode is not None:
            print()
