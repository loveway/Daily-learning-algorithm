# -*- encoding: utf-8 -*-
'''
@File    :   select_sort.py
@Time    :   2019/10/29 09:51:00
@Author  :   HenryCheng 
'''

# here put the import lib


def select_sort(origin_items, comp=lambda x, y: x < y):
    items = origin_items[:]
    for i in range(len(items) - 1):
        min_index = i
        for j in range(i+1, len(items)):
            if comp(items[j], items[min_index]):
                min_index = j
        items[i], items[min_index] = items[min_index], items[i]
    return items


def main():
    sort_items = select_sort([2, 5, 7, 78, 34, 56, 32, 57, 785, 12, 1])
    print(sort_items)


if __name__ == '__main__':
    main()
