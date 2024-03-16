# GURU2Project_22

![슬라이드1](https://user-images.githubusercontent.com/68212670/157681151-d7e113de-e724-484b-9328-c5ce9bccfdb2.PNG)

시연 영상 : https://youtu.be/w5bjX3w5acg

## 📌 프로젝트명
푸시푸시

## 작품 설명
- Android Studio를 이용하여 제작한 습관 만들기 앱
- 습관을 들이기 위한 일정을 저장하고, 그 일정을 수행하였을
시에 얻을 수 있는 코인으로 고양이 방을 꾸밀 수 있도록 하여
사용자 의욕을 끌어내고자 하였음.
- 다른 습관 앱들로부터 **차별성**을 주기 위하여 원형 일정표로 구현
  
## 개인 기여도 (김유원)
- 팀장을 맡아 스크럼 주도
- SqliteDB로 연동하여 일정 저장
- 원형 그래프를 활용하여 일정표 구현

## 화면 설명 (김유원)
### 1) 일정표 화면 
🔗 : https://github.com/purangi/GURU2Project_22/blob/master/app/src/main/java/com/example/guru2project_22/DayActivity.kt

![image](https://github.com/purangi/GURU2Project_22/assets/68212670/14e5e7ae-bd75-45b5-b453-55bab97c7de1)

- 저장된 일정표 확인
- 습관 추가하기 버튼 입력 시 2)로 이동
### 2) 습관 추가하기 화면 
🔗 : https://github.com/purangi/GURU2Project_22/blob/master/app/src/main/java/com/example/guru2project_22/HabitActivity.kt

![image](https://github.com/purangi/GURU2Project_22/assets/68212670/c58a5d28-d50f-4618-80d9-a03872113cc5)

-  일정의 아이콘, 습관 만들기 활동 시간, 날짜 반복 등을 설정하여 저장
-  아이콘 버튼 클릭 시 3) 으로 이동
### 3) 아이콘 선택 화면
🔗 : https://github.com/purangi/GURU2Project_22/blob/master/app/src/main/java/com/example/guru2project_22/IconSelect.kt

![image](https://github.com/purangi/GURU2Project_22/assets/68212670/2e1e9280-ca09-47cc-8016-9f6c2363b323)

- 일정에 맞는 다양한 아이콘 선택 가능
- 해당 아이콘은 메인 화면에서 확인 가능
