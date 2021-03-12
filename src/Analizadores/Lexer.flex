package Analizadores;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%full
%line
%column
%char
%public
L=[a-zA-Z_]+
D=[0-9]+
C=[%|#|!|&|(|)|?|¿|_|-]+
espacio=[ |\t|\r|\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Crear usuario */
("CREAR_USUARIO") {System.out.println("Crear usuario");return new Symbol(sym.CrearU,yycolumn,yyline,yytext());}

/* Usuario */
("USUARIO") {return new Symbol(sym.UsuarioP,yycolumn,yyline,yytext());}

/* Contraseña*/
("PASSWORD") {return new Symbol(sym.ContraP,yycolumn,yyline,yytext());}

/*Fecha de creación*/
("FECHA_CREACION") {return new Symbol(sym.FechaCP,yycolumn,yyline,yytext());}

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yycolumn, yyline, yytext());}

/* Inicio de mas de una solicitud */
( "ini_solicitudes" ) {return new Symbol(sym.MasSolicitudes, yycolumn, yyline, yytext());}

/* Fin de mas de una solicitud */
( "fin_solicitudes" ) {return new Symbol(sym.FinMasSolicitudes, yycolumn, yyline, yytext());}

/* Inicio de etiqueta*/
( "<!" ) {return new Symbol(sym.InicioE,yycolumn,yyline,yytext());}

/* Menor que */
( "<" ) {return new Symbol(sym.MenorQ,yycolumn,yyline,yytext());}

/* Fin de etiqueta*/
( "!>" ) {return new Symbol(sym.FinE,yycolumn,yyline,yytext());}

/* Mayor que */
( ">" ) {return new Symbol(sym.MayorQ,yycolumn,yyline,yytext());}

/* Inicio de una solicitud */
( "ini_solicitud:" ) {System.out.println("inicio de solicitud correcta");return new Symbol(sym.InicioSolicitud, yycolumn, yyline, yytext());}

/* Fin de una solicitud*/
( "fin_solicitud" ) {return new Symbol(sym.FinSolicitud,yycolumn,yyline,yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.Igual, yycolumn, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.Suma, yycolumn, yyline, yytext());}

/* Dos puntos */
( ":" ) {return new Symbol(sym.DosP, yycolumn, yyline, yytext());}

/* Coma */
( "," ) {return new Symbol(sym.Coma, yycolumn, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.Resta, yycolumn, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.Multiplicacion, yycolumn, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.Division, yycolumn, yyline, yytext());}

/* Operadores logicos */
( "&&" | "||" | "!" | "&" | "|" ) {return new Symbol(sym.Op_logico, yycolumn, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>" ) {return new Symbol(sym.Op_relacional, yycolumn, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Op_atribucion, yycolumn, yyline, yytext());}

/*Operadores Booleanos*/
( true | false ) {return new Symbol(sym.Op_booleano, yycolumn, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yycolumn, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yycolumn, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yycolumn, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yycolumn, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.Corchete_a, yycolumn, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.Corchete_c, yycolumn, yyline, yytext());}

/* Punto y coma */
( ";" ) {return new Symbol(sym.P_coma, yycolumn, yyline, yytext());}

/* ID */
("$"|"_"|"-")("$"|"_"|"-"|{D}|{L})* {System.out.println("ID encontrado");return new Symbol(sym.ID,yycolumn,yyline,yytext());}

/* Numero */
{D}+ {System.out.println("numero correcto");return new Symbol(sym.Numero, yycolumn, yyline, yytext());}

/*Fecha*/
{D}{4}"-"({D}{2}"-"|{D}"-")({D}{2}|{D}) {System.out.println("fecha correcta");return new Symbol(sym.Fecha,yycolumn,yyline,yytext());}

/*Usuario token*/
{L}({L}|{D}|{C})* {System.out.println("usuario correcto");return new Symbol(sym.Usuario,yycolumn,yyline,yytext());}

/*Contraseña*/
({L}|{D}|{C})({L}|{D}|{C})* {return new Symbol(sym.Contra,yycolumn,yyline,yytext());}

/*URL*/
("https://")?{L}({L})*"."{L}({L})*".com/"(({L}|{D}|{C})*("/")?)* {System.out.println("URL");return new Symbol(sym.URL, yycolumn,yyline,yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yycolumn, yyline, yytext());}
