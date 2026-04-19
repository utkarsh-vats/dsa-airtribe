# Merge Sort Questions

## 1. Inversion Count
- gfg
- `https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1`
- Given an array of integers. Find the Inversion Count in the array.
- Two elements `a[i]` and `a[j]` form an inversion if `a[i] > a[j]` and `i < j`.
- **Approach**: Use the Merge Sort technique. While merging two sorted halves, if `a[i] > a[j]`, then all elements from `i` to `mid` in the left half are also greater than `a[j]`. Thus, `count += (mid - i + 1)`.
- **Example 1:**
```
    **Input:** arr[] = {2, 4, 1, 3, 5}
    **Output:** 3
    **Explanation:** The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
```