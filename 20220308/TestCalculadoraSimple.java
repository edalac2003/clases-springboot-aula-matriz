class TestCalculadoraSimple {
	
	static public void main(String[] args){
		Calculadora calc = new Calculadora();
		double resultado = 0d;
		double num1 = Integer.parseInt(args[1]);
		double num2 = Integer.parseInt(args[2]);
		
		resultado = calc.suma(num1, num2);
		System.out.println("El resultado de la suma es " + resultado);
		resultado = calc.resta(num1, num2);	
		System.out.println("El resultado de la resta es " + resultado);
		resultado = calc.multiplicacion(num1, num2);
		System.out.println("El resultado de la multiplicacion es " + resultado);
		resultado = calc.division(num1, num2);
		System.out.println("El resultado de la division es " + resultado);
		
	}
	
}