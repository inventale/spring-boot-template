FROM amazoncorretto:11

RUN mkdir -p /app/
COPY ./build/libs/ /app/
ENV spring.profiles.active=production
WORKDIR /app/
