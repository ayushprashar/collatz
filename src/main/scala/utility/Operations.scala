package utility

object Operations {

  def checkExistence(toFind: Int, domain: List[Int]): Boolean = {
    def subCheckExistence(newDomain: List[Int], flag: Int): Int = {
      newDomain match {
        case head :: Nil if head != toFind => -1
        case head :: tail if head != toFind => subCheckExistence(tail, flag)
        case head :: _ if head == toFind => flag
        case _ => -1
      }
    }

    if (subCheckExistence(domain, 0) == 0) {
      true
    }
    else {
      false
    }
  }

  def printFromN(inputNumber: Int, originalDomain: List[Int]): String = {
    def printTillEnd(domain: List[Int]): String = {
      domain match {
        case head :: tail => s"$head ${printTillEnd(tail)}"
        case _ => " "
      }
    }

    originalDomain match {
      case head :: Nil if head == inputNumber => s"$head"
      case head :: Nil if head != inputNumber => s"$inputNumber doesn't exist in the list"
      case head :: tail if head == inputNumber => s"$head ${printTillEnd(tail)}"
      case head :: tail if head != inputNumber => printFromN(inputNumber, tail)
    }
  }

  def collatz(inputNumber: Int, inputList: List[Int], finalList: List[Int]): List[Int] = {
    if (checkExistence(inputNumber, inputList) || checkExistence(inputNumber, finalList)) {
      inputList ::: finalList
    }
    else {
      if (inputNumber % 2 == 0) {
        collatz(inputNumber / 2, inputList:+inputNumber, finalList)
      }
      else {
        collatz(3 * inputNumber + 1, inputList:+inputNumber, finalList)
      }
    }
  }
}
