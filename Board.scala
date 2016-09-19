trait Field { }
object Empty extends Field {
  override def toString: String = "[ ]"
}
object X extends Field {
  override def toString: String = "[X]"
}
object O extends Field {
  override def toString: String = "[O]"
}


class Board() {
  private val LENGTH = 9
  private val fields: Array[Field] = (for(i <- 0 until LENGTH) yield Empty).toArray

  def move(index: Int, field: Field): Board = {
    val board = new Board()
    board.fields.update(index, field)
    return board
  }

  override def toString(): String = {
    val row1 = fields.take(3);
    val row2 = fields.slice(3,6);
    val row3 = fields.takeRight(3);
    return s"${row1.mkString}\n${row2.mkString}\n${row3.mkString}"
  }

}

println(new Board().move(4, X));