import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;



class DateTest {
  int testDay = 1;
  int testMonth = 10;
  int testYear = 1000;
  Date test = new Date(testMonth, testDay, testYear);

  
  @Test
  public void testgetDay() {
    int output = test.getDay();
    assertEquals(output, testDay);
  }
  
  @Test
  public void testgetMonth() {
    int output = test.getMonth();
    assertEquals(output, testMonth);
  }
  
  @Test
  public void testgetYear() {
    int output = test.getYear();
    assertEquals(output, testYear);
  }
  

  @Test
  public void testMonthIsValid() {
    boolean tester = false;
    int monthNum = test.getMonth();
    String output = test.monthString(monthNum);
    if(test.monthIsValid(output)) {
      tester = true;
    }
    assertEquals(tester, test.monthIsValid(output));
  }
  
}
