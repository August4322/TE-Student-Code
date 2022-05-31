package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice = 0;

    public ReserveAuction(String itemForSale, int reservePrice){
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isReservedBid = false;
        //this checks that each bid meets the minimum reserve price
            if (offeredBid.getBidAmount() >= reservePrice) {
                isReservedBid = super.placeBid(offeredBid);
            } else {
                System.out.println("Offer is not valid - must meet minimum reserve price");
            }
        //If it doesn't the bid is ignored
        return isReservedBid;
    }

    //Alternate code
    /*
    boolean isReservedBid = false;

       //Check that there hasn't been a bid that is adt or above the buyout price
       if(getHighBid().getBidAmount() < reservePrice) {
           //Check if the offered bid is at or above the reserve price
           if(offeredBid.getBidAmount() >= reservePrice) {
               offeredBid = new Bid(offeredBid.getBidder(), reservePrice);
           }
           isReservePrice = super.placeBid(offeredBid);
       }
        return isReservePrice;
    }
     */
    //Doesn't work because it caps the bid price at the reserve price



}
