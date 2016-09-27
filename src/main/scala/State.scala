package com.darkruby.minimax

case class State(
  gameOver: Boolean = false,
  possibleMoves: Seq[Int] = Nil,
  winner: Player = Nobody) {
}

object CpuWins extends State(true, winner = CPU)
object HumanWins extends State(true, winner = Human)
object Draw extends State(true)