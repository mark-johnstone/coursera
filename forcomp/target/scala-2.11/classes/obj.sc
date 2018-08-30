object obj {


  def findMultiples(chars: List[(Char)]): List[(Char, Int)] = {

    chars match {

      case x :: xs if (xs.isEmpty) => List((x, 1))
      case x :: xs => List((x, chars.filter(y => x == y).size))


    }
  }

  val initialList: List[Char] = List[Char]():::"this is a test string"

  findMultiples(initialList)
}