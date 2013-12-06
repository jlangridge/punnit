package io.langridge.punnit

class Reader {
	def Read(signifier: String) : Word = {
		new Word(signifier, Read(signifier, List()))
	}

	def Read(signifier: String, phonemes: List[String]): List[String] = {
		if(signifier.isEmpty) 
			phonemes
		else if(signifier.head.toUpper == 'A')
			Read(signifier.tail, "AE"::phonemes)
		else if(signifier.head.toUpper == 'O')
			Read(signifier.tail, "AA"::phonemes)
		else
			Read(signifier.tail, phonemes)
	}

	
}