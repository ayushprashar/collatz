import org.apache.log4j.Logger
import utility.Operations
object Application extends App {
  val log = Logger.getLogger(this.getClass)
  val firstTreeVariable:Int = 50
  val secondTreeVariable:Int = 22
  val treeForFirstTreeVariable = Operations.collatz(firstTreeVariable,List(),List())
  log.info(s"$treeForFirstTreeVariable \n")
  log.info(s"${Operations.printFromN(secondTreeVariable,Operations.collatz(secondTreeVariable,List(),treeForFirstTreeVariable))}")
}
