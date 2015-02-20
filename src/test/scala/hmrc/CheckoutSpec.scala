package hmrc

import org.specs2.mutable._

class CheckoutSpec extends Specification {

  "Empty shopping cart" should {
    "cost zero" in {
      val emptyShoppingList: List[String] = List()
      new Checkout().scan(emptyShoppingList) must_== 0
    }
  }
}
