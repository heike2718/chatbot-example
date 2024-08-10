# Zeugs

## ollama

```
docker run -d -v ollama:/root/.ollama -p 11434:11434 --name ollama ollama/ollama
```

## REST

```
curl -X POST -H 'Content-Type: application/json' -i http://localhost:6543/chatbot --data '{
"message": "What is a planet?"
}'
```