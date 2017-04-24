import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestNewton {

  
  @Test
  public void TestDerivada () {
	  Newton x = new Newton (3);
      x.coeficientes[2] = 2;
      x.coeficientes[1] = 0;
      x.coeficientes[0] = 2;
	  boolean correto=false;
	  if(4== x.derivada(1))
		  correto=true;
	  assertTrue(correto);
	  
  }

}
