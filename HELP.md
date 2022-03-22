# Invest API

## 기능 사항 
- 사용자는 원하는 부동산/신용 투자 상품을 투자할 수 있습니다.
- 투자상품이 오픈될 때, 다수의 고객이 동시에 투자를 합니다. 
- 투자 후 투자상품의 누적 투자모집 금액, 투자자 수가 증가됩니다.
- 총 투자모집금액 달성 시 투자는 마감되고 상품은 Sold out 됩니다.

## Infra
- REST API
- H2 Database

## H2 DB 세팅용 SQL
```SQL
insert into product(title, total_amount, current_amount, invest_count, product_status, started_at, finished_at)
select '테스트 상품01', 500000, 0, 0, 'INVESTING', PARSEDATETIME ('2022-03-20 10:00:00','yyyy-MM-dd hh:mm:ss'), PARSEDATETIME ('2022-04-30 22:00:00','yyyy-MM-dd hh:mm:ss');
```
