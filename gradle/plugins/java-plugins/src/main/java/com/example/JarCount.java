package com.example;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;

public abstract class JarCount extends DefaultTask {

    /*
     ConfigurableFileCollection <=  @InputFiles
     ConfigurableFileCollection expresses that you can add
     arbitrary many files/folder to an input
     */

    /*
     RegularFileProperty <=  @InputFile
     RegularFileProperty expresses that you can add
     single file to an input
     */

    /*
     DirectoryProperty <=  @InputDirectory
     DirectoryProperty expresses that you can add
     single directory to an input
     */

    @InputFiles// <-tells gradle this is an input of multiple files
    //Input property allJars
    public abstract ConfigurableFileCollection getAllJars();

    @OutputFile
    //Output Property countFile
    public abstract RegularFileProperty getCountFile();

    @TaskAction
    public void doCount() throws IOException {
        Set<File> jarFiles = getAllJars().getFiles();
        int size = jarFiles.size();
        File out = getCountFile().get().getAsFile();
        Files.write(out.toPath(), Collections.singleton(""+size));
    }
}
