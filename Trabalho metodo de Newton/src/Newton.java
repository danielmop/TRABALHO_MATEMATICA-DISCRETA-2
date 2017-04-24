import java.util.ArrayList;

public class Newton {
	double[] coeficientes;
	ArrayList<Double> raizes;

	Newton(int tamanho) {
		raizes = new ArrayList<Double>();
		coeficientes =new double[tamanho];
	}

	public void isolamento() {
		System.out.println("RAIZES: ");
		double h = 0.00000001;
		boolean teste = false;
		for (double i = -10; i <= 10; i = i + 0.1) {
			if (f(i) * f(i + 0.1) > 0.00 && derivada(i) * derivada(i + 0.1) < 0.00) {
				teste = true;
				refinamento(i, i + 0.1, i);
			} else if (f(i) * f(i + 0.1) < 0.00) {
				teste = true;

				refinamento(i, i + 0.1, i);
			}
		}
		if (!teste) {
			System.out.println("Nao existem raizes para essa equacao.");
		}
	}

	public void refinamento(double i, double f, double ref) {
		if (i <= f && i >= ref) {
			if (f(i) >= -0.00000001 && f(i) <= 0.00000001) {
				if (i > -0.4 && i < 0.4) {
					raizes.add((double) Math.round(i));
					System.out.println(i);
				} else {
					raizes.add(i);
					System.out.println(i);
				}
			} else {
				double funcao = f(i);
				double derivada = derivada(i);
				refinamento(i - (funcao / derivada), f, ref);
			}
		}
	}
	
	public double derivada (double x) {
		double resultado=0;
		for(int i=coeficientes.length-1;i>0;i--){
			resultado+=coeficientes[i]*i*Math.pow(x, i-1);		
		}
		return resultado;
		
	}

	public double f(double x) {
		// Math.pow(x, 2) - 4*x - 5
		return f(coeficientes, x);
	}

	public double f(double[] coeficientes, double x) {
		double resultado=0;
		for(int i=coeficientes.length-1;i>=0;i--){
			resultado+=coeficientes[i]*Math.pow(x, i);		
		}
		return resultado;
	}
}