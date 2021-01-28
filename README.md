# StockLetter

- ***MEMBER INSTRODUCTION***

    😙 조장 : **장효진**
    😊 부조장 : **김규민**
    ❣️  Member : 이세연, 오승준<br>
    🎊 Start Date : 2021. 01. 26<br>
    💘 build Date : 2021. 01. 29<br>
    💡  README_Last Modified Date : 2021. 01. 28<br>
    
    Koscom_Hackathon (~˘▾˘)~♫•*¨*•.¸¸♪<br><br>
    
## STOCKLETTER 소개
- 기본 테마 : 사용자가 구독한 기업의 뉴스와 재무정보를 지속적으로 제공
- 사용자의 성향과 구독 정보를 바탕으로 주식을 매매할 때 더욱 합리적일 수 있도록.

- 기능
    1. 사용자가 구독한 기업 관련 뉴스기사 실시간 업데이트
    2. 기업의 핵심적인 재무 지표를 카테고리별로 제공
    3. 구독한 기업의 정보들을 한 눈에 비교
    4. 사용자의 구독 기업 및 투자성향 분석을 바탕으로 기업 추천
    5. 개인별 투자성향에 따라 기업 적합성 평가 의견 제공

## 역할 분배

저의 조는 4명 모두 각각 뚜렷한 역할이 존재합니다.
1. 기획, 발표, 문서 작업
2. 백엔드 : API 구축 및 서버 관리, DB 구축 및 관리
3. 프론트1 : IOS 어플리케이션 개발
4. 프론트2 : WEB SITE 개발

## BackEnd 배포 방법
1. OpenJDK 설치 : Zulu 8
2. Maven 설치
3. spring 프로젝트 디렉토리에서 mvn clean package
4. /target 페이지에서 java -jar spring*.jar으로 서버 실행.

## IOS 배포 방법
> app

## WEB 배포 방법

### Installation

**최초 설정**
- 설치 전 필수요소 : [NodeJs](https://nodejs.org/en/) (>= 10.0.0)

1. web의 내용을 컴퓨터에 다운 받아 주세요
2. CMD나 터미널을 사용해 폴더가 있는 곳으로 이동해 주세요.
3. Run `npm install`.

**주의 사항**
> `.npmrc` 파일이 있는 곳에서 `npm install`을 실행해주세요

### Production
- 배포파일은 `npm run build:prod`를 통해서 만들수 있습니다. 
- 그 후 `/dist/`디렉토리를 복사해서 실행하고 싶은 곳에 넣어주세요!

### Build Customization
 [Webpack](https://webpack.js.org) 에서 구성파일을 Customization하여 파일을 빌드할 수 있습니다.
 구성파일은 `/build`에서 확인하세요!
