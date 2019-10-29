# -*- encoding: utf-8 -*-
'''
@File    :   merge_sort.py
@Time    :   2019/10/29 14:11:36
@Author  :   HenryCheng 
'''

# here put the import lib


def merge_sort(origin_items, comp=lambda x, y: x <= y):
    if len(origin_items) <= 1:
        return origin_items
    mid = len(origin_items) // 2
    left = merge_sort(origin_items[:mid], comp)
    right = merge_sort(origin_items[mid:], comp)
    return merge(left, right, comp)


def merge(items1, items2, comp):
    result = []
    i, j = 0, 0
    while i < len(items1) and j < len(items2):
        if comp(items1[i], items2[j]):
            result.append(items1[i])
            i += 1
        else:
            result.append(items2[j])
            j += 1
    result += items1[i:]
    result += items2[j:]
    return result


def main():
    sort_items = [2, 1, 6, 3, 7, 5, 9, 4]
    sort_items = merge_sort(sort_items)
    print(sort_items)


if __name__ == '__main__':
    main()
