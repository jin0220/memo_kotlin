# Memo

## 프로젝트 설명
쉽고 간편하게 메모를 할 수 있는 어플리케이션입니다. 

- 개발 환경: Android Studio
- 개발 언어: Kotiln
- 데이터베이스: Room
- mvvm 적용


## 애플리케이션 구조
- 글 목록 화면
- 상세 페이지
  - 글보기 모드
  - 글쓰기 모드
  - 수정 모드

## 기능 설명

### 글 목록 화면

![글목록화면](https://user-images.githubusercontent.com/37447282/144559609-1b2b5751-7a74-4cfb-b6f2-f6093ed2b3ac.png)

- 글 목록 화면에는 저장되어있는 메모의 리스트를 **메모 미리보기, 제목, 날짜**의 구성으로 나타냈다.
- **메뉴 > 편집 버튼**을 누르거나 메모 리스트 중 하나를 **길게 누르면** 메모 리스트에 **체크박스**와 **컨텍스트 메뉴**가 나타나면서 메모를 선택할 수 있고, 해당 메모를 **삭제**할 수 있도록 한다.

* * *     
<br/>

### 상세 페이지
![상세페이지](https://user-images.githubusercontent.com/37447282/144561388-a540f24e-013b-4a76-b6a5-71aeabb1a341.png)

상세 페이지는 하나의 액티비티를 사용하여 **글 보기, 글 쓰기, 글 수정하기** 페이지로 나타내었다.
- 액티비티 화면의 상단바에 **제목**을, 레이아웃에 **내용**을 나타내었다.
- **저장 버튼**을 누르면 작성한 메모를 저장하도록 한다.
- **수정 버튼**을 누르면 작성된 메모를 수정할 수 있도록 전환된다.
- **삭제 버튼**을 누르면 작성된 메모를 삭제하도록 한다.
- 제목과 내용을 EditText를 사용하여 **글보기 모드**에서는 **읽기 전용**으로 바꿔 작성이 불가능하게 만들고, **글쓰기 모드**와 **글 수정하기 모드**에서는 **쓰기 전용**으로 바꿔 작성이 가능하게 만들었다.
