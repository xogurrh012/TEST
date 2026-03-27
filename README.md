# 방명록 CRUD 과제 제출 (채점용)

본 프로젝트는 Spring Boot와 Mustache를 이용한 간단한 방명록 CRUD 시스템입니다. 입문자 수준에 맞춘 표준적인 코드와 Lombok을 활용한 간결한 구조로 구현되었습니다.

---

## 📑 과제 요구사항 및 구현 현황

| 문항 | 요구사항 | 구현 내용 | 배점 |
| :--- | :--- | :--- | :--- |
| **1** | Guestbook Entity와 JpaRepository 구현 | `id`, `author`, `content`, `createdAt` 필드 구성 및 `JpaRepository` 상속 완료 | 20점 |
| **2** | 목록/작성폼/저장/삭제 4개 엔드포인트 구현 | `GuestbookController` 내 4개 매핑 완료 | 30점 |
| **3** | Mustache 템플릿 구현 | `list.mustache`, `write.mustache` 생성 및 반복문(`{{#list}}`) 적용 완료 | 30점 |
| **4** | CRUD 흐름 및 Redirect 처리 | 저장/삭제 후 목록으로 정상 리다이렉트 처리 완료 | 20점 |

---

## 📁 주요 파일 구조

- **Entity**: `src/main/java/com/example/demo/entity/Guestbook.java`
  - Lombok(`@Getter`, `@Setter`, `@NoArgsConstructor`)을 사용하여 코드를 간결화함.
- **Repository**: `src/main/java/com/example/demo/repository/GuestbookRepository.java`
  - `findAllByOrderByIdDesc()`를 통해 최신순 정렬 기능을 추가함.
- **Controller**: `src/main/java/com/example/demo/controller/GuestbookController.java`
  - `@RequestMapping("/guestbook")`을 사용하여 공통 경로를 관리함.
- **Templates**: `src/main/resources/templates/`
  - `list.mustache`: 방명록 목록 및 삭제 버튼 구현.
  - `write.mustache`: 방명록 작성 폼 구현.
- **Config**: `src/main/resources/application.properties`
  - H2 Database 활성화 및 JPA 테이블 자동 생성 설정.

---

## 🚀 실행 및 테스트 방법

1. **애플리케이션 실행**: `DemoApplication.java` 실행 (기본 포트: 8080)
2. **접속 주소**: [http://localhost:8080/guestbook](http://localhost:8080/guestbook)
3. **기능 테스트**:
   - **글쓰기**: '글쓰기' 링크 클릭 -> 작성자/내용 입력 -> '저장' 버튼 (목록으로 리다이렉트 확인)
   - **목록**: 작성된 글이 최신순(ID 내림차순)으로 출력되는지 확인
   - **삭제**: 리스트 우측의 '삭제' 버튼 클릭 (목록으로 리다이렉트 확인)
4. **DB 확인 (H2 Console)**:
   - 주소: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User: `sa` / Password: (없음)

---

## 💡 구현 특징
- **Lombok 사용**: 반복적인 Getter/Setter를 제거하여 가독성을 높였습니다.
- **최신순 정렬**: 데이터베이스 조회 시 ID 역순으로 조회하여 최신글이 상단에 오도록 구현했습니다.
- **리다이렉트**: 데이터 변경(저장/삭제) 후에는 반드시 목록으로 이동시켜 중복 요청을 방지했습니다.
