## 1. 프로젝트 소개

저는 제가 배운 Spring Boot를 직접 사용해보고, 백엔드 개발의 주요 부분을 혼자서 만들 수 있음을 보여주고 싶어 이 프로젝트를 시작하게 되었습니다. 처음 해보는 프로젝트라 단순한 게시판 만들기보다는 뭔가 새롭고 다른 사람들의 프로젝트와 구별되는 것을 만들고 싶었습니다. 그래서 저는 게시글을 특정 날짜와 시간에 맞춰 나중에 공개되는 'TimePostit'이라는 프로젝트를 만들게 되었습니다. 백엔드는 전부 제가 직접 코드를 작성했고, 프론트엔드는 부트스트랩의 기본 템플릿을 사용하되, ChatGPT4를 활용하여 디자인을 개선했습니다.

## 2. 프로젝트 기능

이 프로젝트는 기본적인 CRUD 기능을 갖추고 있어, 사용자가 게시글을 만들고, 볼 수 있으며, 수정하고, 삭제할 수 있습니다. 게시글 목록에서는 설정한 '공개 시간'이 지난 게시글만 볼 수 있습니다. 댓글 기능은 아직 추가하지 않았지만, 추후에 CRUD 기능을 포함해서 업데이트할 계획입니다.

## 3. 사용 기술

- HTML5
- CSS3
- Java
- MySQL
- Apache Tomcat
- IntelliJ IDEA
- Spring Boot
- Spring Data JPA
- Bootstrap
- ChatGPT4

## 4. 주요 코드 설명

![image](https://github.com/0055kms/TimePostit/assets/157768680/84a742f2-00ef-4c6e-8939-09ee56573a6b)

@Getter: 필드에 대한 getId, getTitle 등의 읽기 메소드를 자동 생성.
@Setter: 필드 값을 변경하는 setId, setTitle 등의 쓰기 메소드를 자동 생성.
@ToString: 객체를 문자열로 표현하는 toString() 메소드를 자동 생성.
@NoArgsConstructor: 인자 없는 기본 생성자를 자동 생성.
@AllArgsConstructor: 모든 필드 값을 인자로 받는 생성자를 자동 생성.
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME): HTML폼에서 받은 날짜,시간 데이터를 자바의 LocalDateTime 타입으로 변경
toEntity(): Dto를 엔티티로 변환

![image](https://github.com/0055kms/TimePostit/assets/157768680/3bf1ec30-fb6d-4166-ac0a-3430ac96ef21)

@Table(name = "board"): 엔티티가 매핑될 DB 테이블 지정
@GeneratedValue(strategy = GenerationType.IDENTITY): 기본키(id) 를 자동 증가 기능으로 생성함

![image](https://github.com/0055kms/TimePostit/assets/157768680/38b96b9f-994a-4a84-8407-a8b8b4c9afce)

JpaRepository를 확장해 CRUD작업 매소드를 자동으로 사용 가능하게 함
@Query("SELECT b FROM Board b WHERE b.pdt <= ?1"): findAllWithPdtAfter(LocalDateTime now) 메서드를 통해
주어진 now 시간보다 이전에 생성된 모든 Board 엔티티를 조회하는 쿼리를 정의

![image](https://github.com/0055kms/TimePostit/assets/157768680/abd98883-c9c4-45e3-8d2b-9e6d6bb1e720)

BoardService: 게시판 관련 데이터 관리
BoardController: 웹 요청 처리, 서비스에 요청 전달, 로깅을 사용해 일부 작업 내용 기록

## 5. 실행 화면
