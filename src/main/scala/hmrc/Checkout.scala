package hmrc

import scala.collection.immutable.Iterable

class Checkout {
  def scan(shoppingCart: List[String]): Int = {

    val costAfterOfferApplied: Iterable[Int] = shoppingCart.groupBy(item => item).map { case (item, itemList) => {
      if (item == "apple")
        ((itemList.size / 2) + (itemList.size % 2)) * 60
      else
        itemList.size * 25
     }
    }

    costAfterOfferApplied.foldLeft(0)((acc, singleItemCost) => acc + singleItemCost)
  }
}
