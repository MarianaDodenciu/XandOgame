package ro.siit.entity;

import java.util.UUID;

public class Xo {

    private char[][] board = new char[3][3];
    private UUID id;


    public Xo(String boardPosition){

        String[] split = boardPosition.substring(1, boardPosition.length()-1).split(",");
        for(int i=0; i< split.length; i++){
            split[i] = split[i].replace("\"", "");
            System.out.println(split[i]);
            if("".equals(split[i])){
                board[i/3][i%3] = '-';
            }
            if("X".equals(split[i])){
                board[i/3][i%3] = 'x';
            }
            if("O".equals(split[i])){
                board[i/3][i%3] = 'o';
            }
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'x' || board[i][j] =='o') {
                     return true;
                }
            }
        }
        return false;
    }

    public boolean checkAnyThreeValues(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    public boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (checkAnyThreeValues(board[i][0], board[i][1], board[i][2]) == true)
                return true;
        }
        return false;
    }

    public boolean checkColumn() {
        for (int j = 0; j < 3; j++) {
            if (checkAnyThreeValues(board[0][j], board[1][j], board[2][j]) == true)
                return true;
        }
        return false;
    }

    private boolean checkDiagonal() {
        return  (checkAnyThreeValues(board[0][0], board[1][1], board[2][2]) == true
                || (checkAnyThreeValues(board[0][2], board[1][1], board[2][0]) == true));

    }


    public boolean winningCondition(){
        if(checkRow() || checkColumn() || checkDiagonal() == true){
            return true;
        }
        return false;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
