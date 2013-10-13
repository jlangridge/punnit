package io.langridge.punnit

class Title (title: String) {

	def words: List[Word] = {
		val tokenized = title.split(" ").toList
		tokenized.map(word => WordStore.find(word).getOrElse(new Word(word, List(""))))
	}



	def canBeSubstituted(word: Word) :Boolean = {
		words.exists(w => w.canBeSubstitutedFor(word))
	}


		words.foldLeft(false)((a, b) => a && canBeSubstituted(b))
	}

	def canBeSubstituted(words: List[Word]):Boolean = {

	def anyCanBeSubstituted(words: List[Word]): Boolean = {
		words.foldLeft(false)((a, b) => a || canBeSubstituted(b))
	}

	def substitute(word: Word) = {
		words.map(w => w match {
			case w if(w.canBeSubstitutedFor(word)) => word
			case _ => w
			})
	}

	def substituteAll(substituteWords: List[Word]) = {
		substituteWords.map(w => substitute(w))
	}

	override def toString() = {
		title
	}


}