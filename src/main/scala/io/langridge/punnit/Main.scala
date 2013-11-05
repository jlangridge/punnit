package io.langridge.punnit

import scalax.io._
import java.util.Date

object Main extends App {      

	val songTitles = Resource.fromFile("dat/NumberOnes").lines().map(s => new Title(s))

     def printMatches (query: List[String]) = {
     	val words = query.map(q => WordStore.find(q).get) 
     	val matching = songTitles.filter(s => s.canBeSubstituted(words)).map(s => s.substitute(words))
     	println(matching.map(m => m.mkString(" ")).mkString("\n"))
     }

     val selection = List("bean", "carrot", "sprout")

     printMatches(selection)
}