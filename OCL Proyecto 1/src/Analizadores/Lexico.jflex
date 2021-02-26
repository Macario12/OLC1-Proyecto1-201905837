package Analizadores;
import java_cup.runtime.*;

%%

%class Lexico
%cupsym sym
%cup 
%public
%unicode
%line 
%column
%ignorecase

%init{ 
    
%init}

blancos = [ \t\r\n]+

//letras

letra = [a-z A-Z]
entero = [0-9]+  //0,1,2,3,4,5,6,7,8,9 -> 1111, 125
decimal = [0-9]+ "." [0-9]+

//Identificadores
nombre = {letra}+

%{
    
%}

%%

"+" {return new Symbol(sym.unaomasveces,yycolumn,yyline,yytext());}
"." {return new Symbol(sym.concatenacion,yycolumn,yyline,yytext());}
"*" {return new Symbol(sym.ceroomasveces,yycolumn,yyline,yytext());}
"|" {return new Symbol(sym.disyuncion,yycolumn,yyline,yytext());}
"?" {return new Symbol(sym.ceroounavez,yycolumn,yyline,yytext());}

CONJ {return new Symbol(sym.conj,yycolumn,yyline,yytext());}
"!" {return new Symbol(sym.hash,yycolumn,yyline,yytext());}
"CONJ" {return new Symbol(sym.ceroounavez,yycolumn,yyline,yytext());}


\n {yycolumn=1;}
{blancos} {/*Se ignoran*/}
//45+98

{nombre} {return new Symbol(sym.nombre,yycolumn,yyline,yytext());}
{entero} {return new Symbol(sym.entero,yycolumn,yyline,yytext());} // almacenando un valor entero en la tabla de simbolos
{decimal} {return new Symbol(sym.decimal,yycolumn,yyline,yytext());}


//CUALQUIER ERROR:           SIMBOLOS NO DEFINIDOS DENTRO DEL LENGUAJE
.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yycolumn));
    }

/*   . {
    addError("tipo lexico", yytext(), yyline, yycolumn)

}

class name{

}

{

}

*/

