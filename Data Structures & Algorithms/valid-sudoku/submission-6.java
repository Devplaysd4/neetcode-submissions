class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i =0;i<9;i++){
            HashSet<Character>set=new HashSet<>();
            for (int j=0;j<9;j++){
                if (board[i][j]=='.')continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        for (int j = 0; j < 9; j++) {
            HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            if (board[i][j] == '.') continue;

            if (set.contains(board[i][j]))
                return false;

            set.add(board[i][j]);
    }
}
for (int rowstart=0;rowstart<9;rowstart+=3){
    for (int colstart=0;colstart<9;colstart+=3){
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                char current = board[rowstart+i][colstart+j];
                if (current == '.')continue;
                if (set.contains(current))
                    return false;
                set.add(current);
            }
        }
    }
}
return true;
    }
}
