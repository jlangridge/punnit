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

	def syllableCount :Int = {
		phonemes.foldLeft(0) ((a, p) => p match {
			case p if (isVowelSound (p)) => a+1
			case _ => a
			})
	}

	def canBeSubstitutedFor(word: Word) :Boolean = {
		this.syllableCount == word.syllableCount && 
		this.rhymesWith(word)
	}
}
