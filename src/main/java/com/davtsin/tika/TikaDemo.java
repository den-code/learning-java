package com.davtsin.tika;

import org.apache.commons.io.IOUtils;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.document.DocumentFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/*
 * DOC, DOCX, XLS, XLSX, RTF, PNG, JPG, TXT
 * */

public class TikaDemo {
    private static final String filename = "demo.xml";
    private static Logger logger = LoggerFactory.getLogger(TikaDemo.class);

    public static void main(String[] args) throws IOException, TikaException {

        InputStream inputStream = TikaDemo.class.getResourceAsStream(filename);
        byte[] bytes = IOUtils.toByteArray(inputStream);

        String mediaType = getMediaType(bytes, filename);

        getDocumentFormat(mediaType);

        inputStream.close();
    }

    public static DocumentFormat getDocumentFormat(String mediaType) {
        logger.debug("Define document format for jodconverter with media type: {}", mediaType);
        DocumentFormat documentFormat = DefaultDocumentFormatRegistry.getFormatByMediaType(mediaType);

        if (documentFormat == null) {
            logger.warn("FAULT. No such media type in jodconverter document registry. Try to define document format.");
            switch (mediaType) {
                case "application/rtf":
                    documentFormat = DefaultDocumentFormatRegistry.RTF;
                    break;
                default:
                    logger.warn("FAULT. Media type not found. Set default document format: text/plain");
                    documentFormat = DefaultDocumentFormatRegistry.TXT;
            }
        }

        logger.debug("Result document format: {}", documentFormat);
        return documentFormat;
    }

    public static String getMediaType(byte[] bytes, String filename) throws TikaException, IOException {
        logger.debug("Getting media type for byte array with filename: {}", filename);
        TikaInputStream tikaInputStream = TikaInputStream.get(bytes);
        TikaConfig tika = new TikaConfig();
        Metadata metadata = new Metadata();
        metadata.set(Metadata.RESOURCE_NAME_KEY, filename);
        MediaType tikaMediaType = tika.getDetector().detect(tikaInputStream, metadata);
        logger.debug("Result media type: {}", tikaMediaType);
        return tikaMediaType.toString();
    }

    public static String getMediaType(InputStream is, String filename) throws TikaException, IOException {
        logger.debug("Getting media type for bytes with filename: {}", filename);
        TikaInputStream tikaInputStream = TikaInputStream.get(is);
        TikaConfig tika = new TikaConfig();
        Metadata metadata = new Metadata();
        metadata.set(Metadata.RESOURCE_NAME_KEY, filename);
        MediaType tikaMediaType = tika.getDetector().detect(tikaInputStream, metadata);
        logger.debug("MediaType from tika: {}", tikaMediaType);
        tikaInputStream.close();
        return tikaMediaType.toString();
    }
}
