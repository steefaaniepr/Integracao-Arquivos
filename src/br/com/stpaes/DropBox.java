package br.com.stpaes;

public class DropBox {

    void upload(DropBoxFile dbFile) {
        System.out.println("Arquivo enviado para o DropBox " + dbFile.getLocalPath());
    }

    DropBoxFile download (String id) {
        return new DropBoxFile("C:\\temp\\" + id);
    }

}
