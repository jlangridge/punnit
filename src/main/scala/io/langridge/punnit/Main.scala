package io.langridge.punnit

import scalax.io._
import java.util.Date

object Main extends App {      

	val songTitles = Resource.fromFile("dat/NumberOnes").lines().map(s => new Title(s))

     def printMatches (query: List[String]) = {
     	val words = query.map(q => WordStore.find(q).get) 
     	val matching = songTitles.filter(s => s.canBeSubstituted(words(0)))
     	matching.foreach(m => println(m.substitute(words(0)).mkString(" ") + " (" + m + ")"))

     }

     
     println(args.toList)
     printMatches(args.toList)
}