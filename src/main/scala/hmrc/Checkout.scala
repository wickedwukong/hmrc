package hmrc

class Checkout {
  def scan(shoppingCart: List[String]): Int = {
    shoppingCart match {
      case Nil => 0
      case item :: tail if item.equals("apple") => 60
      case _ => 25
    }
  }
}
