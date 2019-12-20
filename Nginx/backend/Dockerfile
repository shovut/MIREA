FROM python:3.9.0a1-alpine3.10

COPY . /opt
WORKDIR /opt
RUN pip install django
EXPOSE 8080
ENTRYPOINT ["python", "manage.py", "runserver", "0.0.0.0:8080"]
