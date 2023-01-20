# this class is to create a trie node which has three attributes
class TrieNode:
    def __init__(self, letter):
        self.letter = letter
        self.next = {}
        self.end_word = False


# this class is the Trie itself where each letter(Trie Node) is put together
class Trie:

    # method to initialize the root of the Trie
    def __init__(self):
        self.root = TrieNode("*")

    # method to add word(each letter) into the trie
    def add_word(self, word):
        current_node = self.root    # current node will start from the root
        for letter in word:     # each letter(Trie Node) is added to the Trie
            if letter not in current_node.next:     # to check if letter already exist in the current node
                current_node.next[letter] = TrieNode(letter)    # add the letter into Trie
            current_node = current_node.next[letter]    # move on to the next letter/node
        current_node.end_word = True    # the last letter of a word is set to end of word
    # to add a word into the Trie, the time complexity is O(n)

    # method to add word using suffix trie
    def add_suffix_word(self, word):
        for i in range(len(word)-1, -1, -1):    # for loop starting from the end of word
            current_node = self.root    # current node will start from the root for each suffix
            for letter in word[i:]:     # for each suffix
                if word[i] not in current_node.next:    # to check if letter already exist in the current node
                    current_node.next[letter] = TrieNode(letter)    # add the letter into Trie
                current_node = current_node.next[letter]    # move on to the next letter/node
            current_node.end_word = True    # the last letter of a word is set to end of word
    # to add suffix into the Trie, the time complexity is O(n^2)

    # method to check if word exist in Trie
    def word_exist(self, word):
        if word == "":      # if there is no word to check, return true
            return True
        current_node = self.root    # current node will start from the root
        for letter in word:     # each letter in the word will be checked
            if letter not in current_node.next:     # if the letter is not present in the true, return false
                return False
            current_node = current_node.next[letter]   # move on to the next letter/node
        return current_node.end_word    # the attribute(end of word) of last letter of input word
    # the time complexity of this method is O(m)


trie = Trie()
# trie.add_word("algorithmisfun")
trie.add_word("algorithm")
trie.add_word("fun")
# trie.add_suffix_word("algorithmisfun")
print(trie.word_exist("fun"))