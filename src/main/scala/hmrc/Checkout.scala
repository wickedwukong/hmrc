package hmrc

import scala.collection.immutable.Iterable

object Checkout {
  def applyAppleOffer(numberOfApples: Int): Int = ((numberOfApples / 2) + (numberOfApples % 2)) * 60
  def applyBananaOffer(numberOfBananas: Int): Int = ((numberOfBananas / 2) + (numberOfBananas % 2)) * 20
  def applyOrangeOffer(numberOfOranges: Int): Int = ((numberOfOranges % 3 * 25) + (numberOfOranges / 3 * 2 * 25))
}

class Checkout {

  import Checkout._

  def scan(shoppingCart: List[String]): Int = {

    val applesAndBananas: List[String] = shoppingCart.filter(item => item == "apple" || item == "banana")

    val anythingElseApartFromAppleAndBananas: List[String] = shoppingCart.diff(applesAndBananas)

    val costOfNoneAppleAndNoneBanana: Int = anythingElseApartFromAppleAndBananas.groupBy(item => item).map { case (item, itemList) => {
      applyOrangeOffer(itemList.size)
    }
    }.sum


    val apples = applesAndBananas.filter(item => item == "apple")
    val bananas = applesAndBananas.filter(item => item == "banana")
    
    
    val deltaBetweenAppleAndBananas: Int = apples.length - bananas.length
    
    val costOfApplesAndBannanas = if (deltaBetweenAppleAndBananas == 0) {
                                        60 * apples.length
                                   } else if (deltaBetweenAppleAndBananas > 0) {
       applyAppleOffer(deltaBetweenAppleAndBananas) + 60 * bananas.length
    } else {
      60 * apples.length + applyBananaOffer(Math.abs(deltaBetweenAppleAndBananas))

    }


    costOfApplesAndBannanas + costOfNoneAppleAndNoneBanana
    
//
//    val costAfterOfferApplied: Iterable[Int] = shoppingCart.groupBy(item => item).map { case (item, itemList) => {
//      if (item == "apple")
//        applyAppleOffer(itemList.size)
//      else if (item == "banana") {
//        20
//      } else
//        applyOrangeOffer(itemList.size)
//    }
//    }
//
//    costAfterOfferApplied.foldLeft(0)((acc, singleItemCost) => acc + singleItemCost)
  }
}
