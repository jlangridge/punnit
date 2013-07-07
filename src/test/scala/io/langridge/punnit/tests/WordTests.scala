package io.langridge.punnit.tests

import org.scalatest.FunSuite
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import io.langridge.punnit.Word

class WordTests extends FunSuite with ShouldMatchers {
	
	def word(record: String) : Word = {
		val tokenized = record.split(" ")
		new Word(tokenized.head, tokenized.tail.toList)
	}

	val testWord = word("MISSION M IH1 SH AH0 N")

	test("Assert the truth"){
		assert(true == true)
	}

	test("Create a new word") {
		testWord.signifier should be === "MISSION"
	}

	test("Last syllable should return the correct phoneme") {
		testWord.lastSyllable should be === List("AH0", "N")
	}

	test("Is vowel phoneme should return true for vowel sounds") {
		testWord.isVowelSound("AH0") should be === true
	}
	
	test("Is vowel phoneme should return false for consonant sounds") {
		testWord.isVowelSound("T") should be === false
	}

	test("Words that do not rhyme should return false for rhymesWith") {
		val nonRhyming = word ("ACCOMPANIED AH0 K AH1 M P AH0 N IY0 D")
		testWord.rhymesWith(nonRhyming) should be === false
	}

	test("Words that do rhyme should return true for rhymesWith") {
		val rhyming = word ("MODERATION M AA2 D ER0 EY1 SH AH0 N")
		testWord.rhymesWith(rhyming) should be === true
	}

	test ("SyllableCount should return the correct number of syllables for a word") {
		testWord.syllableCount should be === 2
	}

	test ("Words that match syllable counts and rhyme should be substitutable") {
		testWord.canBeSubstitutedFor(word("FISSION  F IH1 SH AH0 N")) should be === true
	}

	test ("Vowels should return all vowel phonemes from the word") {
		testWord.vowels should be === List("IH1", "AH0")
	}

}