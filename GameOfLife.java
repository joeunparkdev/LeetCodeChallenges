class Solution {
    public void gameOfLife(int[][] board) {
        int x_size=board.length;
        int y_size=board[0].length;
        int [][]output_array =new int [x_size][y_size];
        
        
        for (int i=0;i<x_size;i++){
            for (int j=0; j<y_size; j++){
                if (should_we_put_this_cell_alive(board,i,j)){
                    output_array[i][j]=1;
                }
                else {
                    output_array[i][j]=0;
                }
            }
        }
     for (int i=0;i<x_size;i++){
            for (int j=0; j<y_size; j++){
               board[i][j] = output_array[i][j]; } 
     }
    }
    
    public boolean should_we_put_this_cell_alive(int[][] board, int i, int j) {
        
            int x_size=board.length;
            int y_size=board[0].length;
            int count = 0;
        
        for (int x=0;x<3;x++){
            for (int y=0; y<3;y++){
                int x_position=i-1+x;
                int y_position=j-1+y;
                if (outside_of_board(x_size, y_size, x_position, y_position)) {
                    continue;
                }
                if (x_position==i&&y_position==j){
                    continue;
                }
                if (board[x_position][y_position]==1){
                    count++;
                }
            }
        }
                    if(board[i][j] == 1){
                        if (count <2) {
                            return false;
                        }
                        if (count==2||count==3) {
                            return true;
                        }
                        if (count >3){
                            return false;
                        }
                    }
                    else { //dead case
                        if (count ==3) {
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
        return false;
    }
    public boolean outside_of_board (int x_size, int y_size, int x_position,int y_position){
        if (x_size<=x_position||y_size<=y_position){
            return true;
        }
        if (x_position<0||y_position<0){
            return true;
        }
        else
           return false;
    }     
}
