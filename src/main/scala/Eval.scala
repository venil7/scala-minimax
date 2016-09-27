package com.darkruby.minimax

case class Eval(position: Int = 0, score: Int = 0)
  extends Ordered[Eval] {
  def compare(other: Eval) = this.score.compareTo(other.score)
}