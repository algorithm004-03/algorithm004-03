public class Solution
{
    public int NumIslands(char[][] grid)
    {
        int m = grid.Length;
        if (m == 0)
            return 0;
        int n = grid[0].Length;
        if (n == 0)
            return 0;

        // Create forest
        UFSet unionSet = new UFSet(n * m);
        int nonGrouped = 0;
        for (int row = 0; row < m; row++)
        {
            for (int column = 0; column < n; column++)
            {
                if (grid[row][column] == '0')
                {
                    nonGrouped++;
                    continue;
                }

                // Check Neighbors
                /// index into the array for row,column
                int currentRowColumn = row * n + column;
                // left
                if ((column - 1) >= 0 && grid[row][column - 1] == '1')
                    unionSet.Union(currentRowColumn, currentRowColumn - 1);
                // top
                if ((row - 1) >= 0 && grid[row - 1][column] == '1')
                    unionSet.Union(currentRowColumn, (row - 1) * n + column);
            }
        }

        return unionSet.GroupCount - nonGrouped;
    }

    private ref struct UFSet
    {
        private Span<int> _elementSet;
        private Span<int> _rankHeight;
        private int _groupCount;

        public UFSet(int size)
        {
            _elementSet = new Span<int>(new int[size]);
            // Init parents to self
            for (int i = 0; i < size; ++i)
                _elementSet[i] = i;
            _rankHeight = new Span<int>(new int[size]);
            _groupCount = size;
        }

        public int Find(int element)
        {
            int id = element;
            while (id != _elementSet[id])
            {
                // Compress path
                _elementSet[id] = _elementSet[_elementSet[id]];
                id = _elementSet[id];
            }
            return id;
        }

        public int GroupCount => _groupCount;

        public void Union(int x, int y)
        {
            int xRoot = Find(x);
            int yRoot = Find(y);
            // Already joined
            if (xRoot == yRoot)
                return;

            // x less than y, so place x under y
            if (_rankHeight[xRoot] < _rankHeight[yRoot])
                _elementSet[xRoot] = yRoot;
            // y less than x, so place y under x
            else if (_rankHeight[yRoot] < _rankHeight[xRoot])
                _elementSet[yRoot] = xRoot;
            // heights are equal, doesn't matter which goes under which
            else
            {
                // place x under y, increase height of y
                _elementSet[xRoot] = yRoot;
                _rankHeight[yRoot]++;
            }
            // each combination is one less group
            _groupCount--;
        }
    }
}