package me.exerosis.jager.gameengine.core.utilites;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Exerosis.
 */
public class FileUtilities {

    public static void createZip(File directory, File zipFile) throws IOException {
        createZip(mapDirectory(directory), zipFile);
    }

    public static Map<String, File> mapDirectory(File directory) throws IOException {
        if (!directory.exists())
            throw new IOException("File does not exist.");
        Map<String, File> contents = new HashMap<>();
        for (File file : directory.listFiles()) {
            if (file.isFile())
                contents.put(file.getPath().replace(directory.getPath(), ""), file);
            else
                contents.putAll(mapDirectory(file));
        }
        return contents;
    }

    public static void unzip(File zipFile, File directory) throws IOException {
        if (directory.mkdirs())
            System.err.println("Could not find destination directory, created it.");

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(zipFile);
            inputStream = new BufferedInputStream(inputStream);
            inputStream = new ZipInputStream(inputStream);

            ZipEntry entry = ((ZipInputStream) inputStream).getNextEntry();
            while (entry != null) {
                if (entry.isDirectory())
                    continue;

                OutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(directory.getPath() + File.separator + entry.getName());
                    outputStream = new BufferedOutputStream(outputStream);
                    IOUtils.copy(inputStream, outputStream);
                } finally {
                    StreamUtilities.closeQuietly(outputStream);
                }
            }
        } finally {
            StreamUtilities.closeQuietly(inputStream);
        }
    }

    public static void createZip(Map<String, File> contents, File zipFile) throws IOException {
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(zipFile);
            outputStream = new BufferedOutputStream(outputStream);
            outputStream = new ZipOutputStream(outputStream);

            for (Map.Entry<String, File> entry : contents.entrySet()) {
                if (!entry.getValue().isFile())
                    throw new IOException("Cannot zip directory.");

                InputStream inputStream = null;
                try {
                    ZipEntry zipEntry = new ZipEntry(entry.getKey());
                    ((ZipOutputStream) outputStream).putNextEntry(zipEntry);

                    inputStream = new FileInputStream(entry.getValue());
                    inputStream = new BufferedInputStream(inputStream);

                    IOUtils.copy(inputStream, outputStream);
                    ((ZipOutputStream) outputStream).closeEntry();
                } finally {
                    StreamUtilities.closeQuietly(inputStream);
                }
            }

        } finally {
            StreamUtilities.closeQuietly(outputStream);
        }
    }

}