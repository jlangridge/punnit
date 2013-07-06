package io.langridge.punnit

import scalax.io._

object Main extends App {
    
    def readWord(line:String):Word = {
     	val lineList = line.split(" ").toList
        return new Word(lineList.head, lineList.tail)
     }


     val input:Input = Resource.fromFile("dat/mpron/cmudict0.3")
     val records = input.lines().map(line => readWord(line))
     
     val pattern = "ZYGOTE"
     val found = records.find(r => (r.signifier matches pattern)).head
     println(found.phonemes)

}


