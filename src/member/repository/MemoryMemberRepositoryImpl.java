package member.repository;

import member.Grade;
import member.Member;
import java.util.Map;
import java.util.HashMap;

public class MemoryMemberRepositoryImpl implements MemberRepository {

    private static MemoryMemberRepositoryImpl instance;

    private Map<Long, Member> memberStore = new HashMap<Long, Member>();

    // 생성자
    private MemoryMemberRepositoryImpl() {
        initData();
    }

    // 싱글톤 외부 접근 메서드
    public static MemoryMemberRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new MemoryMemberRepositoryImpl();
        }
        return instance;
    }

    // 샘플 초기 데이터
    private void initData() {
        memberStore.put(1L, new Member(1L, "홍길동", Grade.VIP));
        memberStore.put(2L, new Member(2L, "이몽룡", Grade.BASIC));
        memberStore.put(3L, new Member(3L, "성춘향", Grade.VIP));
    }

    @Override
    public void save(Member member) {
        // 회원 저장 기능
        memberStore.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberStore.get(memberId);
    }

}
