# leetcode - notes
### 0. There are really few ways to improve a program perfectly. When you are asked to do so, always consider how to sacrifice space(time) to improve time(space). 
* Like if you want to improve from O(n) to O(1), you may need more O(n) space.

### 1. dps/backtracking with memorization could only be used on bottom-up manner.
* If we try to use a up to bottom manner, it's hard to implement memorization.
* BFS is also hard to use with memorization because it's hard to know some true result before all branches reach the end.
* But we can cut some visited branches in BFS.
* Example: 140. Word Break II, 1066. Campus Bikes II, 679. 24 Game (Both bottom up and top down though there have better algorithm)
   
### 2. For dynamic programming: 
#### 1. Please not only consider look back but also consider look forward
* Example: 403. Frog Jump.
#### 2. Please not only consider using a int[] or int[][] to record the dp states. The size of every stages' dp states my change. So we may use a changable structure (Map, Set, List ...) to store states in every stages. This is easy to use when dp transfer function only care about the i - 1 stage. So we can only keep one changeable structure. 
* Example: 1187. Make Array Strictly Increasing
#### 3. If a dp algorithm's transfer function only contains dp[i - 1], it is really similier to a kind of BFS algorithm


### 3. For tree - related problem please consider divide it to sub-trees
* Use DFS but not BFS to solve sub-tree problems. Please realize that root.left and root.right is the same tree as root.
* We can apply the same function to all sub-trees because they are all the same.
* Example：545. Boundary of Binary Tree.

### 4. For problems about game theory
* Use BFS to traverse all possible conditions step by step
* Sometimes we can start from the must win result and traverse back to find all must win startting conditions. 
* Please consider minimax in zero-sum problems. The minimax algorithm is normally about using dfs to tarverse all possible states. And form the terminal node we must trace back to the root. For each Player's state, we selete the max or min value from its children that most benefit either of them.
* Example: 913. Cat and Mouse, 464. Can I Win

### 5. For Parser Problem
* There is a modularized solution using dfs
* Example: 736. Parse Lisp Expression, 1096. Brace Expansion II

### 6. For Problems about Sliding Window or Two Pointers
* [Reference Discussion](https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem)
* Example: 438. Find All Anagrams in a String, 76. Minimum Window Substring, 3. Longest Substring Without Repeating Characters, 30. Substring with Concatenation of All Words, 159. Longest Substring with At Most Two Distinct Characters, 438. Find All Anagrams in a String

### 7. For Problems about Binary Search
* Sometimes we not only need to find a specific number in an array but also need to find the most right one or the most left one.
* For the most right one case, besides testing if mid - 1 is satisfied every time, we can simply set end = mid every time when we find mid is satisifed. When the termination condition is arrived (start < end), end and start is pointing to the most right satisifed answer. 
* Example: 1011. Capacity To Ship Packages Within D Days

### 8. Traveling Sales Man Problem
* Reference to [Travelling Salesman Problem | Dynamic Programming | Graph Theory](https://www.youtube.com/watch?v=cY4HiiFHO1o)
* Example: 943. Find the Shortest Superstring

### 9. For Problems about sorted array
* There are many porperties about sorted array. 
* One key point is that when we choose a position in an array we can determine if it is in the correct position(will it stay in the same position after we sort the whole array?) by some method. If the maxmium value in its left smaller than the smallest value in its right, we are sure that it is in the correct position. In other words, we can sort the left part and right part separately and concatenate them together to form the whole sorted list. There's no swap from left part to right part is needed.
* Example: 769. Max Chunks To Make Sorted, 768. Max Chunks To Make Sorted II

### 10. For Problems about finding repeated substrings in a string
* We could use 2 sets; one to recored all substrings we have ever seen, the other to recored substrings that could not be added to the first string (we have seen it before). Finally all strings that appear in the second set are the result.
* Example: 187. Repeated DNA Sequences

### 11. For Problems about finding the maximum subarray in an array
* Kadane’s algorithm
* Example: 1186. Maximum Subarray Sum with One Deletion

### 12. For Problems about divide and conquer
* When problems can be divided into some sub-problems and all sub-problems are similiar and they contribute to slove the original problem, we can try to solve them by using divide and conquer.
* I think (may not right) that divide and conquer are a kind of backtracking with minimize the size of problem when tracking down
* Example: 241. Different Ways to Add Parentheses

### 13. For Problems about keeping two or more records during traversing
* Sometimes we want to "slow update" something. For example, we want to find the longest increasing subsequence in an array. When we see a  new number, which is smaller than the smallest number we have ever seen, we want to keep a record of it but we have already have a length 4 subsequence so far we don't want to drop it, what would we do? The solution is very easy, just update the first evelement's value!!
* By doing so, we reocrd both the smallest element and the longest increasing sub-sequence so far. It's really hard to describe it more, please see the example(s) below.
* Example: 334. Increasing Triplet Subsequence
