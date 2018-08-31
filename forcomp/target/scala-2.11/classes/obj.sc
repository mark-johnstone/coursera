object obj {

  val initialList: List[Char] = "this is a test string TT".toList

  def countLetters2(chars: List[(Char)]): List[(Char, Int)] = {
    println(chars)
    chars match {
      case x :: xs if (xs.isEmpty) => List((x.toLower, 1))
      case x :: _ => List((x.toLower, chars.filter(y => y.toLower == x.toLower).size)) ::: countLetters2(chars.filter(y => y.toLower != x.toLower))
    }
  }

  val occurences: List[(Char, Int)] = countLetters2(initialList)

  object forcomp {
    val dictionaryPath = List("forcomp", "linuxwords.txt")

    def loadDictionary = {
      val wordstream = Option {
        getClass.getResourceAsStream(dictionaryPath.mkString("/"))
      } orElse {
        common.resourceAsStreamFromSrc(dictionaryPath)
      } getOrElse {
        sys.error("Could not load word list, dictionary file not found")
      }
      try {
        val s = io.Source.fromInputStream(wordstream)
        s.getLines.toList
      } catch {
        case e: Exception =>
          println("Could not load word list: " + e)
          throw e
      } finally {
        wordstream.close()
      }
    }

  }

  val dictionaryList: List[(String)] = forcomp.loadDictionary

  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = {
    val dictionaryList: List[(String)] = forcomp.loadDictionary

    dictionaryList.filter(_.length < occurences.size)

    println(    dictionaryList.filter(_.length < occurences.size)
    )
    Map(dictionaryList.filter(_.length < occurences.size), occurences)


  }



}