# leetcode - notes
### 1. dps/backtracking with memorization could only be used on bottom-up manner. 
* If we try to use a up to bottom manner, it's hard to implement memorization.
* BFS is also hard to use with memorization because it's hard to know some true result before all branches reach the end.
* But we can cut some visited branches in BFS
* Example: 140. Word Break II
   
### 2. For dynamic programming, please not only consider look back but also consider look forward.
* Example: 403. Frog Jump
