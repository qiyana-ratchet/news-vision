FROM pytorch/pytorch:1.11.0-cuda11.3-cudnn8-devel
WORKDIR /workspace
RUN mkdir /workspace/video
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys A4B469963BF863CC
# uncomment this if you have trouble downloading packages
# RUN rm /etc/apt/sources.list.d/cuda.list && \
#     rm /etc/apt/sources.list.d/nvidia-ml.list && \
#     sed -i "s@http://.*archive.ubuntu.com@https://mirrors.tuna.tsinghua.edu.cn@g" /etc/apt/sources.list && \
#     sed -i "s@http://.*security.ubuntu.com@https://mirrors.tuna.tsinghua.edu.cn@g" /etc/apt/sources.list && \
#     pip config set global.index-url https://pypi.tuna.tsinghua.edu.cn/simple
RUN apt-get -y update --fix-missing && \
    apt-get install -y libglib2.0-0 libxrender1 ffmpeg libsm6 && \
    pip install librosa==0.7.0 opencv-contrib-python==4.6.0.66
RUN pip install numba==0.48
RUN pip install resampy==0.3.1

COPY requirements.txt /workspace
RUN pip install -r requirements.txt

COPY . /workspace


ENV FLASK_APP app.py
ENV FLASK_ENV development
ENV FLASK_RUN_PORT 9000
ENV FLASK_RUN_HOST 0.0.0.0


CMD ["flask","run"]