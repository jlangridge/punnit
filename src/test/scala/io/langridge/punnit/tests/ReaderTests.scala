package io.langridge.punnit

import org.scalatest.FunSuite
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class ReaderTests extends FunSuite with ShouldMatchers {
	
	def reader = new Reader()

	test("Read a basic AE") {
		val word = reader.Read("At")
		word.phonemes.head should be === "AE"
	}

	test("Read a basic AA") {
		val word = reader.Read("odd")
		word.phonemes.head should be === "AA"
	}

}