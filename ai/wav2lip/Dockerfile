FROM python:3.10-alpine

WORKDIR /app

COPY requirements.txt /app
RUN pip3 install -r requirements.txt

COPY . /app


ENV FLASK_APP app.py
ENV FLASK_ENV development
ENV FLASK_RUN_PORT 9000
ENV FLASK_RUN_HOST 0.0.0.0


CMD ["flask","run"]