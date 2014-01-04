package io.langridge.punnit

class Reader {
	def Read(signifier: String) : Word = {
		new Word(signifier, Read(signifier, List()))
	}

	def Read(signifier: String, phonemes: List[String]): List[String] = {
		if(signifier.isEmpty) 
			phonemes
		else {
			
			val phoneme:String = signifier.head.toUpper match {
				case 'A' => "AE"
				case 'O' => "AA"
				case _ => signifier.head.toString
			} 
			Read(signifier.tail, phonemes ::: List(phoneme))
		} 		
	}

	
}