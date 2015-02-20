package hmrc

import scala.collection.immutable.Iterable

object Checkout {
  def applyAppleOffer(numberOfApples: Int): Int = ((numberOfApples / 2) + (numberOfApples % 2)) * 60
}

class Checkout {

  import Checkout._

  def scan(shoppingCart: List[String]): Int = {

    val costAfterOfferApplied: Iterable[Int] = shoppingCart.groupBy(item => item).map { case (item, itemList) => {
      if (item == "apple")
        applyAppleOffer(itemList.size)
      else
        itemList.size * 25
    }
    }

    costAfterOfferApplied.foldLeft(0)((acc, singleItemCost) => acc + singleItemCost)
  }
}
