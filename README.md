API 요청 방식
1. 로그인 요청
Method: POST
URL: http://<고정IP>/member/login
Body:
json
{
  "studentId": "your-student-id",
  "memberPassword": "your-password"
}

로그인 시 JWT 토큰이 생성되고, 이후 요청 시 이 토큰을 사용하여 인증해야함.

2. 전체 게시물 조회
Method: GET
URL: http://<고정IP>/board

4. 단일 게시물 조회
Method: GET
URL: http://<고정IP>/board/{게시물 번호}

6. 게시물 생성
Method: POST
URL: http://<고정IP>/board
Body:
json
{
  "title": "게시물 제목",
  "content": "게시물 내용"
}

7. 게시물 수정
Method: PUT
URL: http://<고정IP>/board/{게시물 번호}
Body:
json
{
  "title": "수정된 제목",
  "content": "수정된 내용"
}

8. 게시물 삭제
Method: DELETE
URL: http://<고정IP>/board/{게시물 번호}

10. MemberSubject 조회
Method: GET
URL: http://<고정IP>/member/subjects

12. MemberSkills 조회
Method: GET
URL: http://<고정IP>/member/skills

14. MemberDetails 조회
Method: GET
URL: http://<고정IP>/member/details

16. Member Score 업데이트
Method: PUT + 파라미터 넣어줘야함.
URL: http://<고정IP>/member/graduation-score/update/{score-type}
Params:
newScore: 새로운 점수
scoreName: 점수 이름
예시: PUT http://<고정IP>/member/graduation-score/update/counseling-score?newScore=50&scoreName=Example Score Name

