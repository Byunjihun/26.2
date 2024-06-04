// 로그인 요청
[Post](http://고정IP/member/login) -> 로그인 하면 헤더에 토큰 생성, 이후 Auth Type에 토큰 입력 후 아래 내용 진행.

// 전체 게시물 조회
[GET](http://고정IP/board)

// 단일 게시물 조회
[GET](http://고정IP/board/{게시물 번호})

// 게시물 내용 생성
[POST](http://고정IP/board)

// 게시물 내용 수정
[PUT](http://고정IP/board/{게시물 번호})

// 게시물 내용 삭제
[DELETE](http://고정IP/board/{게시물 번호})

// MemberSubject 요청
[GET](http://고정IP/member/subjects)

// MemberSkills 요청
[GET](http://고정IP/member/skills)

// MemberDetails 요청
[GET](http://고정IP/member/details)
