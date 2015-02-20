package hmrc

class Checkout {
  def scan(shoppingCart: List[String]): Int = {
    shoppingCart.map(item => if (item == "apple") 60 else  25).foldLeft(0)((acc, singleItemCost) => acc + singleItemCost)
  }
}
