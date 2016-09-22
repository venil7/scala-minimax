package com.darkruby.minimax

class Board() {
  private val LENGTH = 9
  val _fields: Array[Field] = Array.fill(9)(Empty)

  def move(index: Int, field: Field): Board = {
    val board = new Board()
    board._fields.update(index, field)
    board
  }

  override def toString(): String = {
    _fields
      .grouped(3)
      .map(_.mkString)
      .mkString("\n", "\n", "\n");
  }

}
