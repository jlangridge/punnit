package io.langridge.punnit

import scalax.io._

object WordStore {
	
     val input:Input = Resource.fromFile("dat/mpron/cmudict0.3")
     val parsed = input.lines().filter(line => line matches "[A-Z].*")
     val records = parsed.map(line => readWord(line)).toList

     def readWord(line:String):Word = {
     	val lineList = line.split(" ").toList
        return new Word(lineList.head, lineList.tail)
     }

     def find (signifier: String) = {
     	records.find(r => r.signifier.equalsIgnoreCase(signifier))
     }
    
     
}