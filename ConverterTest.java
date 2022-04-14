package ru.gnkoshelev.kontur.intern;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class ConverterTest {
  
  @Test
  public void testReadData() {
    String csvFile = "C:\\Mydocs\\Java\\universal-converter\\src\\main\\resources\\file.csv";
    String[] s = {"мм", "с", "кг"};
    String[] t = {"км", "час", "км"};
    double[] expected = {0.000001, 0.00027777777777777777777777777777778, 0.0};
    for (int i = 0; i < 3; i++) {
    	double actual = Converter.readData(csvFile, s[i], t[i]);
        assertEquals("something wrong " + s[i] + " " + t[i], expected[i], actual);
    }
  }
  
  @Test
  public void testGetCodeResponse() {
    int expectedOk = 200;
    int expectedNotFound = 404;
    int actualOk = Converter.getCodeResponse(1000);
    int actualNotFound = Converter.getCodeResponse(0.0);
    assertEquals(expectedOk, actualOk);
    assertEquals(expectedNotFound, actualNotFound);
  }

  @Test
  public void testGetBodyResponse() {
  	double[] value = {0.1234567890123456789, 0.12345678901234, 0.123456789000000};
  	String[] expected = {"0,123456789012346", "0,12345678901234", "0,123456789"};
  	for (int i = 0; i < 3; i++) {
  		String actual = Converter.getBodyResponse(value[i]);
  		assertEquals(expected[i], actual);
  	}
  }
}
