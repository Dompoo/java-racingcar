# 기능 구현 목록

## 입력

- [ ] 자동차이름들을 입력받는다.
  - [ ] 각 이름들이 ,로 구분되어야 한다.
- [ ] 움직임 횟수를 입력받는다.
  - [ ] 숫자형식이어야 한다.

## 출력

- [ ] 한번씩 움직인 결과를 출력한다.
- [ ] 최종 우승자를 출력한다.
  - [ ] 만약 여럿이라면 ,로 조인하여 출력한다.

## 도메인

### 자동차

- [ ] 자동차 이름은 5자 이하여야 한다.
- [ ] 자동차는 전진할 수 있다. 
  - [ ] 0~9 사이 랜덤값이 4 이상일 때만 움직인다.

### 자동차들

- [ ] 자동차들은 자동차를 가진다.
  - [ ] 자동차는 2~30대 사이만 가능하다.
- [ ] 자동차 이름들로 생성될 수 있다.
  - [ ] 각 자동차 이름은 중복될 수 없다.
- [ ] 각 자동차를 한번 움직일 수 있다.
  - [ ] 각 자동차를 한칸씩 움직인다.
  - [ ] 움직인 후 각 결과를 반환한다.

# 프로그래밍 요구 사항

- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍했는가?
- [ ] 들여쓰기(indent)를 2단계 이하로 허용했는가?
- [ ] else 예약어를 쓰지 않았는가?
- [ ] 메소드가 한가지 일만 담당하도록 구현했는가?
- [ ] 클래스를 작게 유지하기 위해 노력했는가?

# 좋은 코드를 위한 체크 사항

- [ ] 모든 원시값과 문자열을 포장했는가?
- [ ] 콜렉션에 대해 일급 콜렉션을 적용했는가?
- [ ] 3개 이상의 인스턴스 변수를 가진 클래스를 구현하지 않았는가?
- [ ] 도메인 객체를 getter/setter 없이 구현했는가?
- [ ] 메소드의 인자 수를 3개 이하로 제한했는가?
- [ ] 코드 한 줄에 점(.)을 하나만 허용했는가?
