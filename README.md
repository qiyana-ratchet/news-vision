# news-vision
Virtual news production using Tacotron2 and Wav2Lip

## 프로젝트 개요
- **목적**: 인공지능 기술을 사용하여 음성 합성 및 Deepfake 기술이 적용된 뉴스를 서비스
- **결과**: Virtual news를 1분 30초 안에 생성하여 제공 (AWS g4dn.xlarge)

##설치방법
- Docker을 활용 -> docker-compose -f docker-compose-dev.yml up
- GPU 환경 사용 시, NVIDIA Container Toolkit 설치:
- [NVIDIA Container Toolkit 설치 가이드](https://docs.nvidia.com/datacenter/cloud-native/container-toolkit/latest/install-guide.html)


## 기술 스택
- **백엔드**: Spring
- **프론트엔드**: React
- **데이터베이스**: MySQL (AWS RDS), Docker Volume (AWS EFS)
- **인공지능**: Python, tensorflow-tts(tactron2), wav2lip
- **네트워크**: Nginx 기반의 리버스 프록시
- **컨테이너화**: Docker, Docker-compose, AWS ECS

## 주요서비스
- Docker을 활용한 MSA 아키텍처의 설계 및 구현
- nginx의 리버스 프록시를 활용한 네트워크
- Spring을 활용한 백엔드 API 개발
- AWS ECS를 통한 배포 (docker-compose-prod.yml)
- tensorflow-tts(tactron2)를 활용한 음성합성
- wav2lip을 활용한 입모양 deepfake

## 핵심 도전과 해결 전략
- **라이브러리 충돌**: Docker와 MSA 아키텍처를 도입하여 서비스를 독립적인 컨테이너로 분리
- **컨테이너 간의 네트워크 연결 문제**: Docker-compose의 네트워크 기능과 Nginx의 리버스 프록시 기능 활용
- **클라우드 환경 배포**: AWS ECS를 사용하여 다양한 인스턴스를 효율적으로 관리 및 서비스 과부하 해결, AWS ALB로 로드 밸런싱 구현

## 추가 정보
- <img width="876" alt="Screenshot 2023-11-14 at 2 38 04 PM" src="https://github.com/qiyana-ratchet/news-vision/assets/89904170/0aaa392a-3738-401a-8cb4-eebb89fd2939">

-<img width="1172" alt="Screenshot 2023-11-14 at 2 38 49 PM" src="https://github.com/qiyana-ratchet/news-vision/assets/89904170/c96eceb3-0053-4cd1-99d3-0d52e09cb430">

-<img width="1160" alt="Screenshot 2023-11-14 at 2 39 02 PM" src="https://github.com/qiyana-ratchet/news-vision/assets/89904170/de6fd540-2db7-45e5-a7f3-0d15bcd0ae06">

## 라이선스
[MIT License](LICENSE)
