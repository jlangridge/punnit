package io.langridge.punnit

class Title (title: String) {

	def words :List[Word] = {
		val tokenized = title.split(" ").toList
		tokenized.map(word => WordStore.find(word).getOrElse(new Word(word, List(""))))
	}

	def canBeSubstituted(word: Word) = {
		words.exists(w => w.canBeSubstitutedFor(word))
	}

	def substitute(word: Word) = {
		words.map(w => w match {
			case w if(w.canBeSubstitutedFor(word)) => word
			case _ => w
			})
	}


}