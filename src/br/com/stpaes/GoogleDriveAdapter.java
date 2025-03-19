package br.com.stpaes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GoogleDriveAdapter implements IPersistencia{

    private GoogleDrive googleDrive;

    public GoogleDriveAdapter(GoogleDrive googleDrive) {
        this.googleDrive = googleDrive;
    }


    @Override
    public void gravar(File file) {
        try {
            byte [] data = Files.readAllBytes(file.toPath());
            googleDrive.send(data, file.getName());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler arquivo para upload no Google Drive", e);
        }
    }

    @Override
    public File ler(String id) {
        byte[] data = googleDrive.get(id);
        String caminho = "C:\\temp\\";

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            caminho = "C:\\temp\\" + id + ".txt";
        }

        File file = new File(caminho);

        try {
            Files.write(file.toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler arquivo para download no Google Drive", e);
        }
        return file;
    }
}
