# Imagem base
FROM golang:1.18-alpine

# Configurando diretório de trabalho
WORKDIR /app

# Copiando os arquivos necessários
COPY . .

# Compilando o aplicativo
RUN go build -o loadtester

# Executável
ENTRYPOINT [ "./loadtester" ]
