class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    enlarge(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void enlarge(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') 
            return;
        
        grid[i][j] = 0;
        enlarge(grid, i, j + 1);
        enlarge(grid, i, j - 1);
        enlarge(grid, i + 1, j);
        enlarge(grid, i - 1, j);
               
    }
}