package prueba;

import domain.Pajaro;
//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
public class PajaroTest {
	
	private Pajaro unPajaro;
	
	@Before
	public void initialize(){
		unPajaro = new Pajaro();
	}
	
	
	@Test
	public void pichonesDeberianNacerConMuchaEnergia(){
		Assert.assertEquals(500, unPajaro.getEnergia());
	}
	@Test
	public void cuandoUnPajaroComeDeberiaTenerMasEnergia(){
		
		int energiaAntes = unPajaro.getEnergia();
		unPajaro.comer();
		Assert.assertTrue(energiaAntes < unPajaro.getEnergia());
	}
	
	
}
