package hmrc

import org.specs2.mutable._

class CheckoutSpec extends Specification {

  "One babana shopping cart" should {
    "cost 20p" in {
      val oneBananaShoppingCart: List[String] = List("banana")
      new Checkout().scan(oneBananaShoppingCart) must_== 20
    }
  }

  "Two babanas only shopping cart" should {
    "cost 20p because buy one get one free offer" in {
      val twoBananaOnlyShoppingCart: List[String] = List("banana", "banana")
      new Checkout().scan(twoBananaOnlyShoppingCart) must_== 20
    }
  }

  "One apple and one banana only shoppng cart" should {
    "cost 60p because the cheapest one go free offer" in {
      val twoBananaOnlyShoppingCart: List[String] = List("apple", "banana")
      new Checkout().scan(twoBananaOnlyShoppingCart) must_== 60
    }
  }

  "two apples and one banana only shoppng cart" should {
    "cost 60p because the cheapest one go free offer" in {
      val twoApplesOneBananaOnlyShoppingCart: List[String] = List("apple", "apple", "banana")
      new Checkout().scan(twoApplesOneBananaOnlyShoppingCart) must_== 120
    }
  }

  "two apples and two bananas only shopping cart" should {
    "cost 60p because the cheapest one go free offer" in {
      val twoApplesTwoBananasOnlyShoppingCart: List[String] = List("apple", "banana", "banana", "apple")
      new Checkout().scan(twoApplesTwoBananasOnlyShoppingCart) must_== 120
    }
  }

  "tree apples and one bananas only shopping cart" should {
    "cost 60p because the cheapest one go free offer" in {
      val threeApplesOneBananasOnlyShoppingCart: List[String] = List("apple", "apple", "banana", "apple")
      new Checkout().scan(threeApplesOneBananasOnlyShoppingCart) must_== 120
    }
  }

  "One apple and two banana" should {
    "cost 80p because" in {
      val twoAppleOneBananaOnlyShoppingCart: List[String] = List("apple", "banana", "banana")
      new Checkout().scan(twoAppleOneBananaOnlyShoppingCart) must_== 80
    }
  }


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
