package hannamproject.hanpro.service;

import hannamproject.hanpro.entity.MemberEntity;
import hannamproject.hanpro.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberStudentId) throws UsernameNotFoundException {
        MemberEntity member = memberRepository.findByMemberStudentId(memberStudentId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + memberStudentId));

        return User.builder()
                .username(member.getMemberStudentId())
                .password(member.getMemberPassword())
                .roles("USER")
                .build();
    }
}
