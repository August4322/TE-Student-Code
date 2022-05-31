package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
      boolean isWinningBid = false;

      //check that we have not received a bid that is at or above the buyout price
      if(getHighBid().getBidAmount() < buyoutPrice) {

          //check if the offered bid is at or above the buyout price
          if(offeredBid.getBidAmount() >= buyoutPrice) {
              offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
          }

          isWinningBid = super.placeBid(offeredBid);

      }

      return isWinningBid;
    }
}
