FROM golang:1.14.0 AS go
COPY main.go /app/main.go
WORKDIR /app
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o app main.go

FROM alpine:3.9.5
COPY --from=go /app .
EXPOSE 8080
CMD ["./app"]  
