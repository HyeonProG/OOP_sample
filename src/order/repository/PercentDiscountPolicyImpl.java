package order.repository;

import member.Grade;
import member.Member;

public class PercentDiscountPolicyImpl implements DiscountPolicy {

    private double discountPercent = 10.0;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return (int) (price * (discountPercent / 100));
        }
        return 0;
    }

}
