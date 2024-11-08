FROM golang:1.22.0-alpine3.19 as base
ENV DOCKER_CONTENT_TRUST=1
FROM base as build
WORKDIR /app
COPY . /app/
RUN apk add --no-cache ca-certificates && \
    CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build -o weather-api /app/cmd/app

WORKDIR /app
ENTRYPOINT [ "./weather-api" ]
