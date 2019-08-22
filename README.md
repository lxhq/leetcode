# leetcode - notes
### 1. dps/backtracking with memorization could only be used on bottom-up manner.
* If we try to use a up to bottom manner, it's hard to implement memorization.
* BFS is also hard to use with memorization because it's hard to know some true result before all branches reach the end.
* But we can cut some visited branches in BFS.
* Example: 140. Word Break II, 1066. Campus Bikes II
   
### 2. For dynamic programming, please not only consider look back but also consider look forward
* Example: 403. Frog Jump.

### 3. For tree - related problem please consider divide it to sub-trees
* Use DFS but not BFS to solve sub-tree problems. Please realize that root.left and root.right is the same tree as root.
* We can apply the same function to all sub-trees because they are all the same.
* Example：545. Boundary of Binary Tree.
