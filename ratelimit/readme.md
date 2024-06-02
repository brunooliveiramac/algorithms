## Rate Limit Application


### Run
```bash
.env
REDIS_ADDRESS=redis:6379

$ go run main.go
```
or

```bash
.end
REDIS_ADDRESS=redis:6379
$ docker-compose up
```

### Test

```bash

curl --location 'http://localhost:8080/config/token' \
--header 'Content-Type: application/json' \
--data '{"token":"token123","requestLimit":3,"blockTime":30}'
```

```bash
curl --location 'http://localhost:8080/'
```

### Config

```
.env
```