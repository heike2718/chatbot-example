# chatbot-example

Beispiel für ein RAG mit einem angebundenen ollama. Ist ein Astronomie- Bot.

Beim Starten werden die 5 Dokumente unter /src/main/resources/catalog vom IngestorExample eingelesen und
in einem durch Quarkus gestarteten reddis-Container als Vektor abgelegt (Dimensionen siehe application.properties)

Wenn eine Frage eintrifft, durchsucht der Augmentor zunächst die auf den 5 Dokumenten basierende Wissensbasis nach den relevantesten
Informationen und modfiziert den Propmt für das LLM, indem es die Frage anreichert. Dadurch gibt es weniger Halluzinationen und die Antworten sind
spezifischer und dadurch hilfreicher.

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


## Wie es arbeitet

das Beispiel arbeitet