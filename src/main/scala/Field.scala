package com.darkruby.minimax

trait Field {
  def reverse: Field = {
    (this) match {
      case X => O
      case O => X
      case _ => throw new Exception("Cant reverse empty field")
    }
  }
}
object Empty extends Field { override def toString = "[ ]" }
object X extends Field { override def toString = "[X]" }
object O extends Field { override def toString = "[O]" }