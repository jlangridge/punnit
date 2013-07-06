package io.langridge.punnit.tests

import org.scalatest.FunSuite
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import io.langridge.punnit.Word

class WordSuite extends FunSuite with ShouldMatchers {
	
	val testWord = new Word("ZYGOTE", "Z AY1 G OW0 T".split(" ").toList)

	test("Assert the truth"){
		assert(true == true)
	}

	test("Create a new word") {
		testWord.signifier should be === "ZYGOTE"
	}

	test("Last syllable should return the correct phoneme") {
		testWord.lastSyllable should be === List("OW0", "T")
	}

	test("Is vowel phoneme should return true for vowel sounds") {
		testWord.isVowelSound("OW0") should be === true
	}
	test("Is vowel phoneme should return false for consonant sounds") {
		testWord.isVowelSound("T") should be === false
	}

}