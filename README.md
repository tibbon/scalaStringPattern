# String Pattern Finder

The main StringPattern class is in `src/main/scala/StringPattern.scala`.
Tests are in `src/test/scala/StringPatternSpec.scala`.

StringPattern is initialized with a single string as the input.

`val example = new StringPattern("abcabcab")`

There are two public methods on StringPattern, `find` and `nextCharacter`. The first one returns the pattern in the string, and the second one returns the next character in the string based on the pattern.

## Logic

### find()

1. I take the full string and turn it into an array.
2. I'm incrementing through each element/index on the string, and slicing a sub-pattern from the first character, up to this one. If the string was `abcabc` then the first iteration it would slice `a` , then `ab`, then `abc`, etc.
3. Take the original string array, and group into sub-sets that are the length of this pattern. So if the original string was `abcabc` and the pattern under test was `ab` it would group it into 3 groups of 2 elements, `ab`, `ca`, `bc`.
4. Take these groups, and check that all of them match the chracters from the pattern.
5. If all of the sub-groups matched the pattern under test, then this is the shortest repeating pattern that covers the string- terminate the method and return this subpattern as a string.
6. If we go through the entire string, and there are no matches, then return the original string.

I believe the time complexity on this could be described as `O(n^2)` since we have to check through the entire string, and then through subgroups each time. This could probably be improved.

### nextCharacter()

1. Find the pattern using the find method.
2. Save the length of this pattern.
3. Split the original string up into groups the size of the pattern, and only take the last one.
4. Compare the pattern length to the length of this tail string. If it is the same, then save the index as `0`, otherwise, save the index as the length of the tail string.
5. Return the character from the pattern from at the index position found above.

## Lessons learned and Challenges

- Scala does remind me a lot of Ruby in many ways, which is good for going between them.
- Figuring out the toolchain (IDEA, sbt, ScalaTest) took longer than writing the code.
- Some opaque errors occurred (something about `java.lang.NoClassDefFoundError: scala/collection/GenTraversableOnce$class`) when I used the wrong version of Scala in the `build.sbt` file.
- It was unclear if the instructions about frequency-counting words in a phrase were intentional, related or a mistake. I didn't do that for this, but if I was to do it, I'd simply split the string on spaces, and then increment a Hash/HashMap's where each word is a key, and the value is the count.


## Improvements and To-do items

- Predict the next letter for a cycle that begins repeating, but does not complete a second cycle. Logically this isn't difficult, but fighting the toolchain slowed me down a bit.
- Learn how to effectively use SBT and an IDE such as IDEA effectively. I'd watch some screencasts to get more comfortable with the environment.
- Break out behaviors from the public methods into multiple private methods with good naming to make the steps clearer.
- Approach the problem a bit more functionally.
- Write code more idiomatically in Scala; surely I'm not using all of the best tools/methods available in the language and standard library.

## Tests

To run tests: `sbt test`
