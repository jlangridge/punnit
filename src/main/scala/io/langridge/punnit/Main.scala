package io.langridge.punnit

import scalax.io._
import java.util.Date

object Main extends App {      

	val songTitles = Resource.fromFile("dat/NumberOnes").lines().map(s => new Title(s))

	def format(outWords: List[Word]) = {
		print(outWords.mkString(" "))
	}

	def printMatch(titleMatch:Title, query: List[Word]) = {
		query.map(w => if(titleMatch.canBeSubstituted(w)) {
				format(titleMatch.substitute(w)) 
				print (" - (")
				format(titleMatch.words)
				print (")")
				println
			} 
		)
	}

     def printMatches (query: List[String]) = {
     	val words = query.map(q => WordStore.find(q).get) 
     	val matching = songTitles.filter(s => s.anyCanBeSubstituted(words))
     	matching.foreach(m => printMatch(m, words))

     }

     printMatches(args.toList)
}