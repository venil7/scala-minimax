package com.darkruby.minimax

class Board() {
  private val LENGTH = 9
  val COMBINATIONS = Array(
    (0, 1, 2), (3, 4, 5), (6, 7, 8),
    (0, 3, 6), (1, 4, 7), (2, 5, 8),
    (0, 4, 8), (2, 4, 6))
  val _fields: Array[Field] = Array.fill(9)(Empty)

  def move(index: Int, field: Field): Board = {
    val board = new Board()
    board._fields.update(index, field)
    board
  }

  def state(): State = {
    for (indices <- COMBINATIONS) {
      (_fields(indices._1), _fields(indices._2), _fields(indices._3)) match {
        case (X, X, X) => return HumanWins //good luck :)
        case (O, O, O) => return CpuWins
      }
    }

    val possibleMoves = this.possibleMoves
    if (possibleMoves.isEmpty) {
      return Draw
    }

    return new State(possibleMoves = possibleMoves)
  }

  def possibleMoves: Seq[Int] = {
    for (index <- 0 until LENGTH; if (_fields(index) != Empty))
      yield index
  }

  override def toString(): String = {
    _fields
      .grouped(3)
      .map(_.mkString)
      .mkString("\n", "\n", "\n");
  }

}
