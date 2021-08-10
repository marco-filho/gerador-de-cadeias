# Gerador de cadeias
## Intro

Um gerador de cadeias (ou palavras) a partir de expressões regulares.
O usuário fornece a entrada e esta, depois da validação, é usada para gerar 
cadeias segundo as regras da álgebra de expressões regulares.

<details>
    <summary>English</summary>

    A string generator from regular expressions.
    After validation, user input is used to generate strings
    by the rules of regular expression algebra.
</details>

## Validação

Nenhum tipo de símbolo é aceito, além de `*`, `(`, `)` ou `^+`. Estes últimos serão substituídos
por `*` durante a validação da entrada. Parenteses não devidamente abertos e fechados também não
são permitados, apesar de parenteses vazios (`()`) serem ignorados durante a validação.
Repetições sequenciais de `*` (e, consequentemente, `^+`) serão lidos como apenas um `*`.

<details>
    <summary>English</summary>

    Accepted symbols are `*`, `(`, `)` and `^+`. The last are replaced for `*`
    whitin input validation. Not properly closed parentheses aren't allowed,
    though empties (`()`) are ignored during validation. Sequencial repetition
    of `*` (thereafter, `^+`) will be read as a single `*`.
</details>

**Exemplos**
```
    ab* //Input ab* válido
    ()* //Input: ()* inválido
    a()* //Input: ()* válido
    (ab() //Input: (ab() inválido
    ab** ou ab^+^+  //Input: ab*, válido
```

## Execução

Execute `stringGenerator.java`:
```
    java stringGenerator.java
```

O programa imprimirá
```
    Insira a expressão regular: 
```

Então, após validação da entrada
```
    Deseja gerar quantas cadeias? 
```
>Aqui não há validação, então tenha cuidado.

Finalmente, cadeias aleatórias são geradas
```
    Insira a expressão regular: 
    ab(AB)**  
    Input lido: ab(AB)*
    Input válido.
    Deseja gerar quantas cadeias?
    10
    Possíveis cadeias geradas:
    abABABAB
    abABABABABAB
    abABAB
    abABABABABABAB
    abABABAB
    abABABABABABABAB
    abABABAB
    abABAB
    abABAB
    abAB
```