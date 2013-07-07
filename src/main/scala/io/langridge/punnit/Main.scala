package io.langridge.punnit

import scalax.io._
import java.util.Date

object Main extends App {      

	val songTitles = Resource.fromFile("dat/NumberOnes").lines().map(s => new Title(s))

     def printMatches (word: Word) = {
     	val matching = songTitles.filter(s => s.canBeSubstituted(word)).map(s => s.substitute(word))
     	println(matching.map(m => m.mkString(" ")).mkString("\n"))
     }

     printMatches(WordStore.find("kiss").get)
}