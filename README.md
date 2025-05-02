# com-musinsa-product

---
## Run
### Build
./gradlew build

### Test
./gradlew test

### Run
cd build <br>
cd libs <br>
java -jar product-0.0.1-SNAPSHOT.jar

## 구현 API

### 1 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
GET /api/item-summary/min-price
<br>
### 2. 단일 브랜드로 모든 카테고리 상품을 구매할때, 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
GET /api/item-summary/single-brand
<br>
### 3. 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
GET /api/item-summary/price

### 4 상품 추가/업데이트/삭제 API
<br>
POST /api/items
<br>
PUT /api/items
<br>
DELETE /api/items/{itemId}
<br>

### 4 브랜드 추가/업데이트/삭제 API
POST /api/brands
<br>
PUT /api/brands/{brandId}
<br>
DELETE /api/brands/{brandId}