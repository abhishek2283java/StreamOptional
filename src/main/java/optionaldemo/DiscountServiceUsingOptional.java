package optionaldemo;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class DiscountServiceUsingOptional {
    public String getDiscountLine(Customer customer) {
        Optional<MemberCard> memberCard = customer.getMemberCard();
        Optional<Integer> integer = memberCard.flatMap(card -> getDiscountPercentage(card));
        Optional<String> s = integer.map(d -> "Discount % " + d);
        return customer.getMemberCard().flatMap(card -> getDiscountPercentage(card)).map(d -> "Discount % " + d).orElse("");
//        return customer.getMemberCard()
//                .flatMap(card -> getDiscountPercentage(card))
//                .map(d -> "Discount % " + d)
//                .orElse("");
    }

    private Optional<Integer> getDiscountPercentage(MemberCard card) {
        if(card.getPoints() > 100) {
            return of(10);
        }
        if(card.getPoints() > 50) {
            return of(5);
        }
        return empty();
    }

    public static void main(String[] args) {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(110))));
        //System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(40))));
        //System.out.println(discountService.getDiscountLine(new Customer()));
    }
}
