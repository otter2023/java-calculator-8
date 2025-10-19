# java-calculator-precourse

## 🎯 미션 개요

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

<br>

## 📝 기능 요구 사항

### 1. 기본 구분자 처리
- 쉼표(`,`) 또는 콜론(`:`)을 구분자로 사용
- 구분자를 기준으로 분리한 각 숫자의 합을 반환

**예시:**
- `""` → 0
- `"1,2"` → 3
- `"1,2,3"` → 6
- `"1,2:3"` → 6

### 2. 커스텀 구분자 지정
- 문자열 앞부분의 `//`와 `\n` 사이에 위치하는 문자를 커스텀 구분자로 사용
- 커스텀 구분자 지정 시 해당 구분자로 숫자를 분리하여 합산

**예시:**
- `"//;\n1;2;3"` → 커스텀 구분자 `;` 사용, 결과 6

### 3. 예외 처리
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생
- 예외 발생 후 애플리케이션 종료

<br>


## 📥 입출력 요구 사항

### 입력
- 구분자와 양수로 구성된 문자열

### 출력
- 덧셈 결과 출력

### 입출력 예시
```bash
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
``` 
<br>

## 🛠️ 프로그래밍 요구 사항

### 실행 환경
- **버전**: JDK 21
- **프로그램 시작점**: `Application`의 `main()`

### 제약 사항
- `build.gradle` 파일 변경 불가
- 제공된 라이브러리 외 외부 라이브러리 사용 금지
- `System.exit()` 호출 금지
- 파일, 패키지 등의 이름 변경 및 이동 금지

### 코드 컨벤션
- 기본적으로 [Java Style Guide](https://google.github.io/styleguide/javaguide.html) 준수
- 추가로 [우아한테크코스 Java 코딩 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java) 준수

### 필수 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API 사용
- 입력 처리: `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용

<br>

## 📋 구현할 기능 목록

### ✅ 필수 기능
- [x] 문자열 입력
- [x] 커스텀 구분자 존재 여부 확인
- [x] 잘못된 입력 시 `IllegalArgumentException` 발생
- [x] 문자열 슬라이싱
- [x] 양수 계산
- [x] 결과 출력
- [x] 테스트 코드 작성

### ⚠️ 주의 사항
- [x] 빈 문자열 입력 시 0 반환

### 🚨 예외 처리 (잘못된 입력 정의)
- [x] 커스텀 구분자 형식이 올바르지 않은 경우
- [x] 기본 구분자 혹은 커스텀 구분자 외의 문자가 등장한 경우
- [x] 구분자가 연속해서 등장한 경우
- [x] 문자열이 숫자로 시작하거나 끝나지 않는 경우

### 🧩 추가 고려 사항
- [x] 커스텀과 기본 구분자는 혼합 사용 불가능, 커스텀 구분자가 더 우선순위를 가짐
- [x] 공백은 문자로 취급

<br>

## 🧪 테스트 실행 가이드
터미널에서 아래 명령어 실행

### Mac 또는 Linux
`./gradlew clean test`

### Windows
`gradlew.bat clean test` 또는  `.\gradlew.bat clean test`

### 테스트 성공 확인
모든 테스트가 통과하면 아래와 같은 메시지가 출력된다.
```bash
BUILD SUCCESSFUL in 0s
```