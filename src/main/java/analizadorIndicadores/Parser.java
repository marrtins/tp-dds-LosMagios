package analizadorIndicadores;

import analisisMetodologico.AntiqueFilter;
import analisisMetodologico.AntiqueSort;
import analisisMetodologico.Consistence;
import analisisMetodologico.Crescent;
import analisisMetodologico.Highest;
import analisisMetodologico.Lowest;
import analisisMetodologico.OperadorNoTaxativo;
import analisisMetodologico.OperadorTaxativo;
import excepciones.ErrorLexico;

public class Parser {
	AnalizadorLexico analyse = new AnalizadorLexico();
	public static double eval(final String str) {
	    return new Object() {
	        int pos = -1, ch;

	        void nextChar() {
	            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	        }

	        boolean eat(int charToEat) {
	            while (ch == ' ') nextChar();
	            if (ch == charToEat) {
	                nextChar();
	                return true;
	            }
	            return false;
	        }

	        double parse() {
	            nextChar();
	            double x = parseExpression();
	            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
	            return x;
	        }

	        // Grammar:
	        // expression = term | expression `+` term | expression `-` term
	        // term = factor | term `*` factor | term `/` factor
	        // factor = `+` factor | `-` factor | `(` expression `)`
	        //        | number | functionName factor | factor `^` factor

	        double parseExpression() {
	            double x = parseTerm();
	            for (;;) {
	                if      (eat('+')) x += parseTerm(); // addition
	                else if (eat('-')) x -= parseTerm(); // subtraction
	                else return x;
	            }
	        }

	        double parseTerm() {
	            double x = parseFactor();
	            for (;;) {
	                if      (eat('*')) x *= parseFactor(); // multiplication
	                else if (eat('/')) x /= parseFactor(); // division
	                else return x;
	            }
	        }

	        double parseFactor() {
	            if (eat('+')) return parseFactor(); // unary plus
	            if (eat('-')) return -parseFactor(); // unary minus

	            double x;
	            int startPos = this.pos;
	            if (eat('(')) { // parentheses
	                x = parseExpression();
	                eat(')');
	            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
	                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
	                x = Double.parseDouble(str.substring(startPos, this.pos));
	            } else if (ch >= 'a' && ch <= 'z') { // functions
	                while (ch >= 'a' && ch <= 'z') nextChar();
	                String func = str.substring(startPos, this.pos);
	                x = parseFactor();
	                if (func.equals("sqrt")) x = Math.sqrt(x);
	                else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
	                else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
	                else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
	                else throw new RuntimeException("Unknown function: " + func);
	            } else {
	                throw new RuntimeException("Unexpected: " + (char)ch);
	            }

	            if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

	            return x;
	        }
	    }.parse();
	}
	
	
	public OperadorTaxativo getOperadorT(String nombre){
		
		OperadorTaxativo operadorReturn = null;
		
		if(nombre.equals("consistence")){
			operadorReturn= new Consistence();
		}
		else if(nombre.equals("crescent")){
			operadorReturn=new Crescent();
		}else if(nombre.equals("antique")){
			operadorReturn=new AntiqueFilter();
		}
		return operadorReturn;	
			
	}
public OperadorNoTaxativo getOperadorNT(String nombre){
		
		OperadorNoTaxativo operadorReturn = null;
		
		if(nombre.equals("highest")){
			operadorReturn= new Highest();
		}
		else if(nombre.equals("lowest")){
			operadorReturn=new Lowest();
		}else if(nombre.equals("antique")){
			operadorReturn=new AntiqueSort();
		}
		return operadorReturn;	
			
	}
	

}
