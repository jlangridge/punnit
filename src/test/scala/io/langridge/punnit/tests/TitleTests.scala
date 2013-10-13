package io.langridge.punnit.tests


import org.scalatest.FunSuite
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import io.langridge.punnit._

class TitleTests extends FunSuite with ShouldMatchers {
	val testTitle = new Title("Smack That")

	def word(signifier: String) ={
		WordStore.find(signifier).get
	}

	test ("Words should return a list of words from the title") {
		testTitle.words.head.signifier should be === "SMACK"
	}

	test("Substitutable Words should return the substitution") {
		testTitle.substitute(WordStore.find("Pack").get).head.signifier should be === "PACK"
	}

	test("CanBeSubstituted should return true if substitution is possible") {
		testTitle.canBeSubstituted(WordStore.find("Pack").get) should be === true
	}

	test("AnyCanBeSubstituted should return true if any word can be substituted") {
		val positive = List(word("Pack"), word("Mule"))
		testTitle.anyCanBeSubstituted(positive) should be === true
	}

}