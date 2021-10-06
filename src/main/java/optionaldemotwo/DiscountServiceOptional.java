package optionaldemotwo;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class DiscountServiceOptional {

    public String getDiscountLines(Customer customer) {
        Stream<MemberCard> memberCardStream = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty);

        List<String> collect = Optional.ofNullable(customer.getMemberCards())
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(this::getDiscountPercentage)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(d -> "Discount % " + d)
                .collect(Collectors.toList());
        //System.out.println("Collect = ");
        collect.stream().forEach(System.out::println);

        return "";

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
        DiscountServiceOptional service = new DiscountServiceOptional();
//        MemberCard card = new MemberCard(60);
//        MemberCard card2 = new MemberCard(40);
//        List<MemberCard> cards = new ArrayList<>();
//        cards.add(card);
//        cards.add(card2);
//        System.out.println(service.getDiscountLines(new Customer(cards)));

//        System.out.println("Customer with no cards");
//        System.out.println(service.getDiscountLines(new Customer()));
    }

}
