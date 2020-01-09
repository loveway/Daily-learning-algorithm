# -*- encoding: utf-8 -*-
'''
@File    :   reverse_sort.py
@Time    :   2020/01/09 11:17:15
@Author  :   HenryCheng
'''

# here put the import lib

"""
:type s: List[str]
:rtype: None Do not return anything, modify s in-place instead.
"""


def reverseString(s):

    for i in range(0, len(s) // 2):
        s[i], s[len(s) - i - 1] = s[len(s) - i - 1], s[i]
    return s


def reverseString_recursive(s):

    if len(s) < 1:
        return s
    return reverseString_recursive(s[1:]) + list(s[0])


def main():
    print(reverseString(["1", "2", "3", "4", "5"]))
    print(reverseString_recursive(["1", "2", "3", "4", "5"]))


if __name__ == "__main__":
    main()
