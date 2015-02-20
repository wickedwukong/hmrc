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

  "Two apples" should {
    "cost 120p" in {
      val twoAppleShoppingCart: List[String] = List("apple", "apple")
      new Checkout().scan(twoAppleShoppingCart) must_== 120
    }
  }

  "Two oranges" should {
    "cost 50p" in {
      val twoOrangeShoppingCart: List[String] = List("orange", "orange")
      new Checkout().scan(twoOrangeShoppingCart) must_== 50
    }
  }

  "Mixed 3 apple and one orange shopping cart" should {
    "cost 205p" in {
      val mixedAppleOrangeShoppingCart: List[String] = List("apple", "apple", "orange", "apple")
      new Checkout().scan(mixedAppleOrangeShoppingCart) must_== 205
    }
  }

}
