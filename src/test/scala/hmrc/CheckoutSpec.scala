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
    "cost 60p because of the buy one get one free offer" in {
      val twoAppleShoppingCart: List[String] = List("apple", "apple")
      new Checkout().scan(twoAppleShoppingCart) must_== 60
    }
  }

  "Three apples" should {
    "cost 120p because of the buy one get one free offer" in {
      val threeAppleShoppingCart: List[String] = List("apple", "apple", "apple")
      new Checkout().scan(threeAppleShoppingCart) must_== 120
    }
  }

  "Two oranges" should {
    "cost 50p" in {
      val twoOrangeShoppingCart: List[String] = List("orange", "orange")
      new Checkout().scan(twoOrangeShoppingCart) must_== 50
    }
  }

  "Three oranges" should {
    "cost 50p because of the 3 for the price of 2 offer" in {
      val threeOrangeShoppingCart: List[String] = List("orange", "orange", "orange")
      new Checkout().scan(threeOrangeShoppingCart) must_== 50
    }
  }

  "Four oranges" should {
    "cost 75p because of the 3 for the price of 2 offer" in {
      val fourOrangeShoppingCart: List[String] = List("orange", "orange", "orange", "orange")
      new Checkout().scan(fourOrangeShoppingCart) must_== 75
    }
  }

  "Mixed 3 apple and one orange shopping cart" should {
    "cost 145p because of apple and orange offers" in {
      val mixedAppleOrangeShoppingCart: List[String] = List("apple", "apple", "orange", "apple")
      new Checkout().scan(mixedAppleOrangeShoppingCart) must_== 145
    }
  }

  "Mixed 3 apple and 4 oranges shopping cart" should {
    "cost 195p because of apple and orange offers" in {
      val mixedAppleOrangeShoppingCart: List[String] = List("apple", "apple", "orange", "apple", "orange", "orange", "orange")
      new Checkout().scan(mixedAppleOrangeShoppingCart) must_== 195
    }
  }

}
