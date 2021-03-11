package Analizadores;
import java_cup.runtime.*;
import ocl.proyecto.pkg1.*;

%%

%class Lexico
%cupsym sym
%cup 
%public
%unicode
%line
%char 
%full
%column
%ignorecase

%init{ 
    yyline = 1; 
	yychar = 1; 
%init}

blancos = [ \r\t\n]+
//letras

letra = [a-zA-Z]
entero = [0-9]+

//Identificadores
identificador = {letra}({letra}|"_"|{entero})*
cadena = "\""[^\"]+"\""
especialC = ("\\""n"|"\\""\'"|"\\""\"")
//Comentarios
comunilinea = ("//".*\n)|("//".*\r)
commultilinea = ("<""!"[^\!]*"!"">")



%{
    public void AddError(String tipo, String lexema, int fila, int columna){
        Errores nuevoE= new Errores(tipo, lexema, fila+1, columna+1);
        Interfaz.listaErrores.add(nuevoE);
    }
%}

%%

//palabra reservada
"CONJ" {return new Symbol(sym.conj,yyline,yychar,yytext());}

//CODIGO ASCII 

"!" {return new Symbol(sym.a33,yyline,yychar,yytext());}
"\"" {return new Symbol(sym.a34,yyline,yychar,yytext());}
"#" {return new Symbol(sym.a35,yyline,yychar,yytext());}
"$" {return new Symbol(sym.a36,yyline,yychar,yytext());}
"&" {return new Symbol(sym.a38,yyline,yychar,yytext());}
"\'" {return new Symbol(sym.a39,yyline,yychar,yytext());}
"(" {return new Symbol(sym.a40,yyline,yychar,yytext());}
")" {return new Symbol(sym.a41,yyline,yychar,yytext());}
"/" {return new Symbol(sym.a47,yyline,yychar,yytext());}
"<" {return new Symbol(sym.a60,yyline,yychar,yytext());}
"=" {return new Symbol(sym.a61,yyline,yychar,yytext());}
"@" {return new Symbol(sym.a64,yyline,yychar,yytext());}
"[" {return new Symbol(sym.a91,yyline,yychar,yytext());}
"\\" {return new Symbol(sym.a92,yyline,yychar,yytext());}
"]" {return new Symbol(sym.a93,yyline,yychar,yytext());}
"^" {return new Symbol(sym.a94,yyline,yychar,yytext());}
"_" {return new Symbol(sym.a95,yyline,yychar,yytext());}
"`" {return new Symbol(sym.a96,yyline,yychar,yytext());}

//simbolos propios del lenguaje
"+" {return new Symbol(sym.unaomasveces,yyline,yychar,yytext());}
"." {return new Symbol(sym.concatenacion,yyline,yychar,yytext());}
"*" {return new Symbol(sym.ceroomasveces,yyline,yychar,yytext());}
"|" {return new Symbol(sym.disyuncion,yyline,yychar,yytext());}
"?" {return new Symbol(sym.ceroounavez,yyline,yychar,yytext());}
"~" {return new Symbol(sym.tildeseparacion,yyline,yychar,yytext());}
"{" {return new Symbol(sym.llaveapertura,yyline,yychar,yytext());}
"}" {return new Symbol(sym.llavecerradura,yyline,yychar,yytext());}
":" {return new Symbol(sym.dospuntos,yyline,yychar,yytext());}
"-" {return new Symbol(sym.guion,yyline,yychar,yytext());}
">" {return new Symbol(sym.mayorq,yyline,yychar,yytext());}
";" {return new Symbol(sym.puntoycoma,yyline,yychar,yytext());}
"%" {return new Symbol(sym.porcentaje,yyline,yychar,yytext());}
"," {return new Symbol(sym.comma,yyline,yychar,yytext());}

//IGNORADOS
{blancos} {}
{comunilinea} {}
{commultilinea} {}


\n {yychar=1;}

{identificador} {return new Symbol(sym.identificador,yyline,yychar,yytext());}
{entero} {return new Symbol(sym.entero,yyline,yychar,yytext());}
{cadena} {return new Symbol(sym.cadena,yyline,yychar,yytext());}
{especialC} {return new Symbol(sym.especialC,yyline,yychar,yytext());}



.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yychar));
             AddError("Error Léxico",yytext(),yyline,yycolumn);
    }

