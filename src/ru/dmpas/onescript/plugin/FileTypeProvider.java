package ru.dmpas.onescript.plugin;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class FileTypeProvider extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(OneScriptFileType.INSTANCE, "OneScript");
    }
}
