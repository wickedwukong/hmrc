package hmrc

import org.specs2.mutable._

class CheckoutSpec extends Specification {

  "Empty shopping cart" should {
    "cost zero" in {
      val emptyShoppingCart: List[String] = List()
      new Checkout().scan(emptyShoppingCart) must_== 0
    }
  }

  "An apple" should {
    "cost 60p" in {
      val oneAppleOnlyShoppingCart: List[String] = List("apple")
      new Checkout().scan(oneAppleOnlyShoppingCart) must_== 60
    }
  }

  "An orange" should {
    "cost 25p" in {
      val oneOrangeOnlyShoppingCart: List[String] = List("orange")
      new Checkout().scan(oneOrangeOnlyShoppingCart) must_== 25
    }
  }
}
