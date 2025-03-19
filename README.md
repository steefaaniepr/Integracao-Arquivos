# Integração de Arquivos: Dropbox e Google Drive

Este projeto demonstra como integrar um sistema de persistência de arquivos com Dropbox e Google Drive usando o padrão Adapter em Java.




## Funcionalidades

- Enviar arquivos para o Dropbox
- Enviar arquivos para o Google Drive
- Baixar arquivos do Dropbox
- Baixar arquivos do Google Drive
- Implementação utilizando Interface e Adapter Pattern


## Tecnologias Utilizadas

- Java (JDK 11+)
- Padrão de Projeto Adapter
- APIs do Dropbox e Google Drive (simuladas)

## Como Funciona

1. Adapter Pattern
O projeto usa o padrão Adapter para permitir que diferentes serviços de armazenamento (Dropbox e Google Drive) implementem a mesma interface IPersistencia, garantindo flexibilidade e baixo acoplamento.

2. Implementação das Classes

- IPersistencia ->  Interface comum para persistência de arquivos.
- DropBoxAdapter -> Adapta a integração com o Dropbox.
- GoogleDriveAdapter -> Adapta a integração com o Google Drive.

3. Fluxo da Aplicação

    - O usuário seleciona um arquivo local.
    - O arquivo é enviado para o Dropbox ou Google Drive via IPersistencia.gravar().
    - O arquivo pode ser recuperado usando IPersistencia.ler().


## Como clonar o Repositório

Para baixar este projeto em sua máquina, use o comando abaixo no terminal:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```

Se precisar configurar as dependências ou bibliotecas do projeto, importe-o na sua IDE e configure o SDK para Java 11.
## Caso de Uso

```java
public static void main(String[] args) {
    String caminhoFile = "C:/temp/teste.txt";

    // Upload para Dropbox
    DropBox dropBox = new DropBox();
    IPersistencia arquivosDropbox = new DropBoxAdapter(dropBox);
    arquivosDropbox.gravar(new File(caminhoFile));

    // Upload para Google Drive
    GoogleDrive googleDrive = new GoogleDrive();
    IPersistencia arquivosGoogleDrive = new GoogleDriveAdapter(googleDrive);
    arquivosGoogleDrive.gravar(new File(caminhoFile));

    // Download do Google Drive
    File downloadFile = arquivosGoogleDrive.ler("teste.txt");
    System.out.println("Arquivo baixado: " + downloadFile.getPath());
}
```


## Pré-Requisitos

- Ter o Java 11 ou superior instalado.
- Clonar o repositório e abrir o projeto em uma IDE como IntelliJ IDEA ou Eclipse.

## Como executar
    - Compile e execute o arquivo Demo.java.
    - Certifique-se de que o arquivo que deseja enviar existe no caminho especificado.
    - Verifique a saída no console para confirmar o upload e download dos arquivos.
    
## Melhorias Futuras

- Implementar autenticação real para Dropbox e Google Drive.
- Criar uma interface gráfica para facilitar o uso. 




