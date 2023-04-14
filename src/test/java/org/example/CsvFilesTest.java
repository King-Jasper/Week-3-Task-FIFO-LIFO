package org.example;

import org.example.utilities.CsvFiles;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CsvFilesTest {
    public CsvFiles csv;
    @Before
    public void setUp(){
        csv = new CsvFiles();
    }

    @Test
    public void csvReader() {
        assertEquals(10, csv.getProducts());
    }
}