# COMPUTE PRE-FIX TABLE (Only uses the pattern)
# ----------------------------------------------------------------------------------------------------------------------
def kmp(pattern, oristring):
    j, i = 0, 1  # i & j is used to iterate in the pattern in order to find the suffix and prefix
    # |F|U|N|
    pt = pattern  # the pattern to be found                                                         |0|0|0|
    index = [0] * len(pt)  # create & initialize the LPS table with all 0s

    while i < len(pt):  # Iterate with i & j to compare similarities with two letters
        if pt[j] != pt[i]:  # If mismatch occurs
            print("Mismatch occurred!! ")

            if j != 0:  # index j will move to the previous index LPS array value's place
                j = index[j - 1]  # till it matches a letter / reaches 0. Then iterates again
                print("Current LPS array: " + str(index))
                print()
            else:
                index[i] = 0  # store 0s in i index of the LPS array
                i += 1  # increase i index by 1 to continue iteration
                print("Current LPS array: " + str(index))
                print()

        else:  # if a match occurs
            print("Match occurred!! ")
            j += 1  # increase j index by 1
            index[i] = j  # store the j index in i index of the LPS array
            i += 1  # increase i index by 1 to continue iteration
            print("Current LPS array: " + str(index))
            print()

    print("Final LPS array: " + str(index))
    print()
    # ----------------------------------------------------------------------------------------------------------------------

    # KMP String Matcher
    i = 0  # for string
    j = 0  # for pattern
    found = False
    s = oristring
    while i < len(s):  # 14

        if s[i] != pt[j]:  # If mismatch occurs
            if j != 0:  # index j will move to the previous index LPS array value's place
                j = index[j - 1]  # till it matches a letter / reaches 0. Then iterates again
            else:
                i += 1  # move i to the right for string
        else:
            i += 1  # move i to the right for string
            j += 1  # move j to the right for pattern

        if len(index) == j:  # if LPS array length and pattern length(j index) matches
            found = True
            if found:
                print(pt + " is at index " + str(i - j))
            j = index[
                j - 1]  # Once found, index j will reposition itself with the LPS array value of the previous index
            # till it matches a letter and iterates again ||| One Jump Big Jump One Jump again

    if not found:
        print(pt + " is not found")


kmp("fun", "algorithmisfn")
