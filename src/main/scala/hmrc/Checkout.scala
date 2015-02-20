package hmrc

import scala.collection.immutable.Iterable

object Checkout {
  def applyAppleOffer(numberOfApples: Int): Int = ((numberOfApples / 2) + (numberOfApples % 2)) * 60
  def applyOrangeOffer(numberOfOranges: Int): Int = ((numberOfOranges  % 3 * 25) + (numberOfOranges / 3 * 2 * 25))
}

class Checkout {

  import Checkout._

  def scan(shoppingCart: List[String]): Int = {

    val costAfterOfferApplied: Iterable[Int] = shoppingCart.groupBy(item => item).map { case (item, itemList) => {
      if (item == "apple")
        applyAppleOffer(itemList.size)
      else
       applyOrangeOffer(itemList.size)
    }
    }

    costAfterOfferApplied.foldLeft(0)((acc, singleItemCost) => acc + singleItemCost)
  }
}
