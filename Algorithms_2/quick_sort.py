# -*- encoding: utf-8 -*-
'''
@File    :   quick_sort.py
@Time    :   2020/01/07 10:28:54
@Author  :   HenryCheng 
'''

# here put the import lib


def quick_sort(array):
    if len(array) < 2:
        return array
    else:
        pivot = array[0]
        less = [i for i in array[1:] if i <= pivot]
        greater = [i for i in array[1:] if i > pivot]
        return quick_sort(less) + [pivot] + quick_sort(greater)


def main():
    sort_array = [1, 56, 9, 3, 5, 67, 89, 123, 4, 6, 8]
    print(quick_sort(sort_array))
    # print  [1, 3, 4, 5, 6, 8, 9, 56, 67, 89, 123]


if __name__ == '__main__':
    main()
