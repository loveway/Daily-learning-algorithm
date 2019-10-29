# -*- encoding: utf-8 -*-
'''
@File    :   bubble_sort.py
@Time    :   2019/10/29 11:12:44
@Author  :   HenryCheng 
'''

# here put the import lib


def bubble_sort(origin_items, comp=lambda x, y: x > y):
    items = origin_items[:]
    for i in range(len(items) - 1):
        for j in range(i, len(items) - 1 - i):
            if comp(items[j], items[j+1]):
                items[j], items[j+1] = items[j+1], items[j]
    return items


def stir_sort(orgin_items, comp=lambda x, y: x > y):
    """Advanced bubble sort."""
    items = orgin_items[:]
    for i in range(len(items) - 1):
        ex_flag = False
        for j in range(i, len(items) - 1 - i):
            if comp(items[j], items[j+1]):
                items[j], items[j+1] = items[j+1], items[j]
                ex_flag = True
        if not ex_flag:
            return items
    return items


def main():
    sort_items = bubble_sort(
        [2, 1, 34, 54, 23, 7, 45, 342, 12, 23, 422, 31, 43])
    print('normal bubble sort: %s' % sort_items)

    stir_items = stir_sort([2, 1, 34, 54, 23, 7, 45, 342, 12, 23, 422, 31, 43])
    print('stir sort: %s' % stir_items)


if __name__ == '__main__':
    main()
