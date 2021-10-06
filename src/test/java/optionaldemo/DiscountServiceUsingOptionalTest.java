package optionaldemo;

import org.junit.jupiter.api.Test;

public class DiscountServiceUsingOptionalTest {

    @Test
    public void testOptional_using_customer_with_card_with_110_points() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(110))));
    }

    @Test
    public void testOptional_using_customer_with_card_with_60_points() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(60))));
    }

    @Test
    public void testOptional_using_customer_with_card_with_40_points() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(40))));
    }

    @Test
    public void testOptional_using_customer_with_no_cards() {
        DiscountServiceUsingOptional discountService = new DiscountServiceUsingOptional();
        System.out.println(discountService.getDiscountLine(new Customer()));
    }



}
