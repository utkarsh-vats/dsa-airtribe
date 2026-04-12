# DSA Questions

## Binary Search

### 1. First occurance
- `arr = [1, 1, 1, 1, 1, 2, 3, 3, 4, 4]` array has duplicates return the `first` occurance 

### 2. Last occurance
- `arr = [1, 1, 1, 1, 1, 2, 3, 3, 4, 4]` array has duplicates return the `last` occurance 

### 3. Count occurance

### 4. LeetCode 34
- https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

### 5. LeetCode 33
- https://leetcode.com/problems/search-in-rotated-sorted-array/

### 6. LeetCode 153
- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
- given RSA, find the minimum element of RSA
- `rsa = [11, 15, 1, 5, 7, 9]` `key = 1`

### 7. LeetCode 154
- 

### 8. Find the no. of rotations
- `arr = {7, 11, 12, 1, 2}`
- find the no. of rotations in the RSA

### 9. Find element in a rotated sorted array

### 10. Koko Eating Bananas
- https://leetcode.com/problems/koko-eating-bananas/

### 11. Capacity to Ship Packages (LeetCode 1011)
- https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
- A conveyor belt has packages with weights. You must ship all packages within `D` days in order. Find the minimum ship capacity.
- How to think: The answer (capacity) is between max(weights) and sum(weights). At max single weight = you can carry at least the heaviest package. At sum = you ship everything in 1 day. Binary search between these. For each mid capacity, simulate: keep adding packages to current day until adding the next one exceeds capacity, then start a new day. Count days needed. If days ≤ D, try smaller capacity. If days > D, try bigger.

## Rotated Sorted Array (RSA)
- `arr = [1, 5, 7, 11, 15]` initial array
- `arr = [15, 1, 5, 7, 11]` rotated array 1
- `arr = [11, 15, 1, 5, 7]` rotated array 2
- `arr = [7, 11, 15, 1, 5]` rotated array 3
- `arr = [5, 7, 11, 15, 1]` rotated array 4