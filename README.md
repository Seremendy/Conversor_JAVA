# Conversor de Moedas em Java

Projeto em Java puro que utiliza a **ExchangeRate API** para converter moedas em tempo real via terminal.

## Aprendizados

- Estrutura de classes (`Principal`, `ConversorDeMoeda`)
- Requisições HTTP com `HttpURLConnection`
- Leitura de JSON com **Gson**
- Uso de `Map<Integer, String[]>` para opções de menu
- Validação de entrada com `hasNextInt()` e `hasNextDouble()`
- Laço principal com `while (true)`, `break` e `continue`
- Arredondamento com `Math.round(...) / 100.0`

## Tecnologias

- Java 17+
- Gson (para JSON)
- API ExchangeRate
- Terminal/Console
