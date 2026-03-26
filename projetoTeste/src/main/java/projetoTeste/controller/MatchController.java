package projetoTeste.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetoTeste.exeption.UnsuportOperationExeption;

@RestController
@RequestMapping("/match")
public class MatchController {
	
	@RequestMapping("/sum/{numberOne}/{numbertwo}")
	public Double sum(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numbertwo") String numbertwo) {
		
		if(!isNumeric(numberOne) || !isNumeric(numbertwo) ) throw new UnsuportOperationExeption("Please set a numeric value");
		
		return converterDouble(numberOne) +converterDouble(numbertwo) ;
		
	}
	
	@RequestMapping("/sub/{numberOne}/{numbertwo}")
	public Double sub(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numbertwo") String numbertwo) {
		if(!isNumeric(numberOne) || !isNumeric(numbertwo) ) throw new UnsuportOperationExeption("Please set a numeric value");
		return converterDouble(numberOne) - converterDouble(numbertwo) ;
	}
	
	@RequestMapping("/multi/{numberOne}/{numbertwo}")
	public Double multi(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numbertwo") String numbertwo) {
		if(!isNumeric(numberOne) || !isNumeric(numbertwo) ) throw new UnsuportOperationExeption("Please set a numeric value");
		return converterDouble(numberOne) * converterDouble(numbertwo) ;
	}
	
	@RequestMapping("/div/{numberOne}/{numbertwo}")
	public Double div(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numbertwo") String numbertwo) {
		if(!isNumeric(numberOne) || !isNumeric(numbertwo) ) throw new UnsuportOperationExeption("Please set a numeric value");
		return converterDouble(numberOne) / converterDouble(numbertwo) ;
	}
	
	@RequestMapping("/med/{numberOne}/{numbertwo}")
	public Double med(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numbertwo") String numbertwo) {
		if(!isNumeric(numberOne) || !isNumeric(numbertwo) ) throw new UnsuportOperationExeption("Please set a numeric value");
		return converterDouble(numberOne) + converterDouble(numbertwo) /2 ;
	}
	
	@RequestMapping("/raiz/{numberOne}")
	public Double med(
			@PathVariable("numberOne") String numberOne) {
		if(!isNumeric(numberOne) )  throw new UnsuportOperationExeption("Please set a numeric value");
		return Math.sqrt(converterDouble(numberOne)) ;
	}
	
	
	
	

	private Double converterDouble(String srtNumber) {
		if(srtNumber == null || srtNumber.isEmpty()) throw new UnsuportOperationExeption("Please set a numeric value");
		return Double.valueOf(srtNumber);
	}

	private boolean isNumeric(String srtNumber) {
		if(srtNumber == null || srtNumber.isEmpty()) return false;
		String number = srtNumber.replace(",", ".");
		
		 return number.matches("[-+]?^[0-9]*\\.?[0-9]+");
	}

}
