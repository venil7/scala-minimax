package com.darkruby.minimax

trait Field
object Empty extends Field { override def toString = "[ ]" }
object X extends Field { override def toString = "[X]" }
object O extends Field { override def toString = "[O]" }