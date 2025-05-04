# 🛍️ Musinsa Product API

A simple product management API service for Musinsa-style fashion products.

---
## 🚀 How to Run

> **Java Version Required:** JDK 17

### 🏗️ Build
```bash
./gradlew build
```

### ✅ Test
```bash
./gradlew test
```

### ▶️ Run
```bash
java -jar ./build/libs/product-0.0.1-SNAPSHOT.jar
```

---
## Architecture
![package](https://www.plantuml.com/plantuml/png/P8n13i9024Ntd88Bz0h6UpHT4CHAx0o4GJV6kskSLfl8wkVn_pksfCXRMS29hpGBalkYJAbMyG7ulf5SfvvSecbBgImJFE4xOWlPsYShf7KTD8cxhcNuY70O3Zk-L_xzUkhy9nxPOcDifKm0rL8mTBuasldL9ndaD0X4ONZlATvIR-5PZ7MbTjC3q6Hi2DXO8yIf6P0cMAk1fA5W8VP4l7_ku8oe93MwUul9z_t_U_CJ6FEQtnp2Gu0YHoG8XUHbfaF9Na1uNsclvaNAZncr6u6wEXXSdf9bVH5FXgFHyC8WzveJyNIDgDHYpKLY1dWf8RbjjpkhORzal_dM90xY9qok_t2S3yviwBwsfTy8VWaGrSGBXUVnx-n2SIEijOFIeQqIAyGvhYIrfMFU7lMg_GNrDz9X1JyZIrkwxBkMoQyhdjRjPaVjLg6PcuA494GaUQO8Sepx_9zLTJSX4wtIaugW4ksR9dBM9KyDwbDnv_QGOpEPN_W1)

## 🌐 API Overview

> Access the test UI: [http://localhost:8080/](http://localhost:8080/)

### 📊 1. 카테고리별 최저가격 브랜드 및 상품 조회
- **GET** `/api/item-summary/min-price`  
  → 각 카테고리별로 최저가를 제공하는 브랜드 및 상품과 총액 조회

### 🧢 2. 단일 브랜드 기준 카테고리 전체 구매 최저가 조회
- **GET** `/api/item-summary/single-brand`  
  → 단일 브랜드가 전 카테고리를 커버할 경우, 해당 브랜드 상품의 최저가 및 총액 조회

### 💰 3. 카테고리별 최고/최저 가격 브랜드 및 상품 조회
- **GET** `/api/item-summary/price`  
  → 특정 카테고리 이름으로 필터링하여 최고가/최저가 상품 및 브랜드 정보 조회

---

## 🛠️ 브랜드 및 상품 관리 API

> Postman 테스트: `musinsa_for_test.postman_collection.json` 파일을 Import 하세요

### 📦 상품(Item)
- **POST** `/api/items` : 상품 추가
- **PUT** `/api/items` : 상품 수정
- **DELETE** `/api/items/{itemId}` : 상품 삭제

### 🏷️ 브랜드(Brand)
- **POST** `/api/brands` : 브랜드 추가
- **PUT** `/api/brands/{brandId}` : 브랜드 수정
- **DELETE** `/api/brands/{brandId}` : 브랜드 삭제