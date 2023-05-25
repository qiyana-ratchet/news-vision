FROM tensorflow/tensorflow:2.6.0-gpu
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys A4B469963BF863CC
RUN apt-get update
RUN apt-get install -y zsh tmux wget git libsndfile1
RUN python -m pip install --upgrade pip
RUN pip install ipython && \
    pip install git+https://github.com/gultz/TensorFlowTTS.git && \
    pip install git+https://github.com/repodiac/german_transliterate.git#egg=german_transliterate
WORKDIR /workspace
RUN mkdir /workspace/voice

COPY requirements.txt /workspace
RUN pip install -r requirements.txt

COPY . /workspace

ENV FLASK_APP server.py
ENV FLASK_ENV development
ENV FLASK_RUN_PORT 8000
ENV FLASK_RUN_HOST 0.0.0.0

CMD ["flask","run"]