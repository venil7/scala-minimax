package com.darkruby.minimax

trait Field { override def toString = "[ ]" }
object Empty extends Field
object X extends Field { override def toString = "[X]" }
object O extends Field { override def toString = "[O]" }