text = "algorithmisfun"
pat = 'fun'
n = len(text)
m = len(pat)  # m = 3
d = 256  # num of input of alphabets
q = 101  # prime number
p = 0  # total asci of pat
j = 0
t = 0  # t from text
for i in range(m - 1, -1, -1):  # 2-1-0
    p = (p + (ord(pat[j]) * pow(d, i))) % q  # Formula :: d= 256^2 / 256^1 / 256^0
    t = (t + (ord(text[j]) * pow(d, i))) % q  # Formula :: d= 256^2 / 256^1 / 256^0
    j += 1
print("Total hash value of pattern: " + str(p))  # Total hash value of pattern
# Total hash value of the string which has the length of the pattern
print("Current hash value of the string which has the length of the pattern: " + str(t))

for x in range(n - m + 1):  # 14-3+1 = 12 || 0 -11
    print("Current hash letter: " + str(text[x] + text[x + 1] + text[x + m - 1]))
    if p == t:  # if the hash value matches
        count = 0
        for i in range(m):
            if pat[i] != text[x + i]:  # But the letters didn't match as per the hash value
                break
            else:  # And the letters match. So, increase the count
                count = i
        if count == (m - 1):  # if count matches the pattern's length, print the index
            print('Pattern found at ', x)
            break
    if x < n - m:
        # Updating the hash value of text by moving one letter to the right
        t = (d * (t - ord(text[x]) * pow(d, m - 1)) + ord(text[x + m])) % q
    print("Current hash value of the string which has the length of the pattern: " + str(t))


