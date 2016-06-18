class StringPattern(val fullString:String) {
  def find(): String = {
    val stringArray: Array[Char] = fullString.toCharArray
    stringArray.zipWithIndex.foreach { case(_, idx) =>
      val subPattern: Array[Char] = stringArray.slice(0, idx + 1)

      val sliceResults: Iterator[Boolean] = stringArray.grouped(subPattern.length).map { slice =>
        slice.zipWithIndex.forall { case (character, index) =>
          character == subPattern(index)
        }
      }

      if (sliceResults.forall { x => x }) return subPattern.mkString
    }
    fullString
  }

  def nextCharacter(): Char = {
    val pattern: String = find()
    val patternLength: Int = pattern.length
    val stringTail: Array[Char] = fullString.toCharArray.grouped(patternLength).toList.last

    val nextCharIndex: Int = if (patternLength == stringTail.length) {
      0
    } else {
      stringTail.length
    }

    pattern(nextCharIndex)
  }
}
