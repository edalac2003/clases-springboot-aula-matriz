class TestCalculadora {
	
	static public void main(String[] args){
		Calculadora calc = new Calculadora();
		double resultado = 0d;
		double num1 = 0d;
		double num2 = 0d;
		if(args != null && args.length == 3){
			try{
				num1 = Integer.parseInt(args[1]);
				num2 = Integer.parseInt(args[2]);
			}catch(NumberFormatException e){
				System.out.println("Parámetros de ejecución incorrectos. Formato: [operación, numero1, numero2]");
				return;
			}
			switch(args[0].toUpperCase()){
				case "SUMA":
					resultado = calc.suma(num1, num2);				
					break;
				case "RESTA":
					resultado = calc.resta(num1, num2);				
					break;
				case "MULTIPLICACION":
					resultado = calc.multiplicacion(num1, num2);				
					break;
				case "DIVISION":
					if(num2 != 0){
						resultado = calc.division(num1, num2);										
					}else{
						System.out.println("No es posible realizar la operación. El denominador debe ser diferente de cero.");			
						return;
					}
					break;
				default:
					System.out.println("Debe escribir la operación a realizar [SUMA, RESTA, MULTIPLICACION ó DIVISION]");			
					break;
			}
			System.out.println("El resultado es " + resultado);
		}else{
			System.out.println("Cantidad de Parametros incorrectos");			
		}
		
	}
	
}