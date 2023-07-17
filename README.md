# 코틀린 연습용 프로젝트

## build.gradle.kts 기본 설정

* Spring Data JPA
* Validation
* Spring Web
* H2 Database - 테스트용
* Postgresql
* Spring Configuration

## 추가설정

```kotlin

    // 코틀린에서 JPA를 사용하기 위한 allOpen 옵션 설정
    allOpen {
        annotation("jakarta.persistence.Entity")
        annotation("jakarta.persistence.MappedSuperclass")
        annotation("jakarta.persistence.Embeddable")
    }
```

코틀린은 기본적으로 **final 클래스** 로 생성되기 때문에 JPA를 사용하기 위해서 설정해줘야 하는 옵션