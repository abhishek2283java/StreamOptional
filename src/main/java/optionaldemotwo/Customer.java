package optionaldemotwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer {
    private String name;
    private List<MemberCard> memberCards = new ArrayList<>();

    public Customer(List<MemberCard> memberCards) {
        this.memberCards = memberCards;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberCard> getMemberCards() {
        return memberCards;
    }

    public Optional<List<MemberCard>> getMemberCardsAsOptional() {
        return Optional.ofNullable(memberCards);
    }

    public void setMemberCards(List<MemberCard> memberCards) {
        this.memberCards = memberCards;
    }
}
