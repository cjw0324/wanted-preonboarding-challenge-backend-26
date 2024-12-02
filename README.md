# Market : Wanted Backend Challenge

사용자간 물건을 거래할 수 있는 플랫폼, 결제 프로세스를 추가하여 테스트 결제도 가능.

### API 명세서

[index.html](https://github.com/cjw0324/wanted-preonboarding-challenge-backend-26/blob/feature/jaewoo-choi/README/index.html)

*OpenAPI definition by swagger*

### ☝🏻 요구사항 - 회원관리, 상품 관리, 상품 거래

사용자간 거래가 가능한 Market API를 생성해야합니다. 

1. 제품 등록과 구매는 회원만 가능합니다.
2. 비회원은 등록된 제품의 목록조회와 상세조회만 가능합니다.
3. 등록된 제품에는 "제품명", "가격", "예약상태"가 포함되어야하고, 목록조회와 상세조회시에 예약상태를 포함해야합니다.
4. 제품의 상태는 "판매중", "예약중", "완료" 세가지가 존재합니다.
5. 구매자가 제품의 상세페이지에서 구매하기 버튼을 누르면 거래가 시작됩니다.
6. 판매자와 구매자는 제품의 상세정보를 조회하면 당사자간의 거래내역을 확인할 수 있습니다.
7. 모든 사용자는 내가 "구매한 용품(내가 구매자)"과 "예약중인 용품(내가 구매자/판매자 모두)"의 목록을 확인할 수 있습니다.
8. 판매자는 거래진행중인 구매자에 대해 '판매승인'을 하는 경우 거래가 완료됩니다.
9. 제품에 수량이 추가됩니다. 제품정보에 "제품명", "가격", "예약상태", "수량"이 포함되어야합니다.
10. 다수의 구매자가 한 제품에 대해 구매하기가 가능합니다. (단, 한 명이 구매할 수 있는 수량은 1개뿐입니다.)
11. 구매확정의 단계가 추가됩니다. 구매자는 판매자가 판매승인한 제품에 대해 구매확정을 할 수 있습니다.
12. 거래가 시작되는 경우 수량에 따라 제품의 상태가 변경됩니다.
    - 추가 판매가 가능한 수량이 남아있는 경우 - 판매중
    - 추가 판매가 불가능하고 현재 구매확정을 대기하고 있는 경우 - 예약중
    - 모든 수량에 대해 모든 구매자가 모두 구매확정한 경우 - 완료
13. "구매한 용품"과 "예약중인 용품" 목록의 정보에서 구매하기 당시의 가격 정보가 나타나야합니다.
    - 예) 구매자 A가 구매하기 요청한 당시의 제품 B의 가격이 3000원이었고 이후에 4000원으로 바뀌었다 하더라도 목록에서는 3000원으로 나타나야합니다.

### ✌🏻 요구사항 - 상품 결제

1. 사용자간 거래에서 결제플랫폼을 통해 결제를 진행 (포트원, 구.아임포트).
2. 결제진행, 결제취소 기능.
3. 결제연동문서를 자세히 보고 단순 기능 추가가 아닌 실제 결제가 진행된다는 관점에서 기능을 구현.

## 🔨구현 범위

1. 회원 가입 및 회원 탈퇴
2. 로그인
    - Spring Security + Interceptor, Session
3. 상품 등록, 수정, 삭제
4. 구매 요청 → 판매 승인 → 구매 확정 순서에 따른 상태 변경
5. 거래에 따른 상품 상태 (판매중 / 예약중 / 완료) 업데이트
6. 포트원 결제
    - 주문 시 <결제UID, AMOUNT> 결제에 대한 정보를 사전 등록
    - 구매 요청 시 결제 진행
    - 결제 완료 후 Web Hook 을 통한 결제 검증 - 검증에 실패 시 결제 취소
    - 판매 거절 시 결제 취소 (환불)
