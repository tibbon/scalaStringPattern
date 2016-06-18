import org.scalatest._

class StringPatternSpec extends FunSpec with Matchers {
  describe("A StringPattern") {
    describe("#find") {
      describe("when input is a short repeating string") {
        val example_string_pattern = new StringPattern("ababababab")

        it("returns the correct pattern") {
          example_string_pattern.find() should equal("ab")
        }
      }

    describe("when input is non-repeating") {
        val example_string_pattern = new StringPattern("1234567")

        it("returns the original string") {
          example_string_pattern.find() should equal("1234567")
        }
      }
    }
  }

  describe("#nextCharacter") {
    describe("when the input is non-repeating") {
      val example_string_pattern = new StringPattern("1234567")

      it("returns the first character in the pattern") {
          example_string_pattern.nextCharacter() should equal('1')
        }
    }
    describe("when the input pattern completely loops") {
      val example_string_pattern = new StringPattern("123123123123")

      it("returns the first character in the pattern") {
          example_string_pattern.nextCharacter() should equal('1')
        }
    }
    describe("when the input pattern partially loops") {
      val example_string_pattern = new StringPattern("1234512345123")

      it("returns the next character from within the pattern") {
          example_string_pattern.nextCharacter() should equal('4')
        }
    }

  }
}
