package Flipkart;
//https://leetcode.com/problems/shopping-offers/
//leetcode problem 638
import java.util.*;
class ShoppingOffers {
    HashMap<List<Integer> , Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return helper(price, special, needs);
    }
    
    public int getMinPrice(List<Integer> price, List<Integer> needs)
    {
        int total =0;
        for(int i=0;i<price.size();i++)
        {
            total += price.get(i) * needs.get(i);
        }
        
        return total;
    }
    
    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs)
    {
        int minPrice = getMinPrice(price, needs);
        
        if(map.get(needs)!=null)
            return map.get(needs);
        
        for(int i=0;i<special.size();i++)
        {
            boolean flag = true;
            List<Integer> offer = special.get(i);
            List<Integer> newNeeds = new ArrayList<>();
            for(int k =0;k<offer.size()-1;k++)
            {
                if(needs.get(k)<offer.get(k))
                {
                    flag = false;
                    break;
                }
                newNeeds.add(needs.get(k)- offer.get(k));
            }
              if(flag == false)
                    continue;
        
             
            minPrice =  Math.min(minPrice, offer.get(offer.size()-1)+ helper(price, special, newNeeds));
        
       }
        map.put(needs, minPrice);
        return minPrice;
               
}
}

