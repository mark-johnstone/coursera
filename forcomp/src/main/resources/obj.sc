object obj {

  val initialList: List[Char] = "this is a test string TT".toList

  def countLetters2(chars: List[(Char)]): List[(Char, Int)] = {
    println(chars)
    chars match {
      case x :: xs if (xs.isEmpty) => List((x.toLower, 1))
      case x :: _ => List((x.toLower, chars.filter(y => y.toLower == x.toLower).size)) ::: countLetters2(chars.filter(y => y.toLower != x.toLower))
    }
  }

  countLetters2(initialList)

}