package com.darkruby.minimax

class Board(private val fields:Array[Field] = Array.fill(9)(Empty)) {
  private val LENGTH = 9
  private val COMBINATIONS = Array(
    (0, 1, 2), (3, 4, 5), (6, 7, 8),
    (0, 3, 6), (1, 4, 7), (2, 5, 8),
    (0, 4, 8), (2, 4, 6))

  def move(index: Int, field: Field): Board = {
      val _fields = fields.clone()
      _fields(index) = field
      new Board(_fields)
  }

  def state(): State = {
    for (indices <- COMBINATIONS) {
      val combination = (fields(indices._1), fields(indices._2), fields(indices._3))
      combination match {
        case (X, X, X) => return HumanWins //good luck :)
        case (O, O, O) => return CpuWins
        case _ => { }
      }
    }

    val moves = possibleMoves;
    if (moves.isEmpty) {
      return Draw
    }

    return new State(possibleMoves = moves)
  }

  def possibleMoves: Array[Int] = {
    (for (index <- 0 until LENGTH; if (fields(index) == Empty))
      yield index).toArray
  }

  def minimax(board: Board = this, field: Field, depth: Int = 1):Eval = {
    val boardState = board.state()
    boardState match {
      case CpuWins => Eval(score = 10 - depth)
      case HumanWins => Eval(score = depth - 10)
      case Draw => Eval()
      case State(false, possibleMoves, _) => {
        val evaluatedMoves = for(move <- possibleMoves) yield {
          val boardClone = board.move(move, field)
          val score = minimax(boardClone, field.reverse, depth + 1).score
          Eval(move, score)
        }

        val sortedMoves = evaluatedMoves.sorted
        field match {
          case X => sortedMoves.head
          case O => sortedMoves.last
          case _ => throw new Exception("Only set X|O")
        }
      }
    }
  }

  def cpu(): Board = {
    val eval = minimax(this, O)
    move(eval.position, O)
  }

  override def toString(): String = {
    fields
      .grouped(3)
      .map(_.mkString)
      .mkString("\n", "\n", "\n");
  }

}
