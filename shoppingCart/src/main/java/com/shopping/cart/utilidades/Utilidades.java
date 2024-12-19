package com.shopping.cart.utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utilidades {
	
	public static Double formato(int cantidad, double precioUnitario) {	    
		double precio = cantidad * precioUnitario;
	    BigDecimal precioRedondeado = new BigDecimal(precio).setScale(2, RoundingMode.HALF_UP);
	    Double precioFinal = precioRedondeado.doubleValue();	 
	    return precioFinal;
	}

}
