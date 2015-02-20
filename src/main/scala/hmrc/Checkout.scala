package hmrc

class Checkout {
  def scan(shoppingCart: List[String]): Int = {
    shoppingCart match {
      case Nil => 0
      case _ => 60
    }
  }
}
