package com.darkruby.minimax

class State(
  val gameOver: Boolean = false,
  val possibleMoves: Seq[Int] = Nil,
  val winner: Player = Nobody) {
}

object CpuWins extends State(true, winner = CPU)
object HumanWins extends State(true, winner = Human)
object Draw extends State(true)