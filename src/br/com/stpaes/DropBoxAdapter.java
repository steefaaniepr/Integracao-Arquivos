package br.com.stpaes;

import java.io.File;

public class DropBoxAdapter implements IPersistencia{

    private DropBox dropBox;

    public DropBoxAdapter(DropBox dropBox) {
        this.dropBox = dropBox;
    }

    @Override
    public void gravar(File file) {
        dropBox.upload(new DropBoxFile(file.getAbsolutePath()));
    }

    @Override
    public File ler(String id) {
        DropBoxFile dbFile = dropBox.download(id);
        return new File(dbFile.getLocalPath());
    }
}
