package io.langridge.punnit

import scalax.io._

object Main extends App {
    
 
     val records = WordStore.records


     val testWord = WordStore.find("booze").get    

     val songTitles = Resource.fromFile("dat/NumberOnes").lines().map(s => new Title(s))

     val matching = songTitles.filter(s => s.canBeSubstituted(testWord)).map(s => s.substitute(testWord))
     
     println(matching.map(m => m.mkString(" ")).mkString("\n"))

}