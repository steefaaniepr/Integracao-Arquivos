package br.com.stpaes;

import java.io.File;

public class App {
    public static void main(String[] args) {

        String caminhoFile = "C:\\temp\\teste.txt";
        File caminhoUpload = new File(caminhoFile);

        if (!caminhoUpload.exists()) {
            System.out.println("Arquivo não encontrado no caminho específicado: " + caminhoFile);
            return;
        }

        DropBox dropBox = new DropBox();
        IPersistencia arquivosDropBox = new DropBoxAdapter(dropBox);
        arquivosDropBox.gravar(caminhoUpload);

        GoogleDrive googleDrive = new GoogleDrive();
        IPersistencia arquivosGoogleDrive = new GoogleDriveAdapter(googleDrive);
        arquivosGoogleDrive.gravar(caminhoUpload);

        File downloadFile = arquivosGoogleDrive.ler("teste");
        if (downloadFile != null) {
            System.out.println("Arquivo encontrado com sucesso: " + downloadFile.getPath());
        } else {
            System.out.println("Erro ao baixar o arquivo do Google Drive.");
        }

    }
}
