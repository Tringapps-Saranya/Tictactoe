package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public static Evaluation evaluateBoard(String board){
    String boardLower=board.toLowerCase();
    int countx=0;
    int counto=0;
    if(boardLower.length()!=9){
      return Evaluation.InvalidInput;
    }

    for(int i=0;i<boardLower.length();i++){
      if(boardLower.charAt(i)=='x'){
        countx++;
      }
      else if(boardLower.charAt(i)=='o'){
        counto++;
      }
    }
    if(Math.abs(counto-countx)>=2){
      return Evaluation.UnreachableState;
    }

    /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
    boolean xwins=win('x',boardLower);
    boolean owins=win('o',boardLower);

    if(xwins && owins){
      return Evaluation.UnreachableState;
    }
    else if(xwins){
      return Evaluation.Xwins;
    }
    else if(owins){
      return Evaluation.Owins;
    }
    else{
      return Evaluation.NoWinner;
    }
  }

  public static boolean win(char ch,String boardLower){
    for(int i=0;i<7;i+=3)
    {
      if(boardLower.charAt(i)==ch && boardLower.charAt(i+1)==ch && boardLower.charAt(i+2)==ch)
      return true;

    }
    for(int i=0;i<3;i++)
    {
    if(boardLower.charAt(i)==ch && boardLower.charAt(i+3)==ch && boardLower.charAt(i+6)==ch)
      return true;
    }

    if(boardLower.charAt(0)==ch && boardLower.charAt(4)==ch && boardLower.charAt(8)==ch)
      return true;
    return (boardLower.charAt(2)==ch && boardLower.charAt(4)==ch && boardLower.charAt(6)==ch);
  }
  public static void main(String[] args) {
    System.out.println(evaluateBoard("O...X.X.."));
    System.out.println(evaluateBoard("XXX...oo."));
    System.out.println(evaluateBoard("...Xxx.oo"));
    System.out.println(evaluateBoard("oo....xxx"));
    System.out.println(evaluateBoard("x..x..xoo"));
    System.out.println(evaluateBoard(".x..xoox."));
    System.out.println(evaluateBoard("..xoox..x"));
    System.out.println(evaluateBoard("x...x.oox"));
    System.out.println(evaluateBoard("..x.x.xoo"));
    System.out.println(evaluateBoard("O.."));
    System.out.println(evaluateBoard("O...X.X...."));
    System.out.println(evaluateBoard("Oooxxx..."));
    System.out.println(evaluateBoard("oxooxooxo"));
    }

}
