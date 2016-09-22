package com.darkruby.minimax

trait Player
object Nobody extends Player { override def toString = "Nobody" }
object Human extends Player { override def toString = "Human" }
object CPU extends Player { override def toString = "CPU" }