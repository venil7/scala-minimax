package com.darkruby.minimax

object Game {
  def main(args: Array[String]) = {

    var board = new Board();
    do {
      println(board);
      println("move [0-8]: ");

      var i: Option[Int] = None

      do {
        i = try {
          Some(Console.readInt)
        } catch {
          case e:NumberFormatException => None
        }
      } while (i == None)

      board = board.move(i.get, X);
      board = board.cpu()

    } while (board.state.gameOver == false)

    println(board)
    println(board.state.winner + " wins!!");
  }
}