package io.langridge.punnit

class Word (val signifier:String, val phonemes:List[String]) {

	def rhymesWith(word: Word) :Boolean = {
		this.lastSyllable == word.lastSyllable
	}

	def lastSyllable :List[String] = {
		val splitOnLastVowel = phonemes.reverse.span(p => !isVowelSound(p))
		splitOnLastVowel._2.head :: splitOnLastVowel._1.reverse
	}



	def isVowelSound (phoneme: String) :Boolean = {
		phoneme matches ".*[AEIOU].*"
	} 
}
