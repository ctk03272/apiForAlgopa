# AlgopaBot을 위한 API 크롤링 봇입니다.

## AlgopaBotT을 위한 API
- 스프링부트2
- JPA 
- 마리아디비 10.2
    - 기본 문제 DB의 구축에는 파이썬 크롤링을 통하여 문제의 번호,이름,몇주차인지를 저장하였다.
    - 사용자의 경우 크롤링을 하기보다는 직접 데이터를 입력하였다.
- API의 경우 2개의 API존재
    - 이번주 데이터를 조회하는 API(/problemses/thisweek)
    - 이번주 대상 단원과 대상 문제를 변경하는 API(/problemses/thisweek/{week}/{problemId})
## 크롤링 봇
- 크롱링 봇의 경우 파이썬3.6버전을 이용하여 작성
- 추가된 라이브러리의 경우
    - bs4
    - pyMysql
- AWS 람다에서 실행하기 위에서는 상기된 2개의 라이브러리를 실행될 파이썬 파일(lambda_function.py)을 하나의 zip으로 만들어 주어야 한다.
- AWS 람다에 등록된 크롤링 봇은 AWS CloudEvent Watch를 통해서 1시간에 1번씩 실행이 되게 된다.
- 크롤링 봇의 경우 1시간에 1번씩 알고파멤버들이 새롭게 푼 문제를 DB에 추가한다.
## 카톡봇의 현재 기능
- @누구
    - 자기소개를 한다.
- @과제
    - 이번주의 과제를 소개해준다.
- @공지사항
    - 현재의 공지사항을 이야기해줍니다.

### 차후 개발 예정 기능
- @스코어
    - 알고파 멤버들의 이번달 스코어를 이야기해줍니다.
- @현황
    - 알고파 멤버들의 이번주 문제풀이 현황을 이야기해줍니다.
- @ 게시물
    - 이번주에 새로 올라온 게시글을 안내해줍니다. 
