package io.langridge.punnit

class Word (val signifier:String, val phonemes:List[String]) {

		def rhymesWith(word: Word) :Boolean = {
		true;
	}

	def lastSyllable :String = {
		phonemes.reverse.find (p => isVowelSound(p)).head
	}

	def isVowelSound (phoneme: String) :Boolean = {
		phoneme matches ".*[AEIOU].*"
	} 
}
