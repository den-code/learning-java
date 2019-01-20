package com.davtsin.jxls;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class JxlsChartTest {
    private static Logger logger = LoggerFactory.getLogger(JxlsChartTest.class);

    public static void main(String[] args) throws IOException {

        DataHolder dataHolder = new DataHolder();

        try (InputStream is = JxlsChartTest.class.getResourceAsStream("chart-sheet.xls")) {
            try (OutputStream os = new FileOutputStream("target/chart-sheet-out.xls")) {
                Context context = new Context();
                context.putVar("dataHolder", dataHolder);

                logger.debug("DataHolder: {}", context.getVar("dataHolder"));

                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        }
    }
}
